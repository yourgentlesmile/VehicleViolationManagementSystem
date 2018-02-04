package cn.xc.controller;

import cn.xc.constant.LoginConstant;
import cn.xc.entity.RespEntity;
import cn.xc.enums.RespCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @version V1.0
 * @Description: 登录相关控制类
 * @Author XiongCheng
 * @Date 2018/2/4 16:53.
 */
@Controller
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);
    @GetMapping("")
    public String mainPage(){
        return "index";
    }
    @GetMapping("/makeCerPic")
    public String getPic() {
        return "makeCerPic";
    }
    @PostMapping("/checkCaptcha")
    @ResponseBody
    public RespEntity checkCaptcha(@RequestParam(name = "code",required = false) String code, HttpServletRequest request) {
        String validCode = (String) request.getSession().getAttribute(LoginConstant.PARAMETER_CAPTCHA);
        boolean result = false;
        if(code == null){
            result = false;
        }
        result = validCode.equals(code);
        return new RespEntity(RespCode.SUCCESS,result);
    }
}
