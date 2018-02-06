package cn.xc.controller;

import cn.xc.entity.RespEntity;
import cn.xc.enums.RespCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 新想法与功能实验类
 * @version V1.0
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

    @GetMapping("/success")
    @ResponseBody
    public RespEntity successPage(){
        return new RespEntity(RespCode.SUCCESS,"登录成功");
    }

    @GetMapping("/Api/User/test")
    @ResponseBody
    public String a(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        String s = userName + ((UserDetails)principal).getAuthorities().toString();
        return s;
    }
    @GetMapping("/User/test")
    @ResponseBody
    public String b(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        String s = userName + ((UserDetails)principal).getAuthorities().toString();
        return s;
    }
    @GetMapping("/Admin/test")
    @ResponseBody
    public String c(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        String s = userName + ((UserDetails)principal).getAuthorities().toString();
        return s;
    }
    @GetMapping("/Api/Admin/test")
    @ResponseBody
    public String d(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        String s = userName + ((UserDetails)principal).getAuthorities().toString();
        return s;
    }
    @GetMapping("/test/test")
    @ResponseBody
    public String e(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        String s = userName + ((UserDetails)principal).getAuthorities().toString();
        return s;
    }

}
