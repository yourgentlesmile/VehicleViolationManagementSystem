package cn.xc.controller;

import cn.xc.constant.ViolatingInformationConstant;
import cn.xc.entity.DO.ViolatingInformationDO;
import cn.xc.entity.RespEntity;
import cn.xc.enums.RespCode;
import cn.xc.exception.ViolatingInformationException;
import cn.xc.service.IViolatingInformationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 违章信息前端控制类
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/1/17 21:19.
 */
@Controller
public class ViolationInformationController{
    private static Logger logger = LoggerFactory.getLogger(BulletinBoardController.class);
    @Autowired
    private IViolatingInformationService service;
    @PostMapping("/Api/Admin/VioInformation")
    @ResponseBody
    public RespEntity addViolatingInformation(@RequestBody ViolatingInformationDO value) throws ViolatingInformationException {
        service.addViolatingInformation(value);
        return new RespEntity(RespCode.SUCCESS,null);
    }
    @DeleteMapping("/Api/Admin/VioInformation")
    @ResponseBody
    public RespEntity deleteViolatingInformation(@RequestBody List<Long> value) throws ViolatingInformationException{
        service.deleteViolatingInformationByList(value);
        return new RespEntity(RespCode.SUCCESS,null);
    }
    @PutMapping("/Api/Admin/VioInformation")
    @ResponseBody
    public RespEntity updateViolatingInformation(@RequestBody ViolatingInformationDO value) throws ViolatingInformationException{
        service.updateViolatingInformation(value);
        return new RespEntity(RespCode.SUCCESS,null);
    }
    @GetMapping("/Api/Admin/VioInformation")
    @ResponseBody
    public RespEntity listAll(HttpServletRequest request){
        String num = request.getParameter("page");
        int pageNum = Integer.parseInt(num  == null ? "1" : num);
        PageHelper.startPage(pageNum,8);
        List<ViolatingInformationDO> result = service.findAll();
        PageInfo page = new PageInfo(result);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("data",page.getTotal());
        resultMap.put("pageInfo",page);
        return new RespEntity(RespCode.SUCCESS,resultMap);
    }
    @GetMapping("/Api/Public/VioInformation")
    @ResponseBody
    public RespEntity query(@RequestParam String carNumber,
                            @RequestParam String engineNumber,
                            @RequestParam String identityNumber,
                            HttpServletRequest request) throws ViolatingInformationException {
        String num = request.getParameter("page");
        int pageNum = Integer.parseInt(num  == null ? "1" : num);
        PageHelper.startPage(pageNum,8 );
        List<ViolatingInformationDO> result = service.listViolatingInformationByCondition(ViolatingInformationConstant.QUERY_BY_CARNUMBER,carNumber);
        PageInfo page = new PageInfo(result);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("data",page.getList());
        resultMap.put("pageInfo",page);
        return new RespEntity(RespCode.SUCCESS,resultMap);
    }
}
