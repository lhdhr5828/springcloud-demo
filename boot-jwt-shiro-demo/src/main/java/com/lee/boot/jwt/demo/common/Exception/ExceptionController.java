package com.lee.boot.jwt.demo.common.Exception;

import com.lee.boot.jwt.demo.common.BaseResponse;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author li.heng
 * @Date 2019/7/2 15
 * @Description: web异常处理
 **/
@RestControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.GATEWAY_TIMEOUT)
    @ExceptionHandler(value = ShiroException.class)
    public BaseResponse<Object> handle401(ShiroException e) {
        return new BaseResponse<>(false, "shiro的异常", null);
    }

    @ResponseStatus(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
    @ExceptionHandler(value = UnauthorizedException.class)
    public BaseResponse handleAccountError(UnauthorizedException e) {
        return new BaseResponse<>(false, e.getMessage(), null);
    }

    @ResponseStatus(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
    @ExceptionHandler(value = UnknownAccountException.class)
    public BaseResponse handleAccountError(UnknownAccountException e) {
        return new BaseResponse<>(false, e.getMessage(), null);
    }

    @ExceptionHandler(UnauthenticatedException.class)
    public BaseResponse handleAuthorizationException(UnauthenticatedException e) {
        System.out.println(e.getMessage());
        return new BaseResponse<>(false, "请联系管理员授权后,登陆操作", null);
    }

}
