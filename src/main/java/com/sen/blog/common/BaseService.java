package com.sen.blog.common;

import java.util.List;
/**
 * @Auther: Sen
 * @Date: 2019/9/26 00:34
 * @Description: 通用service
 */
public interface BaseService<T> {
    /**
     * 查询所有
     * @return
     */
    List<T> selectAll();

    /**
     * 通过id查找
     * @return
     */
    T selectById(T t);

    /**
     * 更新
     * @param t
     */
    void update(T t);

    /**
     * 插入
     * @param t
     */
    void insert(T t);

    /**
     * 删除
     * @param id
     */
    void delete(int id);
}
