package com.sen.blog.controller.admin;

import com.sen.blog.entity.Category;
import com.sen.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/24 00:58
 * @Description: 文章分类
 */
@Controller
@RequestMapping(value = "/admin/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String toCategoryIndex(Model model) {
        List<Category> categories = categoryService.listCategory();
        model.addAttribute("categoryList", categories);
        return "/admin/category/index";
    }
}
