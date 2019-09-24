package com.sen.blog.test;

import com.sen.blog.entity.Article;
import com.sen.blog.service.ArticleService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/20 22:47
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context*")
public class MD5Test {
    @Autowired
    private ArticleService articleService;

    @Test
    public void getEncodePass() {
        //e10adc3949ba59abbe56e057f20f883e
        //e10adc3949ba59abbe56e057f20f883e
        // System.out.println(MD5Utils.strToMd5("123456"));
        System.out.println(DigestUtils.md5DigestAsHex("123456".getBytes()));
    }
    @Test
    public void md5Test() {
        Md5Hash md5 = new Md5Hash("123456", "sxt", 2);
        System.out.println(md5.toString());
    }
    @Test
    public void listArticleAndCategoryTest() {
        articleService.listArticleAndCategory(1,10);
    }
}
