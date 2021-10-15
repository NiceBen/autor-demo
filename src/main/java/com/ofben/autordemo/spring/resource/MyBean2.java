package com.ofben.autordemo.spring.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

/**
 * {@link Resource}
 *
 * @date 2021-10-15
 * @since 1.0.0
 */
@Configuration
@PropertySource("classpath:/META-INF/resource/my-bean.properties")
public class MyBean2 {

    private Resource template;

    @Value("${template.path}")
    private static String path;

    public void setTemplate(@Value("${template.path}") Resource template) {
        this.template = template;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyBean2.class);
        MyBean2 myBean = context.getBean(MyBean2.class);
        System.out.println("path:" + path);
        System.out.println(myBean.template);
    }
}
