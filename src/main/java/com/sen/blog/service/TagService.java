package com.sen.blog.service;

import com.sen.blog.entity.Tag;

import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/24 02:02
 * @Description:
 */
public interface TagService {

    /**
     * 查询所有标签并返回对应的文章数量
     * @return
     */
    List<Tag> listTag();
}
