package cn.xc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version V1.0
 * @Description: 新想法与功能实验类
 * @Author XiongCheng
 * @Date 2018/1/17 16:06.
 */
@Controller
public class testController {
    protected static Logger logger = LoggerFactory.getLogger(testController.class);
    @RequestMapping("/index")
    @ResponseBody
    public String say(String account, String password){
        logger.info("account = " + account +"----password = " + password);
        return account + "----" + password;
    }
}
