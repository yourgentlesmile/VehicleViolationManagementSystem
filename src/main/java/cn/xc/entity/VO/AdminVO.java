package cn.xc.entity.VO;

import cn.xc.entity.DO.AdminDO;

/**
 * @version V1.0
 *  传输到前端的admin数据对象
 * @Author XiongCheng
 * @Date 2018/1/28 10:34.
 */
public class AdminVO {
    /**
     * 管理员编号
     */
    private String identifier;

    /**
     * 管理员类别
     */
    private Integer type;

    /**
     * 真实姓名
     */
    private String adminName;

    /**
     * 性别，1:男 0:女 2:保密
     */
    private Integer sex;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 备注
     */
    private String remark;

    /**
     * 邮箱
     */
    private String email;

    private Long id;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AdminVO{" +
        "identifier='" + identifier + '\'' +
        ", type=" + type +
        ", adminName='" + adminName + '\'' +
        ", sex=" + sex +
        ", phoneNumber='" + phoneNumber + '\'' +
        ", avatar='" + avatar + '\'' +
        ", remark='" + remark + '\'' +
        ", email='" + email + '\'' +
        ", id=" + id +
        '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminVO adminVO = (AdminVO) o;

        if (identifier != null ? !identifier.equals(adminVO.identifier) : adminVO.identifier != null) return false;
        if (type != null ? !type.equals(adminVO.type) : adminVO.type != null) return false;
        if (adminName != null ? !adminName.equals(adminVO.adminName) : adminVO.adminName != null) return false;
        if (sex != null ? !sex.equals(adminVO.sex) : adminVO.sex != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(adminVO.phoneNumber) : adminVO.phoneNumber != null) return false;
        if (avatar != null ? !avatar.equals(adminVO.avatar) : adminVO.avatar != null) return false;
        if (remark != null ? !remark.equals(adminVO.remark) : adminVO.remark != null) return false;
        if (email != null ? !email.equals(adminVO.email) : adminVO.email != null) return false;
        return id != null ? id.equals(adminVO.id) : adminVO.id == null;
    }

    @Override
    public int hashCode() {
        int result = identifier != null ? identifier.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (adminName != null ? adminName.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    public AdminVO(AdminDO fromDB) {
        this.identifier = fromDB.getIdentifier();
        this.type = fromDB.getType();
        this.adminName = fromDB.getAdminName();
        this.sex = fromDB.getSex();
        this.phoneNumber = fromDB.getPhoneNumber();
        this.avatar = fromDB.getAvatar();
        this.remark = fromDB.getRemark();
        this.email = fromDB.getEmail();
        this.id = fromDB.getId();
    }

    public AdminVO() {
    }
}
