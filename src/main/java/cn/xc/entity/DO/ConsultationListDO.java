package cn.xc.entity.DO;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 数据表consultation_list实体类
 * 
 * @Author XiongCheng 
 * @version V1.0
 * @Date 2018/1/20 13:46.
 */
public class ConsultationListDO extends BaseDO implements Serializable {

    /**
     * 工单类别
     */
    private Integer type;
    /**
     * 工单编号
     */
    private String identifier;

    /**
     * 创建者id
     */
    private Long createrId;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String context;

    /**
     * 处理者id
     */
    private Long processorId;

    /**
     * 回应内容
     */
    private String responseContext;

    /**
     * 回应时间
     */
    private Date responseTime;

    /**
     * 工单状态0:未分配 1:已分配 2:已处理 3:已关闭
     */
    private Integer status;

    /**
     * 表名
     */
    public static final String TABLE_NAME = "consultation_list";
    private static final long serialVersionUID = 3L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Long getCreaterId() {
        return createrId;
    }

    public void setCreaterId(Long createrId) {
        this.createrId = createrId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Long getProcessorId() {
        return processorId;
    }

    public void setProcessorId(Long processorId) {
        this.processorId = processorId;
    }

    public String getResponseContext() {
        return responseContext;
    }

    public void setResponseContext(String responseContext) {
        this.responseContext = responseContext;
    }

    public Date getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ConsultationListDO other = (ConsultationListDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getIdentifier() == null ? other.getIdentifier() == null : this.getIdentifier().equals(other.getIdentifier()))
            && (this.getCreaterId() == null ? other.getCreaterId() == null : this.getCreaterId().equals(other.getCreaterId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getContext() == null ? other.getContext() == null : this.getContext().equals(other.getContext()))
            && (this.getProcessorId() == null ? other.getProcessorId() == null : this.getProcessorId().equals(other.getProcessorId()))
            && (this.getResponseContext() == null ? other.getResponseContext() == null : this.getResponseContext().equals(other.getResponseContext()))
            && (this.getResponseTime() == null ? other.getResponseTime() == null : this.getResponseTime().equals(other.getResponseTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getIdentifier() == null) ? 0 : getIdentifier().hashCode());
        result = prime * result + ((getCreaterId() == null) ? 0 : getCreaterId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getContext() == null) ? 0 : getContext().hashCode());
        result = prime * result + ((getProcessorId() == null) ? 0 : getProcessorId().hashCode());
        result = prime * result + ((getResponseContext() == null) ? 0 : getResponseContext().hashCode());
        result = prime * result + ((getResponseTime() == null) ? 0 : getResponseTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModified() == null) ? 0 : getGmtModified().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", identifier=").append(identifier);
        sb.append(", createrId=").append(createrId);
        sb.append(", title=").append(title);
        sb.append(", context=").append(context);
        sb.append(", processorId=").append(processorId);
        sb.append(", responseContext=").append(responseContext);
        sb.append(", responseTime=").append(responseTime);
        sb.append(", status=").append(status);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}