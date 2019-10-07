package com.sen.blog.controller.admin;

import com.sen.blog.common.CommonValidatorMethod;
import com.sen.blog.entity.Menu;
import com.sen.blog.service.MenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: Sen
 * @Date: 2019/9/27 01:47
 * @Description:
 */
@Controller
@RequestMapping(value = "/admin/menu")
public class BackgroundMenuController extends CommonValidatorMethod<Menu> {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showMenu(Model model) {
        model.addAttribute("menuList", menuService.selectAll());
        return "/admin/menu/index";
    }

    @RequestMapping(value = "/edit/{menuId}",method = RequestMethod.GET)
    public String showEdit(Model model,@PathVariable int menuId) {
        model.addAttribute("menu", menuService.selectById(new Menu(menuId)));
        model.addAttribute("menuList", menuService.selectAll());
        return "/admin/menu/edit";
    }

    @RequiresPermissions("admin:manager")
    @RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
    public String editSubmit(Menu menu, RedirectAttributes redirectAttributes, HttpServletResponse response) {
        if (!validate(redirectAttributes, menu, "/admin/menu", response)) {
            return null;
        }
        menuService.update(menu);
        return "redirect:/admin/menu";
    }

    @RequiresPermissions("admin:manager")
    @RequestMapping(value = "/insertSubmit", method = RequestMethod.POST)
    public String insertSubmit(Menu menu, RedirectAttributes redirectAttributes, HttpServletResponse response) {
        if (!validate(redirectAttributes, menu, "/admin/menu", response)) {
            return null;
        }
        menuService.insert(menu);
        return "redirect:/admin/menu";
    }

    @RequiresPermissions("admin:manager")
    @RequestMapping(value = "/delete/{menuId}", method = RequestMethod.GET)
    public String delete(@PathVariable int menuId) {
        menuService.delete(menuId);
        return "redirect:/admin/menu";
    }

}
