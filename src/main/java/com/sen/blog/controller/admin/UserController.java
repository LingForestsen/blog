package com.sen.blog.controller.admin;

import com.sen.blog.entity.User;
import com.sen.blog.service.UserService;
import com.sen.blog.utils.IpUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Auther: Sen
 * @Date: 2019/9/20 19:20
 * @Description: 用户控制
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 跳转登录页
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 跳转首页
     * @return
     */
    @RequiresPermissions("admin:list")
    @RequestMapping(value = {"/","/index"},method = RequestMethod.GET)
    public String index(Model model) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        model.addAttribute("user", user);
        return "index";
    }
    /**
     * 登录
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public void login(Model model, HttpServletRequest request) {

        String className = (String) request.getAttribute("shiroLoginFailure");
        System.out.println(className);
        if (UnknownAccountException.class.getName().equals(className)) {
            model.addAttribute("message", "非法用户");
        } else if (IncorrectCredentialsException.class.getName().equals(className)) {
            model.addAttribute("message", "用户名或密码错误");
        } else if (AuthenticationException.class.getName().equals(className)) {
            model.addAttribute("message", "非法操作");
        }

        // User loginUser = userService.login(name, pass);
        // if (loginUser != null) {
        //     String ipAddr = IpUtils.getIpAddr(request);
        //     loginUser.setLastLoginTime(new Date());
        //     loginUser.setLastLoginIp(ipAddr);
        //     userService.update(loginUser);
        //     if (StringUtils.isNotBlank(rememberme)) {
        //
        //     }
        //     return "index";
        // }
        // attributes.addFlashAttribute("message", "登录失败，请检查您的用户名或密码是否正确");
        // return "redirect:/login";
    }
}
