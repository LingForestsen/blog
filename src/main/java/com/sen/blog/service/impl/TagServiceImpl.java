package com.sen.blog.service.impl;

import com.sen.blog.dao.TagDao;
import com.sen.blog.entity.Article;
import com.sen.blog.entity.Tag;
import com.sen.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/24 02:03
 * @Description:
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Override
    public List<Tag> selectAll() {
        return tagDao.selectAll();
    }

    @Override
    public List<Tag> selectOneByArticleId(Article article) {
        return tagDao.selectOneByArticleId(article);
    }

    @Override
    public Tag selectById(Tag tag) {
        return tagDao.selectById(tag);
    }

    @Transactional
    @Override
    public void update(Tag tag) {
        tagDao.update(tag);
    }

    @Transactional
    @Override
    public void insert(Tag tag) {
        tagDao.insert(tag);
    }

    @Transactional
    @Override
    public void delete(Tag tag) {
        tagDao.delete(tag);
    }
}
