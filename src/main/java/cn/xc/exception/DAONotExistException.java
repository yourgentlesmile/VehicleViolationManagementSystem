package cn.xc.exception;

/**
 * @version V1.0
 * @Description: DAO类空指针异常类
 * @Author XiongCheng
 * @Date 2018/1/23 17:26.
 */
public class DAONotExistException extends Exception {

    public DAONotExistException(String message) {
        super(message);
    }
}
