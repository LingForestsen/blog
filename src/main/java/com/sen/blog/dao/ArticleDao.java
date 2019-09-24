package com.sen.blog.dao;

import com.sen.blog.entity.Article;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Sen
 * @Date: 2019/9/22 19:35
 * @Description:
 */
public interface ArticleDao {
    /**
     * 查询所有的文章
     * @return
     */
    List<Article> listArticle();

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
}
