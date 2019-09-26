package com.sen.blog.controller.admin;

import com.sen.blog.common.CommonValidatorMethod;
import com.sen.blog.entity.User;
import com.sen.blog.service.UserService;
import com.sen.blog.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Sen
 * @Date: 2019/9/20 19:20
 * @Description: 用户控制
 */
@Controller
@RequestMapping(value = "/admin/user")
public class BackgroundUserController extends CommonValidatorMethod<User> {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String showUser(Model model) {
        model.addAttribute("userList", userService.selectAll());
        return "/admin/user/index";
    }

    @RequestMapping(value = "/edit/{userId}")
    public String showEdit(@PathVariable int userId, Model model) {
        model.addAttribute("user",userService.selectById(new User(userId)));
        return "/admin/user/edit";
    }

    /**
     * Ajax检查用户名是否重复
     * @param checkUser
     * @return
     */
    @RequestMapping(value = "/checkUserName", method = RequestMethod.POST)
    @ResponseBody
    public String checkUserName(User checkUser) {
        User user = userService.login(checkUser.getUserName());
        Map<String,Object> map = new HashMap<>();
        //前端输入的用户名存在
        if (user != null) {
            //不是当前登录的用户
            if (user.getUserId() != checkUser.getUserId()) {
                map.put("code", 1);
                map.put("msg", "用户名已存在");
            }
        }
        //输入用户名数据库不存在
        else {
            map.put("code", 0);
            map.put("msg", "");
        }
        String json = MapperUtils.mapToJson(map);
        return json;
    }

    /**
     * 检查邮箱是否重复
     * @param checkUser
     * @return
     */
    @RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
    @ResponseBody
    public String checkEmail(User checkUser) {
        Map<String,Object> map = new HashMap<>();
        User user = userService.selectByEmail(checkUser);
        //邮箱已存在
        if (user != null) {
            //不是当前用户的邮箱
            if (user.getUserId() != checkUser.getUserId()) {
                map.put("code", 1);
                map.put("msg", "邮箱已存在");
            }
        }
        //邮箱不存在
        else {
            map.put("coke", 0);
            map.put("msg", "");
        }
        String json = MapperUtils.mapToJson(map);
        return json;
    }

    @RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
    public String editSubmit(User user, Model model, HttpServletResponse response) {
        if (!validate(model, user, "/admin/user", response)) {
            return null;
        }
        userService.update(user);
        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
    public String delete(@PathVariable int userId) {
        userService.delete(userId);
        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String showInsert() {
        return "/admin/user/insert";
    }

    @RequestMapping(value = "/insertSubmit", method = RequestMethod.POST)
    public String insertSubmit(User user, Model model, HttpServletResponse response) {
        if (!validate(model, user, "/admin/user/insert", response)) {
            return null;
        }
        userService.insert(user);
        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/profile/{userId}",method = RequestMethod.GET)
    public String showProfile(@PathVariable int userId, Model model) {
        model.addAttribute("user", userService.selectById(new User(userId)));
        return "/admin/user/profile";
    }
}
