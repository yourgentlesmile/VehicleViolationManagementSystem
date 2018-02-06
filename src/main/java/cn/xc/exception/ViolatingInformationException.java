package cn.xc.exception;

/**
 *  车辆违章异常类
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/2/1 14:14.
 */
public class ViolatingInformationException extends Exception {
    public ViolatingInformationException(String message) {
        super(message);
    }
}
