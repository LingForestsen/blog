package com.sen.blog.controller.admin;

import com.sen.blog.entity.Article;
import com.sen.blog.entity.Comment;
import com.sen.blog.service.ArticleService;
import com.sen.blog.service.CommentService;
import com.sen.blog.utils.IpUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Auther: Sen
 * @Date: 2019/9/26 17:57
 * @Description: 评论控制器
 */
@Controller
@RequestMapping("/admin/comment")
public class BackgrundCommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showComment(Model model,
                              @RequestParam(required = false, defaultValue = "1") int pageIndex,
                              @RequestParam(required = false, defaultValue = "10") int pageSize) {

        model.addAttribute("pageInfo", commentService.selectAllByPage(pageIndex, pageSize));
        model.addAttribute("pageUrlPrefix", "/admin/comment?pageIndex");
        return "/admin/comment/index";
    }

    @RequestMapping(value = "/reply/{commentId}", method = RequestMethod.GET)
    public String showRely(@PathVariable int commentId, Model model) {
        model.addAttribute("comment", commentService.selectById(new Comment(commentId)));
        return "/admin/comment/reply";
    }

    @RequestMapping(value = "/replySubmit", method = RequestMethod.POST)
    public String replySubmit(Comment comment, HttpServletRequest request) {
        comment.setCommentIp(IpUtils.getIpAddr(request));
        comment.setCommentCreateTime(new Date());
        commentService.insert(comment);
        return "redirect:/admin/comment";
    }

    @RequestMapping(value = "/edit/{commentId}", method = RequestMethod.GET)
    public String showEdit(@PathVariable int commentId,Model model) {
        model.addAttribute("comment", commentService.selectById(new Comment(commentId)));
        return "/admin/comment/edit";
    }


    @RequiresPermissions("admin:manager")
    @RequestMapping(value = "/editSubmit" ,method = RequestMethod.POST)
    public String editSubmit(Comment comment) {
        commentService.update(comment);
        return "redirect:/admin/comment";
    }

    @RequiresPermissions("admin:manager")
    @RequestMapping(value = "/delete/{commentId}", method = RequestMethod.POST)
    public String deleteComment(@PathVariable int commentId){
        Comment comment = commentService.selectById(new Comment(commentId));
        Article article = articleService.selectById(new Article(comment.getCommentArticleId()));
        commentService.delete(commentId);
        article.setArticleCommentCount(commentService.countByArticleId(article.getArticleId()));
        articleService.update(article);
        return "redirect:/admin/comment";
    }

}
