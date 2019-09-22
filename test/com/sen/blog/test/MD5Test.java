package com.sen.blog.test;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.springframework.util.DigestUtils;

/**
 * @Auther: Sen
 * @Date: 2019/9/20 22:47
 * @Description:
 */
public class MD5Test {
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
}
