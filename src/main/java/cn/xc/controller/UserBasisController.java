package cn.xc.controller;

import cn.xc.entity.RespEntity;
import cn.xc.entity.VO.RegisterVO;
import cn.xc.entity.VO.UserVO;
import cn.xc.enums.RespCode;
import cn.xc.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version V1.0
 * @Description: 用户基本信息前端控制类
 * @Author XiongCheng
 * @Date 2018/1/17 21:18.
 */
@Controller
public class UserBasisController {
    private static Logger logger = LoggerFactory.getLogger(BulletinBoardController.class);
    @Autowired
    private IUserService service;
    @PostMapping("/Api/Public/User/register")
    @ResponseBody
    public RespEntity registerAdmin(@RequestBody RegisterVO user){
        service.registerUser(user);
        return new RespEntity(RespCode.SUCCESS,null);
    }
    @PostMapping("/Api/User/update")
    @ResponseBody
    public RespEntity updateAdminInformation(@RequestBody UserVO user){
        service.updateInformation(user);
        return new RespEntity(RespCode.SUCCESS,null);
    }
    @PostMapping("/Api/User/changepwd")
    @ResponseBody
    public RespEntity changePassword(String identifier, String password){
        if(service.updatePassword(identifier,password) == -1){
            return new RespEntity(RespCode.WARN,null);
        }
        return new RespEntity(RespCode.SUCCESS,null);
    }
    @GetMapping("/Api/Public/User/checkIdentifier")
    @ResponseBody
    public RespEntity checkIdentifier(String identifier){
        boolean result = service.checkIdentifierUnique(identifier);
        return new RespEntity(RespCode.SUCCESS,result);
    }

}
