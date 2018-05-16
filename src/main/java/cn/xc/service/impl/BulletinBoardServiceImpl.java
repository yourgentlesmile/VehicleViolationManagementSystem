package cn.xc.service.impl;

import cn.xc.constant.BulletinBoardConstant;
import cn.xc.dao.IBulletinBoardDAO;
import cn.xc.entity.DO.BaseDO;
import cn.xc.entity.DO.BulletinBoardDO;
import cn.xc.exception.BulletinBoardException;
import cn.xc.service.IBulletinBoardService;
import cn.xc.service.constant.ServiceConstant;
import cn.xc.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *  公告板服务实现类
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/1/23 16:33.
 */
@Service
public class BulletinBoardServiceImpl implements IBulletinBoardService{

    @Autowired
    private IBulletinBoardDAO db;

    /**
     *  添加公告
     * @param value 待添加的数据，包含数据：发布者id，正文，类型
     */
    @Override
    public void addBulletin(BulletinBoardDO value) throws BulletinBoardException {
        if (db != null) {
            db.insertData(value);
        }else{
            throw new BulletinBoardException("DAO autowired is null");
        }
    }

    /**
     *  单个删除公告
     * @param value 待删除的数据
     *  删除公告
     */
    @Override
    public void deleteBulletin(BulletinBoardDO value) throws BulletinBoardException {
        if (db != null) {
            db.deleteDataByPrimaryKey(value.getId());
        }

    }

    /**
     *  批量删除公告
     * @param list
     * @throws BulletinBoardException
     */
    @Override
    public void deleteBulletinByList(List<Long> list) throws BulletinBoardException {
        if (db != null) {
            db.deleteDataByList(list);
        }else{
            throw new BulletinBoardException("DAO autowired is null");
        }
    }

    /**
     *  按条件查询公告信息
     * @param queryType 查询方式 0:根据发布者ID, 1:根据公告类型
     *                  2:根据创建时间, 3:根据最后修改时间 4:获取所有公告
     * @param param     查询参数
     * @return 查询结果集 java.util.List&lt;BulletinBoardDO&gt;
     * @see BulletinBoardConstant
     */
    @Override
    public List<BulletinBoardDO> listDataByCondition(int queryType, String param) throws BulletinBoardException {
        if (db == null) {
            throw new BulletinBoardException("DAO autowired is null");
        }
        if(param == null && (queryType != BulletinBoardConstant.FETCH_ALL)){
            throw new BulletinBoardException("When queryType isn't FETCH_ALL，param can't be null");
        }
        List<BaseDO> rawResult = null;
        switch (queryType){
            case BulletinBoardConstant.QUERY_BY_PUBLISHER_ID:
                rawResult = db.getDataByPublisherId(Long.parseLong(param));
                break;
            case BulletinBoardConstant.QUERY_BY_TYPE:
                rawResult = db.getDataByType((Integer.parseInt(param)));
                break;
            case BulletinBoardConstant.QUERY_BY_GMT_CREATE:
                List<Timestamp> queryParam = Util.MillisToDateList(param);
                if(queryParam.size() != 2){
                    throw new BulletinBoardException("Need two argument，actual the number of argument in list is：" + queryParam.size());
                }
                rawResult = db.getDataByGmtCreateBetween(queryParam.get(ServiceConstant.INDEX_START_TIME),queryParam.get(ServiceConstant.INDEX_END_TIME));
                break;
            case BulletinBoardConstant.QUERY_BY_GMT_MODIFIED:
                List<Timestamp> timeScope = Util.MillisToDateList(param);
                if(timeScope.size() != 2){
                    throw new BulletinBoardException("Need two argument，actual the number of argument in list is：" + timeScope.size());
                }
                rawResult = db.getDataByGmtModifiedBetween(timeScope.get(ServiceConstant.INDEX_START_TIME),timeScope.get(ServiceConstant.INDEX_END_TIME));
                break;
            case BulletinBoardConstant.FETCH_ALL:
                rawResult = db.findAll();
                break;
            default:
                throw new BulletinBoardException("Query Argument is not within the scope of the definition，actual passed query argument is:" + queryType);
        }
        List<BulletinBoardDO> convertedResult = new ArrayList<>();
        for (BaseDO baseDO : rawResult) {
            convertedResult.add((BulletinBoardDO)baseDO);
        }
        return convertedResult;
    }

    /**
     *  按更新条件更新公告信息
     * @param updateType 更新方式 0:全部更新 1:批量全部更新 2:部分更新(非null字段更新)
     *                   3:批量部分更新
     * @param param      参数类型详情则参看本类静态字段updateType字段
     * @see BulletinBoardConstant
     */
    @Override
    public void updateBulletin(int updateType, Object param) throws BulletinBoardException {
        if (db == null) {
            throw new BulletinBoardException("DAO autowired is null");
        }
        if(param == null){
            throw new BulletinBoardException("param can't be null");
        }
        switch(updateType){
            case BulletinBoardConstant.UPDATE_COLUMN_ALL:
                db.updateData((BaseDO) param);
                break;
            case BulletinBoardConstant.UPDATE_COLUMN_ALL_BY_LIST:
                List<BaseDO> value = (List<BaseDO>)param;
                if(value.size() == 0){
                    throw new BulletinBoardException("list can't be empty");
                }
                db.updateDataByList(value);
                break;
            case BulletinBoardConstant.UPDATE_COLUMN_SELECTIVE:
                db.updateDataSelective((BaseDO) param);
                break;
            case BulletinBoardConstant.UPDATE_COLUMN_SELECTIVE_BY_LIST:
                List<BaseDO> val = (List<BaseDO>)param;
                if(val.size() == 0){
                    throw new BulletinBoardException("list can't be empty");
                }
                db.updateDataByListSelective(val);
                break;
        }
    }
}
