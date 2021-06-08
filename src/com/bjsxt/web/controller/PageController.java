package com.bjsxt.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转控制器
 */
@Controller
public class PageController {
    /**
     * 处理请求首页,当index.jsp不在默认WEB-INF目录下，可以设置默认页面index，以避免404错误。
     */
    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    /**
     * 处理页面跳转请求
     */
    @RequestMapping("/page/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }
}
