package cn.xc.enums;

/**
 *  响应码
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/1/28 13:54.
 */
public enum RespCode {
    SUCCESS(0, "请求成功"),
    WARN(-1, "网络异常，请稍后重试"),
    LOGINFAILED(-2,"登录失败"),
    EXCEPTION(-3,"出现异常"),
    UNLOGIN(-4,"请登陆后再请求");

    private int code;
    private String msg;

    RespCode(int code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}
