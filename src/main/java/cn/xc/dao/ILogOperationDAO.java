package cn.xc.dao;

import cn.xc.dao.condition.LogOperationExample;
import cn.xc.entity.DO.LogOperationDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 *  操作日志数据表操作接口
 * 
 * @Author XiongCheng 
 * @version V1.0
 * @Date 2018/1/30 12:20.
 */
public interface ILogOperationDAO {
    long countByExample(LogOperationExample example);

    int deleteByExample(LogOperationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LogOperationDO record);

    int insertSelective(LogOperationDO record);

    List<LogOperationDO> selectByExample(LogOperationExample example);

    LogOperationDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LogOperationDO record, @Param("example") LogOperationExample example);

    int updateByExample(@Param("record") LogOperationDO record, @Param("example") LogOperationExample example);

    int updateByPrimaryKeySelective(LogOperationDO record);

    int updateByPrimaryKey(LogOperationDO record);
}