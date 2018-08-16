package com.springmvc.handler;

import com.springmvc.constant.RestCodeConstants;
import com.springmvc.exception.BaseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice("com.springmvc")
@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(BaseException.class)
    public BaseResponse baseExceptionHandler(HttpServletResponse response, BaseException ex){
        return new BaseResponse(ex.getStates(),ex.getMessage());

    }

    @ExceptionHandler(Exception.class)
    public BaseResponse otherExceptionHandler(HttpServletResponse response, Exception ex){
        return new BaseResponse(RestCodeConstants.EX_OTHER_CODE,ex.getMessage());

    }
}
