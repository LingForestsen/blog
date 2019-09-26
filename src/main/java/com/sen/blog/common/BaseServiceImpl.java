package com.sen.blog.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/26 14:26
 * @Description: 通用的ServiceImpl
 */
public abstract class BaseServiceImpl<T,D extends BaseDao> implements BaseService<T>{

    @Autowired
    private  D dao;

    @Override
    public List<T> selectAll() {
        return dao.selectAll();
    }

    @Override
    public T selectById(T t) {
        return (T) dao.selectById(t);
    }

    @Transactional
    @Override
    public void update(T t) {
        dao.update(t);
    }

    @Transactional
    @Override
    public void insert(T t) {
        dao.insert(t);
    }

    @Transactional
    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}
