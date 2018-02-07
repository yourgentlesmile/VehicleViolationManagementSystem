package cn.xc.service.impl;

import cn.xc.constant.ConsultationListConstant;
import cn.xc.dao.IConsultationListDAO;
import cn.xc.dao.condition.ConsultationListExample;
import cn.xc.entity.DO.ConsultationListDO;
import cn.xc.exception.ConsultationListException;
import cn.xc.service.IConsultationService;
import cn.xc.service.constant.ServiceConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 *  咨询单服务实现类
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/2/6 10:17.
 */
@Service
public class ConsultationServiceImpl implements IConsultationService{
    @Autowired
    private IConsultationListDAO db;
    /**
     * 创建新的咨询单
     *
     * @param form 新的咨询单数据
     * @throws ConsultationListException
     */
    @Override
    public void createNewConsultation(ConsultationListDO form) throws ConsultationListException {
        if (form == null) {
            throw new ConsultationListException("传入参数不能为空");
        }
        db.insert(form);
    }

    /**
     * 删除咨询单
     *
     * @param id 需要删除的咨询单号集合
     * @throws ConsultationListException
     */
    @Override
    public void deleteConsultation(List<Long> id) throws ConsultationListException {
        if (id == null) {
            throw new ConsultationListException("传入参数不能为空");
        }
        ConsultationListExample example = new ConsultationListExample();
        ConsultationListExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(id);
        db.deleteByExample(example);
    }

    /**
     * 咨询单回应
     *
     * @param form 已回应的咨询单
     * @throws ConsultationListException
     */
    @Override
    public void responseConsultation(ConsultationListDO form) throws ConsultationListException {
        updateConsultation(form);
    }

    /**
     * 咨询单修改
     *
     * @param form 修改的咨询单
     * @throws ConsultationListException
     */
    @Override
    public void updateConsultation(ConsultationListDO form) throws ConsultationListException {
        if (form == null) {
            throw new ConsultationListException("传入参数不能为空");
        }
        if (form.getId() == null) {
            throw new ConsultationListException("传入参数中的id为空");
        }
        db.updateByPrimaryKey(form);
    }

    /**
     * 查询咨询单
     *
     * @param type  查询类型 详见常量类ConsultationListConstent
     * @param param 查询参数
     * @return 查询结果
     * @throws ConsultationListException
     * @see ConsultationListConstant
     */
    @Override
    public List<ConsultationListDO> listConsultationByCondition(int type, Object param) throws ConsultationListException {
        if(param == null) {
            throw new ConsultationListException("param can't be null");
        }
        ConsultationListExample example = new ConsultationListExample();
        ConsultationListExample.Criteria criteria = example.createCriteria();
        boolean isParamValid = false;
        List<ConsultationListDO> result = null;
        switch (type){
            case ConsultationListConstant.QUERY_BY_ID:
                isParamValid = param instanceof Long;
                if (!isParamValid){
                    throw new ConsultationListException("当以ID查询时，param的参数必须为Long类型");
                }
                criteria.andIdEqualTo((Long) param);
                break;
            case ConsultationListConstant.QUERY_BY_TYPE:
                isParamValid = param instanceof Integer;
                if (!isParamValid){
                    throw new ConsultationListException("当以type查询时，param的参数必须为Integer类型");
                }
                criteria.andTypeEqualTo((Integer) param);
                break;
            case ConsultationListConstant.QUERY_BY_IDENTIFIER:
                isParamValid = param instanceof String;
                if (!isParamValid){
                    throw new ConsultationListException("当以identifier查询时，param的参数必须为String类型");
                }
                criteria.andIdentifierEqualTo((String) param);
                break;
            case ConsultationListConstant.QUERY_BY_CREATERID:
                isParamValid = param instanceof Long;
                if (!isParamValid){
                    throw new ConsultationListException("当以createrID查询时，param的参数必须为Long类型");
                }
                criteria.andCreaterIdEqualTo((Long) param);
                break;
            case ConsultationListConstant.QUERY_BY_PROCESSORID:
                isParamValid = param instanceof Long;
                if (!isParamValid){
                    throw new ConsultationListException("当以processorId查询时，param的参数必须为Long类型");
                }
                criteria.andProcessorIdEqualTo((Long) param);
                break;
            case ConsultationListConstant.QUERY_BY_STATUS:
                isParamValid = param instanceof Integer;
                if (!isParamValid){
                    throw new ConsultationListException("STATUS，param的参数必须为Integer类型");
                }
                criteria.andStatusEqualTo((Integer) param);
                break;
            case ConsultationListConstant.QUERY_BETWEEN_RESPONSETIME:
                isParamValid = param instanceof List;
                if (!isParamValid){
                    throw new ConsultationListException("当以responseTime查询时，param的参数必须为java.util.List<Timestamp>类型");
                }
                List<Timestamp> responseTimeScope = (List<Timestamp>) param;
                if(responseTimeScope.size() != 2){
                    throw new ConsultationListException("需要两个参数，实际传入的list中的参数个数为： " + responseTimeScope.size());
                }
                criteria.andResponseTimeBetween(responseTimeScope.get(ServiceConstant.INDEX_START_TIME),responseTimeScope.get(ServiceConstant.INDEX_END_TIME));
                break;
            case ConsultationListConstant.QUERY_BETWEEN_GMTCREATE:
                isParamValid = param instanceof List;
                if(!isParamValid){
                    throw new ConsultationListException("当以GMTCREATE查询时，param的参数必须为java.util.List<Timestamp>类型");
                }
                List<Timestamp> createTimeScope = (List<Timestamp>) param;
                if(createTimeScope.size() != 2){
                    throw new ConsultationListException("需要两个参数，实际传入的list中的参数个数为： " + createTimeScope.size());
                }
                criteria.andGmtCreateBetween(createTimeScope.get(ServiceConstant.INDEX_START_TIME),createTimeScope.get(ServiceConstant.INDEX_END_TIME));
                break;
            case ConsultationListConstant.QUERY_BETWEEN_GMTMODIFIED:
                isParamValid = param instanceof List;
                if(!isParamValid){
                    throw new ConsultationListException("当以GMTMODIFIED查询时，param的参数必须为java.util.List<Timestamp>类型");
                }
                List<Timestamp> modifiedTimeScope = (List<Timestamp>) param;
                if(modifiedTimeScope.size() != 2){
                    throw new ConsultationListException("需要两个参数，实际传入的list中的参数个数为： " + modifiedTimeScope.size());
                }
                criteria.andGmtModifiedBetween(modifiedTimeScope.get(ServiceConstant.INDEX_START_TIME),modifiedTimeScope.get(ServiceConstant.INDEX_END_TIME));
                break;
            default:
                throw new ConsultationListException("Query Argument is not within the scope of the definition，actual passed query argument is:" + type);
        }
        result = db.selectByExample(example);
        return result;
    }

    /**
     * 获取所有咨询单
     *
     * @return 查询结果
     * @throws ConsultationListException
     */
    @Override
    public List<ConsultationListDO> findAll() throws ConsultationListException {
        ConsultationListExample example = new ConsultationListExample();
        ConsultationListExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeletedEqualTo(ServiceConstant.IS_DELETE_NO);
        return db.selectByExample(example);
    }
}
