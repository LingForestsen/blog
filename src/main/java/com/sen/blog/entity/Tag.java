package com.sen.blog.entity;

import lombok.Data;
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

    private String tagName;

    private String tagDescription;
    /**
     * 标签对应的文章数量（非数据库字段）
     */
    private int articleCount;
}
