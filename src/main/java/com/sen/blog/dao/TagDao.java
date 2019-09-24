package com.sen.blog.dao;

import com.sen.blog.entity.Tag;

import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/24 01:47
 * @Description:
 */
public interface TagDao {
    /**
     * 查询所有标签并返回对应的文章总数
     * @return
     */
    List<Tag> listTag();
}
