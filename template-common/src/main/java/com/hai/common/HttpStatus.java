package com.hai.common;

/**
 * @author: Ghai-th
 * @date: 2021/10/31
 **/
public enum HttpStatus {

    /**
     * 操作成功
     */
    SUCCESS(200, "操作成功"),
    /**
     * 发生了 意料之外的错误
     */
    ERROR(500, "系统内部错误"),

    VALIDATED(306,"");


    private final Integer code;
    private final String msg;


    HttpStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }
}
