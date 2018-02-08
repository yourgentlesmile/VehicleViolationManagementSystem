package cn.xc.controller;

import cn.xc.constant.LoginConstant;
import cn.xc.entity.DO.LogLoginDO;
import cn.xc.entity.RespEntity;
import cn.xc.enums.RespCode;
import cn.xc.exception.LogLoginException;
import cn.xc.service.ILogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * todo
 *
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/2/8 14:40.
 */
@Controller
public class LogLoginController {
    @Autowired
    private ILogLoginService service;
    @GetMapping(value = {"/Api/User/ListLoginLog","/Api/Admin/ListLoginLog"})
    @ResponseBody
    public RespEntity listLoginLog(HttpServletRequest request) throws LogLoginException {
        HttpSession session = request.getSession(false);
        if (session == null) {
            throw new LogLoginException("session不存在");
        }
        Long userId = (Long) session.getAttribute(LoginConstant.SESSION_USER_ID);
        List<LogLoginDO> list = service.listLog(userId);
        return new RespEntity(RespCode.SUCCESS,list);
    }
}
