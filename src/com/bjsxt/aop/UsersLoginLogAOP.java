package com.bjsxt.aop;

import com.bjsxt.mapper.LogsMapper;
import com.bjsxt.pojo.Logs;
import com.bjsxt.pojo.Users;
import com.bjsxt.pojo.UsersExt;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 用户登录日志记录切面
 */
@Aspect
@Component
public class UsersLoginLogAOP {
    @Autowired
    private LogsMapper logsMapper;
    /**
     * 配置切点
     */
    @Pointcut("execution(* com.bjsxt.service.UsersService.userLogin(..))")
    public void myPointcut(){

    }
    /**
     * 在后置通知中记录登录日志
     */
    @AfterReturning("myPointcut()")
    public void userLoginLog(JoinPoint joinPoint){
        Object[] objects = joinPoint.getArgs();
        UsersExt users = (UsersExt) objects[0];
        Logs logs = new Logs();
        logs.setLogtime(new Date());
        logs.setUsername(users.getUsername());
        logs.setIp(users.getIp());
        this.logsMapper.insertSelective(logs);
    }
}
