package cn.xc.entity.DO;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *  数据表log_login实体类
 *
 * @Author XiongCheng
 * @version V1.0
 * @Date 2018/1/30 12:19.
 */
public class LogLoginDO implements Serializable {
    private Long id;

    /**
     * 用户登录IP
     */
    private Long loginUserId;

    /**
     * 登录IP
     */
    private String loginIp;

    /**
     * 登录时间
     */
    private Timestamp loginTime;

    /**
     * 登录用户编号
     */
    private String loginUserIdentifier;

    /**
     * 是否是管理员 1:是, 0:否
     */
    private Integer isAdmin;

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

    public Long getLoginUserId() {
        return loginUserId;
    }

    public void setLoginUserId(Long loginUserId) {
        this.loginUserId = loginUserId;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginUserIdentifier() {
        return loginUserIdentifier;
    }

    public void setLoginUserIdentifier(String loginUserIdentifier) {
        this.loginUserIdentifier = loginUserIdentifier;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
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
        LogLoginDO other = (LogLoginDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLoginUserId() == null ? other.getLoginUserId() == null : this.getLoginUserId().equals(other.getLoginUserId()))
            && (this.getLoginIp() == null ? other.getLoginIp() == null : this.getLoginIp().equals(other.getLoginIp()))
            && (this.getLoginTime() == null ? other.getLoginTime() == null : this.getLoginTime().equals(other.getLoginTime()))
            && (this.getLoginUserIdentifier() == null ? other.getLoginUserIdentifier() == null : this.getLoginUserIdentifier().equals(other.getLoginUserIdentifier()))
            && (this.getIsAdmin() == null ? other.getIsAdmin() == null : this.getIsAdmin().equals(other.getIsAdmin()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLoginUserId() == null) ? 0 : getLoginUserId().hashCode());
        result = prime * result + ((getLoginIp() == null) ? 0 : getLoginIp().hashCode());
        result = prime * result + ((getLoginTime() == null) ? 0 : getLoginTime().hashCode());
        result = prime * result + ((getLoginUserIdentifier() == null) ? 0 : getLoginUserIdentifier().hashCode());
        result = prime * result + ((getIsAdmin() == null) ? 0 : getIsAdmin().hashCode());
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
        sb.append(", loginUserId=").append(loginUserId);
        sb.append(", loginIp=").append(loginIp);
        sb.append(", loginTime=").append(loginTime);
        sb.append(", loginUserIdentifier=").append(loginUserIdentifier);
        sb.append(", isAdmin=").append(isAdmin);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}