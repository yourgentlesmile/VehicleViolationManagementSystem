package cn.xc.security;

import cn.xc.constant.LoginConstant;
import cn.xc.entity.DO.AdminDO;
import cn.xc.entity.DO.LogLoginDO;
import cn.xc.entity.DO.UserDO;
import cn.xc.exception.LogLoginException;
import cn.xc.service.IAdminService;
import cn.xc.service.ILogLoginService;
import cn.xc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * 登录失败操作处理类,在登录成功后向session中写入了登录成功的用户ID与用户种类
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/2/7 12:15.
 */
public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Autowired
    private IUserService userService;
    @Autowired
    private IAdminService adminService;
    @Autowired
    private ILogLoginService logLoginService;

    /**
     * Calls the parent class {@code handle()} method to forward or redirect to the target
     * URL, and then calls {@code clearAuthenticationAttributes()} to remove any leftover
     * session data.
     *
     * @param request
     * @param response
     * @param authentication
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        HttpSession session = request.getSession();
        CustomWebAuthenticationDetails details = (CustomWebAuthenticationDetails) authentication.getDetails();
        LogLoginDO logLoginDO = new LogLoginDO();
        if(LoginConstant.USER_TYPE_ADMIN.equals(details.getUserType())){
            AdminDO adminDO = adminService.findUserByName(authentication.getName());

            logLoginDO.setIsAdmin(Integer.parseInt(LoginConstant.USER_TYPE_ADMIN));
            logLoginDO.setLoginUserId(adminDO.getId());
            logLoginDO.setLoginTime(new Timestamp(System.currentTimeMillis()));
            logLoginDO.setLoginUserIdentifier(authentication.getName());
            logLoginDO.setLoginIp(details.getRemoteAddress());


            session.setAttribute(LoginConstant.SESSION_USER_ID,adminDO.getId());
            session.setAttribute(LoginConstant.SESSION_USER_TYPE,LoginConstant.USER_TYPE_ADMIN);
        }
        if(LoginConstant.USER_TYPE_CUSTOM_USER.equals(details.getUserType())){
            UserDO userDO = userService.findUserByName(authentication.getName());

            logLoginDO.setIsAdmin(Integer.parseInt(LoginConstant.USER_TYPE_CUSTOM_USER));
            logLoginDO.setLoginUserId(userDO.getId());
            logLoginDO.setLoginTime(new Timestamp(System.currentTimeMillis()));
            logLoginDO.setLoginUserIdentifier(authentication.getName());
            logLoginDO.setLoginIp(details.getRemoteAddress());

            session.setAttribute(LoginConstant.SESSION_USER_ID,userDO.getId());
            session.setAttribute(LoginConstant.SESSION_USER_TYPE,LoginConstant.USER_TYPE_CUSTOM_USER);
        }
        try {
            logLoginService.addLog(logLoginDO);
        } catch (LogLoginException e) {
            e.printStackTrace();
        }
        String targetUrl = request.getHeader("Referer");
        handle(request, response, authentication);
        clearAuthenticationAttributes(request);
    }
}
