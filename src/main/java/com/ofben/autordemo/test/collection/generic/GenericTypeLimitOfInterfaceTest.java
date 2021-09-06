package com.ofben.autordemo.test.collection.generic;

import com.ofben.autordemo.test.collection.generic.Mock.Animal;
import com.ofben.autordemo.test.collection.generic.Mock.Cat;
import com.ofben.autordemo.test.collection.generic.Mock.Dog;

/**
 * 限制泛型 类型范围 Test
 *
 * @date 2021-09-03
 * @since 1.0.0
 */
public class GenericTypeLimitOfInterfaceTest<T extends Animal> {

    public static void main(String[] args) {
        // 实例化 GenericTypeLimitTest 的泛型类 Cat，正确
        GenericTypeLimitOfInterfaceTest<Cat> catG = new GenericTypeLimitOfInterfaceTest<>();
        // 实例化 GenericTypeLimitTest 的泛型类 Dog，正确
        GenericTypeLimitOfInterfaceTest<Dog> dogG = new GenericTypeLimitOfInterfaceTest<>();
        // 实例化 GenericTypeLimitTest 的泛型类 Flower，错误
//        GenericTypeLimitOfInterfaceTest<Flower> flowerG = new GenericTypeLimitOfInterfaceTest<>();
    }
}
