package com.ofben.autordemo.spring.aop.demo1;

import com.ofben.autordemo.spring.aop.demo1.interceptor.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Test Demo
 *
 * @date 2021-10-12
 * @since 1.0.0
 */
public class AopInterceptorDemo {

    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Object proxy = Proxy.newProxyInstance(classLoader, new Class[]{EchoService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (EchoService.class.isAssignableFrom(method.getDeclaringClass())) {
                    Long endTime = 0L;
                    Long startTime = 0L;
                    String result = null;
                    try {
                        // 前置拦截器
                        BeforeInterceptor beforeInterceptor = (proxy1, method1, args1) -> System.currentTimeMillis();
                        startTime = (Long) beforeInterceptor.before(proxy, method, args);

                        // 执行目标方法
                        EchoService echoService = new DefaultEchoService();
                        result = echoService.echo((String) args[0]);

                        // 后置拦截器
                        AfterInterceptor afterInterceptor = (proxy2, method2, args2, result2) -> System.currentTimeMillis();
                        endTime = (Long) afterInterceptor.after(proxy, method, args, result);

                        return result;
                    } catch (Exception e) {
                        // 异常拦截器
                        ExceptionInterceptor exceptionInterceptor = (proxy3, method3, args3, e3) -> {};
                        exceptionInterceptor.interceptor(proxy, method, args, e);
                    } finally {
                        // finally 最终拦截器
                        FinallyInterceptor finallyInterceptor = new TimeFinallyInterceptor(startTime, endTime);
                        Long costTime = (Long) finallyInterceptor.finalize(proxy, method, args, result);
                        System.out.println("echo 方法执行的时间：" + costTime + "ms.");
                    }
                }
                return null;
            }
        });

        EchoService echoService = (EchoService) proxy;
        String result = echoService.echo("hello world");
        System.out.println(result);
    }
}
