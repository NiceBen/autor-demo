package com.ofben.autordemo.test.io.bytes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * {@link FileInputStream}
 *
 * @date 2021-09-09
 * @since 1.0.0
 */
public class FileInputStreamTest {

    public static void main(String[] args) {
        String pathname = "E:/MyTestWorkspace2020/autor-demo/src/main/java/com/ofben/autordemo/test/io/bytes/FileInputStreamTest.java";
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File(pathname));
            byte[] buffer = new byte[1024];
            int count = 0;
            while ((count = fis.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, count));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
