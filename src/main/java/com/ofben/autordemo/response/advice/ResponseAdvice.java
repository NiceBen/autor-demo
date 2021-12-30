package com.ofben.autordemo.response.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ofben.autordemo.response.resp.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * ResponseBodyAdvice： 该接口是SpringMVC 4.1提供的，它允许在 执行 @ResponseBody后自定义返回数据，用来封装统一数据格式返回；
 * @RestControllerAdvice： 该注解是对Controller进行增强的，可以全局捕获抛出的异常。
 *
 * @date 2021-12-29
 * @since TODO
 */
@Slf4j
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 是否开启功能 true：是
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    /**
     * 处理返回结果
     */
    @Override
    public Object beforeBodyWrite(Object object, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // 处理字符串类型数据
        if (object instanceof String) {
            try {
                return objectMapper.writeValueAsString(Result.success(object));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        // 返回类型是否已经封装
        if (object instanceof Result) {
            return object;
        }

        return Result.success(object);
    }
}
