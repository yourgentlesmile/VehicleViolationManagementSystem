package cn.xc.entity.DO;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Description: 数据表log_operation实体类
 * 
 * @Author XiongCheng 
 * @version V1.0
 * @Date 2018/1/30 12:19.
 */
public class LogOperationDO implements Serializable {
    private Long id;

    /**
     * 操作员id
     */
    private Long opUserId;

    /**
     * 操作员用户编号
     */
    private Long opUserIdentifier;

    /**
     * 操作者IP
     */
    private String opIp;

    /**
     * 操作类型
     */
    private Integer opType;

    /**
     * 操作时间
     */
    private Timestamp opTime;

    /**
     * 操作详细描述
     */
    private String opContext;

    /**
     * 记录创建时间
     */
    private Timestamp gmtCreate;

    /**
     * 最后修改时间
     */
    private Timestamp gmtModified;

    /**
     * 是否被删除1:已删除 0:未删除
     */
    private Integer isDeleted;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOpUserId() {
        return opUserId;
    }

    public void setOpUserId(Long opUserId) {
        this.opUserId = opUserId;
    }

    public Long getOpUserIdentifier() {
        return opUserIdentifier;
    }

    public void setOpUserIdentifier(Long opUserIdentifier) {
        this.opUserIdentifier = opUserIdentifier;
    }

    public String getOpIp() {
        return opIp;
    }

    public void setOpIp(String opIp) {
        this.opIp = opIp;
    }

    public Integer getOpType() {
        return opType;
    }

    public void setOpType(Integer opType) {
        this.opType = opType;
    }

    public Timestamp getOpTime() {
        return opTime;
    }

    public void setOpTime(Timestamp opTime) {
        this.opTime = opTime;
    }

    public String getOpContext() {
        return opContext;
    }

    public void setOpContext(String opContext) {
        this.opContext = opContext;
    }

    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Timestamp getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Timestamp gmtModified) {
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
        LogOperationDO other = (LogOperationDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOpUserId() == null ? other.getOpUserId() == null : this.getOpUserId().equals(other.getOpUserId()))
            && (this.getOpUserIdentifier() == null ? other.getOpUserIdentifier() == null : this.getOpUserIdentifier().equals(other.getOpUserIdentifier()))
            && (this.getOpIp() == null ? other.getOpIp() == null : this.getOpIp().equals(other.getOpIp()))
            && (this.getOpType() == null ? other.getOpType() == null : this.getOpType().equals(other.getOpType()))
            && (this.getOpTime() == null ? other.getOpTime() == null : this.getOpTime().equals(other.getOpTime()))
            && (this.getOpContext() == null ? other.getOpContext() == null : this.getOpContext().equals(other.getOpContext()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOpUserId() == null) ? 0 : getOpUserId().hashCode());
        result = prime * result + ((getOpUserIdentifier() == null) ? 0 : getOpUserIdentifier().hashCode());
        result = prime * result + ((getOpIp() == null) ? 0 : getOpIp().hashCode());
        result = prime * result + ((getOpType() == null) ? 0 : getOpType().hashCode());
        result = prime * result + ((getOpTime() == null) ? 0 : getOpTime().hashCode());
        result = prime * result + ((getOpContext() == null) ? 0 : getOpContext().hashCode());
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
        sb.append(", opUserId=").append(opUserId);
        sb.append(", opUserIdentifier=").append(opUserIdentifier);
        sb.append(", opIp=").append(opIp);
        sb.append(", opType=").append(opType);
        sb.append(", opTime=").append(opTime);
        sb.append(", opContext=").append(opContext);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}