package com.sen.blog.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Auther: Sen
 * @Date: 2019/9/24 01:44
 * @Description: 文章标签
 */
@Data
public class Tag implements Serializable {
    private static final long serialVersionUID = 999154364946298828L;

    private int tagId;

    @NotNull(message = "标签名不能为空")
    private String tagName;

    private String tagDescription;
    /**
     * 标签对应的文章数量（非数据库字段）
     */
    private int articleCount;

    public Tag() {
    }

    public Tag(int tagId) {
        this.tagId = tagId;
    }
}
