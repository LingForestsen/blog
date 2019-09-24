package com.sen.blog.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @Auther: Sen
 * @Date: 2019/9/24 19:54
 * @Description: 管理文章、标签中间表
 */
public interface ArticleTagRefDao {
    /**
     * 新增
     * @param articleId
     * @param tagId
     */
    void saveArticleTag(@Param("articleId") int articleId, @Param("tagId") int tagId);
}
