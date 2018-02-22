package cn.xc.dao;

import cn.xc.dao.condition.UserPointExample;
import cn.xc.entity.DO.UserPointDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户分数数据表操作接口
 * 
 * @Author XiongCheng 
 * @version V1.0
 * @Date 2018/2/19 11:57.
 */
public interface IUserPointDAO {
    long countByExample(UserPointExample example);

    int deleteByExample(UserPointExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserPointDO record);

    int insertSelective(UserPointDO record);

    List<UserPointDO> selectByExample(UserPointExample example);

    UserPointDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserPointDO record, @Param("example") UserPointExample example);

    int updateByExample(@Param("record") UserPointDO record, @Param("example") UserPointExample example);

    int updateByPrimaryKeySelective(UserPointDO record);

    int updateByPrimaryKey(UserPointDO record);
}