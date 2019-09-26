package com.sen.blog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: Sen
 * @Date: 2019/9/27 02:55
 * @Description: 选项
 */
@Data
public class Options implements Serializable {

    private static final long serialVersionUID = -9093200000567592147L;

    private int optionId;

    /**
     * 站点标题
     */
    private String optionSiteTitle;

    /**
     * 站点描述
     */
    private String optionSiteDescrption;

    /**
     * 首页描述
     */
    private String optionMetaDescrption;
    /**
     * 首页关键字
     */
    private String optionMetaKeyword;

    private String optionAboutsiteAvatar;

    private String optionAboutsiteTitle;

    private String optionAboutsiteContent;

    /**
     * 微信二维码
     */
    private String optionAboutsiteWechat;

    private String optionAboutsiteQq;

    private String optionAboutsiteGithub;

    private String optionAboutsiteWeibo;

    private String optionTongji;

    private int optionStatus;
}
