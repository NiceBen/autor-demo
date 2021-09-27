package com.ofben.autordemo.spring.path.named;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 * {@link MyNameGenerator}
 *
 * @date 2021-09-27
 * @since 1.0.0
 */
@Configuration
@ComponentScan(basePackages = "com.ofben.autordemo.spring.path.named",
//        nameGenerator = MyNameGenerator.class,
        scopeResolver = MyScopeResolver.class,
        scopedProxy = ScopedProxyMode.INTERFACES)
public class MyNameGeneratorTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyNameGeneratorTest.class);
        context.refresh();

        MyNameGeneratorTest bean = context.getBean(MyNameGeneratorTest.class);

        context.close();
    }
}
