package com.sen.blog.controller.admin;

import com.sen.blog.entity.Comment;
import com.sen.blog.service.ArticleService;
import com.sen.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
     * 跳转后台管理页面
     *
     * @return
     */
    @RequestMapping(value = {"/","/admin"})
    public String toBackgroud(Model model) {
        model.addAttribute("articleList", articleService.listArticle());
        model.addAttribute("commentList", commentService.listComment());
        return "/admin/index";
    }
}
