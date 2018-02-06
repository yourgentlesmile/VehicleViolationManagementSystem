package cn.xc.entity.VO;

/**
 * @version V1.0
 *  注册相关数据对象
 * @Author XiongCheng
 * @Date 2018/1/28 11:05.
 */
public class RegisterVO {
    /**
     * 管理员编号
     */
    private String identifier;
    /**
     * 密码
     */
    private String adminPassword;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public String toString() {
        return "RegisterVO{" +
        "identifier='" + identifier + '\'' +
        ", adminPassword='" + adminPassword + '\'' +
        '}';
    }
}
