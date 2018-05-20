package cn.xc.service.impl;

import cn.xc.constant.ViolatingInformationConstant;
import cn.xc.controller.BulletinBoardController;
import cn.xc.dao.ICarInformationDAO;
import cn.xc.dao.IUserPointDAO;
import cn.xc.dao.IViolatingInformationDAO;
import cn.xc.dao.condition.CarInformationExample;
import cn.xc.dao.condition.ViolatingInformationExample;
import cn.xc.entity.DO.CarInformationDO;
import cn.xc.entity.DO.UserPointDO;
import cn.xc.entity.DO.ViolatingInformationDO;
import cn.xc.exception.ViolatingInformationException;
import cn.xc.service.IUserService;
import cn.xc.service.IViolatingInformationService;
import cn.xc.service.constant.ServiceConstant;
import cn.xc.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 *  违章信息相关服务实现类
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/2/1 12:16.
 */
@Service
public class ViolatingInformationServiceImpl implements IViolatingInformationService {
    private static Logger logger = LoggerFactory.getLogger(BulletinBoardController.class);
    @Autowired
    private IViolatingInformationDAO db;
    @Autowired
    private IUserService userService;
    @Autowired
    private ICarInformationDAO carInforDB;

    @Autowired
    private IUserPointDAO userPointDAO;


    /**
     *  获取所有违章信息
     * @return 查询结果集
     */
    @Override
    public List<ViolatingInformationDO> findAll() {
        ViolatingInformationExample example = new ViolatingInformationExample();
        ViolatingInformationExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeletedEqualTo(0);
        List<ViolatingInformationDO> raw = db.selectByExample(example);
        return raw;
    }

    /**
     *  添加违章信息
     * @param value 待添加的数据
     * @return 添加成功返回true 添加失败返回false
     * @throws ViolatingInformationException
     */
    @Override
    public void addViolatingInformation(ViolatingInformationDO value) throws ViolatingInformationException {
        boolean isCarNumberValid = ValidatorUtil.checkCarNumberLegality(value.getCarNumber());
        if (!isCarNumberValid){
            throw new ViolatingInformationException("车牌号格式不正确");
        }
        CarInformationExample carExample = new CarInformationExample();
        CarInformationExample.Criteria criteria = carExample.createCriteria();
        criteria.andCarNumberEqualTo(value.getCarNumber());
        List<CarInformationDO> carInforResult = carInforDB.selectByExample(carExample);
        for (CarInformationDO carInformationDO : carInforResult) {
            UserPointDO userPointInformation = userService.getUserPointInformation(carInformationDO.getOwner());
            userPointInformation.setCurrentPoint(userPointInformation.getCurrentPoint() - value.getPenaltyPoint() < 0 ? 0 : userPointInformation.getCurrentPoint() - value.getPenaltyPoint());
            userPointDAO.updateByPrimaryKey(userPointInformation);
        }
        db.insert(value);
    }

    /**
     *  删除违章信息
     * @param value 待删除的信息
     */
    @Override
    public void deleteViolatingInformation(ViolatingInformationDO value) {
        db.deleteByPrimaryKey(value.getId());
    }

    /**
     *  批量删除违章信息
     * @param primaryKey 待删除的信息集合
     */
    @Override
    public void deleteViolatingInformationByList(List<Long> primaryKey) {
        db.deleteByPrimaryKeyList(primaryKey);
    }

    /**
     *  按条件查询违章信息
     * @param queryType 查询方式 0:根据ID, 1:根据违章者ID
     *                  2:根据违章类型, 3:根据车牌号, 4:根据违章时间,
     *                  5:根据扣分, 6:根据罚款金额, 7:根据违章记录创建时间, 8:根据记录修改时间
     * @param param     查询参数
     * @return 查询结果集 java.util.List&lt;ViolatingInformationDO&gt;
     */
    @Override
    public List<ViolatingInformationDO> listViolatingInformationByCondition(int queryType, Object param) throws ViolatingInformationException {
        if(param == null) {
            throw new ViolatingInformationException("param can't be null");
        }
        ViolatingInformationExample example = new ViolatingInformationExample();
        ViolatingInformationExample.Criteria criteria = example.createCriteria();
        boolean isParamValid = false;
        List<ViolatingInformationDO> result = null;
        switch (queryType){
            case ViolatingInformationConstant.QUERY_BY_ID:
                isParamValid = param instanceof Long;
                if(!isParamValid){
                    throw new ViolatingInformationException("When queryType is QUERY_BY_ID,type of param must be java.lang.Long");
                }
                criteria.andIdEqualTo((Long) param);
                break;
            case ViolatingInformationConstant.QUERY_BY_IDENTIFIER:
                isParamValid = param instanceof String;
                if(!isParamValid){
                    throw new ViolatingInformationException("When queryType is QUERY_BY_IDENTIFIER,type of param must be java.lang.String");
                }
                criteria.andIdentifierEqualTo((String) param);
                break;
            case ViolatingInformationConstant.QUERY_BY_VIOLATIONTYPE:
                isParamValid = param instanceof Integer;
                if(!isParamValid){
                    throw new ViolatingInformationException("When queryType is QUERY_BY_VIOLATIONTYPE,type of param must be java.lang.Integer");
                }
                criteria.andViolationTypeEqualTo((Integer) param);
                break;
            case ViolatingInformationConstant.QUERY_BY_CARNUMBER:
                isParamValid = param instanceof String;
                if(!isParamValid){
                    throw new ViolatingInformationException("When queryType is QUERY_BY_CARNUMBER,type of param must be java.lang.String");
                }
                criteria.andCarNumberEqualTo((String) param);
                break;
            case ViolatingInformationConstant.QUERY_BETWEEN_VIOLATIONTIME:
                isParamValid = param instanceof List;
                if(!isParamValid){
                    throw new ViolatingInformationException("When queryType is QUERY_BETWEEN_VIOLATIONTIME,type of param must be java.util.List");
                }
                List<Timestamp> timeScope = (List<Timestamp>) param;
                if(timeScope.size() != 2){
                    throw new ViolatingInformationException("Need two argument，actual the number of argument in list is：" + timeScope.size());
                }
                criteria.andViolationTimeBetween(timeScope.get(ServiceConstant.INDEX_START_TIME),timeScope.get(ServiceConstant.INDEX_END_TIME));
                break;
            case ViolatingInformationConstant.QUERY_BETWEEN_PENALTYPOINT:
                isParamValid = param instanceof List;
                if(!isParamValid){
                    throw new ViolatingInformationException("When queryType is QUERY_BETWEEN_PENALTYPOINT,type of param must be java.util.List");
                }
                List<Integer> pointScope = (List<Integer>) param;
                if(pointScope.size() != 2){
                    throw new ViolatingInformationException("Need two argument，actual the number of argument in list is：" + pointScope.size());
                }
                criteria.andPenaltyPointBetween(pointScope.get(ServiceConstant.INDEX_START_POINT),pointScope.get(ServiceConstant.INDEX_END_POINT));
                break;
            case ViolatingInformationConstant.QUERY_BETWEEN_PENALTYMONEY:
                isParamValid = param instanceof List;
                if(!isParamValid){
                    throw new ViolatingInformationException("When queryType is QUERY_BETWEEN_PENALTYMONEY,type of param must be java.util.List");
                }
                List<BigDecimal> moneyScope = (List<BigDecimal>) param;
                if(moneyScope.size() != 2){
                    throw new ViolatingInformationException("Need two argument，actual the number of argument in list is：" + moneyScope.size());
                }
                criteria.andPenaltyMoneyBetween(moneyScope.get(ServiceConstant.INDEX_START_PENALTYMONEY),moneyScope.get(ServiceConstant.INDEX_END_PENALTYMONEY));
                break;
            case ViolatingInformationConstant.QUERY_BETWEEN_GMTCREATE:
                isParamValid = param instanceof List;
                if(!isParamValid){
                    throw new ViolatingInformationException("When queryType is QUERY_BETWEEN_VIOLATIONTIME,type of param must be java.util.List");
                }
                List<Timestamp> createTimeScope = (List<Timestamp>) param;
                if(createTimeScope.size() != 2){
                    throw new ViolatingInformationException("Need two argument，actual the number of argument in list is：" + createTimeScope.size());
                }
                criteria.andGmtCreateBetween(createTimeScope.get(ServiceConstant.INDEX_START_TIME),createTimeScope.get(ServiceConstant.INDEX_END_TIME));
                break;
            case ViolatingInformationConstant.QUERY_BETWEEN_GMTMODIFIED:
                isParamValid = param instanceof List;
                if(!isParamValid){
                    throw new ViolatingInformationException("When queryType is QUERY_BETWEEN_GMTMODIFIED,type of param must be java.util.List");
                }
                List<Timestamp> modifiedTimeScope = (List<Timestamp>) param;
                if(modifiedTimeScope.size() != 2){
                    throw new ViolatingInformationException("Need two argument，actual the number of argument in list is：" + modifiedTimeScope.size());
                }
                criteria.andGmtModifiedBetween(modifiedTimeScope.get(ServiceConstant.INDEX_START_TIME),modifiedTimeScope.get(ServiceConstant.INDEX_END_TIME));
                break;
            default:
                throw new ViolatingInformationException("Query Argument is not within the scope of the definition，actual passed query argument is:" + queryType);
        }
        result = db.selectByExample(example);
        return result;
    }
    /**
     *  更新违章信息
     * @param value 待更新的信息集合
     */
    @Override
    public void updateViolatingInformation(ViolatingInformationDO value) {
        db.updateByPrimaryKey(value);
    }

    /**
     * 根据车牌号返回当前车辆扣分总和
     *
     * @param carNumber
     * @return
     */
    @Override
    public int getTotalPenaltyPointByCarNumber(String carNumber) throws ViolatingInformationException {
        List<ViolatingInformationDO> carInformations = listViolatingInformationByCondition(ViolatingInformationConstant.QUERY_BY_CARNUMBER, carNumber);
        int penaltyPointSum = 0;
        for (ViolatingInformationDO carInformation : carInformations) {
            penaltyPointSum += carInformation.getPenaltyPoint();
        }
        return penaltyPointSum;
    }
}
