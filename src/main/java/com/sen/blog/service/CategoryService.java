package com.sen.blog.service;

import com.sen.blog.common.BaseService;
import com.sen.blog.entity.Article;
import com.sen.blog.entity.Category;
import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/24 01:37
 * @Description:
 */
public interface CategoryService extends BaseService<Category> {

    /**
     * 通过文章id查询所有类目
     * @param article
     * @return
     */
    List<Category> selectByArticleId(Article article);

}
