package com.sen.blog.controller.home;

import com.github.pagehelper.PageInfo;
import com.sen.blog.entity.Article;
import com.sen.blog.entity.Category;
import com.sen.blog.service.ArticleService;
import com.sen.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: Sen
 * @Date: 2019/9/29 00:48
 * @Description:
 */
@Controller
public class CategoryController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/category/{categoryId}")
    public String showArticleByCategory(@PathVariable int categoryId,
                                        @RequestParam(required = false,defaultValue = "1") int pageIndex,
                                        @RequestParam(required = false,defaultValue = "10")int pageSize,
                                        Model model) {

        PageInfo<Article> articlePageInfo = articleService.listArticlesByCategoryId(pageIndex, pageSize, categoryId);
        model.addAttribute("pageInfo", articlePageInfo);
        model.addAttribute("category", categoryService.selectById(new Category(categoryId)));
        model.addAttribute("pageUrlPrefix", "/category?pageIndex");
        return "/home/page/articleListByCategory";
    }
}
