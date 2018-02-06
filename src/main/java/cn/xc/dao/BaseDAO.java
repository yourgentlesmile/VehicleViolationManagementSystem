package cn.xc.dao;

import cn.xc.entity.DO.BaseDO;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 * DAO基类包含基本的增删查改和相应的批量操作
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/1/21 22:59.
 */
public interface BaseDAO {
    /**
     *  添加数据
     * @param data 新增的数据实例
     */
    void insertData(BaseDO data);
    /**
     *  批量插入
     * @param list 待保存的数据List集合
     */
    void insertDataByList(List<BaseDO> list);
    /**
     *  按主键删除
     * @param id 待删除的主键ID
     */
    void deleteDataByPrimaryKey(Long id);
    /**
     *  批量删除(依旧是按主键删除)
     * @param list 待删除的主键ID集合(List)
     */
    void deleteDataByList(List<Long> list);
    /**
     *  修改数据中的信息
     * @param Data 待修改的数据实例(全局更新-每一个数据项都会更新)
     */
    void updateData(BaseDO Data);
    /**
     *  批量修改数据中的信息
     * @param list 待修改的数据实例List集合(全局更新-每一个数据项都会更新)
     */
    void updateDataByList(List<BaseDO> list);
    /**
     *  部分修改数据信息
     * @param Data 待修改的数据实例(局部更新-只有非NULL项才会更新)
     */
    void updateDataSelective(BaseDO Data);
    /**
     *  批量部分修改数据中的信息
     * @param list 待修改的数据实例List集合(局部更新-只有非NULL项才会更新)
     */
    void updateDataByListSelective(List<BaseDO> list);
    /**
     *  根据主键获取数据中的信息
     * @param id 待查询的主键ID
     * @return Data 查询到的结果
     */
    BaseDO getDataByPrimaryKey(Long id);
    /**
     *  根据创建时间进行区间查询
     * @param start  开始时间
     * @param end    结束时间
     * @return       查询到的结果集
     */
    List<BaseDO> getDataByGmtCreateBetween(@Param("start") Timestamp start, @Param("end") Timestamp end);
    /**
     *  根据最后修改时间进行区间查询
     * @param start  开始时间
     * @param end    结束时间
     * @return       查询到的结果集
     */
    List<BaseDO> getDataByGmtModifiedBetween(@Param("start") Timestamp start,@Param("end") Timestamp end);
    /**
     *  根据删除标记进行查询
     * @return       查询到的结果集
     */
    List<BaseDO> getDataByIsDeleted();
    /**
     *  获取全部数据
     * @return
     */
    List<BaseDO> findAll();
}
