package com.ofben.autordemo.test.reflect.collection;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * GenericTest
 *
 * @date 2021-09-14
 * @since 1.0.0
 */
public class GenericTest {

    private Map<String, Integer> score;

    public static void main(String[] args) throws Exception {
        Class<GenericTest> clazz = GenericTest.class;
        Field f = clazz.getDeclaredField("score");
        Class<?> a = f.getType();
        System.out.println("score 的类型是：" + a);

        Type gType = f.getGenericType();
        System.out.println("gType:" + gType);

        if (gType instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) gType;
            Type rType = pType.getRawType();
            System.out.println("原始类型是：" + rType);
            Type[] tArgs = pType.getActualTypeArguments();
            System.out.println("泛型信息是：");
            for (int i = 0; i < tArgs.length; i++) {
                System.out.println("第" + (i + 1) + "个泛型类型是：" + tArgs[i]);
            }
        } else {
            System.out.println("获取泛型类型出错！");
        }
    }
}
