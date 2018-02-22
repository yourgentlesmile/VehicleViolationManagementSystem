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
import org.springframework.web.bind.annotation.*;

/**
 * 管理员基本前端控制类
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/1/28 11:40.
 *
 */
@RequestMapping("/Admin")
@Controller
public class AdminBasisController {
    private static Logger logger = LoggerFactory.getLogger(AdminBasisController.class);
    @Autowired
    private IAdminService service;
    @PostMapping("/Api/Public/Admin/register")
    @ResponseBody
    public RespEntity registerAdmin(@RequestBody RegisterVO user){
        service.registerAdmin(user);
        return new RespEntity(RespCode.SUCCESS,null);
    }
    @PutMapping("/Api/Admin/update")
    @ResponseBody
    public RespEntity updateAdminInformation(@RequestBody AdminVO user){
        service.updateInformation(user);
        return new RespEntity(RespCode.SUCCESS,null);
    }
    @PutMapping("/Api/Admin/changepwd")
    @ResponseBody
    public RespEntity changePassword(String identifier, String password){
        if(service.updatePassword(identifier,password) == -1){
            return new RespEntity(RespCode.WARN,null);
        }
        return new RespEntity(RespCode.SUCCESS,null);
    }
    @GetMapping("/Api/Public/Admin/checkIdentifier/{name}")
    @ResponseBody
    public RespEntity checkIdentifier(@PathVariable(value = "name",required = false) String identifier){
        if (identifier == null) {
            return new RespEntity(RespCode.SUCCESS,true);
        }
        boolean result = service.checkIdentifierUnique(identifier);
        return new RespEntity(RespCode.SUCCESS,result);
    }


}
