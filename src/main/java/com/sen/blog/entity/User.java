package com.sen.blog.entity;

import com.sen.blog.constant.Regx;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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

    private int userId;

    @Length(min = 4,max = 12,message = "用户名长度为4-12")
    private String userName;

    @NotNull
    private String userPass;

    @NotNull
    private String userNickname;

    @Pattern(regexp = Regx.CHECK_MAIL,message = "邮箱格式不正确")
    private String userEmail;

    @Pattern(regexp =Regx.CHECK_URL, message = "url格式有误")
    private String userUrl;

    private String userAvatar;

    private String userLastLoginIp;

    private Date userRegisterTime;

    private Date userLastLoginTime;
    /**
     * 1为正常 ，0 为异常
     */
    private int userStatus;

    /**
     * 盐值
     */
    private String userSalt;
    /**
     * 权限
     */
    private String userPermission;
    /**
     * 文章总数（非数据库字段）
     */
    private int articleCount;

    public User() {
    }

    public User(int userId) {
        this.userId = userId;
    }
}
