package com.ofben.autordemo.test.io.bytes;

import java.io.*;

/**
 * {@link FileOutputStream}
 *
 * @date 2021-09-09
 * @since 1.0.0
 */
public class FileOutputStreamTest {

    public static void main(String[] args) {
        String inPathname = "E:/MyTestWorkspace2020/autor-demo/src/main/java/com/ofben/autordemo/test/io/bytes/FileOutputStreamTest.java";
        String outPathName = "E:/myJava/world3.txt";
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(new File(inPathname));
            fos = new FileOutputStream(new File(outPathName));
            byte[] buffer = new byte[1024];
            int read;
            while ((read = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, read);
            }
            System.out.println("处理完成！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
