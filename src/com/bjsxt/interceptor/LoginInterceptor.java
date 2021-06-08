package com.bjsxt.interceptor;

import com.bjsxt.pojo.Users;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 判断用户是否登录
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 判断用户是否登录
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //处理请求方法前，实现该方法就可以了
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        if (user == null || user.getUsername().length() <= 0){
            //未登录的话，会默认跳转到login页面，则一开始访问页面的时候默认就不是index，而是login页面了
            response.sendRedirect("/page/login");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
