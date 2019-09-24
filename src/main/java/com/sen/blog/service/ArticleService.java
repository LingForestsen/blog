package com.sen.blog.service;

import com.github.pagehelper.PageInfo;
import com.sen.blog.entity.Article;

import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/22 19:47
 * @Description:
 */
public interface ArticleService {
    /**
     * 查询最近发布的5篇文章
     * @return
     */
    List<Article> listArticle();

    /**
     * 查询所有的文章和对用的分类名称
     * @param pageIndex 起始页
     * @param pageSize 每页多少条
     * @return
     */
    PageInfo<Article> listArticleAndCategory(int pageIndex, int pageSize);
}
