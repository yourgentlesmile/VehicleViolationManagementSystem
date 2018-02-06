package cn.xc.security;

import cn.xc.service.IUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 *  用户登录信息认证支持类
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/2/3 12:23.
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private IUserDetailService userDetailsService;

    /**
     *  验证用户是否正确
     * @param authentication 需要验证的用户
     * @return 返回验证成功token
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication)
    throws AuthenticationException {
        CustomWebAuthenticationDetails details = (CustomWebAuthenticationDetails) authentication.getDetails();  // 如上面的介绍，这里通过authentication.getDetails()获取详细信息
        // 下面是验证逻辑，验证通过则返回UsernamePasswordAuthenticationToken，
        // 否则，可直接抛出错误（AuthenticationException的子类，在登录验证不通过重定向至登录页时可通过session.SPRING_SECURITY_LAST_EXCEPTION.message获取具体错误提示信息）
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        UserDetails user = userDetailsService.loadUserByUsername(token.getName(),details.getUserType());
        if (user == null) {
            throw new UsernameNotFoundException("找不到该用户");
        }
        if(!user.getPassword().equals(token.getCredentials().toString()))
        {
            throw new BadCredentialsException("密码错误");
        }
        return new UsernamePasswordAuthenticationToken(user,user.getPassword(),user.getAuthorities());

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}