package cn.xc.dao;

import cn.xc.dao.condition.LogLoginExample;
import cn.xc.entity.DO.LogLoginDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Description: 登录日志数据表操作接口
 * 
 * @Author XiongCheng 
 * @version V1.0
 * @Date 2018/1/30 12:20.
 */
public interface ILogLoginDAO {
    long countByExample(LogLoginExample example);

    int deleteByExample(LogLoginExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LogLoginDO record);

    int insertSelective(LogLoginDO record);

    List<LogLoginDO> selectByExample(LogLoginExample example);

    LogLoginDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LogLoginDO record, @Param("example") LogLoginExample example);

    int updateByExample(@Param("record") LogLoginDO record, @Param("example") LogLoginExample example);

    int updateByPrimaryKeySelective(LogLoginDO record);

    int updateByPrimaryKey(LogLoginDO record);
}