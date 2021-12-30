package com.ofben.autordemo.response.advice;

import com.ofben.autordemo.response.resp.Result;
import com.ofben.autordemo.response.resp.ResultMsgEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.message.AuthException;

/**
 * 全局异常处理类
 *
 * @date 2021-12-30
 * @since TODO
 */
@Slf4j
@RestControllerAdvice
public class CustomerExceptionHandler {

//    @ExceptionHandler(AuthException.class)
//    public String ErrorHandler(AuthorizationException e) {
//        log.error("没有通过权限验证！", e);
//        return "没有通过权限验证！";
//    }

    @ExceptionHandler(AuthorizationException.class)
    public Result ErrorHandler(AuthorizationException e) {
        log.error("没有通过权限验证！", e);
        return Result.error(ResultMsgEnum.AUTH_ERROR.getCode(), ResultMsgEnum.AUTH_ERROR.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result Exception(Exception e) {
        log.error("未知异常！", e);
        return Result.error(ResultMsgEnum.SERVER_BUSY.getCode(), ResultMsgEnum.SERVER_BUSY.getMessage());
    }
}
