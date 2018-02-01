package cn.xc.exception;

/**
 * @version V1.0
 * @Description: 车牌号异常类
 * @Author XiongCheng
 * @Date 2018/2/1 14:14.
 */
public class ViolatingInformationException extends Exception {
    public ViolatingInformationException(String message) {
        super(message);
    }
}
