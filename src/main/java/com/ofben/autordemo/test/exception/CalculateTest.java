package com.ofben.autordemo.test.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 计算 Catch Exception
 *
 * @date 2021-09-08
 * @since 1.0.0
 */
public class CalculateTest {

    /*
        System.out.println("出现数组越界错误，下标过大或者过小。");
        System.out.println("出现算术运算错误，被除数不能为0。");
        System.out.println("输入的数据类型不匹配，只能输入数字。");
        System.out.println("发生未知错误。");
     */
    public static void main(String[] args) {
        Compute compute = new Compute();
        int[] array = compute.getNum();
        int res = 0;
        String YorN = null;
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("请输入第一个整数：");
            array[0] = in.nextInt();
            System.out.println("请输入第二个整数：");
            array[1] = in.nextInt();
            res = array[0] / array[1];
            System.out.println("是否保存结果请输入Y或者N：");
            YorN = in.next();
            if (YorN.equals("Y")) {
                array[2] = res;
            }
            System.out.println(array[0] + "除以" + array[1] + "的结果是：" + res);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("出现数组越界错误，下标过大或者过小。");
        } catch (ArithmeticException e) {
            System.out.println("出现算术运算错误，被除数不能为0。");
        } catch (InputMismatchException e) {
            System.out.println("输入的数据类型不匹配，只能输入数字。");
        } catch (Exception e) {
            System.out.println("发生未知错误。");
        }
        // 多次测试使用
//        main(args);
    }
}

class Compute {

    private int[] num = new int[2];

    public int[] getNum() {
        return num;
    }

    public void setNum(int[] num) {
        this.num = num;
    }
}

