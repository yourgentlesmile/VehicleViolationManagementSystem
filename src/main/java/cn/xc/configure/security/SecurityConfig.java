package cn.xc.configure.security;

import cn.xc.configure.filter.IndexFilter;
import cn.xc.constant.RoleNameConstant;
import cn.xc.security.RestAuthenticationFailureHandler;
import cn.xc.security.RestAuthenticationSuccessHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.cors.CorsUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @version V1.0
 *  spring-security配置文件
 * @Author XiongCheng
 * @Date 2018/2/2 14:22.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static Logger logger = LoggerFactory.getLogger(SecurityConfig.class);
    @Autowired
    private AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> authenticationDetailsSource;
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private IndexFilter filter;
    @Autowired
    private RestAuthenticationSuccessHandler successHandler;
    @Autowired
    private LogoutSuccessHandler successLogoutHandler;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.ignoring().antMatchers("/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(filter,ChannelProcessingFilter.class)
        .authorizeRequests()
        .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
        .antMatchers("/Api/Admin/**","/Admin/**").hasRole(RoleNameConstant.ROLE_ADMIN_FOR_CONFIG)
        .antMatchers("/Api/User/**","/User/**").hasRole(RoleNameConstant.ROLE_CUSTOM_USER_FOR_CONFIG)
        .anyRequest().permitAll()
        .and()
        .formLogin().loginPage("/login").permitAll()
        .loginProcessingUrl("/login")
        .authenticationDetailsSource(authenticationDetailsSource)
        .successHandler(successHandler)
        .failureHandler(new RestAuthenticationFailureHandler())
        .and().logout().logoutSuccessHandler(successLogoutHandler)
        .and().csrf().disable();
    }
}