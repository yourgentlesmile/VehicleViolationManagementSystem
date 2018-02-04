package cn.xc.security;

import cn.xc.constant.LoginConstant;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * @version V1.0
 * @Description: 本类提供了获取用户登录时携带的额外的信息，父类实现了获得remoteAddress与获得sessionId两种信息
 *               此类额外添加了获得用户登录类型的信息。如之后有额外信息需要添加，可在此类实现
 * @Author XiongCheng
 * @Date 2018/2/3 12:21.
 */
public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {
    /**
     *
     */
    private static final long serialVersionUID = 6975601077710753878L;
    private final String userType;


    public CustomWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        userType = request.getParameter(LoginConstant.PARAMETER_USER_TYPE);
    }

    public String getUserType() {
        return userType;
    }

}