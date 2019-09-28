package com.sen.blog.constant;

/**
 * @Auther: Sen
 * @Date: 2019/9/29 01:28
 * @Description: 链接的状态
 */
public enum LinkStatus {

    PUBLIS(1,"显示"),

    HIDE(0,"隐藏");

    private int value;
    private String description;

    LinkStatus(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
