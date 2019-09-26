package com.sen.blog.service;
import com.sen.blog.common.BaseService;
import com.sen.blog.entity.User;


/**
 * @Auther: Sen
 * @Date: 2019/9/20 21:34
 * @Description:
 */
public interface UserService extends BaseService<User> {
    /**
     * 登录
     * @param name
     * @return
     */
    User login(String name);

    User selectByEmail(User user);

}
