package com.ofben.autordemo.test.io;

import java.io.File;

/**
 * File list
 *
 * @date 2021-09-08
 * @since 1.0.0
 */
public class Test05 {

    /*
        http://c.biancheng.net/view/1133.html
     */
    public static void main(String[] args) {
        File file = new File("e:/");
        System.out.println("文件名称\t\t文件类型\t\t文件大小");
        System.out.println("-----------------------------");
        String[] list = file.list();
        for (int i = 0, length = list.length; i < length; i++) {
            System.out.print(list[i] + "\t\t");
            System.out.print((new File("e:/" + list[i]).isFile()?"是文件":"目录") + "\t\t");
            System.out.println((new File("e:/" + list[i]).length() + "字节"));
        }
    }
}
