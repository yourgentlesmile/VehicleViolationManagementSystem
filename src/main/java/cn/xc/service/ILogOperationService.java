package cn.xc.service;

import cn.xc.entity.DO.LogOperationDO;
import cn.xc.exception.LogOperationException;

import java.util.List;

/**
 * 用户操作日志服务接口
 *
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/2/8 14:49.
 */
public interface ILogOperationService {
    void addLog(LogOperationDO log) throws LogOperationException;
    List<LogOperationDO> listLog(Long userId) throws LogOperationException;
}
