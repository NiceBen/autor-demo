package com.ofben.autordemo.spring.path;

import com.ofben.autordemo.test.exception.log.Test;
import org.junit.rules.TestRule;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 * Bean
 *
 * @date 2021-09-27
 * @since 1.0.0
 */
@Component
public class FactoryMethodComponent {

    private static int i;

    @Bean
    @Qualifier("public")
    public TestBean publicInstance() {
        return new TestBean("publicInstance");
    }

    @Bean
    protected TestBean protectedInstance(
            @Qualifier("public") TestBean spouse,
            @Value("#{privateInstance.age}") String country) {
        TestBean tb = new TestBean("protectedInstance", 1);
        tb.setSpouse(spouse);
        tb.setCountry(country);
        return tb;
    }

    @Autowired
    private TestBean protectedInstance;


    @Bean @Scope("prototype")
    @Qualifier("injectionPoint")
    public TestBean injectionPointInstance(InjectionPoint injectionPoint) {
        System.out.println("+++++++++++");
        System.out.println(injectionPoint.getMethodParameter());
        System.out.println(injectionPoint.getField());
        System.out.println(injectionPoint.getAnnotations());
        System.out.println("+++++++++++");
        return new TestBean("prototypeInstance for " + injectionPoint.getMember());
    }

    @Autowired
    @Qualifier("injectionPoint")
    private TestBean injectionPointInstance;

    @Bean
    private TestBean privateInstance() {
        return new TestBean("privateInstance", i++);
    }

//    @Bean
//    @RequestScope
//    public TestBean requestInstance() {
//        return new TestBean("requestScopedInstance", 3);
//    }

    public void doWork() {
        // do Something ...
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(FactoryMethodComponent.class);
        context.refresh();

        FactoryMethodComponent bean = context.getBean(FactoryMethodComponent.class);
        TestBean testBean = bean.protectedInstance;
        System.out.println(testBean);

        System.out.println("------------");
        TestBean testBean2 = bean.injectionPointInstance;
        System.out.println(testBean2);


        context.close();
    }
}
