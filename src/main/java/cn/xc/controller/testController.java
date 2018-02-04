package cn.xc.controller;

import cn.xc.entity.RespEntity;
import cn.xc.enums.RespCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @version V1.0
 * @Description: 新想法与功能实验类
 * @Author XiongCheng
 * @Date 2018/1/17 16:06.
 */
@Controller
public class testController {
    protected static Logger logger = LoggerFactory.getLogger(testController.class);
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            return "success";
        }
        return "index";
    }

    @GetMapping("")
    @ResponseBody
    public RespEntity failurePage(){
        return new RespEntity(RespCode.SUCCESS,"登录失败");
    }
    @GetMapping("/success")
    @ResponseBody
    public RespEntity successPage(){
        return new RespEntity(RespCode.SUCCESS,"登录成功");
    }

}
