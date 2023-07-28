package com.zdinit.icecream.common;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
@Slf4j
public class BaseResponse<T> implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     200    请求成功             201   创建成功             202    更新成功

     400    无效请求             401  地址不存在

     403    禁止访问             404  请求资源不存在

     500    内部错误
     */

    public static final Integer SUCCESS_CODE = 200;
    public static final String SUCCESS_MSG = "请求成功！";

    public static final Integer FALSE_CODE = 400;
    public static final String FALSE_MSG = "无效请求！";

    public static final Integer ERROR_CODE = 500;
    public static final String ERROR_MSG = "内部错误！";

    private Integer code;
    private String msg;
    /*** 返回数据*/
    private T data;

    public BaseResponse() {

    }

    public BaseResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
