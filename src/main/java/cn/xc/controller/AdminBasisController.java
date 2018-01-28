package cn.xc.controller;

import cn.xc.controller.constant.ControllerConstant;
import cn.xc.entity.VO.RegisterVO;
import cn.xc.service.IAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version V1.0
 * @Description: 管理员基本前端控制类
 * @Author XiongCheng
 * @Date 2018/1/28 11:40.
 */
@RequestMapping("/admin")
public class AdminBasisController {
    private static Logger logger = LoggerFactory.getLogger(AdminBasisController.class);
    @Autowired
    private IAdminService service;
    @PostMapping("/add")
    @ResponseBody
    public String registerAdmin(@RequestBody RegisterVO user){
        service.registerAdmin(user);
        return ControllerConstant.ACTION_SUCCESS;
    }
}
