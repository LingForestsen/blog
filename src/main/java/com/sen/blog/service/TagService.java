package com.sen.blog.service;

import com.sen.blog.common.BaseServie;
import com.sen.blog.entity.Article;
import com.sen.blog.entity.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/24 02:02
 * @Description:
 */
public interface TagService extends BaseServie<Tag> {

    /**
     * 通过文章id关联查询对应的标签
     * @param article
     * @return
     */
    List<Tag> selectOneByArticleId(Article article);


}
