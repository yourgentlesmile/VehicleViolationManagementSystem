package cn.xc.service;

import cn.xc.entity.DO.ViolatingInformationDO;
import cn.xc.exception.ViolatingInformationException;

import java.util.List;

/**
 * @version V1.0
 * @Description: 违章信息相关服务类接口
 * @Author XiongCheng
 * @Date 2018/2/1 11:13.
 */
public interface IViolatingInformationService {
    List<ViolatingInformationDO> findAll();
    List<ViolatingInformationDO> listViolatingInformationByType(int queryType,Object param)throws ViolatingInformationException;
    void addViolatingInformation(ViolatingInformationDO value) throws ViolatingInformationException;
    void deleteViolatingInformation(ViolatingInformationDO value)throws ViolatingInformationException;
    void deleteViolatingInformationByList(List<Long> primaryKey)throws ViolatingInformationException;
    void updateViolatingInformation(ViolatingInformationDO value)throws ViolatingInformationException;
}
