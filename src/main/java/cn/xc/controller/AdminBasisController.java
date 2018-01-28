package cn.xc.controller;

import cn.xc.entity.RespEntity;
import cn.xc.entity.VO.AdminVO;
import cn.xc.entity.VO.RegisterVO;
import cn.xc.enums.RespCode;
import cn.xc.service.IAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@Controller
public class AdminBasisController {
    private static Logger logger = LoggerFactory.getLogger(AdminBasisController.class);
    @Autowired
    private IAdminService service;
    @PostMapping("/add")
    @ResponseBody
    public RespEntity registerAdmin(@RequestBody RegisterVO user){
        service.registerAdmin(user);
        return new RespEntity(RespCode.SUCCESS,null);
    }
    @PostMapping("/update")
    @ResponseBody
    public RespEntity updateAdminInformation(@RequestBody AdminVO user){
        service.updateInformation(user);
        return new RespEntity(RespCode.SUCCESS,null);
    }
    @PostMapping("/changepwd")
    @ResponseBody
    public RespEntity changePassword(String identifier, String password){
        service.updatePassword(identifier,password);
        return new RespEntity(RespCode.SUCCESS,null);
    }
    @PostMapping("/checkIdentifier")
    @ResponseBody
    public RespEntity checkIdentifier(String identifier){
        boolean result = service.checkIdentifierUnique(identifier);
        return new RespEntity(RespCode.SUCCESS,result);
    }
    @PostMapping("/login")
    @ResponseBody
    public RespEntity login(String identifier,String password){
        AdminVO result = service.checkPassword(identifier,password);
        return new RespEntity(RespCode.SUCCESS,result);
    }

}
