package com.sen.blog.controller.home;

import com.sen.blog.common.CommonValidatorMethod;
import com.sen.blog.entity.Comment;
import com.sen.blog.service.CommentService;
import com.sen.blog.utils.IpUtils;
import com.sen.blog.utils.MapperUtils;
import org.apache.regexp.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;

/**
 * @Auther: Sen
 * @Date: 2019/9/28 03:47
 * @Description:
 */
@Controller
public class CommentController extends CommonValidatorMethod<Comment> {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "comment", method = RequestMethod.POST)
    @ResponseBody
    public String commitComment(Model model, Comment comment, HttpServletResponse response, HttpServletRequest request) {
        comment.setCommentIp(IpUtils.getIpAddr(request));
        comment.setCommentCreateTime(new Date());
        HashMap<String, Object> map = new HashMap<>();
        if (validate(model, comment, null, response)) {
            map.put("code", 1);
            map.put("msg", "发生位置错误");
            return null;
        }
        commentService.insert(comment);
        map.put("code", 0);
        return MapperUtils.mapToJson(map);
    }
}
