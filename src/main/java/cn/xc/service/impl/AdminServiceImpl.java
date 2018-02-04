package cn.xc.service.impl;

import cn.xc.dao.IAdminDAO;
import cn.xc.entity.DO.AdminDO;
import cn.xc.entity.DO.BaseDO;
import cn.xc.entity.VO.AdminVO;
import cn.xc.entity.VO.RegisterVO;
import cn.xc.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version V1.0
 * @Description: 管理员服务实现类
 * @Author XiongCheng
 * @Date 2018/1/28 10:56.
 */
@Service
public class AdminServiceImpl implements IAdminService {
    @Autowired
    private IAdminDAO db;

    /**
     * @Description: 用户注册
     * @param user
     */
    @Override
    public void registerAdmin(RegisterVO user) {
        AdminDO toDB = new AdminDO();
        toDB.setIdentifier(user.getIdentifier());
        toDB.setAdminPassword(user.getAdminPassword());
        db.insertData(toDB);
    }

    /**
     * @Description: 用户更新信息
     * @param user 待更新数据
     */
    @Override
    public void updateInformation(AdminVO user) {
        AdminDO toDB = new AdminDO(user);
        db.updateDataSelective(toDB);
    }

    /**
     * @Description: 获得用户信息
     * @param id 用户id
     * @return 获取到的用户信息
     */
    @Override
    public AdminVO getAdminInformation(Long id) {
        AdminDO fromDB = (AdminDO) db.getDataByPrimaryKey(id);
        return new AdminVO(fromDB);
    }

    /**
     * @Description: 校验密码是否正确
     * @param identifier
     * @return
     */
    @Override
    public AdminDO findUserByName(String identifier) {
        List<BaseDO> result = db.getDataByIdentifier(identifier);
        if(result.size() == 0){
            return null;
        }
        AdminDO prepare = (AdminDO) result.get(0);
        return prepare;
    }

    /**
     * @param identifier 账号
     * @param password   密码
     * @Description: 更新密码
     */
    @Override
    public int updatePassword(String identifier, String password) {
        List<BaseDO> result = db.getDataByIdentifier(identifier);
        if(result.size() == 0){
            return -1;
        }
        AdminDO prepare = (AdminDO) result.get(0);
        prepare.setAdminPassword(password);
        db.updateDataSelective(prepare);
        return 0;
    }

    /**
     * @Description: 检查用户名是否可用
     * @param identifier
     * @return
     */
    @Override
    public boolean checkIdentifierUnique(String identifier) {
        int result = db.checkIdentifierUnique(identifier);
        return result == 0 ? true : false;
    }
}
