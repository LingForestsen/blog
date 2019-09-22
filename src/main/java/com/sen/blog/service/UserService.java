package com.sen.blog.service;

import com.sen.blog.entity.User;

/**
 * @Auther: Sen
 * @Date: 2019/9/20 21:34
 * @Description:
 */
public interface UserService {
    /**
     * 登录
     * @param name
     * @return
     */
    User login(String name,String pass);

    /**
     * 更新用户信息
     * @param user
     */
    void update(User user);

}
