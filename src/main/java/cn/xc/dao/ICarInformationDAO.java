package cn.xc.dao;

import cn.xc.dao.condition.CarInformationExample;
import cn.xc.entity.DO.CarInformationDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 车辆信息数据表操作接口
 * 
 * @Author XiongCheng 
 * @version V1.0
 * @Date 2018/2/19 11:57.
 */
public interface ICarInformationDAO {
    long countByExample(CarInformationExample example);

    int deleteByExample(CarInformationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CarInformationDO record);

    int insertSelective(CarInformationDO record);

    List<CarInformationDO> selectByExample(CarInformationExample example);

    CarInformationDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CarInformationDO record, @Param("example") CarInformationExample example);

    int updateByExample(@Param("record") CarInformationDO record, @Param("example") CarInformationExample example);

    int updateByPrimaryKeySelective(CarInformationDO record);

    int updateByPrimaryKey(CarInformationDO record);
}