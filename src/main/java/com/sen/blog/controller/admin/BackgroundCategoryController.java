package com.sen.blog.controller.admin;

import com.sen.blog.common.CommonValidatorMethod;
import com.sen.blog.entity.Category;
import com.sen.blog.service.CategoryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/24 00:58
 * @Description: 文章分类
 */
@Controller
@RequestMapping(value = "/admin/category")
public class BackgroundCategoryController extends CommonValidatorMethod<Category> {

    @Autowired
    private CategoryService categoryService;

    /**
     * 跳转分类主页
     * @param model
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showCategoryIndex(Model model) {
        List<Category> categories = categoryService.selectAll();
        model.addAttribute("categoryList", categories);
        return "/admin/category/index";
    }

    /**
     * 新增文章分类
     * @param category
     * @param redirectAttributes
     * @param response
     * @return
     */
    @RequiresPermissions("admin:manager")
    @RequestMapping(value = "/insertSubmit", method = RequestMethod.POST)
    public String insertCategorySubmit(Category category, RedirectAttributes redirectAttributes, HttpServletResponse response) {
        if (!validate(redirectAttributes, category, "/admin/category", response)) {
            return null;
        }
        categoryService.insert(category);
        return "redirect:/admin/category";
    }

    @RequestMapping(value = "/delete/{categoryId}")
    public String deleteCategory(@PathVariable Integer categoryId) {
        categoryService.delete(categoryId);
        return "redirect:/admin/category";
    }

    /**
     * 跳转分类编辑页面
     * @param categoryId
     * @param model
     * @return
     */
    @RequestMapping(value = "/edit/{categoryId}")
    public String showCategoryEdit(@PathVariable Integer categoryId, Model model) {
        Category category = categoryService.selectById(new Category(categoryId));
        List<Category> categories = categoryService.selectAll();
        model.addAttribute("categoryList", categories);
        model.addAttribute("category", category);
        return "/admin/category/edit";
    }

    /**
     * 修改分类
     * @param category
     * @param redirectAttributes
     * @param response
     * @return
     */
    @RequiresPermissions("admin:manager")
    @RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
    public String insertEditSubmit(Category category, RedirectAttributes redirectAttributes, HttpServletResponse response) {
        if (!validate(redirectAttributes, category, "/admin/category", response)) {
            return null;
        }
        categoryService.update(category);
        return "redirect:/admin/category";
    }

    /**
     * 跳转新增页面
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String showInsert() {
        System.out.println("hello");
        return "redirect:/admin/category";
    }
}
