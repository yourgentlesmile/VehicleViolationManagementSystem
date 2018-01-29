package cn.xc.service;

import cn.xc.entity.VO.RegisterVO;
import cn.xc.entity.VO.UserVO;

/**
 * @version V1.0
 * @Description: 用户模块服务类接口
 * @Author XiongCheng
 * @Date 2018/1/28 10:20.
 */
public interface IUserService {
    /**
     * @Description: 用户注册
     * @param user
     */
    void registerUser(RegisterVO user);

    /**
     * @Description: 用户更新信息
     * @param user 待更新数据
     */
    void updateInformation(UserVO user);

    /**
     * @Description: 获得用户信息
     * @param id 用户id
     * @return 获取到的用户信息
     */
    UserVO getAdminInformation(Long id);

    /**
     * @Description: 校验密码是否正确
     * @param identifier
     * @param password
     * @return
     */
    UserVO checkPassword(String identifier, String password);

    /**
     * @Description: 更新密码
     * @param identifier 账号
     * @param password 密码
     */
    int updatePassword(String identifier, String password);

    /**
     * @Description: 检查用户名是否可用
     * @param identifier
     * @return
     */
    boolean checkIdentifierUnique(String identifier);
}
