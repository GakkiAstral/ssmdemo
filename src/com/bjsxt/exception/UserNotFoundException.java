package com.bjsxt.exception;

/**
 * 自定义异常表示用户登录状态
 */
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){

    }

    public UserNotFoundException(String msg){
        super(msg);
    }

    public UserNotFoundException(String msg,Throwable throwable){
        super(msg,throwable);
    }
}
