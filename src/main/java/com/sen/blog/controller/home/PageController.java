package com.sen.blog.controller.home;

import com.sen.blog.entity.Page;
import com.sen.blog.service.ArticleService;
import com.sen.blog.service.CategoryService;
import com.sen.blog.service.PageService;
import com.sen.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: Sen
 * @Date: 2019/9/29 01:49
 * @Description:
 */
@Controller
public class PageController {

    @Autowired
    private PageService pageService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TagService tagService;

    @RequestMapping(value = "/{key}", method = RequestMethod.GET)
    public String showAbuotSite(@PathVariable String key, Model model) {
        Page page = pageService.selectByKey(key);
        model.addAttribute("page", page);
        return "/home/page/page";
    }

    @RequestMapping(value = "/map",method = RequestMethod.GET)
    public String showSiteMap(Model model) {
        model.addAttribute("articleList", articleService.selectAll());
        model.addAttribute("categoryList", categoryService.selectAll());
        model.addAttribute("tagList", tagService.selectAll());
        return "/home/page/siteMap";
    }

    @RequestMapping(value = "/message" ,method = RequestMethod.GET)
    public String showMessage() {
        return "/home/page/message";
    }
}
