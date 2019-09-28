package com.sen.blog.controller.admin;

import com.sen.blog.entity.User;
import com.sen.blog.service.ArticleService;
import com.sen.blog.service.CommentService;
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
import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Sen
 * @Date: 2019/9/22 19:10
 * @Description:
 */
@Controller
public class AdminController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    /**
     * 跳转登录页
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 跳转后台首页
     * @return
     */
    @RequestMapping(value = {"/admin"},method = RequestMethod.GET)
    public String showBackgroundIndex(Model model) {
        model.addAttribute("articleList", articleService.selectAll());
        model.addAttribute("commentList", commentService.listRecentComment(0,5));

        return "/admin/index";
    }
    /**
     * 登录
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public void login(Model model, HttpServletRequest request) {
        String className = (String) request.getAttribute("shiroLoginFailure");
        if (UnknownAccountException.class.getName().equals(className)) {
            model.addAttribute("message", "非法用户");
        } else if (IncorrectCredentialsException.class.getName().equals(className)) {
            model.addAttribute("message", "用户名或密码错误");
        } else if (AuthenticationException.class.getName().equals(className)) {
            model.addAttribute("message", "非法操作");
        }
    }

}
