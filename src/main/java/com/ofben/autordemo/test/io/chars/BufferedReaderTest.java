package com.ofben.autordemo.test.io.chars;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * {@link BufferedReader}
 *
 * @date 2021-09-10
 * @since 1.0.0
 */
public class BufferedReaderTest {

    public static void main(String[] args) {
        String pathname = "E:/MyTestWorkspace2020/autor-demo/src/main/java/com/ofben/autordemo/test/io/chars/BufferedReaderTest.java";

        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(pathname);
            br = new BufferedReader(fr);

            String read;
            while ((read = br.readLine()) != null) {
                System.out.println(read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
