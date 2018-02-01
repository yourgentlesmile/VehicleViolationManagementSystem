package cn.xc.exception;

/**
 * @version V1.0
 * @Description: 操作日志服务异常类
 * @Author XiongCheng
 * @Date 2018/2/1 19:03.
 */
public class LogOperationException extends Exception {
    public LogOperationException(String message) {
        super(message);
    }
}
