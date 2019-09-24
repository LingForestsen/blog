package com.sen.blog.controller.admin;

import com.sen.blog.entity.Tag;
import com.sen.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/24 02:00
 * @Description:
 */
@Controller
@RequestMapping(value = "/admin/tag")
public class BackgroundTagController {

    @Autowired
    private TagService tagService;

    /**
     * 跳转标签管理首页
     * @param model
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String toTagIndex(Model model) {
        List<Tag> tags = tagService.listTag();
        model.addAttribute("tagList", tags);
        return "/admin/tag/index";
    }
}
