package com.sen.blog.constant;

/**
 * @Auther: Sen
 * @Date: 2019/9/28 03:56
 * @Description: 验证字段正则表达式
 */
public class Regx {
    /**
     * 验证邮箱格式
     */
    public static final String CHECK_MAIL ="^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

    /**
     * 验证URL格式
     */
    public static final String CHECK_URL = "(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]";

}
