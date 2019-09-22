package com.sen.blog.service.impl;

import com.sen.blog.dao.UserDao;
import com.sen.blog.entity.User;
import com.sen.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @Auther: Sen
 * @Date: 2019/9/20 21:36
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User login(String name,String pass) {
        User user = userDao.login(name);
        //从数据库里面查到的user不为空
        if (user != null) {
            //把原密码加密
            String encodePass = DigestUtils.md5DigestAsHex(pass.getBytes());
            if (encodePass.equals(user.getPass())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }
}
