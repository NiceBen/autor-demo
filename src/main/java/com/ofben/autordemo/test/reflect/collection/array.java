package com.ofben.autordemo.test.reflect.collection;

import java.lang.reflect.Array;

/**
 * {@link Array}
 *
 * @date 2021-09-14
 * @since 1.0.0
 */
public class array {

    public static void main(String[] args) {
        Integer[] integers = new Integer[4];
        Integer[] integers1 = {1, 2, 3, 4};
        Integer[] integers2 = (Integer[]) Array.newInstance(Integer.class, 4);
        Class componentType = Integer.class;
        Object array = Array.newInstance(componentType, 4);

        Array.set(integers, 0, 111);
        Object o = Array.get(integers, 0);
        System.out.println(o);

        boolean isArray = integers.getClass().isArray();
        System.out.println(isArray);
        Object integerArray = Array.newInstance(Integer.class, 8);
        Array.set(integerArray, 0, 88);
        int length = Array.getLength(integerArray);
        int length1 = Array.getLength(array);

        Class<?> componentType1 = integerArray.getClass().getComponentType();
        System.out.println(componentType1);
    }
}
