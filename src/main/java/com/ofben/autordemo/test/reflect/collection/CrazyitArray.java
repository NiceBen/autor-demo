package com.ofben.autordemo.test.reflect.collection;

import java.lang.reflect.Array;

/**
 * CrazyitArray
 *
 * @date 2021-09-14
 * @since 1.0.0
 */
public class CrazyitArray {

    @SuppressWarnings("unchecked")
    public static <T> T[] getInstance(Class<T> componentType, int length) {
        try {
            return (T[]) Array.newInstance(componentType, length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String[] strings = CrazyitArray.getInstance(String.class, 3);
        String[][] strstr = CrazyitArray.getInstance(String[].class, 5);
    }
}
