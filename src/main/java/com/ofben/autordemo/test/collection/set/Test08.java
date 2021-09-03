package com.ofben.autordemo.test.collection.set;

import java.util.*;

/**
 * {@link Set}
 *
 * @author SL Zhou
 * @date 2021-09-03
 * @see Set
 * @see TreeSet
 * @since 1.0.0
 */
public class Test08 {

    public static void main(String[] args) {
        TreeSet<Double> scores = new TreeSet<>();
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------");
        for (int i = 0; i < 5; i++) {
            System.out.println("第" + (i + 1) + "个学生成绩");
            double score = input.nextDouble();
            scores.add(score);
        }
        Iterator<Double> it = scores.iterator();
        System.out.println("学生成绩从低到高的排序为：");
        while (it.hasNext()) {
            System.out.print(it.next() + "\t");
        }
        System.out.println("\n 请输入要查询的成绩：");
        double searchScore = input.nextDouble();
        if (scores.contains(searchScore)) {
            System.out.println("成绩为：" + searchScore + " 的学生存在！");
        } else {
            System.out.println("成绩为：" + searchScore + " 的学生不存在！");
        }
        // 查询不及格的学生成绩
        SortedSet<Double> score1 = scores.headSet(60.0);
        Object[] score1Arr = score1.toArray();
        System.out.println("\n不及格的成绩有：");
        for (int i = 0,set1Len = score1Arr.length; i < set1Len; i++) {
            System.out.print(score1Arr[i] + "\t");
        }
        // 查询 90 分以上的学生成绩
        SortedSet<Double> tailSet = scores.tailSet(90.0);
        Object[] tailArr = tailSet.toArray();
        System.out.println("\n90 分以上的成绩有：");
        for (int i = 0, tailArrLen = tailArr.length; i < tailArrLen; i++) {
            System.out.print(tailArr[i] + "\t");
        }
    }
}
