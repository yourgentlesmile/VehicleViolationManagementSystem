package cn.xc.service;

import java.io.OutputStream;

public interface IMakeCertPicService {
    String getCerPic(int width, int height, OutputStream os);
}
