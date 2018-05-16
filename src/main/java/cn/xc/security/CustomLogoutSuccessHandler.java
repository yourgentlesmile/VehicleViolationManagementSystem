package cn.xc.security;

import cn.xc.entity.RespEntity;
import cn.xc.enums.RespCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 退出登录成功处理类，退出登录后将不再跳转到登录页，而是返回JSON
 *
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018-05-10 13:50.
 */
@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(new RespEntity(RespCode.SUCCESS,"登出成功"));
        response.getWriter().write(json);
        response.getWriter().flush();
    }
}
