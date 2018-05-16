package cn.xc.service;

import cn.xc.entity.DO.UserDO;
import cn.xc.entity.DO.UserPointDO;
import cn.xc.entity.VO.RegisterVO;
import cn.xc.entity.VO.UserVO;
import cn.xc.exception.UserException;
import cn.xc.exception.ViolatingInformationException;

/**
 *  用户模块服务类接口
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/1/28 10:20.
 */
public interface IUserService {
    /**
     *  用户注册
     * @param user
     */
    void registerUser(RegisterVO user);

    /**
     *  用户更新信息
     * @param user 待更新数据
     */
    void updateInformation(UserVO user);

    /**
     *  获得用户信息
     * @param id 用户id
     * @return 获取到的用户信息
     */
    UserVO getUserInformation(Long id);

    /**
     *  校验密码是否正确
     * @param identifier
     * @return
     */
    UserDO findUserByName(String identifier);

    /**
     *  更新密码
     * @param identifier 账号
     * @param password 密码
     */
    int updatePassword(String identifier, String password);

    /**
     *  检查用户名是否可用
     * @param identifier
     * @return
     */
    boolean checkIdentifierUnique(String identifier);

    /**
     * 用户注册车辆
     * @param identifier 用户名
     * @param carNumber 车牌号
     * @param frameNumber 车架号
     * @param engineNumber 发动机号
     * @throws UserException
     * @throws ViolatingInformationException
     * @return
     */
    int registerCar(String identifier, String carNumber,String frameNumber,String engineNumber) throws UserException, ViolatingInformationException;

    /**
     * 获取用户积分信息
     * @param identifier
     * @return
     */
    UserPointDO getUserPointInformation(String identifier);
}
