package com.ofben.autordemo.spring.annotation.permission;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器适配
 *
 * @date 2021-10-29
 * @since 1.0.0
 */
public class PermissionCheckInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        PermissionCheck permission = findPermissionCheck(handlerMethod);

        // 如果没有添加权限注解则直接跳过允许访问
        if (permission == null) {
            return true;
        }

        // 获取注解中的值
        String resourceKey = permission.resourceKey();

        // TODO 权限校验一般需要获取用户信息，通过查询数据库进行权限校验
        // TODO 这里只进行简单演示，如果 resourceKey 为 testKey 则校验通过，否则不通过
        if ("testKey".equals(resourceKey)) {
            return true;
        }
        return false;
    }

    /**
     * 根据handlerMethod返回注解信息
     * @param handlerMethod     方法对象
     * @return  PermissionCheck 注解
     */
    private PermissionCheck findPermissionCheck(HandlerMethod handlerMethod) {
        // 在方法上寻找注解
        PermissionCheck permission = handlerMethod.getMethodAnnotation(PermissionCheck.class);
        if (permission == null) {
            // 在类上寻找注解
            permission = handlerMethod.getBeanType().getAnnotation(PermissionCheck.class);
        }

        return permission;
    }
}
