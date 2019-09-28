package com.sen.blog.service;

import com.sen.blog.common.BaseService;
import com.sen.blog.entity.Page;

/**
 * @Auther: Sen
 * @Date: 2019/9/25 22:59
 * @Description:
 */
public interface PageService extends BaseService<Page> {
    /**
     * 通过页面key查询
     * @param key
     * @return
     */
    Page selectByKey(String key);
}
