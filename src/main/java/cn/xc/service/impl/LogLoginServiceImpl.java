package cn.xc.service.impl;

import cn.xc.dao.ILogLoginDAO;
import cn.xc.dao.condition.LogLoginExample;
import cn.xc.entity.DO.LogLoginDO;
import cn.xc.exception.LogLoginException;
import cn.xc.service.ILogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 登录日志服务实现类
 *
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/2/8 14:17.
 */
@Service
public class LogLoginServiceImpl implements ILogLoginService {
    @Autowired
    private ILogLoginDAO db;
    @Override
    public void addLog(LogLoginDO log) throws LogLoginException {
        if (log == null) {
            throw new LogLoginException("参数不能为NULL");
        }
        db.insert(log);
    }

    @Override
    public List<LogLoginDO> listLog(Long userId) throws LogLoginException {
        if (userId == null) {
            throw new LogLoginException("参数不能为NULL");
        }
        LogLoginExample example = new LogLoginExample();
        LogLoginExample.Criteria criteria = example.createCriteria();
        criteria.andLoginUserIdEqualTo(userId);
        return db.selectByExample(example);
    }
}
