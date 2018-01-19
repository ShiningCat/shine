package com.shine.user.controller.user;

import com.shine.common.vo.ResultDO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileController {
    @PostMapping(value = "/image")
    public Object imageUpload(@RequestParam MultipartFile file) {
        if (file.isEmpty()) {
            return new ResultDO<>(false,"文件为空");
        }
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(bi == null){
            return new ResultDO<>(false,"文件格式错误");
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
//        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
//        logger.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        String filePath = "E://docker/docker_study/image/";
        // 解决中文问题，liunx下中文路径，图片显示问题
        fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return new ResultDO<>("上传成功");
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResultDO<>(false,"上传失败");
    }

}
