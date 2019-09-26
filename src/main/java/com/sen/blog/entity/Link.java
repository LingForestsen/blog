package com.sen.blog.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: Sen
 * @Date: 2019/9/26 03:50
 * @Description: 连接
 */
@Data
public class Link implements Serializable {

    private static final long serialVersionUID = -2591649158562162677L;

    private int linkId;

    @NotNull(message = "url不能为空")
    private String linkUrl;

    @NotNull(message = "linkName不能为空")
    private String linkName;

    private String linkImage;

    private String linkDescription;

    private String linkOwnerNickname;
    /**
     * 联系方式
     */
    private String linkOwnerContact;

    private Date linkUpdateTime;

    private Date linkCreateTime;

    private int linkOrder;
    /**
     * 1 显示，非1 隐藏
     */
    private int linkStatus;

    public Link() {
    }

    public Link(int linkId) {
        this.linkId = linkId;
    }
}
