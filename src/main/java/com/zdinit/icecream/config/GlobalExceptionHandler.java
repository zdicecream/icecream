package com.zdinit.icecream.config;


import cn.dev33.satoken.exception.NotLoginException;
import com.zdinit.icecream.common.BaseResponse;
import com.zdinit.icecream.common.CheckException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局统一错误处理
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
//    非restAPI 类型的指向
//    public static final String DEFAULT_ERROR_VIEW ="error";
//    @ExceptionHandler(value = Exception.class)
//    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e){
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.addObject("url", req.getRequestURL());
//        mav.setViewName(DEFAULT_ERROR_VIEW);
//        return mav;
//    }

    /**
     * 统一的restAPI 500返回
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResponse<String> defaultErrorHandler(HttpServletRequest req, Exception e){
        log.info("系统错误",e);
        BaseResponse baseResponse = new BaseResponse(BaseResponse.ERROR_CODE,BaseResponse.ERROR_MSG +"["+e.getMessage()+"]",null);
        return baseResponse;
    }


    /**
     * 统一的restAPI 登录错误返回
     * @param req
     * @param nle
     * @return
     */
    @ExceptionHandler(value = NotLoginException.class)
    @ResponseBody
    public BaseResponse<String> notLoginExceptionhandler(HttpServletRequest req,NotLoginException nle){
        log.info("登录异常",nle);
        BaseResponse baseResponse = new BaseResponse(BaseResponse.FALSE_CODE,nle.getMessage(),null);
        return baseResponse;
    }

    /**
     * 统一的restAPI 参数检测错误返回
     * @param req
     * @param nle
     * @return
     */
    @ExceptionHandler(value = CheckException.class)
    @ResponseBody
    public BaseResponse<String> checkExceptionhandler(HttpServletRequest req,CheckException nle){
        log.info("参数检测异常",nle);
        BaseResponse baseResponse = new BaseResponse(BaseResponse.FALSE_CODE,nle.getMessage(),null);
        return baseResponse;
    }

}
