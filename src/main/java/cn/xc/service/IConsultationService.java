package cn.xc.service;

import cn.xc.entity.DO.ConsultationListDO;
import cn.xc.exception.ConsultationListException;

import java.util.List;

/**
 *  咨询单服务类
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/2/6 9:57.
 */
public interface IConsultationService {
    /**
     *  创建新的咨询单
     * @param form 新的咨询单数据
     * @throws ConsultationListException
     */
    void createNewConsultation(ConsultationListDO form) throws ConsultationListException;

    /**
     *  删除咨询单
     * @param id 需要删除的咨询单号集合
     * @throws ConsultationListException
     */
    void deleteConsultation(List<Long> id) throws ConsultationListException;

    /**
     *  咨询单回应
     * @param form 已回应的咨询单
     * @throws ConsultationListException
     */
    void responseConsultation(ConsultationListDO form) throws ConsultationListException;
    /**
     *  咨询单修改
     * @param form 修改的咨询单
     * @throws ConsultationListException
     */
    void updateConsultation(ConsultationListDO form) throws ConsultationListException;
    /**
     *  查询咨询单
     * @param type 查询类型 详见常量类ConsultationListConstent
     * @param param 查询参数
     * @return 查询结果
     * @throws ConsultationListException
     * @see cn.xc.constant.ConsultationListConstant
     */
    List<ConsultationListDO> listConsultationByCondition(int type, Object param) throws ConsultationListException;

    /**
     * 获取所有咨询单
     * @return 查询结果
     * @throws ConsultationListException
     */
    List<ConsultationListDO> findAll() throws ConsultationListException;
}
