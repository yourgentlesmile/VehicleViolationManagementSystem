package cn.xc.controller;

import cn.xc.entity.RespEntity;
import cn.xc.enums.RespCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @version V1.0
 * @Description: 新想法与功能实验类
 * @Author XiongCheng
 * @Date 2018/1/17 16:06.
 */
@Controller
public class testController {
    protected static Logger logger = LoggerFactory.getLogger(testController.class);
    @RequestMapping("/index")
    @ResponseBody
    public RespEntity say(@RequestBody Object list){
        logger.info(list.toString());
        return new RespEntity(RespCode.SUCCESS,list instanceof List);
    }
}
