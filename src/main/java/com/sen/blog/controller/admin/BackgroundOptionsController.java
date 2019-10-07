package com.sen.blog.controller.admin;

import com.sen.blog.entity.Options;
import com.sen.blog.service.OptionsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/27 03:17
 * @Description:
 */
@Controller
@RequestMapping(value = "/admin/options")
public class BackgroundOptionsController {

    @Autowired
    private OptionsService optionsService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showOptions(Model model) {
        List<Options> options = optionsService.selectAll();
        model.addAttribute("option", options.get(0));
        return "/admin/options/index";
    }

    @RequiresPermissions("admin:manager")
    @RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
    public String editSubmit(Options options) {
        optionsService.update(options);
        return "redirect:/admin/options";
    }
}
