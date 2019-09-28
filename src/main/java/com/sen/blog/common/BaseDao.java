package com.sen.blog.common;

import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/26 00:30
 * @Description: 通用的Mapper
 */
public interface BaseDao<T> {
    /**
     * 查询所有
     * @return
     */
    List<T> selectAll();

    /**
     * 通过id查找
     * @param t
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

    /**
     * 查询文章总数
     * @return
     */
    int count();
}
