package cn.xc.controller;

import cn.xc.constant.ConsultationListConstant;
import cn.xc.constant.LoginConstant;
import cn.xc.controller.constant.ControllerQueryConstant;
import cn.xc.entity.DO.ConsultationListDO;
import cn.xc.entity.RespEntity;
import cn.xc.enums.RespCode;
import cn.xc.exception.ConsultationListException;
import cn.xc.service.IConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @version V1.0
 * @Description: 咨询单前端控制类
 * @Author XiongCheng
 * @Date 2018/2/7 12:08.
 */
@Controller
public class ConsultationListController {
    @Autowired
    private IConsultationService service;
    @PostMapping("/Api/User/ConsultationList/add")
    @ResponseBody
    public RespEntity createConsultation(HttpServletRequest request, ConsultationListDO form) throws ConsultationListException{
        HttpSession session = request.getSession(false);
        if (session == null) {
            throw new ConsultationListException("session不可用");
        }
        form.setCreaterId((Long) session.getAttribute(LoginConstant.SESSION_USER_ID));
        service.createNewConsultation(form);
        return new RespEntity(RespCode.SUCCESS,null);
    }
    @PutMapping("/Api/User/ConsultationList/update")
    @ResponseBody
    public RespEntity updateConsultationList(ConsultationListDO form) throws ConsultationListException {
        service.updateConsultation(form);
        return new RespEntity(RespCode.SUCCESS,null);
    }
    @PutMapping("/Api/User/ConsultationList/response")
    @ResponseBody
    public RespEntity responseConsultationList(ConsultationListDO form) throws ConsultationListException {
        service.responseConsultation(form);
        return new RespEntity(RespCode.SUCCESS,null);
    }
    @DeleteMapping("/Api/User/ConsultationList/delete")
    @ResponseBody
    public RespEntity deleteConsultationList(List<ConsultationListDO> value) throws ConsultationListException {
        List<Long> id = new ArrayList<>();
        for (ConsultationListDO consultationListDO : value) {
            id.add(consultationListDO.getId());
        }
        service.deleteConsultation(id);
        return new RespEntity(RespCode.SUCCESS,null);
    }
    @GetMapping("/Api/User/ConsultationList/list/{type}")
    @ResponseBody
    public RespEntity queryByCondition(@PathVariable(value = "type") Integer type,HttpServletRequest request) throws ConsultationListException{
        List<ConsultationListDO> result = null;
        switch (type){
            case ConsultationListConstant.QUERY_BY_ID:
            case ConsultationListConstant.QUERY_BY_CREATERID:
            case ConsultationListConstant.QUERY_BY_PROCESSORID:
                Long queryParam = Long.parseLong(request.getParameter(ControllerQueryConstant.QUERY_SINGLE_PARAM));
                result = service.listConsultationByCondition(type,queryParam);
                break;
            case ConsultationListConstant.QUERY_BY_TYPE:
            case ConsultationListConstant.QUERY_BY_STATUS:
                Integer integer = Integer.parseInt(request.getParameter(ControllerQueryConstant.QUERY_SINGLE_PARAM));
                result = service.listConsultationByCondition(type,integer);
                break;
            case ConsultationListConstant.QUERY_BY_IDENTIFIER:
                result = service.listConsultationByCondition(type,request.getParameter(ControllerQueryConstant.QUERY_SINGLE_PARAM));
                break;
            case ConsultationListConstant.QUERY_BETWEEN_RESPONSETIME:
            case ConsultationListConstant.QUERY_BETWEEN_GMTCREATE:
            case ConsultationListConstant.QUERY_BETWEEN_GMTMODIFIED:
                List<Timestamp> paramList = new ArrayList<>();
                Long millisecondsStart = Long.parseLong(request.getParameter(ControllerQueryConstant.QUERY_PARAM_SCOPE_START));
                Long millisecondsEnd = Long.parseLong(request.getParameter(ControllerQueryConstant.QUERY_PARAM_SCOPE_END));
                paramList.add(new Timestamp(millisecondsStart));
                paramList.add(new Timestamp(millisecondsEnd));
                result = service.listConsultationByCondition(type,paramList);
                break;
            default:
                throw new ConsultationListException("查询种类参数不在既定范围中");
        }
        return new RespEntity(RespCode.SUCCESS,result);
    }
    @GetMapping("/Api/User/ConsultationList/list")
    @ResponseBody
    public RespEntity listAll(HttpServletRequest request) throws ConsultationListException{
        List<ConsultationListDO> result = service.findAll();
        return new RespEntity(RespCode.SUCCESS,result);
    }
}
