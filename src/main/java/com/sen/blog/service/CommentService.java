package com.sen.blog.service;

import com.sen.blog.entity.Comment;

import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/23 01:27
 * @Description:
 */
public interface CommentService {
    /**
     * 查询所有评论
     * @return
     */
    List<Comment> listComment();
}
