package com.sen.blog.dao;

import com.sen.blog.entity.Category;

import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/24 01:28
 * @Description:
 */
public interface CategoryDao {
    /**
     *  查询所有的文章分类及对应的文章总数
     * @return
     */
    List<Category> listCategory();
}
