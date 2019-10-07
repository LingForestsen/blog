package com.sen.blog.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: Sen
 * @Date: 2019/9/25 22:27
 * @Description: 页面实体类
 */
@Data
public class Page implements Serializable {
    private static final long serialVersionUID = 3109121387799744452L;
    private int pageId;
    /**
     * 别名
     */
    @NotNull(message = "别名不能为空")
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
