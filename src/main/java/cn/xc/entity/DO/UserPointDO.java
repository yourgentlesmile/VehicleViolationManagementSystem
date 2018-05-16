package cn.xc.entity.DO;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 驾驶员积分类，提供当前驾驶员的分数情况
 * 
 * @Author XiongCheng 
 * @version V1.0
 * @Date 2018/2/19 11:56.
 */
public class UserPointDO implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 驾驶员编号
     */
    private String identifier;

    /**
     * 当前分数
     */
    private Integer currentPoint;

    /**
     * 创建时间
     */
    private Timestamp gmtCreate;

    /**
     * 最后修改时间
     */
    private Timestamp gmtModifier;

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

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Integer getCurrentPoint() {
        return currentPoint;
    }

    public void setCurrentPoint(Integer currentPoint) {
        this.currentPoint = currentPoint;
    }

    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Timestamp getGmtModifier() {
        return gmtModifier;
    }

    public void setGmtModifier(Timestamp gmtModifier) {
        this.gmtModifier = gmtModifier;
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
        UserPointDO other = (UserPointDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIdentifier() == null ? other.getIdentifier() == null : this.getIdentifier().equals(other.getIdentifier()))
            && (this.getCurrentPoint() == null ? other.getCurrentPoint() == null : this.getCurrentPoint().equals(other.getCurrentPoint()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModifier() == null ? other.getGmtModifier() == null : this.getGmtModifier().equals(other.getGmtModifier()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIdentifier() == null) ? 0 : getIdentifier().hashCode());
        result = prime * result + ((getCurrentPoint() == null) ? 0 : getCurrentPoint().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModifier() == null) ? 0 : getGmtModifier().hashCode());
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
        sb.append(", identifier=").append(identifier);
        sb.append(", currentPoint=").append(currentPoint);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModifier=").append(gmtModifier);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}