package com.sen.blog.service.impl;

import com.sen.blog.common.BaseServiceImpl;
import com.sen.blog.dao.NoticeDao;
import com.sen.blog.entity.Notice;
import com.sen.blog.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;

/**
 * @Auther: Sen
 * @Date: 2019/9/26 15:08
 * @Description:
 */
@Service
@Transactional(readOnly = true)
public class NoticeServiceImpl extends BaseServiceImpl<Notice, NoticeDao> implements NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    @Transactional
    @Override
    public void update(Notice notice) {
        notice.setNoticeUpdateTime(new Date());
        noticeDao.update(notice);
    }

    @Transactional
    @Override
    public void insert(Notice notice) {
        notice.setNoticeCreateTime(new Date());
        notice.setNoticeUpdateTime(new Date());
        notice.setNoticeStatus(1);
        notice.setNoticeOrder(1);
        noticeDao.insert(notice);
    }
}
