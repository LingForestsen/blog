package com.sen.blog.service;

import com.github.pagehelper.PageInfo;
import com.sen.blog.common.BaseServie;
import com.sen.blog.dto.ArticleDto;
import com.sen.blog.entity.Article;
import com.sen.blog.entity.User;

import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/22 19:47
 * @Description:
 */
public interface ArticleService extends BaseServie<Article> {

    /**
     * 查询所有的文章和对用的分类名称
     * @param pageIndex 起始页
     * @param pageSize 每页多少条
     * @return
     */
    PageInfo<Article> listArticleAndCategory(int pageIndex, int pageSize);

    /**
     * 新增文章
     * @param articleDto
     */
    void saveArticle(ArticleDto articleDto, User user);

    /**
     * 保存草稿
     * @param articleDto
     */
    void saveArticleDraft(ArticleDto articleDto,User user);

    void updateArticle(ArticleDto articleDto, User user);

}
