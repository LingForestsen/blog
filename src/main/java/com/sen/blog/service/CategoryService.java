package com.sen.blog.service;

import com.sen.blog.entity.Category;

import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/24 01:37
 * @Description:
 */
public interface CategoryService {
    /**
     * 查询所有的文章类与及对应分类的文章总数
     * @return
     */
    List<Category> listCategory();
}
