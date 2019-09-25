package com.sen.blog.service.impl;

import com.sen.blog.dao.PageDao;
import com.sen.blog.entity.Page;
import com.sen.blog.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/25 23:00
 * @Description:
 */
@Service
@Transactional(readOnly = true)
public class PageServiceImpl implements PageService {

    @Autowired
    private PageDao pageDao;

    @Override
    public List<Page> selectAll() {
        return pageDao.selectAll();
    }

    @Override
    public Page selectById(Page page) {
        return pageDao.selectById(page);
    }

    @Transactional
    @Override
    public void update(Page page) {
        Page pageSelect = pageDao.selectById(page);
        pageSelect.setPageUpdateTime(new Date());
        pageDao.update(page);
    }

    @Transactional
    @Override
    public void insert(Page page) {
        page.setPageViewCount(0);
        page.setPageCommentCount(0);
        page.setPageStatus(1);
        page.setPageCreateTime(new Date());
        page.setPageUpdateTime(new Date());
        pageDao.insert(page);
    }

    @Transactional
    @Override
    public void delete(Page page) {
        pageDao.delete(page);
    }
}
