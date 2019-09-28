package com.sen.blog.controller.home;

import com.sen.blog.constant.LinkStatus;
import com.sen.blog.entity.Link;
import com.sen.blog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * @Auther: Sen
 * @Date: 2019/9/29 01:12
 * @Description:
 */
@Controller
public class LinkController {

    @Autowired
    private LinkService linkService;

    @RequestMapping(value = "/applyLink",method = RequestMethod.GET)
    public String showApplyLink() {
        return "/home/page/applyLink";
    }

    @RequestMapping(value = "/applyLinkSubmit", method = RequestMethod.POST)
    public void applyLinkSubmit(Link link) {
        link.setLinkStatus(LinkStatus.HIDE.getValue());
        link.setLinkCreateTime(new Date());
        link.setLinkUpdateTime(new Date());
        linkService.insert(link);
    }
}
