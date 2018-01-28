package cn.xc.controller;

import cn.xc.constant.BulletinBoardConstant;
import cn.xc.controller.constant.ControllerConstant;
import cn.xc.entity.DO.BulletinBoardDO;
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
@RequestMapping("/BulletinBoard")
public class BulletinBoardController {
    private static Logger logger = LoggerFactory.getLogger(BulletinBoardController.class);
    @Autowired
    IBulletinBoardService bulletinBoardService;
    @PostMapping("/add")
    @ResponseBody
    public String addBulletin(@RequestBody BulletinBoardDO value) throws Exception{
        bulletinBoardService.addBulletin(value);
        return ControllerConstant.ACTION_SUCCESS;
    }
    @GetMapping("/list")
    @ResponseBody
    public List<BulletinBoardDO> listBulletin() throws Exception{
        return bulletinBoardService.listDataByCondition(BulletinBoardConstant.FETCH_ALL,null);
    }
    @PostMapping("/update")
    @ResponseBody
    public String updateBulletin(@RequestBody BulletinBoardDO value) throws Exception{
        bulletinBoardService.updateBulletin(BulletinBoardConstant.UPDATE_COLUMN_SELECTIVE,value);
        return ControllerConstant.ACTION_SUCCESS;
    }
    @PostMapping("/query/{type}")
    @ResponseBody
    public List<BulletinBoardDO> queryBulletin(@PathVariable(value = "type",required = false) int type, @RequestBody String queryParam) throws Exception {
        return bulletinBoardService.listDataByCondition(type, queryParam);
    }

}
