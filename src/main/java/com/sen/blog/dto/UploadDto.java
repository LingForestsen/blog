package com.sen.blog.dto;

import lombok.Data;

/**
 * @Auther: Sen
 * @Date: 2019/9/24 03:33
 * @Description: 用于返回json的自定义对象
 */
@Data
public class UploadDto {

    private String url;

    private String fileName;
}

