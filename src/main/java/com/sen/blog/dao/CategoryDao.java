package com.sen.blog.dao;

import com.sen.blog.common.BaseDao;
import com.sen.blog.entity.Article;
import com.sen.blog.entity.Category;
import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/24 01:28
 * @Description:
 */
public interface CategoryDao extends BaseDao<Category> {

    /**
     * 通过文章id查询所有类目
     * @param article
     * @return
     */
    List<Category> selectByArticleId(Article article);

}
