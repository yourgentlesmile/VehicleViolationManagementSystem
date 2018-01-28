package cn.xc.service.impl;

import cn.xc.constant.BulletinBoardConstant;
import cn.xc.dao.IBulletinBoardDAO;
import cn.xc.entity.DO.BaseDO;
import cn.xc.entity.DO.BulletinBoardDO;
import cn.xc.exception.DAONotExistException;
import cn.xc.service.IBulletinBoardService;
import cn.xc.service.constant.ServiceConstant;
import cn.xc.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @version V1.0
 * @Description: 公告板服务实现类
 * @Author XiongCheng
 * @Date 2018/1/23 16:33.
 */
@Service
public class BulletinBoardServiceImpl implements IBulletinBoardService{

    @Autowired
    private IBulletinBoardDAO db;

    /**
     * @Description: 添加公告
     * @param value 待添加的数据，包含数据：发布者id，正文，类型
     */
    @Override
    public void addBulletin(BulletinBoardDO value) throws DAONotExistException {
        if (db != null) {
            db.insertData(value);
        }else{
            throw new DAONotExistException("DAO autowired is null");
        }
    }

    /**
     * @Description: 单个删除公告
     * @param value 待删除的数据
     * @Description: 删除公告
     */
    @Override
    public void deleteBulletin(BulletinBoardDO value) throws DAONotExistException{
        if (db != null) {
            db.deleteDataByPrimaryKey(value.getId());
        }

    }

    /**
     * @Description: 批量删除公告
     * @param list
     * @throws DAONotExistException
     */
    @Override
    public void deleteBulletinByList(List<BulletinBoardDO> list) throws DAONotExistException{
        List<Long> idCollection = new ArrayList<>();
        for (BulletinBoardDO item : list) {
            idCollection.add(item.getId());
        }
        if (db != null) {
            db.deleteDataByList(idCollection);
        }else{
            throw new DAONotExistException("DAO autowired is null");
        }
    }

    /**
     * @Description: 按条件查询公告信息
     * @param queryType 查询方式 0:根据发布者ID, 1:根据公告类型
     *                  2:根据创建时间, 3:根据最后修改时间 4:获取所有公告
     * @param param     查询参数
     * @return 查询结果集 java.util.List&lt;BulletinBoardDO&gt;
     * @see BulletinBoardConstant
     */
    @Override
    public List<BulletinBoardDO> listDataByCondition(int queryType, String param) throws DAONotExistException{
        if (db == null) {
            throw new DAONotExistException("DAO autowired is null");
        }
        if(param == null && (queryType != BulletinBoardConstant.FETCH_ALL)){
            throw new IllegalArgumentException("When queryType isn't FETCH_ALL，param can't be null");
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
                List<Date> queryParam = DateUtil.MillisToDateList(param);
                if(queryParam.size() != 2){
                    throw new IllegalArgumentException("Need two argument，actual the number of argument in list is：" + queryParam.size());
                }
                rawResult = db.getDataByGmtCreateBetween(queryParam.get(ServiceConstant.INDEX_START_TIME),queryParam.get(ServiceConstant.INDEX_END_TIME));
                break;
            case BulletinBoardConstant.QUERY_BY_GMT_MODIFIED:
                List<Date> timeScope = DateUtil.MillisToDateList(param);
                if(timeScope.size() != 2){
                    throw new IllegalArgumentException("Need two argument，actual the number of argument in list is：" + timeScope.size());
                }
                rawResult = db.getDataByGmtModifiedBetween(timeScope.get(ServiceConstant.INDEX_START_TIME),timeScope.get(ServiceConstant.INDEX_END_TIME));
                break;
            case BulletinBoardConstant.FETCH_ALL:
                rawResult = db.findAll();
                break;
            default:
                throw new IllegalArgumentException("Query Argument is not within the scope of the definition，actual passed query argument is:" + queryType);
        }
        List<BulletinBoardDO> convertedResult = new ArrayList<>();
        for (BaseDO baseDO : rawResult) {
            convertedResult.add((BulletinBoardDO)baseDO);
        }
        return convertedResult;
    }

    /**
     * @Description: 按更新条件更新公告信息
     * @param updateType 更新方式 0:全部更新 1:批量全部更新 2:部分更新(非null字段更新)
     *                   3:批量部分更新
     * @param param      参数类型详情则参看本类静态字段updateType字段
     * @see BulletinBoardConstant
     */
    @Override
    public void updateBulletin(int updateType, Object param) throws DAONotExistException{
        if (db == null) {
            throw new DAONotExistException("DAO autowired is null");
        }
        if(param == null){
            throw new IllegalArgumentException("param can't be null");
        }
        switch(updateType){
            case BulletinBoardConstant.UPDATE_COLUMN_ALL:
                db.updateData((BaseDO) param);
                break;
            case BulletinBoardConstant.UPDATE_COLUMN_ALL_BY_LIST:
                List<BaseDO> value = (List<BaseDO>)param;
                if(value.size() == 0){
                    throw new IllegalArgumentException("list can't be empty");
                }
                db.updateDataByList(value);
                break;
            case BulletinBoardConstant.UPDATE_COLUMN_SELECTIVE:
                db.updateDataSelective((BaseDO) param);
                break;
            case BulletinBoardConstant.UPDATE_COLUMN_SELECTIVE_BY_LIST:
                List<BaseDO> val = (List<BaseDO>)param;
                if(val.size() == 0){
                    throw new IllegalArgumentException("list can't be empty");
                }
                db.updateDataByListSelective(val);
                break;
        }
    }
}
