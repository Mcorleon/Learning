package com.tqh.demo.exception;

import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * @Author: Mcorleon
 * @Date: 18-7-26 19:55
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private final static Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(AuthorizationException.class)
    public String AuthenticationExceptionHandler(AuthorizationException e){
        logger.error("权限错误");
        logger.error(e.getMessage());
        return  "403";
    }

    @ExceptionHandler(UnknownAccountException.class)
    public String AUnknownAccountExceptionHandler(UnknownAccountException e){
        logger.error("未知用户");
        logger.error(e.getMessage());
        return  "Err";
    }
    @ExceptionHandler(IncorrectCredentialsException.class)
    public String IncorrectCredentialsExceptionHandler(IncorrectCredentialsException e){
        logger.error("校验出错");
        logger.error(e.getMessage());
        return  "Err";
    }
    @ExceptionHandler(LockedAccountException.class)
    public String LockedAccountExceptionHandler(LockedAccountException e){
        logger.error("账户已锁定");
        logger.error(e.getMessage());
        return  "Err";
    }
    @ExceptionHandler(ExcessiveAttemptsException.class)
    public String ExcessiveAttemptsExceptionHandler(ExcessiveAttemptsException e){
        logger.error("错误次数过多");
        logger.error(e.getMessage());
        return  "Err";
    }



}
