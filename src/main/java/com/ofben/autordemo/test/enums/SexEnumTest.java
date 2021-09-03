package com.ofben.autordemo.test.enums;

import java.util.stream.Stream;

/**
 * {@link SexEnum} Test
 *
 * @author SL Zhou
 * @date 2021-09-03
 * @since 1.0.0
 */
public class SexEnumTest {

    public static void main(String[] args) {
        SexEnum[] values = SexEnum.values();
        Stream.of(values).forEach(System.out::println);

        SexEnum sexEnum = SexEnum.valueOf("female");
        System.out.println(sexEnum);
        System.out.println(sexEnum.ordinal());

    }
}
