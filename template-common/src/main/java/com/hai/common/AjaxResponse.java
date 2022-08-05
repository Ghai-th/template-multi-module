package com.hai.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;


/**
 * @className: AjaxResult
 * @description: 公共返回类 以.add(k,v) 链式添加返回参数默认未根节点下,
 * 以.add(data,hashmap) 添加子
 * 如果需要返回String数据时，需要将String强制转换为Object
 * 如果success(v)v为一个map对象  这时使用.add(v) 会将值添加如map中
 * @author: Ghai-th
 * @date: 2021/10/31
 **/
@Data
public class AjaxResponse {
    private static final String CODE_TAG = "code";

    private static final String MESSAGE_TAG = "msg";

    private static final String DATA_TAG = "data";


    private String message;
    private Integer code;
    private Object data;

    private AjaxResponse() {
    }


    private AjaxResponse(Integer code, String message) {
        this.data = new HashMap<>();
        this.code = code;
        this.message = message;

    }


    /**
     * 默认成功返回
     *
     * @return ajax
     */
    public static AjaxResponse success() {
        return new AjaxResponse(HttpStatus.SUCCESS.getCode(), HttpStatus.SUCCESS.getMsg());
    }

    /**
     * 自定应消息返回
     *
     * @param msg 消息体
     * @return ajax
     */
    public static AjaxResponse success(String msg) {
        return new AjaxResponse(HttpStatus.SUCCESS.getCode(), msg);
    }

    /**
     * 直接返回数据
     *
     * @param data 数据
     * @return 数据
     */
    public static AjaxResponse success(Object data) {
        AjaxResponse ajaxResponse = new AjaxResponse(HttpStatus.SUCCESS.getCode(), HttpStatus.SUCCESS.getMsg());
        ajaxResponse.setData(data);
        return ajaxResponse;
    }


    /**
     * 失败返回
     *
     * @return ajax
     */
    public static AjaxResponse failed() {
        return new AjaxResponse(HttpStatus.ERROR.getCode(), HttpStatus.ERROR.getMsg());
    }

    /**
     * 失败返回带提示
     *
     * @param msg 错误提示
     * @return ajax
     */
    public static AjaxResponse failed(String msg) {
        return new AjaxResponse(HttpStatus.ERROR.getCode(), msg);
    }


    /**
     * 失败返回
     *
     * @param httpStatus 返回相应枚举类
     * @return ajax
     */
    public static AjaxResponse failed(HttpStatus httpStatus) {
        return new AjaxResponse(httpStatus.getCode(), httpStatus.getMsg());
    }

    /**
     * 失败返回
     *
     * @param httpStatus 返回相应枚举类
     * @return ajax
     */
    public static AjaxResponse failed(HttpStatus httpStatus, String message) {
        return new AjaxResponse(httpStatus.getCode(), message);
    }


    public AjaxResponse add(String key, Object value) {
        if (this.data instanceof Map) {
            ((Map<String, Object>) this.data).put(key, value);
        } else {
            throw new RuntimeException("AjaxResult 不要同时使用.add(k,v)方法和success(v)方法");
        }
        return this;
    }

}
