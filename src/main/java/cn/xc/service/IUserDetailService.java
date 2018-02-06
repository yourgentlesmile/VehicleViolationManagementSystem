package cn.xc.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *  用户认证服务类接口
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/2/3 12:28.
 */
public interface IUserDetailService {
    UserDetails loadUserByUsername(String username,String token) throws UsernameNotFoundException;
}
