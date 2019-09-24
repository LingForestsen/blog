package com.sen.blog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/22 19:21
 * @Description: 文章实体类
 */
@Data
public class Article implements Serializable {
    private static final long serialVersionUID = 8467422043010798159L;

    private int articleId;

    private int articleUserId;

    private String articleTitle;

    private String articleContent;

    private int articleViewCount;

    private int articleCommentCount;

    private int articleLikeCount;
    /**
     * 是否允许评论
     */
    private int articleIsComment;
    /**
     * 文章状态 1 为已发布，0为草稿
     */
    private int articleStatus;

    private int articleOrder;

    private Date articleUpdateTime;

    private Date articleCreateTime;

    private String articleSummary;
    /**
     * 文章分类（非数据库字段）
     */
    private List<Category> categoryList;
    /**
     * 文章标签（非数据库字段）
     */
    private List<Tag> tagList;

}
