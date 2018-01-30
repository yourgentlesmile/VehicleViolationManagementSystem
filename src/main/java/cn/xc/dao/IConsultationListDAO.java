package cn.xc.dao;

import cn.xc.entity.DO.ConsultationListDO;
import cn.xc.dao.condition.ConsultationListExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Description: 咨询工单数据表操作接口
 *
 * @Author XiongCheng
 * @version V1.0
 * @Date 2018/1/30 12:20.
 */
public interface IConsultationListDAO {
    long countByExample(ConsultationListExample example);

    int deleteByExample(ConsultationListExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ConsultationListDO record);

    int insertSelective(ConsultationListDO record);

    List<ConsultationListDO> selectByExample(ConsultationListExample example);

    ConsultationListDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ConsultationListDO record, @Param("example") ConsultationListExample example);

    int updateByExample(@Param("record") ConsultationListDO record, @Param("example") ConsultationListExample example);

    int updateByPrimaryKeySelective(ConsultationListDO record);

    int updateByPrimaryKey(ConsultationListDO record);
}