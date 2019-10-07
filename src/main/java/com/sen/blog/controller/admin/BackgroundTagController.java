package com.sen.blog.controller.admin;

import com.sen.blog.common.CommonValidatorMethod;
import com.sen.blog.entity.Tag;
import com.sen.blog.service.TagService;
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
 * @Date: 2019/9/24 02:00
 * @Description:
 */
@Controller
@RequestMapping(value = "/admin/tag")
public class BackgroundTagController extends CommonValidatorMethod<Tag> {

    @Autowired
    private TagService tagService;

    /**
     * 跳转标签管理首页
     * @param model
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String toTagIndex(Model model) {
        List<Tag> tags = tagService.selectAll();
        model.addAttribute("tagList", tags);
        return "/admin/tag/index";
    }

    /**
     * 添加标签
     *
     * @param tag
     * @return
     */
    @RequiresPermissions("admin:manager")
    @RequestMapping(value = "/insertSubmit", method = RequestMethod.POST)
    public String insertTagtSubmit(Tag tag, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        if (!validate(redirectAttributes, tag, "/admin/tag", response)) {
            return null;
        }
        tagService.insert(tag);
        return "redirect:/admin/tag";
    }

    /**
     * 跳转编辑页面
     * @param tagId
     * @param model
     * @return
     */
    @RequestMapping(value = "/edit/{tagId}")
    public String editTag(@PathVariable Integer tagId, Model model) {
        Tag tag = tagService.selectById(new Tag(tagId));
        List<Tag> tags = tagService.selectAll();
        model.addAttribute("tagList", tags);
        model.addAttribute("tag", tag);
        return "/admin/tag/edit";
    }

    /**
     * 编辑文章
     *
     * @param tag
     * @return
     */
    @RequiresPermissions("admin:manager")
    @RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
    public String editTagSubmit(Tag tag, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        if (!validate(redirectAttributes, tag, "/admin/tag", response)) {
            return null;
        }
        tagService.update(tag);
        return "redirect:/admin/tag";
    }

    @RequestMapping(value = "/delete/{tagId}")
    public String deleteTag(@PathVariable Integer tagId) {
        tagService.delete(tagId);
        return "redirect:/admin/tag";
    }
}
