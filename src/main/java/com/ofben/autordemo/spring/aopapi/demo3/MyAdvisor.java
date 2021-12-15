package com.ofben.autordemo.spring.aopapi.demo3;

import com.ofben.autordemo.spring.aopapi.demo2.LockMixin;
import com.ofben.autordemo.spring.aopapi.demo2.Lockable;
import org.springframework.aop.support.DefaultIntroductionAdvisor;

/**
 * TODO
 *
 * @date 2021-12-14
 * @since TODO
 */
public class MyAdvisor extends DefaultIntroductionAdvisor {

    private String someProperty;

    public MyAdvisor() {
        super(new LockMixin(), Lockable.class);
    }

    public void setSomeProperty(String someProperty) {
        this.someProperty = someProperty;
    }
}
