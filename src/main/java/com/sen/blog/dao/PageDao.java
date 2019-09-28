package com.sen.blog.dao;

import com.sen.blog.common.BaseDao;
import com.sen.blog.entity.Page;

/**
 * @Auther: Sen
 * @Date: 2019/9/25 22:33
 * @Description: 页面
 */
public interface PageDao extends BaseDao<Page> {

    /**
     * 通过页面key查询
     * @param key
     * @return
     */
    Page selectByKey(String key);
}
