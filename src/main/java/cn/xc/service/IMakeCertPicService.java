package cn.xc.service;

import java.io.OutputStream;

/**
 * 验证码生成服务接口
 * 
 * @Author XiongCheng 
 * @version V1.0
 * @Date 2018/2/6 10:43.
 */
public interface IMakeCertPicService {
    String getCerPic(int width, int height, OutputStream os);
}
