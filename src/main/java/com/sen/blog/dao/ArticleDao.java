package com.sen.blog.dao;

import com.sen.blog.common.BaseDao;
import com.sen.blog.entity.Article;
import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/22 19:35
 * @Description:
 */
public interface ArticleDao extends BaseDao<Article> {

    /**
     * 查询文章和对应的分类名称
     *
     * @return
     */
    List<Article> listArticleAndCategory();

    /**
     * 查询文章总数
     * @return
     */
    int count();

    /**
     * 查询没用用户的文章总数
     * @return
     */
    int countByUserId(int userId);

}
