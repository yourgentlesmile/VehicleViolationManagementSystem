package cn.xc.entity.DO;

import java.io.Serializable;
import java.util.Date;

/**
 * @version V1.0
 * @Description: 数据表violation_information实体类
 * @Author XiongCheng
 * @Date 2018/1/20 13:50.
 */
public class ViolationInformationDO extends BaseDO implements Serializable {

    /**
     * 违章编号
     */
    private String identifier;

    /**
     * 违章类型
     */
    private Integer violationType;

    /**
     * 违章时间
     */
    private Date violationTime;

    /**
     * 违章详情
     */
    private String detail;

    /**
     * 违章车牌号
     */
    private String carNumber;

    /**
     * 扣分
     */
    private Integer penaltyPoint;

    /**
     * 罚款
     */
    private Integer penaltyMoney;

    /**
     * 表名
     */
    public static final String TABLE_NAME = "violation_information";
    private static final long serialVersionUID = 8L;

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

    public Integer getViolationType() {
        return violationType;
    }

    public void setViolationType(Integer violationType) {
        this.violationType = violationType;
    }

    public Date getViolationTime() {
        return violationTime;
    }

    public void setViolationTime(Date violationTime) {
        this.violationTime = violationTime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Integer getPenaltyPoint() {
        return penaltyPoint;
    }

    public void setPenaltyPoint(Integer penaltyPoint) {
        this.penaltyPoint = penaltyPoint;
    }

    public Integer getPenaltyMoney() {
        return penaltyMoney;
    }

    public void setPenaltyMoney(Integer penaltyMoney) {
        this.penaltyMoney = penaltyMoney;
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
        ViolationInformationDO other = (ViolationInformationDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getIdentifier() == null ? other.getIdentifier() == null : this.getIdentifier().equals(other.getIdentifier()))
        && (this.getViolationType() == null ? other.getViolationType() == null : this.getViolationType().equals(other.getViolationType()))
        && (this.getViolationTime() == null ? other.getViolationTime() == null : this.getViolationTime().equals(other.getViolationTime()))
        && (this.getDetail() == null ? other.getDetail() == null : this.getDetail().equals(other.getDetail()))
        && (this.getCarNumber() == null ? other.getCarNumber() == null : this.getCarNumber().equals(other.getCarNumber()))
        && (this.getPenaltyPoint() == null ? other.getPenaltyPoint() == null : this.getPenaltyPoint().equals(other.getPenaltyPoint()))
        && (this.getPenaltyMoney() == null ? other.getPenaltyMoney() == null : this.getPenaltyMoney().equals(other.getPenaltyMoney()))
        && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
        && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()))
        && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIdentifier() == null) ? 0 : getIdentifier().hashCode());
        result = prime * result + ((getViolationType() == null) ? 0 : getViolationType().hashCode());
        result = prime * result + ((getViolationTime() == null) ? 0 : getViolationTime().hashCode());
        result = prime * result + ((getDetail() == null) ? 0 : getDetail().hashCode());
        result = prime * result + ((getCarNumber() == null) ? 0 : getCarNumber().hashCode());
        result = prime * result + ((getPenaltyPoint() == null) ? 0 : getPenaltyPoint().hashCode());
        result = prime * result + ((getPenaltyMoney() == null) ? 0 : getPenaltyMoney().hashCode());
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
        sb.append(", identifier=").append(identifier);
        sb.append(", violationType=").append(violationType);
        sb.append(", violationTime=").append(violationTime);
        sb.append(", detail=").append(detail);
        sb.append(", carNumber=").append(carNumber);
        sb.append(", penaltyPoint=").append(penaltyPoint);
        sb.append(", penaltyMoney=").append(penaltyMoney);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}