package com.sen.blog.service;

import com.github.pagehelper.PageInfo;
import com.sen.blog.common.BaseService;
import com.sen.blog.dto.ArticleDto;
import com.sen.blog.entity.Article;
import com.sen.blog.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/22 19:47
 * @Description:
 */
public interface ArticleService extends BaseService<Article> {

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

    /**
     * 查询文章总阅读数
     * @return
     */
    int sumView();

    /**
     * 查询文章总评论数
     * @return
     */
    int sumComment();

    /**
     * 查询文章状态为1 的文章总数
     * @return
     */
    int countArticle();

    /**
     * 通过分类id查找详细的文章
     * @return
     */
    List<Article> listByCategoryIds(List<Integer> categoryIds);

    /**
     * 查询评论数较多的文章（猜你喜欢）
     * @return
     */
    List<Article> listMostViewCountArticle(int pageSize);

    /**
     * 获取后一篇文章
     * @param ArticleId
     * @return
     */
    Article selectAfterArticle(int ArticleId);

    /**
     * 获取前一篇文章
     * @param ArticleId
     * @return
     */
    Article selectBeforeArticle(int ArticleId);

    /**
     * 获取随机的文章集合
     * @param pageSize
     * @return
     */
    List<Article> listRandArticle(@Param("pageSize") int pageSize);

    /**
     * 获取热评文章
     * @param pageSize
     * @return
     */
    List<Article> listMostCommentArticle(@Param("pageSize") int pageSize);
}
