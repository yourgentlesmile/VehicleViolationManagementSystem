package cn.xc.entity.VO;

import cn.xc.entity.DO.UserDO;

import java.sql.Timestamp;

/**
 * @version V1.0
 *  传输到前端的user数据对象
 * @Author XiongCheng
 * @Date 2018/1/29 10:09.
 */
public class UserVO {
    private Long id;
    /**
     * 用户编号
     */
    private String identifier;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 性别，1:男 0:女 2:保密
     */
    private Integer sex;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 身份证号
     */
    private String idcardNumber;

    /**
     * 车牌号
     */
    private String carNumber;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 自定义头像地址
     */
    private String avatar;

    /**
     * 备注
     */
    private String remark;

    /**
     * 出生日期
     */
    private Timestamp birthDate;

    public UserVO(UserDO fromDB) {
        this.id = fromDB.getId();
        this.identifier = fromDB.getIdentifier();
        this.userName = fromDB.getUserName();
        this.nickName = fromDB.getNickName();
        this.sex = fromDB.getSex();
        this.phoneNumber = fromDB.getPhoneNumber();
        this.idcardNumber = fromDB.getIdcardNumber();
        this.carNumber = fromDB.getCarNumber();
        this.email = fromDB.getEmail();
        this.avatar = fromDB.getAvatar();
        this.remark = fromDB.getRemark();
        this.birthDate = fromDB.getBirthDate();
    }

    public UserVO() {
    }

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public String getIdcardNumber() {
        return idcardNumber;
    }

    public void setIdcardNumber(String idcardNumber) {
        this.idcardNumber = idcardNumber;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

}
