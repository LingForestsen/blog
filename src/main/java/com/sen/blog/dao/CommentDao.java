package com.sen.blog.dao;

import com.sen.blog.entity.Comment;

import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/23 01:17
 * @Description:
 */
public interface CommentDao {
    /**
     * 查询所有评论
     * @return
     */
    List<Comment> listRecentComment();
}
