package cn.xc.service.impl;

import cn.xc.constant.LoginConstant;
import cn.xc.constant.RoleNameConstant;
import cn.xc.entity.DO.AdminDO;
import cn.xc.entity.DO.UserDO;
import cn.xc.service.IAdminService;
import cn.xc.service.IUserDetailService;
import cn.xc.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *  用户认证服务类，包含认证普通用户登录以及管理员用户
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/2/2 13:27.
 */
@Component
public class UserDetailServiceImpl implements IUserDetailService {
    private static Logger logger = LoggerFactory.getLogger(IUserDetailService.class);
    private final IUserService userService;
    private final IAdminService adminService;

    public UserDetailServiceImpl(IUserService userService, IAdminService adminService) {
        logger.info("------------IUserDetailService constructure invoke");
        this.userService = userService;
        this.adminService = adminService;
    }

    @Override
    public UserDetails loadUserByUsername(String username,String userType) throws UsernameNotFoundException {
        logger.info("------------IUserDetailService loadUserByUsername invoke ,username = " + username + " - userType = " + userType);
        if(LoginConstant.USER_TYPE_CUSTOM_USER.equals(userType)){
            UserDO user = userService.findUserByName(username);
            if(user == null){
                throw new UsernameNotFoundException("Username [" + username +"] not found");
            }
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(RoleNameConstant.ROLE_CUSTOM_USER_FOR_DESTRIBUTION));
            return new User(user.getIdentifier(),user.getUserPassword(),authorities);
        }
        else if(LoginConstant.USER_TYPE_ADMIN.equals(userType)){
            AdminDO user = adminService.findUserByName(username);
            if(user == null){
                throw new UsernameNotFoundException("Adminname [" + username +"] not found");
            }
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(RoleNameConstant.ROLE_ADMIN_FOR_DESTRIBUTION));
            return new User(user.getIdentifier(),user.getAdminPassword(),authorities);

        }
        throw new UsernameNotFoundException("非指定登录种类");
    }

}
