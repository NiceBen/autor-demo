package com.ofben.autordemo.test.io.chars;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * {@link FileWriter}
 *
 * @date 2021-09-09
 * @since 1.0.0
 */
public class FileWriterTest {
    /*
    http://c.biancheng.net/view/1150.html
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pathname = "E:/myJava/world4.txt";
        FileWriter fw = null;

        try {
            fw = new FileWriter(pathname);
            for (int i = 0; i < 4; i++) {
                System.out.println("please input " + (i + 1) + " char：");
                String next = scanner.next();
                fw.write(next + "\n");
            }
            fw.flush();
            System.out.println("input complete！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
