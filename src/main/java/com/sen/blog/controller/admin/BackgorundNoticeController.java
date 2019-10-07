package com.sen.blog.controller.admin;

import com.sen.blog.common.CommonValidatorMethod;
import com.sen.blog.entity.Notice;
import com.sen.blog.service.NoticeService;
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
 * @Date: 2019/9/26 15:10
 * @Description:
 */
@Controller
@RequestMapping(value = "/admin/notice")
public class BackgorundNoticeController extends CommonValidatorMethod<Notice> {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showNotice(Model model) {
        model.addAttribute("noticeList", noticeService.selectAll());
        return "/admin/notice/index";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String showInsert() {
        return "/admin/notice/insert";
    }

    @RequiresPermissions("admin:manager")
    @RequestMapping(value = "/insertSubmit", method = RequestMethod.POST)
    public String insertNoticeSubmit(RedirectAttributes redirectAttributes, HttpServletResponse response, Notice notice) {
        if (!validate(redirectAttributes, notice, "/admin/notice/insert", response)) {
            return null;
        }
        noticeService.insert(notice);
        return "redirect:/admin/notice";
    }

    @RequestMapping(value = "/edit/{noticeId}")
    public String showEdit(@PathVariable int noticeId, Model model) {
        model.addAttribute("notice", noticeService.selectById(new Notice(noticeId)));
        return "/admin/notice/edit";
    }

    @RequiresPermissions("admin:manager")
    @RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
    public String editNoticeSubmit(RedirectAttributes redirectAttributes, HttpServletResponse response, Notice notice) {
        if (!validate(redirectAttributes, notice, "/admin/notice", response)) {
            return null;
        }
        noticeService.update(notice);
        return "redirect:/admin/notice";
    }

    @RequiresPermissions("admin:manager")
    @RequestMapping(value = "/delete/{noticeId}")
    public String deleteNotice(@PathVariable int noticeId) {
        noticeService.delete(noticeId);
        return "redirect:/admin/notice";
    }
}
