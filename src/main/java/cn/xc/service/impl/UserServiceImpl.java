package cn.xc.service.impl;

import cn.xc.dao.IUserDAO;
import cn.xc.entity.DO.BaseDO;
import cn.xc.entity.DO.UserDO;
import cn.xc.entity.VO.RegisterVO;
import cn.xc.entity.VO.UserVO;
import cn.xc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  用户服务实现类
 * 
 * @Author XiongCheng 
 * @version V1.0
 * @Date 2018/1/29 10:21.
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDAO db;

    /**
     *  用户注册
     * @param user
     */
    @Override
    public void registerUser(RegisterVO user) {
        UserDO toDB = new UserDO();
        toDB.setIdentifier(user.getIdentifier());
        toDB.setUserPassword(user.getAdminPassword());
        db.insertData(toDB);
    }

    /**
     *  用户更新信息
     * @param user 待更新数据
     */
    @Override
    public void updateInformation(UserVO user) {
        UserDO toDB = new UserDO(user);
        db.updateDataSelective(toDB);
    }

    /**
     *  获得用户信息
     * @param id 用户id
     * @return 获取到的用户信息
     */
    @Override
    public UserVO getAdminInformation(Long id) {
        UserDO fromDB = (UserDO) db.getDataByPrimaryKey(id);
        return new UserVO(fromDB);
    }

    /**
     *  校验密码是否正确
     * @param identifier
     * @return
     */
    @Override
    public UserDO findUserByName(String identifier) {
        List<BaseDO> result = db.getDataByIdentifier(identifier);
        if(result.size() == 0){
            return null;
        }
        UserDO prepare = (UserDO) result.get(0);
        return prepare;
    }

    /**
     * @param identifier 账号
     * @param password   密码
     *  更新密码
     */
    @Override
    public int updatePassword(String identifier, String password) {
        List<BaseDO> result = db.getDataByIdentifier(identifier);
        if(result.size() == 0){
            return -1;
        }
        UserDO prepare = (UserDO) result.get(0);
        prepare.setUserPassword(password);
        db.updateDataSelective(prepare);
        return 0;
    }

    /**
     *  检查用户名是否可用
     * @param identifier
     * @return
     */
    @Override
    public boolean checkIdentifierUnique(String identifier) {
        int result = db.checkIdentifierUnique(identifier);
        return result == 0 ? true : false;
    }
}
