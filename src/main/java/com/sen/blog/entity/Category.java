package com.sen.blog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: Sen
 * @Date: 2019/9/23 03:54
 * @Description:
 */
@Data
public class Category implements Serializable {
    private static final long serialVersionUID = -3795551710709166825L;
    private int categoryId;

    private int categoryPid;

    private String categoryName;

    private String categoryDescription;

    private int categoryOrder;

    private String categoryIcon;
    /**
     * 每个类目对应的文章数量（非数据库字段）
     */
    private int articleCount;
}
