package com.sen.blog.interception;

import com.sen.blog.entity.Options;
import com.sen.blog.service.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/29 03:23
 * @Description: 后台资源拦截器
 */
public class BackgroundInterception implements HandlerInterceptor {
    @Autowired
    private OptionsService optionsService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //网站基本信息
        List<Options> options = optionsService.selectAll();
        request.setAttribute("options", options.get(0));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
