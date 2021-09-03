package com.ofben.autordemo.test.collection.generic;


import com.ofben.autordemo.test.collection.generic.Mock.Animal;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型通配符
 *
 * @author SL Zhou
 * @date 2021-09-03
 * @since 1.0.0
 */
public class GenericWildcardTest2<T, R> {

    private R value;

    public R test(List<? extends String> list, R r) {
        value = r;
        return value;
    }

    public R test2(GenericWildcardTest<? extends T, ? extends R> test) {
//        test.test(new ArrayList<String>(), value);
        return null;
    }

    public static void main(String[] args) {
        List<? extends Animal> list = null;
    }
}
