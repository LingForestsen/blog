package com.sen.blog.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: Sen
 * @Date: 2019/9/26 03:50
 * @Description: 连接
 */
@Data
public class Link {

    private int linkId;

    private String linkUrl;

    private String linkName;

    private String linkImage;

    private String linkDescription;

    private String linkOwnerNickname;

    private String linkOwnerContact;

    private Date linkUpdateTime;

    private Date linkCreateTime;

    private int linkOrder;
    /**
     * 1 显示，非1 隐藏
     */
    private int linkStatus;
}
