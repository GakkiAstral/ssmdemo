package com.bjsxt.web.controller;

import com.bjsxt.pojo.Users;
import com.bjsxt.pojo.UsersExt;
import com.bjsxt.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户管理控制器
 */
@Controller
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UsersService usersService;
    /**
     * 处理用户登录请求
     */
    @RequestMapping("/userLogin")
    public String userLogin(UsersExt users, HttpSession session, HttpServletRequest request){
        String ip = request.getRemoteAddr();
        users.setIp(ip);
        Users user = this.usersService.userLogin(users);
        session.setAttribute("user",user);
        //实现页面跳转采用重定向，而不能使用请求转发;
        //登录成功则需要跳转到首页，需要变更URL，采用重定向。
        return "redirect:/page/index";
    }
}
