package com.sen.blog.service.impl;

import com.sen.blog.common.BaseServiceImpl;
import com.sen.blog.dao.MenuDao;
import com.sen.blog.entity.Menu;
import com.sen.blog.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: Sen
 * @Date: 2019/9/27 01:46
 * @Description:
 */
@Service
@Transactional(readOnly = true)
public class MenuServiceImpl extends BaseServiceImpl<Menu, MenuDao> implements MenuService {
}
