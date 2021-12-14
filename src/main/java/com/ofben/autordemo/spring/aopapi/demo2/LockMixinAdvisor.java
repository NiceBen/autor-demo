package com.ofben.autordemo.spring.aopapi.demo2;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

/**
 * TODO
 *
 * @date 2021-12-14
 * @since TODO
 */
public class LockMixinAdvisor extends DefaultIntroductionAdvisor {

    public LockMixinAdvisor() {
        super(new LockMixin(), Lockable.class);
    }
}
