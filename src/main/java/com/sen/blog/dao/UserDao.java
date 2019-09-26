package com.sen.blog.dao;

import com.sen.blog.common.BaseDao;
import com.sen.blog.entity.User;

/**
 * @Auther: Sen
 * @Date: 2019/9/20 18:57
 * @Description:
 */
public interface UserDao extends BaseDao<User> {
    /**
     * 用户登录
     * @param name 用户名
     * @return 重数据库查询到的用户
     */
    User login(String name);

    User selectByEmail(User user);

}
