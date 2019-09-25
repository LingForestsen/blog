package com.sen.blog.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @Auther: Sen
 * @Date: 2019/9/24 20:00
 * @Description: 管理文章、文章分类中间表
 */
public interface ArticleCategoryRefDao {

    void saveArticleCategory(@Param("articleId") int articleId, @Param("categoryId") int categoryId);

    void updateArticleCategory(@Param("articleId") int articleId, @Param("categoryId") int categoryId);

    void deleteArticleCategory(@Param("articleId") int articleId);
}
