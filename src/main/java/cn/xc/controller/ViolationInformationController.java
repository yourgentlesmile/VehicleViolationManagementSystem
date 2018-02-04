package cn.xc.controller;

import cn.xc.constant.ViolatingInformationConstant;
import cn.xc.controller.constant.ControllerVioInformationConstant;
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

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.Timestamp;
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
    @PostMapping("/Api/Admin/VioInformation/add")
    @ResponseBody
    public RespEntity addViolatingInformation(@RequestBody ViolatingInformationDO value) throws ViolatingInformationException {
        service.addViolatingInformation(value);
        return new RespEntity(RespCode.SUCCESS,null);
    }
    @PostMapping("/Api/Admin/VioInformation/delete")
    @ResponseBody
    public RespEntity deleteViolatingInformation(@RequestBody List<ViolatingInformationDO> value) throws ViolatingInformationException{
        List<Long> id = new ArrayList<>();
        for (ViolatingInformationDO violatingInformationDO : value) {
            id.add(violatingInformationDO.getId());
        }
        service.deleteViolatingInformationByList(id);
        return new RespEntity(RespCode.SUCCESS,null);
    }
    @PostMapping("/Api/Admin/VioInformation/update")
    @ResponseBody
    public RespEntity updateViolatingInformation(@RequestBody ViolatingInformationDO value) throws ViolatingInformationException{
        service.updateViolatingInformation(value);
        return new RespEntity(RespCode.SUCCESS,null);
    }
    @GetMapping("/Api/Admin/VioInformation/list")
    @ResponseBody
    public RespEntity listAll(){
        return new RespEntity(RespCode.SUCCESS,service.findAll());
    }
    @GetMapping("/Api/Admin/VioInformation/query")
    @ResponseBody
    public RespEntity query(HttpServletRequest request) throws ViolatingInformationException {
        int type = Integer.parseInt(request.getParameter("type"));
        List<ViolatingInformationDO> result = null;
        switch (type){
            case ViolatingInformationConstant.QUERY_BY_ID:
                Long id = Long.parseLong(request.getParameter(ControllerVioInformationConstant.QUERY_SINGLE_PARAM));
                result = service.listViolatingInformationByCondition(type,id);
                break;
            case ViolatingInformationConstant.QUERY_BY_VIOLATIONTYPE:
                int vioType = Integer.parseInt(request.getParameter(ControllerVioInformationConstant.QUERY_SINGLE_PARAM));
                result = service.listViolatingInformationByCondition(type,vioType);
                break;
            //由于参数都为String类型，所以情况做合并处理
            case ViolatingInformationConstant.QUERY_BY_IDENTIFIER:
            case ViolatingInformationConstant.QUERY_BY_CARNUMBER:
                String param = request.getParameter(ControllerVioInformationConstant.QUERY_SINGLE_PARAM);
                result = service.listViolatingInformationByCondition(type,param);
                break;
            //由于参数都为List<Timestamp>类型，所以情况做合并处理
            case ViolatingInformationConstant.QUERY_BETWEEN_VIOLATIONTIME:
            case ViolatingInformationConstant.QUERY_BETWEEN_GMTCREATE:
            case ViolatingInformationConstant.QUERY_BETWEEN_GMTMODIFIED:
                List<Timestamp> paramList = new ArrayList<>();
                Long millisecondsStart = Long.parseLong(request.getParameter(ControllerVioInformationConstant.QUERY_PARAM_SCOPE_START));
                Long millisecondsEnd = Long.parseLong(request.getParameter(ControllerVioInformationConstant.QUERY_PARAM_SCOPE_END));
                paramList.add(new Timestamp(millisecondsStart));
                paramList.add(new Timestamp(millisecondsEnd));
                result = service.listViolatingInformationByCondition(type,paramList);
                break;
            case ViolatingInformationConstant.QUERY_BETWEEN_PENALTYPOINT:
                List<Integer> point = new ArrayList<>();
                int pointStart = Integer.parseInt(request.getParameter(ControllerVioInformationConstant.QUERY_PARAM_SCOPE_START));
                int pointEnd = Integer.parseInt(request.getParameter(ControllerVioInformationConstant.QUERY_PARAM_SCOPE_END));
                point.add(pointStart);
                point.add(pointEnd);
                result = service.listViolatingInformationByCondition(type,point);
                break;
            case ViolatingInformationConstant.QUERY_BETWEEN_PENALTYMONEY:
                List<BigDecimal> money = new ArrayList<>();
                BigDecimal moneyStart = new BigDecimal(request.getParameter(ControllerVioInformationConstant.QUERY_PARAM_SCOPE_START));
                BigDecimal moneyEnd = new BigDecimal(request.getParameter(ControllerVioInformationConstant.QUERY_PARAM_SCOPE_END));
                money.add(moneyStart);
                money.add(moneyEnd);
                result = service.listViolatingInformationByCondition(type,money);
                break;
            default:
                throw new ViolatingInformationException("查询参数错误,传入的参数为:[" + type +"]");
        }
        return new RespEntity(RespCode.SUCCESS,result);
    }
}
