package com.sen.blog.controller.admin;

import com.sen.blog.common.CommonValidatorMethod;
import com.sen.blog.entity.Link;
import com.sen.blog.service.LinkService;
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
 * @Date: 2019/9/26 11:33
 * @Description:
 */
@Controller
@RequestMapping(value = "/admin/link")
public class BackgroundLinkController{

   public CommonValidatorMethod<Link> common = new CommonValidatorMethod<>();

    @Autowired
    private LinkService linkService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showLink(Model model) {
        List<Link> linkList = linkService.selectAll();
        model.addAttribute("linkList", linkList);
        return "/admin/link/index";
    }

    @RequestMapping(value = "/edit/{linkId}",method = RequestMethod.GET)
    public String showEditLink(@PathVariable Integer linkId, Model model) {
        Link link = linkService.selectById(new Link(linkId));
        List<Link> linkList = linkService.selectAll();
        model.addAttribute("linkList", linkList);
        model.addAttribute("linkCustom", link);
        return "/admin/link/edit";
    }

    @RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
    public String editLinkSubmin(Link link, Model model, HttpServletResponse response) {
        if (!common.validate(model, link, "/admin/link", response)) {
            return null;
        }
        linkService.update(link);
        return "redirect:/admin/link";
    }

    @RequestMapping(value = "/delete/{linkId}", method = RequestMethod.GET)
    public String deleteLink(@PathVariable Integer linkId) {
        linkService.delete(linkId);
        return "redirect:/admin/link";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String showInsert(Model model) {
        List<Link> linkList = linkService.selectAll();
        model.addAttribute("linkList", linkList);
        return "/admin/link/insert";
    }

    @RequestMapping(value = "/insertSubmit", method = RequestMethod.POST)
    public String insertLinkSubmit(Link link, Model model, HttpServletResponse response) {
        if (!common.validate(model, link, "/admin/link/insert", response)) {
            return null;
        }
        linkService.insert(link);
        return "redirect:/admin/link";
    }
}
