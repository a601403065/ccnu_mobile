package com.ccnu.mobile;


import com.ccnu.mobile.entity.vo.ResultStatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandle {
    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandle.class);
    //捕获全局异常，处理所有不可知的异常 这个注解是捕获所有异常
    @ExceptionHandler(value=Exception.class)
    public Object handleException(Exception e, HttpServletRequest request) {
        //此处返回json数据
        LOG.error("msg:{},url:{}", e.getMessage(), request.getRequestURL());
        Map<String, Object> map = new HashMap<>();
        //捕捉到的异常如果是自定义异常类，那么就返回自定义异常类中的错误码和错误信息
        if(e instanceof ResultStatusEnum){
            map.put("code",((ResultStatusEnum) e).getCode());
            map.put("msg",((ResultStatusEnum) e).getMsg());
        }
        //这里是除了自定义异常的其他异常信息
        else {
            map.put("code", 100);
            map.put("msg", e.getMessage());
        }
        map.put("url", request.getRequestURL());
        return map;

    }


}