package cn.xc.entity.DO;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 车辆信息实体类，包含车辆的车牌号，车架号，发动机号，车辆违章次数
 * 
 * @Author XiongCheng 
 * @version V1.0
 * @Date 2018/2/19 11:55.
 */
public class CarInformationDO implements Serializable {
    /**
     * 主键编号
     */
    private Long id;

    /**
     * 车牌号
     */
    private String carNumber;

    /**
     * 违章次数
     */
    private Integer numberViolation;

    /**
     * 车辆所有者编号
     */
    private String owner;

    /**
     * 发动机号
     */
    private String engineNumber;

    /**
     * 车架号
     */
    private String frameNumber;

    /**
     * 创建时间
     */
    private Timestamp gmtCreate;

    /**
     * 最后修改时间
     */
    private Timestamp gmtModifier;

    /**
     * 是否被删除,1:已删除 0:未删除
     */
    private Byte isDeleted;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Integer getNumberViolation() {
        return numberViolation;
    }

    public void setNumberViolation(Integer numberViolation) {
        this.numberViolation = numberViolation;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getFrameNumber() {
        return frameNumber;
    }

    public void setFrameNumber(String frameNumber) {
        this.frameNumber = frameNumber;
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

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
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
        CarInformationDO other = (CarInformationDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCarNumber() == null ? other.getCarNumber() == null : this.getCarNumber().equals(other.getCarNumber()))
            && (this.getNumberViolation() == null ? other.getNumberViolation() == null : this.getNumberViolation().equals(other.getNumberViolation()))
            && (this.getOwner() == null ? other.getOwner() == null : this.getOwner().equals(other.getOwner()))
            && (this.getEngineNumber() == null ? other.getEngineNumber() == null : this.getEngineNumber().equals(other.getEngineNumber()))
            && (this.getFrameNumber() == null ? other.getFrameNumber() == null : this.getFrameNumber().equals(other.getFrameNumber()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModifier() == null ? other.getGmtModifier() == null : this.getGmtModifier().equals(other.getGmtModifier()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCarNumber() == null) ? 0 : getCarNumber().hashCode());
        result = prime * result + ((getNumberViolation() == null) ? 0 : getNumberViolation().hashCode());
        result = prime * result + ((getOwner() == null) ? 0 : getOwner().hashCode());
        result = prime * result + ((getEngineNumber() == null) ? 0 : getEngineNumber().hashCode());
        result = prime * result + ((getFrameNumber() == null) ? 0 : getFrameNumber().hashCode());
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
        sb.append(", carNumber=").append(carNumber);
        sb.append(", numberViolation=").append(numberViolation);
        sb.append(", owner=").append(owner);
        sb.append(", engineNumber=").append(engineNumber);
        sb.append(", frameNumber=").append(frameNumber);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModifier=").append(gmtModifier);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}