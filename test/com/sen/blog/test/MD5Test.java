package com.sen.blog.test;

import com.sen.blog.service.ArticleService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;

/**
 * @Auther: Sen
 * @Date: 2019/9/20 22:47
 * @Description:
 */
// @RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration("classpath:spring-context*")
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
        articleService.listArticleAndCategory(1, 10, null);
    }

    @Test
    public void getGravatar() {
        String emailMd5 = DigestUtils.md5DigestAsHex("pizzaling@outlook.com".getBytes());
        //设置图片大小32px
        String avatar = "http://cn.gravatar.com/avatar/" + emailMd5 + "?s=128&d=identicon&r=PG";
        System.out.println(avatar);
    }

    @Test
    public void logTest() {
        final Logger logger = LoggerFactory.getLogger(MD5Test.class);
        logger.info("hello logger");
    }
}
