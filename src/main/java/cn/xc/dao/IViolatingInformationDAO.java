package cn.xc.dao;

import cn.xc.dao.condition.ViolatingInformationExample;
import cn.xc.entity.DO.ViolatingInformationDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 违章信息数据表操作接口
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/1/21 23:20.
 */
public interface IViolatingInformationDAO extends BaseDAO {
    long countByExample(ViolatingInformationExample example);

    int deleteByExample(ViolatingInformationExample example);

    int insertSelective(ViolatingInformationDO record);

    List<ViolatingInformationDO> selectByExample(ViolatingInformationExample example);

    int updateByExampleSelective(@Param("record") ViolatingInformationDO record, @Param("example") ViolatingInformationExample example);

    int updateByExample(@Param("record") ViolatingInformationDO record, @Param("example") ViolatingInformationExample example);


}
