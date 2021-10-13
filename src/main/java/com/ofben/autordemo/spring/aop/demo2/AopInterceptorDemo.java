package com.ofben.autordemo.spring.aop.demo2;

import com.ofben.autordemo.spring.aop.demo2.interceptor.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * {@link EchoService}
 *
 * @date 2021-10-13
 * @since 1.0.0
 */
public class AopInterceptorDemo {

    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Object proxy = Proxy.newProxyInstance(classLoader, new Class[]{EchoService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (EchoService.class.isAssignableFrom(method.getDeclaringClass())) {
                    Long startTime = 0L;
                    Long endTime = 0L;
                    Object result = null;
                    try {
                        BeforeInterceptor beforeInterceptor = (proxy1, method1, args1) -> System.currentTimeMillis();
                        startTime = (Long) beforeInterceptor.before(proxy, method, args);

                        EchoService echoService = new DefaultEchoService();
                        result = echoService.echo((String) args[0]);

                        AfterInterceptor afterInterceptor = (proxy1, method1, args1, result1) -> System.currentTimeMillis();
                        endTime = (Long) afterInterceptor.after(proxy, method, args, result);

                        return result;
                    } catch (Exception e) {
                        ExceptionInterceptor exceptionInterceptor = (proxy1, method1, args1, e1) -> System.currentTimeMillis();
                        exceptionInterceptor.interceptor(proxy, method, args, e);
                    } finally {
                        FinallyInterceptor finallyInterceptor = new TimeFinallyInterceptor(startTime, endTime);
                        Long costTime = (Long) finallyInterceptor.finalize(proxy, method, args, result);
                        System.out.println("echo 方法执行的时间：" + costTime + "ms.");
                    }
                    return result;
                }
                return null;
            }
        });

        EchoService echoService = (EchoService) proxy;
        String result = (String) echoService.echo("hello world");
        System.out.println(result);
    }

}
