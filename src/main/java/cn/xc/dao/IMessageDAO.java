package cn.xc.dao;

import cn.xc.dao.condition.MessageExample;
import cn.xc.entity.DO.MessageDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 *  私信数据表操作接口
 * 
 * @Author XiongCheng 
 * @version V1.0
 * @Date 2018/1/30 12:20.
 */
public interface IMessageDAO {
    long countByExample(MessageExample example);

    int deleteByExample(MessageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MessageDO record);

    int insertSelective(MessageDO record);

    List<MessageDO> selectByExample(MessageExample example);

    MessageDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MessageDO record, @Param("example") MessageExample example);

    int updateByExample(@Param("record") MessageDO record, @Param("example") MessageExample example);

    int updateByPrimaryKeySelective(MessageDO record);

    int updateByPrimaryKey(MessageDO record);
}