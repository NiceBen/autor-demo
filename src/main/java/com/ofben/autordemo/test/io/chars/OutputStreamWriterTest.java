package com.ofben.autordemo.test.io.chars;

import java.io.*;

/**
 * {@link OutputStreamWriter}
 *
 * @date 2021-09-10
 * @since 1.0.0
 */
public class OutputStreamWriterTest {

    public static void main(String[] args) {
        String inPathname = "E:/MyTestWorkspace2020/autor-demo/src/main/java/com/ofben/autordemo/test/io/chars/OutputStreamWriterTest.java";
        String outPathname = "E:/myJava/world6.txt";

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        try {
            fis = new FileInputStream(inPathname);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);

            fos = new FileOutputStream(outPathname);
            osw = new OutputStreamWriter(fos);
            bw = new BufferedWriter(osw);

            String read;
            while ((read = br.readLine()) != null) {
                bw.write(read);
                bw.newLine();
            }

            bw.flush();
            System.out.println("Stream Operation Complete.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();

                bw.close();
                osw.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
