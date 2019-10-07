package com.sen.blog.controller.admin;

import com.github.pagehelper.PageInfo;
import com.sen.blog.common.CommonValidatorMethod;
import com.sen.blog.dto.ArticleDto;
import com.sen.blog.entity.Article;
import com.sen.blog.entity.Category;
import com.sen.blog.entity.Tag;
import com.sen.blog.entity.User;
import com.sen.blog.service.ArticleService;
import com.sen.blog.service.CategoryService;
import com.sen.blog.service.TagService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

        PageInfo<Article> articlePageInfo = articleService.listArticleAndCategory(pageIndex, pageSize,null);
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
        model.addAttribute("categoryList", categoryService.selectAll());
        model.addAttribute("tagList", tagService.selectAll());
        return "/admin/article/insert";
    }

    /**
     * 新增文章
     * @param articleDto 文章传输模型
     * @param redirectAttributes
     * @return
     */
    @RequiresPermissions("admin:manager")
    @RequestMapping(value = "/insertSubmit",method = RequestMethod.POST)
    public String insertArticle(ArticleDto articleDto, RedirectAttributes redirectAttributes, HttpServletResponse response) {
        User user = CommonValidatorMethod.validateArticle(redirectAttributes, articleDto, "/admin/article/insert", response);
        if (user == null) {
            return null;
        }
        articleService.saveArticle(articleDto, user);
        return "redirect:/admin/article";
    }

    /**
     * 保存草稿
     * @param articleDto
     * @return
     */
    @RequiresPermissions("admin:manager")
    @RequestMapping(value = "/insertDraftSubmit", method = RequestMethod.POST)
    public String insertDraftSubmit(ArticleDto articleDto,RedirectAttributes redirectAttributes,HttpServletResponse response) {
        User user = CommonValidatorMethod.validateArticle(redirectAttributes, articleDto, "/admin/article", response);
        if (user == null) {
            return null;
        }
        articleService.saveArticleDraft(articleDto, user);
        return "redirect:/admin/article";
    }

    /**
     * 跳转编辑文章页面
     * @param articleId
     * @param model
     * @return
     */
    @RequestMapping(value = "/edit/{articleId}", method = RequestMethod.GET)
    public String showEdit(@PathVariable int articleId,Model model) {
        Article articleParam = new Article();
        articleParam.setArticleId(articleId);

        //封装article非数据库字段
        Article article = articleService.selectById(articleParam);
        List<Category> categories = categoryService.selectByArticleId(article);
        List<Tag> tags = tagService.selectOneByArticleId(article);
        article.setCategoryList(categories);
        article.setTagList(tags);

        List<Category> categoryList = categoryService.selectAll();
        List<Tag> tagList = tagService.selectAll();
        model.addAttribute("article", article);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("tagList", tagList);

        return "/admin/article/edit";
    }

    /**
     * 保存编辑文章
     * @param articleDto
     * @param redirectAttributes
     * @return
     */
    @RequiresPermissions("admin:manager")
    @RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
    public String editSubmit(ArticleDto articleDto, RedirectAttributes redirectAttributes, HttpServletResponse response) {
        User user = CommonValidatorMethod.validateArticle(redirectAttributes, articleDto, "/admin/article/edit", response);
        if (user == null) {
            return null;
        }
        articleService.updateArticle(articleDto,user);
        return "redirect:/admin/article";
    }

    /**
     * 级联删除文章、分类、标签
     * @param articleId
     * @return
     */
    @RequiresPermissions("admin:manager")
    @RequestMapping(value = "/delete/{articleId}",method = RequestMethod.POST)
    public String deleteArticle(@PathVariable Integer articleId) {
        articleService.delete(articleId);
        return "redirect:/admin/article";
    }
}
