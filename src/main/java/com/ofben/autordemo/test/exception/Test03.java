package com.ofben.autordemo.test.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * TODO
 *
 * @date 2021-09-07
 * @since 1.0.0
 */
public class Test03 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        try {
            System.out.println("请输入班级总人数：");
            int count = input.nextInt();
            System.out.println("请输入班级总成绩：");
            int score = input.nextInt();
            // 获取平均分
            int avg = score / count;
            System.out.println("本次考试平均成绩为：" + avg);
        } catch (InputMismatchException ime) {
            System.out.println("输入数值有误！");
        } catch (ArithmeticException ae) {
            System.out.println("输入的总人数不能为 0 ！");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("发生错误！" + e.getMessage());
        }
    }
}
