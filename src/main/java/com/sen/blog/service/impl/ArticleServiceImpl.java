package com.sen.blog.service.impl;

import com.github.pagehelper.PageInfo;
import com.sen.blog.dao.ArticleDao;
import com.sen.blog.entity.Article;
import com.sen.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/22 19:48
 * @Description:
 */
@Service
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    ArticleDao articleDao;

    @Override
    public List<Article> listArticle() {
        return articleDao.listArticle();
    }

    @Override
    public PageInfo<Article> listArticleAndCategory(int pageIndex, int pageSize) {

         //编辑用于分页的起始索引
        int pageStart = pageSize * (pageIndex - 1);
        List<Article> articles = articleDao.listArticleAndCategory();
        //TO DO
        //查询文章总数（因为使用limit导致分页数据错误）
        int count = articleDao.count();
        //总页数
        int pages = (count + pageSize -1)/pageSize;

        List<Article> targetArticle = null;
        // 不是最后一页时
        if (pageIndex <= pages - 1) {
            targetArticle = articles.subList(pageStart, pageStart + pageSize);
        }
        //是最后一页时
        else {
            targetArticle = articles.subList(pageStart, count - 1);
        }
        PageInfo<Article> pageInfo = new PageInfo<>(targetArticle);
        pageInfo.setTotal(count);
        pageInfo.setPages(pages);
        pageInfo.setPageNum(pageIndex);
        return pageInfo;
    }
}
