package cn.xc.service;

import cn.xc.entity.DO.LogLoginDO;
import cn.xc.exception.LogLoginException;

import java.util.List;

/**
 * 登录日志服务接口
 *
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/2/8 14:12.
 */
public interface ILogLoginService {
    void addLog(LogLoginDO log) throws LogLoginException;
    List<LogLoginDO> listLog(Long userId,String userType) throws LogLoginException;
}
