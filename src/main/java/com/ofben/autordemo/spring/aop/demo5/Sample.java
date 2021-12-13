package com.ofben.autordemo.spring.aop.demo5;

import java.util.Collection;

/**
 * TODO
 *
 * @date 2021-12-13
 * @since TODO
 */
public interface Sample<T> {

    void sampleGenericMethod(T param);

    void sampleGenericCollectionMethod(Collection<T> param);
}
