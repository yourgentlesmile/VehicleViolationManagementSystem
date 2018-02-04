package cn.xc.controller;

import cn.xc.constant.BulletinBoardConstant;
import cn.xc.entity.DO.BulletinBoardDO;
import cn.xc.entity.RespEntity;
import cn.xc.enums.RespCode;
import cn.xc.service.IBulletinBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version V1.0
 * @Description: 公告板前端控制类

 * @Author XiongCheng
 * @Date 2018/1/17 21:17.
 */
@Controller
public class BulletinBoardController {
    private static Logger logger = LoggerFactory.getLogger(BulletinBoardController.class);
    @Autowired
    IBulletinBoardService bulletinBoardService;
    @PostMapping("/Api/BulletinBoard/add")
    @ResponseBody
    public RespEntity addBulletin(@RequestBody BulletinBoardDO value) throws Exception{
        bulletinBoardService.addBulletin(value);
        return new RespEntity(RespCode.SUCCESS,null);
    }
    @GetMapping("/Api/Public/BulletinBoard/list")
    @ResponseBody
    public RespEntity listBulletin() throws Exception{
        List<BulletinBoardDO> list = bulletinBoardService.listDataByCondition(BulletinBoardConstant.FETCH_ALL,null);
        return new RespEntity(RespCode.SUCCESS,list);
    }
    @PostMapping("/Api/BulletinBoard/update")
    @ResponseBody
    public RespEntity updateBulletin(@RequestBody BulletinBoardDO value) throws Exception{
        bulletinBoardService.updateBulletin(BulletinBoardConstant.UPDATE_COLUMN_SELECTIVE,value);
        return new RespEntity(RespCode.SUCCESS,null);
    }
    @PostMapping("/Api/Public/query/{type}")
    @ResponseBody
    public RespEntity queryBulletin(@PathVariable(value = "type") int type, @RequestBody String queryParam) throws Exception {
        List<BulletinBoardDO> list = bulletinBoardService.listDataByCondition(type, queryParam);
        return new RespEntity(RespCode.SUCCESS,list);
    }

}
