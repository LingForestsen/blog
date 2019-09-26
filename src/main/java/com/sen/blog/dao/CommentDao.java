package com.sen.blog.dao;

import com.sen.blog.common.BaseDao;
import com.sen.blog.entity.Comment;

import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/23 01:17
 * @Description:
 */
public interface CommentDao extends BaseDao<Comment> {
    /**
     * 查询所有评论
     * 通过id逆序得到
     * @return
     */
    List<Comment> listRecentComment();
}
