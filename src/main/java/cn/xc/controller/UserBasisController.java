package cn.xc.controller;

import cn.xc.entity.RespEntity;
import cn.xc.entity.VO.RegisterVO;
import cn.xc.entity.VO.UserVO;
import cn.xc.enums.RespCode;
import cn.xc.exception.UserException;
import cn.xc.exception.ViolatingInformationException;
import cn.xc.service.IUserService;
import cn.xc.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户基本信息前端控制类
 * //todo 违章信息录入的时候，自动扣分处理注册的时候，自动对有记录的违规记录进行追加扣分记录
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/1/17 21:18.
 */
@RestController
public class UserBasisController {
    private static Logger logger = LoggerFactory.getLogger(BulletinBoardController.class);
    @Autowired
    private IUserService service;
    @PostMapping("/Api/Public/User/register")
    public RespEntity registerUser(@RequestBody RegisterVO user){
        service.registerUser(user);
        return new RespEntity(RespCode.SUCCESS,null);
    }

    @PutMapping("/Api/User/update")
    public RespEntity updateUserInformation(@RequestBody UserVO user){
        service.updateInformation(user);
        return new RespEntity(RespCode.SUCCESS,null);
    }

    @PutMapping("/Api/User/changepwd")
    public RespEntity changePassword(String identifier, String password){
        if(service.updatePassword(identifier,password) == -1){
            return new RespEntity(RespCode.WARN,null);
        }
        return new RespEntity(RespCode.SUCCESS,null);
    }

    @GetMapping("/Api/Public/User/checkIdentifier/{username}")
    public RespEntity checkIdentifier(@PathVariable("username") String identifier){
        boolean result = service.checkIdentifierUnique(identifier);
        return new RespEntity(RespCode.SUCCESS,result);
    }

    @PostMapping("/Api/User/carRegister")
    public RespEntity carRegister(@RequestParam("carNumber") String carNumber,
                                  @RequestParam("engineNumber") String engineNumber,
                                  @RequestParam("frameNumber") String frameNumber) throws UserException, ViolatingInformationException {
        service.registerCar(Util.getCurrentUsername(),carNumber,engineNumber,frameNumber);
        return new RespEntity(RespCode.SUCCESS,null);
    }

    @GetMapping("/Api/User/pointInformation")
    public RespEntity getUserPoint(@RequestParam("identifier") String identifier){
        return new RespEntity(RespCode.SUCCESS,service.getUserPointInformation(identifier));

    }

    @GetMapping("/Api/User")
    public RespEntity getUserInformation() {
        String username = Util.getCurrentUsername();
        UserVO userVO = new UserVO(service.findUserByName(username));
        return new RespEntity(RespCode.SUCCESS,userVO);
    }
}
