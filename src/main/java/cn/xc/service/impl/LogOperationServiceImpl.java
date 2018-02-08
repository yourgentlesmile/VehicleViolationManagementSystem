package cn.xc.service.impl;

import cn.xc.dao.ILogOperationDAO;
import cn.xc.dao.condition.LogOperationExample;
import cn.xc.entity.DO.LogOperationDO;
import cn.xc.exception.LogOperationException;
import cn.xc.service.ILogOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * todo
 *
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/2/8 14:50.
 */
@Service
public class LogOperationServiceImpl implements ILogOperationService {
    @Autowired
    private ILogOperationDAO db;
    @Override
    public void addLog(LogOperationDO log) throws LogOperationException {
        if (log == null) {
            throw new LogOperationException("传入参数不能为空");
        }
        db.insert(log);
    }

    @Override
    public List<LogOperationDO> listLog(Long userId) throws LogOperationException {
        if (userId == null) {
            throw new LogOperationException("传入参数不能为空");
        }
        LogOperationExample example = new LogOperationExample();
        LogOperationExample.Criteria criteria = example.createCriteria();
        criteria.andOpUserIdEqualTo(userId);
        return db.selectByExample(example);
    }
}
