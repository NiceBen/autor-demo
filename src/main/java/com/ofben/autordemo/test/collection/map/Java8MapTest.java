package com.ofben.autordemo.test.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link Map}
 *
 * @date 2021-09-03
 * @since 1.0.0
 */
public class Java8MapTest {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");

        System.out.println(map.get(4));
        System.out.println(map.getOrDefault(4, "world"));

        map.forEach((key, value) -> System.out.println(key + ":" + value));

        map.replaceAll((key, value) -> key + value);
        map.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}
