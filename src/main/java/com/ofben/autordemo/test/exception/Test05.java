package com.ofben.autordemo.test.exception;

import java.io.FileInputStream;
import java.io.IOException;

public class Test05 {

    public void readFile() throws IOException {
        // 定义方法时声明异常
        FileInputStream file = new FileInputStream("read.txt"); // 创建 FileInputStream 实例对象
        int f;
        while ((f = file.read()) != -1) {
            System.out.println((char) f);
            f = file.read();
        }
        file.close();
    }

    public static void main(String[] args) {
        Test05 t = new Test05();
        try {
            t.readFile(); // 调用 readFHe()方法
        } catch (IOException e) {
            // 捕获异常
            System.out.println(e);
        }
    }
}