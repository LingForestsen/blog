package com.sen.blog.controller.admin;

import com.sen.blog.dto.BaseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther: Sen
 * @Date: 2019/9/24 03:07
 * @Description: 图片上传
 */
@Controller
@RequestMapping(value = "/admin/upload")
public class UploadController {

    @RequestMapping(value = "/img")
    public BaseResult uploadImage(MultipartFile file) {
        file.getOriginalFilename();

        return BaseResult.success();
    }
}
