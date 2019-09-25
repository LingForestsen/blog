package com.sen.blog.dao;

import com.sen.blog.common.BaseDao;
import com.sen.blog.entity.Article;
import com.sen.blog.entity.Tag;
import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/24 01:47
 * @Description:
 */
public interface TagDao extends BaseDao<Tag> {

    /**
     * 通过文章id关联查询对应的标签
     * @param article
     * @return
     */
    List<Tag> selectOneByArticleId(Article article);
}
