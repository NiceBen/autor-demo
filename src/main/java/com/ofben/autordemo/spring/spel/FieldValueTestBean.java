package com.ofben.autordemo.spring.spel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * bean
 *
 * @date 2021-10-15
 * @since 1.0.0
 */
@Configuration
public class FieldValueTestBean {

//    @Value("#{ systemProperties['user.name'] }")
    private String userName;

//    @Value("#{ systemProperties['user.name'] }")
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }

    @Autowired
    public void configure(@Value("#{ systemProperties['user.region'] }") String userName) {
        this.userName = userName;
    }

//    public FieldValueTestBean(@Value("#{ systemProperties['user.name'] }") String userName) {
//        this.userName = userName;
//    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FieldValueTestBean.class);
        FieldValueTestBean bean = context.getBean(FieldValueTestBean.class);
        System.out.println(bean.userName);
    }
}
