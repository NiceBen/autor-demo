package com.ofben.autordemo.test.collection.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * {@link Stream} Test
 *
 * @author SL Zhou
 * @date 2021-09-03
 * @since 1.0.0
 */
public class SteamTest {

    public static void main(String[] args) {
//        testStreamOperation();
        testStreamOperation2();
    }

    private static void testStreamOperation2() {
        IntStream is = IntStream.builder().add(20).add(13).add(-2).add(18).build();
        // 下面调用聚集方法的代码每次只能执行一行
        System.out.println("is 所有元素的最大值：" + is.max().getAsInt());
        System.out.println("is 所有元素的最小值：" + is.min().getAsInt());
        System.out.println("is 所有元素的总和：" + is.sum());
        System.out.println("is 所有元素的总数：" + is.count());
        System.out.println("is 所有元素的平均值：" + is.average());
        System.out.println("is所有元素的平方是否都大于20: " + is.allMatch(ele -> ele * ele > 20));
        System.out.println("is是否包含任何元素的平方大于20 : " + is.anyMatch(ele -> ele * ele > 20));
        // 将is映射成一个新Stream,新Stream的每个元素是原Stream元素的2倍+1
        IntStream newIs = is.map(ele -> ele * 2 + 1);
        // 使用方法引用的方式来遍历集合元素
        newIs.forEach(System.out::println); // 输岀 41 27 -3 37
    }

    private static void testStreamOperation() {
        IntStream is = IntStream.builder().add(20).add(13).add(-2).add(18).build();
        System.out.println("max:" + is.max());
        System.out.println("min:" + is.min());
        System.out.println("sum:" + is.sum());
        System.out.println("count:" + is.count());
        System.out.println("average:" + is.average());
        System.out.println("is 所有元素的平方是否都大于 20 :" + is.allMatch(i -> i * i > 20));
        System.out.println("is 是否包含任何元素的平方大于 20 :" + is.anyMatch(i -> i * i > 20));
        // 将is映射成一个新Stream,新Stream的每个元素是原Stream元素的2倍+1
        IntStream newStream = is.map(i -> 2 * i + 1);
        // 使用方法引用的方式来遍历集合元素
        newStream.forEach(System.out::println);



    }
}
