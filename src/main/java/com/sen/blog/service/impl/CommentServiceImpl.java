package com.sen.blog.service.impl;

import com.sen.blog.dao.CommentDao;
import com.sen.blog.entity.Comment;
import com.sen.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/23 01:28
 * @Description:
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;
    @Override
    public List<Comment> listComment() {
        return commentDao.listRecentComment();
    }
}
