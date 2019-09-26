package com.sen.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sen.blog.common.BaseServiceImpl;
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
public class CommentServiceImpl extends BaseServiceImpl<Comment, CommentDao> implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public List<Comment> listComment() {
        return commentDao.listRecentComment();
    }

    @Override
    public PageInfo<Comment> selectAllByPage(int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<Comment> comments = commentDao.selectAll();
        return new PageInfo<>(comments);
    }

}
