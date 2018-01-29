package cn.xc.dao;

import cn.xc.entity.DO.BaseDO;

import java.util.List;

/**
 * @version V1.0
 * @Description: 用户信息数据表操作接口
 * @Author XiongCheng
 * @Date 2018/1/21 23:20.
 */
public interface IUserDAO extends BaseDAO {
    /**
     * @Description: 根据管理员账号查找
     * @param identifier 管理员账号
     * @return       查询到的结果集
     */
    List<BaseDO> getDataByIdentifier(String identifier);
    /**
     * @Description: 检查账号名是否唯一
     * @param identifier 待检查的账号
     * @return       0:是唯一 1:已注册
     */
    Integer checkIdentifierUnique(String identifier);
}
