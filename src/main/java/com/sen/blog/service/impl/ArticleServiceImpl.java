package com.sen.blog.service.impl;

import cn.hutool.http.HtmlUtil;
import com.github.pagehelper.PageInfo;
import com.sen.blog.common.BaseServiceImpl;
import com.sen.blog.dao.ArticleCategoryRefDao;
import com.sen.blog.dao.ArticleDao;
import com.sen.blog.dao.ArticleTagRefDao;
import com.sen.blog.dto.ArticleDto;
import com.sen.blog.entity.Article;
import com.sen.blog.entity.User;
import com.sen.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/22 19:48
 * @Description:
 */
@Service
@Transactional(readOnly = true)
public class ArticleServiceImpl extends BaseServiceImpl<Article, ArticleDao> implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private ArticleCategoryRefDao articleCategoryRefDao;

    @Autowired
    private ArticleTagRefDao articleTagRefDao;

    @Override
    public PageInfo<Article> listArticleAndCategory(int pageIndex, int pageSize) {

        //编辑用于分页的起始索引
        int pageStart = pageSize * (pageIndex - 1);
        List<Article> articles = articleDao.listArticleAndCategory();
        //TODO 更好的解决方案
        //查询文章总数（因为使用limit导致分页数据错误）
        int count = articleDao.count();
        //总页数
        int pages = (count + pageSize - 1) / pageSize;

        List<Article> targetArticle = null;
        // 不是最后一页时
        if (pageIndex <= pages - 1) {
            targetArticle = articles.subList(pageStart, pageStart + pageSize);
        }
        //是最后一页时
        else {
            targetArticle = articles.subList(pageStart, count);
        }
        PageInfo<Article> pageInfo = new PageInfo<>(targetArticle);
        pageInfo.setTotal(count);
        pageInfo.setPages(pages);
        pageInfo.setPageNum(pageIndex);
        return pageInfo;
    }

    @Transactional(readOnly = false)
    @Override
    public void saveArticle(ArticleDto articleDto, User user) {
        Article article = commonSaveArticle(articleDto, user);
        article.setArticleCreateTime(new Date());
        articleDao.insert(article);
        //保存文章-分类中间表
        int articleId = article.getArticleId();
        List<Integer> categorylist = articleDto.getArticleCategoryIds();
        for (int i = 0; i < categorylist.size(); i++) {
            Integer categoryId = categorylist.get(i);
            articleCategoryRefDao.saveArticleCategory(articleId, categoryId);
        }

        //保存文章-标签中间表
        List<Integer> tagIds = articleDto.getArticleTagIds();
        if (tagIds != null && tagIds.size() > 0) {
            for (int i = 0; i < tagIds.size(); i++) {
                Integer tagId = tagIds.get(i);
                articleTagRefDao.saveArticleTag(articleId, tagId);
            }
        }
    }

    @Transactional(readOnly = false)
    @Override
    public void saveArticleDraft(ArticleDto articleDto, User user) {
        Article article = commonSaveArticle(articleDto, user);
        articleDao.insert(article);
    }

    @Transactional(readOnly = false)
    @Override
    public void updateArticle(ArticleDto articleDto, User user) {
        Article article = commonSaveArticle(articleDto, user);
        article.setArticleOrder(articleDto.getArticleOrder());
        article.setArticleCreateTime(articleDto.getArticleCreateTime());
        article.setArticleId(articleDto.getArticleId());
        articleDao.update(article);

        //保存文章-分类中间表
        List<Integer> categorylist = articleDto.getArticleCategoryIds();
        if (categorylist != null && categorylist.size() > 0) {
            articleCategoryRefDao.deleteArticleCategory(articleDto.getArticleId());
            for (int i = 0; i < categorylist.size(); i++) {
                Integer categoryId = categorylist.get(i);
                articleCategoryRefDao.saveArticleCategory(articleDto.getArticleId(), categoryId);
            }
        }

        //保存文章-标签中间表
        List<Integer> tagIds = articleDto.getArticleTagIds();
        if (tagIds != null && tagIds.size() > 0) {
            articleTagRefDao.deleteArticleTag(articleDto.getArticleId());
            for (int i = 0; i < tagIds.size(); i++) {
                Integer tagId = tagIds.get(i);
                articleTagRefDao.saveArticleTag(articleDto.getArticleId(), tagId);
            }
        }
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(int id) {
        articleDao.delete(id);
        Article article = new Article(id);
        articleCategoryRefDao.deleteArticleCategory(article.getArticleId());
        articleTagRefDao.deleteArticleTag(article.getArticleId());
    }

    /**
     * 设置文章通用方法
     *
     * @param articleDto
     * @param user
     * @return
     */
    private Article commonSaveArticle(ArticleDto articleDto, User user) {
        Article article = new Article();
        article.setArticleUserId(user.getUserId());
        article.setArticleTitle(articleDto.getArticleTitle());
        article.setArticleContent(articleDto.getArticleContent());
        article.setArticleViewCount(1);
        article.setArticleCommentCount(0);
        article.setArticleLikeCount(0);
        article.setArticleIsComment(1);
        article.setArticleStatus(articleDto.getArticleStatus());
        article.setArticleOrder(1);
        article.setArticleUpdateTime(new Date());
        //去掉contentHTML标签
        String summary = HtmlUtil.cleanHtmlTag(articleDto.getArticleContent());
        //设置summary的长度
        int lengthSummary = 150;
        if (summary.length() > 150) {
            article.setArticleSummary(summary.substring(0, lengthSummary - 1));
        } else {
            article.setArticleSummary(summary);
        }
        return article;
    }

}
