package com.sen.blog.controller.home;

import com.sen.blog.entity.Notice;
import com.sen.blog.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: Sen
 * @Date: 2019/9/29 02:23
 * @Description:
 */
@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "/notice/{noticeId}", method = RequestMethod.GET)
    public String showNoticeDetail(@PathVariable int noticeId, Model model) {
        model.addAttribute("notice", noticeService.selectById(new Notice(noticeId)));
        return "/home/page/noticeDetail";
    }
}
