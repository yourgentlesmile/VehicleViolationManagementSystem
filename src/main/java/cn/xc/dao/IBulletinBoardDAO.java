package cn.xc.dao;

import cn.xc.entity.DO.BaseDO;

import java.util.List;

/**
 * 公告板数据表操作接口
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/1/21 22:30.
 */
public interface IBulletinBoardDAO extends IBaseDAO {
    /**
     *  根据发布者ID进行查询
     * @param publishId 发布者ID
     * @return       查询到的结果集
     */
    List<BaseDO> getDataByPublisherId(Long publishId);
    /**
     *  根据公告类型进行查询
     * @param type   公告类型
     * @return       查询到的结果集
     */
    List<BaseDO> getDataByType(Integer type);
}
