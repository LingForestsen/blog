package com.sen.blog.controller.admin;

import com.sen.blog.common.CommonValidatorMethod;
import com.sen.blog.entity.Page;
import com.sen.blog.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/25 23:02
 * @Description:
 */
@Controller
@RequestMapping(value = "/admin/page")
public class BackgroundPageController extends CommonValidatorMethod<Page> {

    @Autowired
    private PageService pageService;

    /**
     * 跳转页面管理首页
     * @param model
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showPage(Model model) {
        List<Page> pageList = pageService.selectAll();
        model.addAttribute("pageList", pageList);
        return "/admin/page/index";
    }

    /**
     * 跳转编辑页面
     * @param pageId
     * @param model
     * @return
     */
    @RequestMapping(value = "/edit/{pageId}")
    public String showEdit(@PathVariable Integer pageId, Model model) {
        Page page = pageService.selectById(new Page(pageId));
        model.addAttribute("page", page);
        return "/admin/page/edit";
    }

    /**
     * 保存编辑页面
     *
     * @param page
     * @return
     */
    @RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
    public String pageEditSubmit(Page page, Model model, HttpServletResponse response) {
        if (!validate(model, page, "/admin/page", response)) {
            return null;
        }
        pageService.update(page);
        return "redirect:/admin/page";
    }

    /**
     * 删除页面
     * @param pageId
     * @return
     */
    @RequestMapping(value = "/delete/{pageId}")
    public String deletePage(@PathVariable Integer pageId) {
        pageService.delete(new Page(pageId));
        return "redirect:/admin/page";
    }

    /**
     * 跳转新增页面
     * @return
     */
    @RequestMapping(value = "/insert")
    public String showInsertPage() {
        return "/admin/page/insert";
    }

    /**
     * 新建页面
     *
     * @param page
     * @return
     */
    @RequestMapping(value = "/insertSubmit", method = RequestMethod.POST)
    public String insertPageSubmit(Page page, HttpServletResponse response, Model model) {
        if (!validate(model, page, "/admin/page/insert", response)) {
            return null;
        }
        pageService.insert(page);
        return "redirect:/admin/page";
    }
}
