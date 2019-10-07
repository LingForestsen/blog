package com.sen.blog.controller.home;

import cn.hutool.http.HtmlUtil;
import com.sen.blog.common.CommonValidatorMethod;
import com.sen.blog.dto.BaseResult;
import com.sen.blog.entity.Article;
import com.sen.blog.entity.Comment;
import com.sen.blog.entity.User;
import com.sen.blog.service.ArticleService;
import com.sen.blog.service.CommentService;
import com.sen.blog.utils.AvatarUtils;
import com.sen.blog.utils.IpUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Auther: Sen
 * @Date: 2019/9/28 03:47
 * @Description:
 */
@Controller
@ResponseBody
public class CommentController extends CommonValidatorMethod<Comment> {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public BaseResult commitComment(RedirectAttributes redirectAttributes, Comment comment, HttpServletRequest request) {
        comment.setCommentIp(IpUtils.getIpAddr(request));
        comment.setCommentCreateTime(new Date());
        //设置通用头象
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        comment.setCommentAuthorAvatar(AvatarUtils.getGravatar(user.getUserEmail()));

        //防止XSS攻击
        comment.setCommentContent(HtmlUtil.escape(comment.getCommentContent()));
        comment.setCommentAuthorName(HtmlUtil.escape(comment.getCommentAuthorName()));
        comment.setCommentAuthorEmail(HtmlUtil.escape(comment.getCommentAuthorEmail().trim()));
        comment.setCommentAuthorUrl(HtmlUtil.escape(comment.getCommentAuthorUrl()));

        //封装返回结果
        BaseResult baseResult = null;
        if (!validate(redirectAttributes, comment, null, null)) {
            baseResult = BaseResult.failed("请检查您的邮箱格式否正确");
        } else {
            commentService.insert(comment);
            baseResult = BaseResult.success();
        }
        //更新文章表的评论数
        Article article = articleService.selectById(new Article(comment.getCommentArticleId()));
        article.setArticleCommentCount(commentService.countByArticleId(article.getArticleId()));
        articleService.update(article);
        return baseResult;
    }
}
