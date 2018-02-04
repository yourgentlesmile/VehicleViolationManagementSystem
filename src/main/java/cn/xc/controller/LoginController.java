package cn.xc.controller;

import cn.xc.constant.LoginConstant;
import cn.xc.security.CustomWebAuthenticationDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @version V1.0
 * @Description: 登录相关控制类
 * @Author XiongCheng
 * @Date 2018/2/4 16:53.
 */
@Controller
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    @Qualifier(value = "customAuthenticationProvider")
    private AuthenticationProvider authManager;

//    @Autowired
//    private SessionAuthenticationStrategy sessionStrategy;

    @Autowired(required = false)
    private RememberMeServices rememberMeServices;

    @Autowired(required = false)
    private ApplicationEventPublisher eventPublisher;

    @PostMapping("/login")
    public void loginPost(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        // 创建一个用户名密码登陆信息
        String username = request.getParameter(LoginConstant.PARAMETER_USERNAME);
        String password = request.getParameter(LoginConstant.PARAMETER_PASSWORD);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        token.setDetails(new CustomWebAuthenticationDetails(request));
        // 用户名密码登陆效验
        Authentication authResult = authManager.authenticate(token);

        // 在 session 中保存 authResult
        //sessionStrategy.onAuthentication(authResult, request, response);

        // 在当前访问线程中设置 authResult
        SecurityContextHolder.getContext().setAuthentication(authResult);

        // 如果记住我在配置文件中有配置
        if (rememberMeServices != null) {
            rememberMeServices.loginSuccess(request, response, authResult);
        }

        // 发布登陆成功事件
        if (eventPublisher != null) {
            eventPublisher.publishEvent(new InteractiveAuthenticationSuccessEvent(authResult, this.getClass()));
        }
    }
}
