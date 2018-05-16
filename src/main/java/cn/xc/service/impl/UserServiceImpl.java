package cn.xc.service.impl;

import cn.xc.dao.ICarInformationDAO;
import cn.xc.dao.IUserDAO;
import cn.xc.dao.IUserPointDAO;
import cn.xc.dao.condition.CarInformationExample;
import cn.xc.dao.condition.UserPointExample;
import cn.xc.entity.DO.BaseDO;
import cn.xc.entity.DO.CarInformationDO;
import cn.xc.entity.DO.UserDO;
import cn.xc.entity.DO.UserPointDO;
import cn.xc.entity.VO.RegisterVO;
import cn.xc.entity.VO.UserVO;
import cn.xc.exception.UserException;
import cn.xc.exception.ViolatingInformationException;
import cn.xc.service.IUserService;
import cn.xc.service.IViolatingInformationService;
import cn.xc.util.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  用户服务实现类
 * 
 * @Author XiongCheng 
 * @version V1.0
 * @Date 2018/1/29 10:21.
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDAO db;

    @Autowired
    private IUserPointDAO userPointDB;
    @Autowired
    private ICarInformationDAO carDB;

    @Autowired
    private IViolatingInformationService vioService;
    /**
     *  用户注册
     * @param user
     */
    @Override
    public void registerUser(RegisterVO user) {
        UserDO toDB = new UserDO();
        toDB.setIdentifier(user.getIdentifier());
        toDB.setUserPassword(user.getAdminPassword());
        toDB.setAvatar("akari.jpg");
        UserPointDO userPointDO = new UserPointDO();
        userPointDO.setIdentifier(user.getIdentifier());
        userPointDO.setCurrentPoint(0);
        userPointDB.insert(userPointDO);
        db.insertData(toDB);
    }

    /**
     *  用户更新信息
     * @param user 待更新数据
     */
    @Override
    public void updateInformation(UserVO user) {
        UserDO toDB = new UserDO(user);
        db.updateDataSelective(toDB);
    }

    /**
     *  获得用户信息
     * @param id 用户id
     * @return 获取到的用户信息
     */
    @Override
    public UserVO getUserInformation(Long id) {
        UserDO fromDB = (UserDO) db.getDataByPrimaryKey(id);
        return new UserVO(fromDB);
    }

    /**
     *  校验密码是否正确
     * @param identifier
     * @return
     */
    @Override
    public UserDO findUserByName(String identifier) {
        List<BaseDO> result = db.getDataByIdentifier(identifier);
        if(result.size() == 0){
            return null;
        }
        UserDO prepare = (UserDO) result.get(0);
        return prepare;
    }

    /**
     * @param identifier 账号
     * @param password   密码
     *  更新密码
     */
    @Override
    public int updatePassword(String identifier, String password) {
        List<BaseDO> result = db.getDataByIdentifier(identifier);
        if(result.size() == 0){
            return -1;
        }
        UserDO prepare = (UserDO) result.get(0);
        prepare.setUserPassword(password);
        db.updateDataSelective(prepare);
        return 0;
    }

    /**
     *  检查用户名是否可用
     * @param identifier
     * @return
     */
    @Override
    public boolean checkIdentifierUnique(String identifier) {
        int result = db.checkIdentifierUnique(identifier);
        return result == 0 ? true : false;
    }

    /**
     * 用户注册车辆
     *
     * @param carNumber    车牌号
     * @param frameNumber  车架号
     * @param engineNumber 发动机号
     * @return
     */
    @Override
    public int registerCar(String Identifier, String carNumber, String frameNumber, String engineNumber) throws UserException, ViolatingInformationException {
        if(!ValidatorUtil.checkCarNumberLegality(carNumber)) {
            throw new UserException("车牌号不正确");
        }
        CarInformationExample carInformationExample = new CarInformationExample();
        CarInformationExample.Criteria criteria = carInformationExample.createCriteria();
        criteria.andCarNumberEqualTo(carNumber);

        int userPenaltyPointSum = vioService.getTotalPenaltyPointByCarNumber(carNumber);
        UserPointExample userPointExample = new UserPointExample();
        UserPointExample.Criteria userPointCriteria = userPointExample.createCriteria();
        userPointCriteria.andIdentifierEqualTo(Identifier);
        UserPointDO userPointDO = userPointDB.selectByExample(userPointExample).get(0);
        int currentPoint = (12 - userPenaltyPointSum) < 0 ? 0 : 12 - userPenaltyPointSum;
        userPointDO.setCurrentPoint(currentPoint);

        CarInformationDO result = (carDB.selectByExample(carInformationExample)).get(0);
        if(result.getEngineNumber().equals(engineNumber) && result.getFrameNumber().equals(frameNumber)){
            UserDO userDO = findUserByName(Identifier);
            userDO.setCarNumber(carNumber);
            db.updateDataSelective(userDO);
            result.setOwner(Identifier);
            userPointDB.updateByPrimaryKey(userPointDO);
            carDB.updateByPrimaryKey(result);
        }else {
            throw new UserException("车架号及发动机号验证失败");
        }
        return 1;
    }

    /**
     * 获取用户积分信息
     *
     * @param identifier
     * @return
     */
    @Override
    public UserPointDO getUserPointInformation(String identifier) {
        UserPointExample userPointExample = new UserPointExample();
        UserPointExample.Criteria userPointCriteria = userPointExample.createCriteria();
        userPointCriteria.andIdentifierEqualTo(identifier);
        UserPointDO userPointDO = userPointDB.selectByExample(userPointExample).get(0);
        return userPointDO;
    }
}
