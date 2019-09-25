package com.sen.blog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: Sen
 * @Date: 2019/9/20 18:45
 * @Description: 用户
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 5322586187380510636L;

    private int id;

    private String name;

    private String pass;

    private String nickName;

    private String email;

    private String url;

    private String avatar;

    private String lastLoginIp;

    private Date registerTime;

    private Date lastLoginTime;

    /**
     * 1为正常 ，0 为异常
     */
    private int status;
    /**
     * 盐值
     */
    private String salt;
    /**
     * 权限
     */
    private String permission;

}
