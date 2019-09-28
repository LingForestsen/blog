package com.sen.blog.dao;

import com.sen.blog.common.BaseDao;
import com.sen.blog.entity.Article;
import com.sen.blog.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/23 01:17
 * @Description:
 */
public interface CommentDao extends BaseDao<Comment> {
    /**
     * 查询最近评论
     * 通过id逆序得到
     *
     * @return
     */
    List<Comment> listRecentComment(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    /**
     * 查找文章的所有评论
     * @param articleId
     * @return
     */
    List<Comment> selectByArticleId(int articleId);

    /**
     * 查询文章所有评论
     * @param articleId
     * @return
     */
    int countByArticleId(@Param("articleId") int articleId);
}
