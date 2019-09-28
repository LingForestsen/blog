package com.sen.blog.interception;

import com.sen.blog.entity.Options;
import com.sen.blog.entity.Tag;
import com.sen.blog.service.CategoryService;
import com.sen.blog.service.MenuService;
import com.sen.blog.service.OptionsService;
import com.sen.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/27 19:20
 * @Description: 首页通用资源拦截器（提供数据）
 */
public class HomeResourcesInterception implements HandlerInterceptor {

    @Autowired
    private MenuService menuService;

    @Autowired
    private OptionsService optionsService;

    @Autowired
    private TagService tagService;

    @Autowired
    private CategoryService categoryService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //顶部主菜单
        httpServletRequest.setAttribute("menuList", menuService.selectAll());
        //面包屑
        List<Options> options = optionsService.selectAll();
        httpServletRequest.setAttribute("options", options.get(0));
        //顶部分类菜单
        httpServletRequest.setAttribute("allCategoryList", categoryService.selectAll());
        //所有标签
        List<Tag> tags = tagService.selectAll();
        httpServletRequest.setAttribute("allTagList", tags);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
