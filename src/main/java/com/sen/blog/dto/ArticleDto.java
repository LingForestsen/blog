package com.sen.blog.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/9/24 21:46
 * @Description: 用于新增文章接收参数
 */
@Data
public class ArticleDto {

    private int articleId;

    @Length(min = 5 , max = 20, message = "文章标题长度为5-20")
    private String articleTitle;
    @Length(min = 1, message = "文章长度至少为1")
    private String articleContent;

    private int articleViewCount;

    private int articleIsComment;
    @NotNull
    private int articleStatus;

    private int articleOrder;

    private Date articleUpdateTime;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date articleCreateTime;

    private String articleSummary;
    /**
     * 接收类目ID
     */
    private List<Integer> articleCategoryIds;
    /**
     * 接收标签ID
     */
    private List<Integer> articleTagIds;
}
