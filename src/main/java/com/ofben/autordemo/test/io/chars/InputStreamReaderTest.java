package com.ofben.autordemo.test.io.chars;

import java.io.*;

/**
 * {@link InputStreamReader}
 *
 * 汉字，￥测试
 *
 * @date 2021-09-10
 * @since 1.0.0
 */
public class InputStreamReaderTest {

    public static void main(String[] args) {
        String pathname = "E:/MyTestWorkspace2020/autor-demo/src/main/java/com/ofben/autordemo/test/io/chars/InputStreamReaderTest.java";

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        try {
            fis = new FileInputStream(pathname);
            isr = new InputStreamReader(fis,"UTF-8");
            br = new BufferedReader(isr);

            String read;
            while ((read = br.readLine()) != null) {
                System.out.println(read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
