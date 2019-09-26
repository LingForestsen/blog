package com.sen.blog.service.impl;

import com.sen.blog.common.BaseServiceImpl;
import com.sen.blog.dao.OptionsDao;
import com.sen.blog.entity.Options;
import com.sen.blog.service.OptionsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: Sen
 * @Date: 2019/9/27 03:15
 * @Description:
 */
@Service
@Transactional(readOnly = true)
public class OptionsServiceImpl extends BaseServiceImpl<Options, OptionsDao> implements OptionsService {

}
