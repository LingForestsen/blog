package com.sen.blog.controller.home;

import com.github.pagehelper.PageInfo;
import com.sen.blog.constant.ArticleStatus;
import com.sen.blog.entity.Article;
import com.sen.blog.entity.Category;
import com.sen.blog.service.ArticleService;
import com.sen.blog.service.CategoryService;
import com.sen.blog.service.CommentService;
import com.sen.blog.service.TagService;
import com.sen.blog.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
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

    @RequestMapping(value = "/article/view/{articleId}", method = RequestMethod.POST)
    @ResponseBody
    public String addArticleViewCount(@PathVariable int articleId) {
        Article article = articleService.selectById(new Article(articleId));
        int viewCount = article.getArticleLikeCount() + 1;
        article.setArticleLikeCount(viewCount);
        articleService.update(article);
        String json = null;
        try {
            json = MapperUtils.obj2json(viewCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public String searchSubmit(String keywords, Model model,
                               @RequestParam(required = false, defaultValue = "1") int pageIndex,
                               @RequestParam(required = false, defaultValue = "10") int pageSize) {
        HashMap<String,Object> criteria = new HashMap<>();
        criteria.put("status", ArticleStatus.PUBLIS.getValue());
        criteria.put("keywords", keywords);
        PageInfo<Article> articlePageInfo = articleService.listArticleAndCategory(pageIndex, pageSize, criteria);
        model.addAttribute("pageInfo", articlePageInfo);
        //返回搜索关键字
        model.addAttribute("keywords", keywords);
        model.addAttribute("pageUrlPrefix", "/search?keywords="+keywords+"&&pageIndex");
        return "/home/page/search";
    }

    @RequestMapping(value = "/articleFile", method = RequestMethod.GET)
    public String showArticleFile(Model model) {
        model.addAttribute("articleList", articleService.selectAll());
        return "/home/page/articleFile";
    }
}
