package com.ofben.autordemo.spring.aopapi.demo2;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * TODO
 *
 * @date 2021-12-14
 * @since TODO
 */
public class LockMixin extends DelegatingIntroductionInterceptor implements Lockable {

    private boolean locked;

    @Override
    public void lock() {
        this.locked = true;
    }

    @Override
    public void unlock() {
        this.locked = false;
    }

    @Override
    public boolean locked() {
        return this.locked;
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        if (locked() && mi.getMethod().getName().indexOf("set") == 0) {
            throw new LockedException();
        }
        return super.invoke(mi);
    }
}
