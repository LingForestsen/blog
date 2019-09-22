package com.sen.blog;

import com.sen.blog.dao.UserDao;
import com.sen.blog.entity.User;
import com.sen.blog.utils.IpUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @Auther: Sen
 * @Date: 2019/9/22 00:30
 * @Description:
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserDao userDao;
    @Override
    public String getName() {
        return "userRealm";
    }

    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User user = (User) principals.getPrimaryPrincipal();
        if (user.getPermission() == null) {
            return null;
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission(user.getPermission());
        return info;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = token.getPrincipal().toString();
        String credentials = token.getCredentials().toString();
        User user = userDao.login(username);
        if (user != null) {
            if (user.getPass().equals(credentials)) {
                user.setLastLoginTime(new Date());
                userDao.update(user);
            }
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user
                ,user.getPass(), ByteSource.Util.bytes(user.getSalt()), getName());
        return info;
    }

    /**
     * 如在运行过程中，主体的权限发生了改变，
     * 那么应该从spring容器中调用realm的清理缓存方法。
     * @param principals
     */
    @Override
    protected void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }
}
