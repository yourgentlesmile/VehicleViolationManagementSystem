package cn.xc.dao;

import cn.xc.entity.DO.BaseDO;

import java.util.List;

/**
 * @version V1.0
 * @Description: 管理员数据表操作接口
 * @Author XiongCheng
 * @Date 2018/1/20 14:31.
 */
public interface IAdminDAO extends BaseDAO{

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
