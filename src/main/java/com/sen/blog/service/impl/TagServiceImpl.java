package com.sen.blog.service.impl;

import com.sen.blog.common.BaseServiceImpl;
import com.sen.blog.dao.TagDao;
import com.sen.blog.entity.Article;
import com.sen.blog.entity.Tag;
import com.sen.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/24 02:03
 * @Description:
 */
@Service
public class TagServiceImpl extends BaseServiceImpl<Tag, TagDao> implements TagService {

    @Autowired
    private TagDao tagDao;

    @Override
    public List<Tag> selectOneByArticleId(Article article) {
        return tagDao.selectOneByArticleId(article);
    }

}
