package cn.xc.controller;

import cn.xc.constant.BulletinBoardConstant;
import cn.xc.entity.DO.BulletinBoardDO;
import cn.xc.entity.RespEntity;
import cn.xc.enums.RespCode;
import cn.xc.exception.BulletinBoardException;
import cn.xc.service.IBulletinBoardService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公告板前端控制类
 * @version V1.0

 * @Author XiongCheng
 * @Date 2018/1/17 21:17.
 */
@Controller
public class BulletinBoardController {
    private static Logger logger = LoggerFactory.getLogger(BulletinBoardController.class);
    @Autowired
    IBulletinBoardService bulletinBoardService;

    @PostMapping("/Api/Admin/BulletinBoard")
    @ResponseBody
    public RespEntity addBulletin(@RequestBody BulletinBoardDO value) throws BulletinBoardException{

        bulletinBoardService.addBulletin(value);
        return new RespEntity(RespCode.SUCCESS,null);
    }
    @PutMapping("/Api/Admin/BulletinBoard")
    @ResponseBody
    public RespEntity updateBulletin(@RequestBody BulletinBoardDO value) throws BulletinBoardException{
        bulletinBoardService.updateBulletin(BulletinBoardConstant.UPDATE_COLUMN_SELECTIVE,value);
        return new RespEntity(RespCode.SUCCESS,null);
    }
    @GetMapping("/Api/Public/BulletinBoard/{type}/{param}/{pagenum}")
    @ResponseBody
    public RespEntity queryBulletin(@PathVariable(value = "type") int type,
                                    @PathVariable(value = "param",required = false) String queryParam,
                                    @PathVariable(value = "pagenum",required = false) Integer pageNum) throws BulletinBoardException {
        if (type != BulletinBoardConstant.FETCH_ALL && queryParam == null) {
            return new RespEntity(RespCode.SUCCESS,null);
        }
        PageHelper.startPage(pageNum,8 );
        List<BulletinBoardDO> list = bulletinBoardService.listDataByCondition(type, queryParam);
        PageInfo page = new PageInfo(list);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("data",page.getTotal());
        resultMap.put("pageInfo",page);
        return new RespEntity(RespCode.SUCCESS,resultMap);
    }
    @DeleteMapping("/Api/Admin/BulletinBoard")
    @ResponseBody
    public RespEntity deleteBulletin(@RequestBody List<Long> preDeleteIndex) throws BulletinBoardException {
        bulletinBoardService.deleteBulletinByList(preDeleteIndex);
        return new RespEntity(RespCode.SUCCESS,true);
    }

}
