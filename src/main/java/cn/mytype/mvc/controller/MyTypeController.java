package cn.mytype.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;

import cn.mytype.MyTypeException;

public abstract class MyTypeController {

    @ExceptionHandler
    public String handle(HttpServletRequest request, Exception ex) {
        request.setAttribute("ex", ex);
        // 业务异常的时候
        if (ex instanceof MyTypeException) {
            return "/error";
        }
        // 其他异常的时候
        return "/error";
    }
}
