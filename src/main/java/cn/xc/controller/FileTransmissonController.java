package cn.xc.controller;

import cn.xc.entity.RespEntity;
import cn.xc.enums.RespCode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;

/**
 * 头像上传控制类
 *
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018-05-10 10:11.
 */
@RestController
public class FileTransmissonController {
    private static final String FILE_PATH_PREFIX = "E://Graduation-Design//User_Avatar//";
    @PostMapping("/Api/Public/avatar")
    public RespEntity avatarUpload(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Part filePart = request.getPart("avatar");
        String avatarName = UUID.randomUUID().toString();
        String avatarType = filePart.getSubmittedFileName().split("\\.")[1];
        String realPath = FILE_PATH_PREFIX + avatarName + "." + avatarType;
        filePart.write(realPath);
        return new RespEntity(RespCode.SUCCESS,avatarName + "." + avatarType);
    }
}
