package com.zdinit.icecream.common.utils;

import com.zdinit.icecream.common.BaseResponse;

public class ResponseUtil {
    public static BaseResponse sucess(Object object){
        BaseResponse baseResponse= new BaseResponse();
        baseResponse.setCode(BaseResponse.SUCCESS_CODE);
        baseResponse.setMsg(BaseResponse.SUCCESS_MSG);
        baseResponse.setData(object);
        return baseResponse;
    }

    public static BaseResponse sucess(){
        return sucess(null);
    }

    public static BaseResponse error(Integer code,String msg){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(code);
        baseResponse.setMsg(msg);
        return baseResponse;
    }

    public static BaseResponse error(){
        return error(BaseResponse.ERROR_CODE,BaseResponse.ERROR_MSG);
    }

    public static BaseResponse error(String msg){
        return error(BaseResponse.ERROR_CODE,msg);
    }
}
