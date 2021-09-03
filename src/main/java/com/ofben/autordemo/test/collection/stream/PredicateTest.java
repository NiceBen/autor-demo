package com.ofben.autordemo.test.collection.stream;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

/**
 * {@link Predicate}
 *
 * @author SL Zhou
 * @date 2021-09-03
 * @since 1.0.0
 */
public class PredicateTest {

    public static void main(String[] args) {
        testPredicateTest();
    }

    private static void testPredicateTest() {
        Collection<String> objs = new HashSet<>();
        objs.add("C语言中文网Java教程");
        objs.add("C语言中文网C++教程");
        objs.add("C语言中文网C语言教程");
        objs.add("C语言中文网Python教程");
        objs.add("C语言中文网Go教程");

        // 统计集合中出现“C语言中文网”字符串的数量
        System.out.println(callAll(objs, book -> book.toString().contains("C语言中文网")));
        // 统计集合中出现“Java”字符串的数量
        System.out.println(callAll(objs, book -> book.toString().contains("Java")));
        // 统计集合中出现字符串长度大于 12 的数量
        System.out.println(callAll(objs, book -> book.toString().length() > 12));
    }

    private static int callAll(Collection books, Predicate p) {
        int total = 0;
        for (Object obj : books) {
            if (p.test(obj)) {
                total++;
            }
        }
        return total;
    }
}
