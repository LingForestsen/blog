package com.sen.blog.shiro;

import com.sen.blog.dao.UserDao;
import com.sen.blog.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: Sen
 * @Date: 2019/9/21 01:35
 * @Description:
 */
@Component
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserDao userDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 授权认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        String password = String.valueOf(usernamePasswordToken.getPassword());
        User user = userDao.login(username);
        if(user == null) {
            throw new AccountException("账号或密码错误");
        }
        if(!password.equals(user.getPass())){
            throw new AccountException("账号或密码错误");
        }
        // SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
        //         user.getName(),user.getPass());
        // return simpleAuthenticationInfo;
        return null;
    }
}
