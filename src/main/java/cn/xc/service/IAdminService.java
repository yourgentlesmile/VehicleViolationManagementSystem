package cn.xc.service;

import cn.xc.entity.DO.AdminDO;
import cn.xc.entity.VO.AdminVO;
import cn.xc.entity.VO.RegisterVO;

/**
 * @version V1.0
 * @Description: 管理员模块服务类接口
 * @Author XiongCheng
 * @Date 2018/1/27 22:10.
 */
public interface IAdminService {
    /**
     * @Description: 用户注册
     * @param user
     */
    void registerAdmin(RegisterVO user);

    /**
     * @Description: 用户更新信息
     * @param user 待更新数据
     */
    void updateInformation(AdminVO user);

    /**
     * @Description: 获得用户信息
     * @param id 用户id
     * @return 获取到的用户信息
     */
    AdminVO getAdminInformation(Long id);

    /**
     * @Description: 校验密码是否正确
     * @param identifier
     * @param password
     * @return
     */
    AdminDO findUserByName(String identifier);

    /**
     * @Description: 更新密码
     * @param identifier 账号
     * @param password 密码
     */
    int updatePassword(String identifier,String password);

    /**
     * @Description: 检查用户名是否可用
     * @param identifier
     * @return
     */
    boolean checkIdentifierUnique(String identifier);
}
