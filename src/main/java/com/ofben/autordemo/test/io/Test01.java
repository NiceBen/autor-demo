package com.ofben.autordemo.test.io;

import java.io.IOException;

/**
 * Java系统流 - 简单的输入输出控制台
 *
 * @date 2021-09-08
 * @since 0.0.1
 */
public class Test01 {

    public static void main(String[] args) {
        byte[] byteData = new byte[100];
        System.out.println("请输入英文：");
        try {
            System.in.read(byteData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("您输入的内容如下：");
        for (int i = 0; i < byteData.length; i++) {
            System.out.print((char) byteData[i]);
        }

        getPropertyOfSystemEncode();
    }

    private static void getPropertyOfSystemEncode() {
        // 获取当前系统编码
        System.out.println("系统默认编码：" + System.getProperty("file.encoding"));
    }
}
