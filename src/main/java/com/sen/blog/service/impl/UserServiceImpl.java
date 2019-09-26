package com.sen.blog.service.impl;

import com.sen.blog.common.BaseServiceImpl;
import com.sen.blog.dao.ArticleDao;
import com.sen.blog.dao.UserDao;
import com.sen.blog.entity.User;
import com.sen.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/20 21:36
 * @Description:
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl extends BaseServiceImpl<User, UserDao> implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private ArticleDao articleDao;

    @Override
    public User login(String name) {
        // User user = userDao.login(name);
        // //从数据库里面查到的user不为空
        // if (user != null) {
        //     //把原密码加密
        //     String encodePass = DigestUtils.md5DigestAsHex(pass.getBytes());
        //     if (encodePass.equals(user.getUserPass())) {
        //         return user;
        //     }
        // }
        return userDao.login(name);
    }

    @Override
    public User selectByEmail(User user) {
        return userDao.selectByEmail(user);
    }

    @Override
    public List<User> selectAll() {
        List<User> users = userDao.selectAll();
        if (users.size() > 0 && users != null) {
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                int articleCount = articleDao.countByUserId(user.getUserId());
                user.setArticleCount(articleCount);
            }
        }
        return users;
    }
}
