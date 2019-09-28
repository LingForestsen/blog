package com.sen.blog.service;

import com.github.pagehelper.PageInfo;
import com.sen.blog.common.BaseService;
import com.sen.blog.entity.Article;
import com.sen.blog.entity.Comment;
import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/23 01:27
 * @Description:
 */
public interface CommentService extends BaseService<Comment> {
    /**
     * 查询近期评论
     * @return
     */
    List<Comment> listRecentComment(int pageIndex, int pageSize);


    PageInfo<Comment> selectAllByPage(int pageIndex, int pageSize);

    /**
     * 查找文章的所有评论
     * @param articleId
     * @return
     */
    List<Comment> selectByArticleId(int articleId);

}
