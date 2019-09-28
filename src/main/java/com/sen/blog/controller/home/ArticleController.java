package com.sen.blog.controller.home;

import com.sen.blog.entity.Article;
import com.sen.blog.entity.Category;
import com.sen.blog.service.ArticleService;
import com.sen.blog.service.CategoryService;
import com.sen.blog.service.CommentService;
import com.sen.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/27 18:55
 * @Description:
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private TagService tagService;

    @RequestMapping(value = "/article/{articleId}", method = RequestMethod.GET)
    public String showArticleDetail(@PathVariable int articleId, Model model) {
        //文章
        model.addAttribute("article", articleService.selectById(new Article(articleId)));
        //评论
        model.addAttribute("commentList", commentService.selectByArticleId(articleId));
        //相关文章
        List<Category> categories = categoryService.selectByArticleId(new Article(articleId));
        List<Integer> categoryIds = new ArrayList<>();
        categories.forEach(category->{
            categoryIds.add(category.getCategoryId());
        });
        List<Article> similarArticleList = articleService.listByCategoryIds(categoryIds);
        model.addAttribute("similarArticleList", similarArticleList);
        //猜你喜欢
        model.addAttribute("mostViewArticleList", articleService.listMostViewCountArticle(5));
        //前一页
        model.addAttribute("preArticle", articleService.selectBeforeArticle(articleId));
        //后一页
        model.addAttribute("afterArticle", articleService.selectAfterArticle(articleId));
        //随机文章
        model.addAttribute("randomArticleList", articleService.listRandArticle(5));
        //热评文章
        model.addAttribute("mostCommentArticleList", articleService.listMostCommentArticle(5));
        return "/home/page/articleDetail";
    }

    @RequestMapping(value = "/article/like/{articleId}", method = RequestMethod.POST)
    @ResponseBody
    public int addArticleLikeCount(@PathVariable int articleId) {
        Article article = articleService.selectById(new Article(articleId));
        article.setArticleLikeCount(article.getArticleLikeCount() + 1);
        articleService.update(article);
        return article.getArticleLikeCount();
    }
}
