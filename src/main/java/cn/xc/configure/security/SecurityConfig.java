package cn.xc.configure.security;

import cn.xc.security.RestAuthenticationFailureHandler;
import cn.xc.service.IAdminService;
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
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * @version V1.0
 * @Description: spring-security配置文件
 * @Author XiongCheng
 * @Date 2018/2/2 14:22.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static Logger logger = LoggerFactory.getLogger(SecurityConfig.class);
    @Autowired
    private IAdminService adminService;
    @Autowired
    private AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> authenticationDetailsSource;
    @Autowired
    private AuthenticationProvider authenticationProvider;

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
        http.authorizeRequests()
        .antMatchers("/Api/Admin/**").hasRole("ADMIN")
        .antMatchers("/Admin/**").authenticated()
        .antMatchers("/Api/User/**").hasRole("USER")
        .antMatchers("/User/**").authenticated()
        .anyRequest().permitAll()
        .and()
        .formLogin().loginPage("/login").permitAll()
        .loginProcessingUrl("/login")
        .failureHandler(new RestAuthenticationFailureHandler())
        .authenticationDetailsSource(authenticationDetailsSource)
        .and().csrf().disable();
    }
}