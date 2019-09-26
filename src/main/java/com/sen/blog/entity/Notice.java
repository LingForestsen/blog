package com.sen.blog.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: Sen
 * @Date: 2019/9/26 14:22
 * @Description: 公告
 */
@Data
public class Notice implements Serializable {

    private static final long serialVersionUID = -2938756888507153071L;
    private int noticeId;

    @Length(min = 5, message = "公告标题长度至少为5")
    private String noticeTitle;

    @NotNull(message = "公告内容不能为空")
    private String noticeContent;

    private Date noticeCreateTime;

    private Date noticeUpdateTime;

    private int noticeStatus;

    private int noticeOrder;

    public Notice() {
    }

    public Notice(int noticeId) {
        this.noticeId = noticeId;
    }
}
