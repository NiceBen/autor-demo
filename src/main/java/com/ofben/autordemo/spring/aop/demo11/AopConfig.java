package com.ofben.autordemo.spring.aop.demo11;

import com.ofben.autordemo.spring.aop.demo11.package1.FirstTarget;
import com.ofben.autordemo.spring.aop.demo11.package2.SecondTarget;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * TODO
 *
 * @author SL Zhou
 * @date 2021-12-21
 * @since TODO
 */
@Configuration
@ComponentScan(basePackages = "com.ofben.autordemo.spring.aop.demo11")
@EnableAspectJAutoProxy(proxyTargetClass = false, exposeProxy = false)
public class AopConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);

        FirstTarget first = context.getBean(FirstTarget.class);
        first.first();
        first.first2();

        System.out.println("--------------");

        SecondTarget second = context.getBean(SecondTarget.class);
        second.second();
    }


}
