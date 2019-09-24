package com.sen.blog.controller.admin;

import cn.hutool.http.HtmlUtil;
import com.github.pagehelper.PageInfo;
import com.sen.blog.common.BeanValidator;
import com.sen.blog.dto.ArticleDto;
import com.sen.blog.entity.Article;
import com.sen.blog.entity.User;
import com.sen.blog.service.ArticleService;
import com.sen.blog.service.CategoryService;
import com.sen.blog.service.TagService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: Sen
 * @Date: 2019/9/23 16:09
 * @Description:
 */
@Controller
@RequestMapping(value = "/admin/article",method = RequestMethod.GET)
public class BackgroundArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagService tagService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 跳转后台文章管理页面
     * @param pageIndex 页数
     * @param status 文章状态
     * @param pageSize 页宽
     * @param model
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String showArticle(
            @RequestParam(required = false,defaultValue = "1") int pageIndex
            ,@RequestParam(required = false) String status
            ,@RequestParam(required = false, defaultValue = "10") int pageSize , Model model) {

        PageInfo<Article> articlePageInfo = articleService.listArticleAndCategory(pageIndex, pageSize);
        model.addAttribute("pageUrlPrefix", "/admin/article?status=" + status + "&pageIndex");
        model.addAttribute("pageInfo", articlePageInfo);

        return "/admin/article/index";
    }

    /**
     * 跳转插入文章页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String showInsert(Model model) {
        model.addAttribute("categoryList", categoryService.listCategory());
        model.addAttribute("tagList", tagService.listTag());
        return "/admin/article/insert";
    }

    /**
     * 新增文章
     * @param articleDto
     * @param model
     * @return
     */
    @RequestMapping(value = "/insertSubmit",method = RequestMethod.POST)
    public String insertArticle(ArticleDto articleDto, Model model) {
        //验证articleDto是否合法
        String vaildateMessage = BeanValidator.validator(articleDto);
        if (vaildateMessage != null) {
            String cleanMsg = HtmlUtil.cleanHtmlTag(vaildateMessage);
            model.addAttribute("vaildateMessage", cleanMsg);
            return "redirect:/admin/article/insert";
        }
        //从shiro获取当前登录的用户
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        articleService.saveArticle(articleDto, user);
        return "redirect:/admin/article";
    }
}
