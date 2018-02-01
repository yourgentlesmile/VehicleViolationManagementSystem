package cn.xc.controller;

import cn.xc.entity.DO.ViolatingInformationDO;
import cn.xc.entity.RespEntity;
import cn.xc.enums.RespCode;
import cn.xc.exception.ViolatingInformationException;
import cn.xc.service.IViolatingInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @version V1.0
 * @Description: 违章信息前端控制类
 * @Author XiongCheng
 * @Date 2018/1/17 21:19.
 */
@Controller
public class ViolationInformationController{
    private static Logger logger = LoggerFactory.getLogger(BulletinBoardController.class);
    @Autowired
    private IViolatingInformationService service;
    @PostMapping("/api/VioInformation/add")
    @ResponseBody
    public RespEntity addViolatingInformation(@RequestBody ViolatingInformationDO value) throws ViolatingInformationException {
        service.addViolatingInformation(value);
        return new RespEntity(RespCode.SUCCESS,null);
    }
    @PostMapping("/api/VioInformation/delete")
    @ResponseBody
    public RespEntity deleteViolatingInformation(@RequestBody List<ViolatingInformationDO> value) throws ViolatingInformationException{
        List<Long> id = new ArrayList<>();
        for (ViolatingInformationDO violatingInformationDO : value) {
            id.add(violatingInformationDO.getId());
        }
        service.deleteViolatingInformationByList(id);
        return new RespEntity(RespCode.SUCCESS,null);
    }
    @PostMapping("/api/VioInformation/update")
    @ResponseBody
    public RespEntity updateViolatingInformation(@RequestBody ViolatingInformationDO value) throws ViolatingInformationException{
        service.updateViolatingInformation(value);
        return new RespEntity(RespCode.SUCCESS,null);
    }
    @GetMapping("/api/VioInformation/list")
    @ResponseBody
    public RespEntity listAll(){
        return new RespEntity(RespCode.SUCCESS,service.findAll());
    }
}
