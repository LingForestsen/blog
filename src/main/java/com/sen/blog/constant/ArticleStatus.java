package com.sen.blog.constant;

/**
 * @Auther: Sen
 * @Date: 2019/9/23 03:21
 * @Description: 文章状态
 */
public enum ArticleStatus {

    PUBLIS(1,"已发布"),
    DRAFT(0,"草稿");

    private int value;
    private String desc;

    ArticleStatus(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
