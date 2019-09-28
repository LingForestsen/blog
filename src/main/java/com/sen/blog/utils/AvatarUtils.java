package com.sen.blog.utils;

import org.springframework.util.DigestUtils;

/**
 * @Auther: Sen
 * @Date: 2019/9/28 16:37
 * @Description:
 */
public class AvatarUtils {
    /**
     * 获取Gravatar 公认头像
     * @param email 邮箱（需要在gravatar上注册）
     * @return Gravatar地址
     */
    public static String getGravatar(String email) {
        String emailMd5 = DigestUtils.md5DigestAsHex(email.getBytes());
        //设置图片大小32px
        String avatar = "http://cn.gravatar.com/avatar/" + emailMd5 + "?s=128&d=identicon&r=PG";
        return avatar;
    }

}
