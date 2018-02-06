package cn.xc.service;

import cn.xc.entity.DO.ViolatingInformationDO;
import cn.xc.exception.ViolatingInformationException;

import java.util.List;

/**
 *  违章信息相关服务类接口
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/2/1 11:13.
 */
public interface IViolatingInformationService {
    /**
     *  获取所有违章信息
     * @return 查询结果集
     */
    List<ViolatingInformationDO> findAll();

    /**
     *  按条件查询违章信息
     * @param queryType 使用常量类中的参数。详情见下方的see部分 ,查询方式 0:根据ID, 1:根据违章者ID<br>
     *                  2:根据违章类型, 3:根据车牌号, 4:根据违章时间,<br>
     *                  5:根据扣分, 6:根据罚款金额, 7:根据违章记录创建时间, 8:根据记录修改时间<br>
     *
     * @param param     查询参数
     * @return 查询结果集 java.util.List&lt;ViolatingInformationDO&gt;
     * @see cn.xc.constant.ViolatingInformationConstant
     */
    List<ViolatingInformationDO> listViolatingInformationByCondition(int queryType,Object param)throws ViolatingInformationException;

    /**
     *  添加违章信息
     * @param value 待添加的数据
     * @return 添加成功返回true 添加失败返回false
     * @throws ViolatingInformationException
     */
    void addViolatingInformation(ViolatingInformationDO value) throws ViolatingInformationException;

    /**
     *  删除违章信息
     * @param value 待删除的信息
     */
    void deleteViolatingInformation(ViolatingInformationDO value)throws ViolatingInformationException;

    /**
     *  批量删除违章信息
     * @param primaryKey 待删除的信息集合
     */
    void deleteViolatingInformationByList(List<Long> primaryKey)throws ViolatingInformationException;

    /**
     *  更新违章信息
     * @param value 待更新的信息集合
     */
    void updateViolatingInformation(ViolatingInformationDO value)throws ViolatingInformationException;

}
