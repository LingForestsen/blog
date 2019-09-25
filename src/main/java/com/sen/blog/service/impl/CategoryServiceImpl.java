package com.sen.blog.service.impl;

import com.sen.blog.dao.CategoryDao;
import com.sen.blog.entity.Article;
import com.sen.blog.entity.Category;
import com.sen.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/24 01:38
 * @Description:
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> selectAll() {
        return categoryDao.selectAll();
    }

    @Override
    public List<Category> selectByArticleId(Article article) {
        return categoryDao.selectByArticleId(article);
    }

    @Override
    public void insert(Category category) {
        categoryDao.insert(category);
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(Category category) {
        categoryDao.delete(category);
    }

    @Override
    public Category selectById(Category category) {
        return categoryDao.selectById(category);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(Category category) {
        categoryDao.update(category);
    }
}
