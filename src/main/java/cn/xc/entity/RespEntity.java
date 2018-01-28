package cn.xc.entity;

import cn.xc.enums.RespCode;

/**
 * @version V1.0
 * @Description: 响应报文
 * @Author XiongCheng
 * @Date 2018/1/28 13:50.
 */
public class RespEntity{
    private int code;
    private String msg;
    private Object data;
    public RespEntity(RespCode respCode) {
        this.code = respCode.getCode();
        this.msg = respCode.getMsg();
    }

    public RespEntity(RespCode respCode, Object data) {
        this(respCode);
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
