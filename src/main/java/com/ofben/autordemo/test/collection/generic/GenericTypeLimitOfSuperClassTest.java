package com.ofben.autordemo.test.collection.generic;

import com.ofben.autordemo.test.collection.generic.Mock.*;

/**
 * 限制泛型 类型范围 Test
 *
 * @author SL Zhou
 * @date 2021-09-03
 * @since 1.0.0
 */
public class GenericTypeLimitOfSuperClassTest<T extends Plant> {

    public static void main(String[] args) {
        // 实例化 GenericTypeLimitTest 的泛型类 Flower，正确
        GenericTypeLimitOfSuperClassTest<Plant> plantG = new GenericTypeLimitOfSuperClassTest<>();
        // 实例化 GenericTypeLimitTest 的泛型类 Flower，正确
        GenericTypeLimitOfSuperClassTest<Flower> flowerG = new GenericTypeLimitOfSuperClassTest<>();
    }
}
