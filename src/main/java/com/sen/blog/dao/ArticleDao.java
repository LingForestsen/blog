package com.sen.blog.dao;

import com.sen.blog.common.BaseDao;
import com.sen.blog.entity.Article;
import org.apache.ibatis.annotations.Param;
import org.checkerframework.checker.units.qual.A;

import java.util.HashMap;
import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/22 19:35
 * @Description:
 */
public interface ArticleDao extends BaseDao<Article> {

    /**
     * 查询文章和对应的分类名称
     *
     * @return
     */
    List<Article> listArticleAndCategory(HashMap<String, Object> criteria);


    /**
     * 查询没用用户的文章总数
     * @return
     */
    int countByUserId(int userId);

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
    List<Article> listByCategoryIds(@Param("categoryIds") List<Integer> categoryIds);

    /**
     * 查询评论数较多的文章（猜你喜欢）
     * @return
     */
    List<Article> listMostViewCountArticle(@Param("pageSize") int pageSize);

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

    /**
     * 查询总条数
     * @param criteria 查询条件
     * @return
     */
    int countByCriteria(HashMap<String,Object> criteria);

    /**
     * 查找一个标签下的所有文章
     * @param tagId
     * @return
     */
    List<Article> listArticlesByTagId(int tagId);

    /**
     * 查找一个分类下的所有文章
     * @param categoryId
     * @return
     */
    List<Article> listArticlesByCategoryId(int categoryId);
}
