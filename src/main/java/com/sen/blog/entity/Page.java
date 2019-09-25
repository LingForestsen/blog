package com.sen.blog.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @Auther: Sen
 * @Date: 2019/9/25 22:27
 * @Description: 页面实体类
 */
@Data
public class Page {
    private int pageId;
    /**
     * 别名
     */
    @Pattern(regexp = "/^[a-zA-Z0-9_-]{2,20}$/", message = "别名格式错误")
    private String pageKey;
    @Length(min = 2, message = "标题长度至少为2")
    private String pageTitle;

    private String pageContent;

    private Date pageCreateTime;

    private Date pageUpdateTime;

    private int pageViewCount;

    private int pageCommentCount;

    /**
     * 状态1显示，状态0隐藏，状态3不可修改
     */
    private int pageStatus;

    public Page() {
    }

    public Page(int pageId) {
        this.pageId = pageId;
    }
}
