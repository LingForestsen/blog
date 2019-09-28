package com.sen.blog.controller.home;

import com.github.pagehelper.PageInfo;
import com.sen.blog.entity.Article;
import com.sen.blog.entity.Tag;
import com.sen.blog.service.ArticleService;
import com.sen.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: Sen
 * @Date: 2019/9/29 00:09
 * @Description:
 */
@Controller
public class TagController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagService tagService;

    @RequestMapping(value = "/tag/{tagId}", method = RequestMethod.GET)
    public String showTagPage(@PathVariable int tagId,
                              Model model,
                              @RequestParam(required = false,defaultValue = "1") int pageIndex,
                              @RequestParam(required = false,defaultValue = "10") int pageSize) {

        PageInfo<Article> articlePageInfo = articleService.listArticlesByTagId(pageIndex, pageSize, tagId);
        Tag tag = tagService.selectById(new Tag(tagId));
        model.addAttribute("pageInfo", articlePageInfo);
        model.addAttribute("tag", tag);
        model.addAttribute("pageUrlPrefix", "/tag?pageIndex");
        return "/home/page/articleListByTag";
    }

}
