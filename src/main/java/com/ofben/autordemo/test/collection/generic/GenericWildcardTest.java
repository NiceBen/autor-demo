package com.ofben.autordemo.test.collection.generic;


import com.ofben.autordemo.test.collection.generic.Mock.Animal;
import com.ofben.autordemo.test.collection.generic.Mock.Dog;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型通配符
 *
 * @date 2021-09-03
 * @since 1.0.0
 */
public class GenericWildcardTest<T, R> {

    private R value;

    public R test(List<? extends String> list, R r) {
        value = r;
        return value;
    }

    public static void main(String[] args) {
        List<? extends Animal> list = null;
    }

    public R getValue() {
        return value;
    }
}
