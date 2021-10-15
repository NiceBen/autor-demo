package com.ofben.autordemo.spring.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

/**
 * {@link Resource}
 *
 * @date 2021-10-15
 * @since 1.0.0
 */
public class MyBean {

    private Resource template;

    private Resource[] templates;

    public void setTemplate(Resource template) {
        this.template = template;
    }

    public void setTemplates(@Value("${template.path}") Resource[] templates) {
        this.templates = templates;
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/resource/my-bean.xml");
        MyBean myBean = context.getBean("myBean", MyBean.class);
        System.out.println(myBean.template);
        System.out.println(myBean.templates);
        Resource[] rs = myBean.templates;
        for (int i = 0; i < rs.length; i++) {
            System.out.println(rs[i]);
        }
    }
}
