package com.sen.blog.controller.admin;

import com.sen.blog.dto.BaseResult;
import com.sen.blog.dto.UploadDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @Auther: Sen
 * @Date: 2019/9/24 03:07
 * @Description: 图片上传
 */
@RestController
@RequestMapping(value = "/admin/upload")
public class UploadController {
    /**
     * 文件存放的真实路径
     */
    private final String realPath = "F:\\codeHub\\blog\\uploads";

    @RequestMapping(value = "/img")
    public BaseResult uploadImage(MultipartFile file) {

        //获取文件名
        String originalFilename = file.getOriginalFilename();
        //获取文件后缀
        int index = originalFilename.lastIndexOf(".");
        String fileType = originalFilename.substring(index);
        //获取上传的文件名（不带后缀）
        String fullFileName = originalFilename.substring(0, index);
        //定义可上传到的文件类型
        List<String> fileTypes = Arrays.asList(".bmp", ".jpg", ".jpeg", ".png", ".gif", ".pdf", ".doc", ".zip", ".rar", ".gz");
        //判断上传文件类型是否支持
        if (!fileTypes.contains(fileType)) {
            return BaseResult.failed("上传的文件类型不支持");
        }

        //创建目标目录(格式：年/月)
        Calendar calendar = Calendar.getInstance();
        File targetPath = new File(realPath + File.separator +
                calendar.get(Calendar.YEAR) + File.separator + (calendar.get(Calendar.MARCH) + 1));
        //目标目录不存在则创建
        if (!targetPath.exists()) {
            targetPath.mkdirs();
        }
        //目标文件
        String targetFileName = fullFileName + UUID.randomUUID().toString() + fileType;
        //在指定的目标目录下创建文件
        targetPath = new File(targetPath, targetFileName);

        //写入
        try {
            file.transferTo(targetPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //封装DTO
        String src = String.format("/uploads/%s/%s/%s", calendar.get(Calendar.YEAR), (calendar.get(Calendar.MARCH) + 1), targetFileName);
        UploadDto dto = new UploadDto();
        dto.setSrc(src);
        dto.setTitle(originalFilename);

        return BaseResult.success(dto);
    }
}
