package com.bjsxt.web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理器
 */
@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler({com.bjsxt.exception.UserNotFoundException.class})
    public String userNotFoundExceptionHandler(Exception e, Model model){
        model.addAttribute("msg",e.getMessage());
        return "login";
    }

    @ExceptionHandler({java.lang.Exception.class})
    public String ExceptionHandler(Exception e){
        //重定向不走视图解析器，需要加前缀
        return "redirect:/page/error";
    }
}
