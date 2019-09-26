package com.sen.blog.service.impl;

import cn.hutool.core.date.DateTime;
import com.sen.blog.common.BaseServiceImpl;
import com.sen.blog.dao.LinkDao;
import com.sen.blog.entity.Link;
import com.sen.blog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/26 11:32
 * @Description:
 */
@Service
@Transactional(readOnly = true)
public class LinkServiceImpl extends BaseServiceImpl<Link, LinkDao> implements LinkService {

    @Autowired
    private LinkDao linkDao;

    @Override
    public List<Link> selectAll() {
        return linkDao.selectAll();
    }

    @Transactional
    @Override
    public void update(Link link) {
        link.setLinkUpdateTime(new Date());
        linkDao.update(link);
    }

    @Transactional
    @Override
    public void insert(Link link) {
        link.setLinkCreateTime(new Date());
        link.setLinkUpdateTime(new DateTime());
        link.setLinkStatus(1);
        linkDao.insert(link);
    }

}
