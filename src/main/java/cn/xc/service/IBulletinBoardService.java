package cn.xc.service;

import cn.xc.entity.DO.BulletinBoardDO;
import cn.xc.exception.BulletinBoardException;

import java.util.List;

/**
 *  公告板服务类接口
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/1/23 15:37.
 */
public interface IBulletinBoardService {

    /**
     *  添加公告
     * @param value 待添加的数据，包含数据：发布者id，正文，类型
     */
    void addBulletin(BulletinBoardDO value) throws BulletinBoardException;
    /**
     *  删除单个公告
     * @param value 待删除的数据
     */
    void deleteBulletin(BulletinBoardDO value) throws BulletinBoardException;

    void deleteBulletinByList(List<Long> list) throws BulletinBoardException;
    /**
     *  查询公告
     * @param queryType 查询方式 0:根据发布者ID, 1:根据公告类型
     *                  2:根据创建时间, 3:根据最后修改时间 4:获取所有公告
     * @param param 查询参数，获取所有公告时填null
     * @return 查询结果集 java.util.List&lt;BulletinBoardDO&gt;
     */
    List<BulletinBoardDO> listDataByCondition(int queryType, String param) throws BulletinBoardException;

    /**
     *  更新公告
     * @param updateType 更新方式 0:全部更新 1:批量全部更新 2:部分更新(非null字段更新)
     *                   3:批量部分更新
     * @param param 参数类型可以是单个BulletinBoardDO，也可以是<code>java.util.List&lt;BulletinBoardDO>
     */
    void updateBulletin(int updateType, Object param) throws BulletinBoardException;
}
