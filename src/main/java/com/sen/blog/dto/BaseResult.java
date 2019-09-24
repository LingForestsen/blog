package com.sen.blog.dto;

import lombok.Data;

/**
 * @Auther: Sen
 * @Date: 2019/9/24 03:16
 * @Description: 定义返回的结构
 */
@Data
public class BaseResult {

    private static final String SUCCESS_MSG = "操作成功";
    private static final String FAILED_MSG = "操作失败";

    /**
     * 错误码
     * 1 失败，0 成功
     */
    private Integer code;
    /**
     * 返回的信息
     */
    private String msg;
    /**
     * 返回的具体对象
     */
    private Object data;

    public BaseResult() {
    }

    public BaseResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 默认失败方法
     * @return
     */
    public static BaseResult failed() {
        return new BaseResult(1, FAILED_MSG, null);
    }

    /**
     * 默认失败方法
     * @param msg 自定义信息
     * @return
     */
    public static BaseResult failed(String msg) {
        return new BaseResult(1, msg, null);
    }

    /**
     * 成功
     * @return
     */
    public static BaseResult success() {
        return new BaseResult(0, SUCCESS_MSG, null);
    }

    /**
     * 成功
     * @param data 自定义对象
     * @return
     */
    public static BaseResult success(Object data) {
        return new BaseResult(0, SUCCESS_MSG, data);
    }
}
