package com.sen.blog.controller.home;

import com.github.pagehelper.PageInfo;
import com.sen.blog.entity.Article;
import com.sen.blog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;

/**
 * @Auther: Sen
 * @Date: 2019/9/27 14:56
 * @Description: 首页控制器
 */
@Controller
public class IndexController {



    @Autowired
    private CategoryService categoryService;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagService tagService;

    @Autowired
    private LinkService linkService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = {"", "/article"}, method = RequestMethod.GET)
    public String showIndex(
            @RequestParam(required = false, defaultValue = "1") int pageIndex,
            @RequestParam(required = false, defaultValue = "10") int pageSize,
            Model model) {

        //顶部通知
        model.addAttribute("noticeList", noticeService.selectAll());
        //左侧文章菜单
        PageInfo<Article> articlePageInfo = articleService.listArticleAndCategory(pageIndex, pageSize, null);
        model.addAttribute("pageInfo", articlePageInfo);
        model.addAttribute("pageUrlPrefix", "/article?pageIndex");

        //右侧菜单
        ArrayList<String> siteBasicStatistics = new ArrayList<>();
        siteBasicStatistics.add(articleService.countArticle() + "");
        siteBasicStatistics.add(articleService.sumComment() + "");
        siteBasicStatistics.add(categoryService.count() + "");
        siteBasicStatistics.add(tagService.count() + "");
        siteBasicStatistics.add(linkService.count() + "");
        siteBasicStatistics.add(articleService.sumView() + "");
        model.addAttribute("siteBasicStatistics", siteBasicStatistics);
        //友情链接
        model.addAttribute("linkList", linkService.selectAll());
        //近期评论
        model.addAttribute("recentCommentList", commentService.listRecentComment(0, 10));
        //最后更新的文章
        PageInfo<Article> lastUpdateArticlePageInfo = articleService.listArticleAndCategory(1, 1, null);
        model.addAttribute("lastUpdateArticle", lastUpdateArticlePageInfo.getList().get(0));
        return "/home/index";
    }

}
