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
    public static final String CHECK_MAIL ="\\w+(\\.\\w)*@\\w+(\\.\\w{2,3}){1,3}";
    /**
     * 验证URL格式
     */
    public static final String CHECK_URL = "(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]";

}
