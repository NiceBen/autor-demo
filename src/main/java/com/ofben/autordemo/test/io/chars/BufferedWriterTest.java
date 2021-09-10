package com.ofben.autordemo.test.io.chars;

import org.mortbay.util.IO;

import java.io.*;

/**
 * {@link BufferedWriter}
 *
 * @date 2021-09-10
 * @since 1.0.0
 */
public class BufferedWriterTest {

    public static void main(String[] args) {
        String inPathname = "E:/MyTestWorkspace2020/autor-demo/src/main/java/com/ofben/autordemo/test/io/chars/BufferedWriterTest.java";
        String outPathname = "e:/myJava/world5.txt";

        FileReader fr = null;
        BufferedReader br = null;

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fr = new FileReader(inPathname);
            br = new BufferedReader(fr);

            fw = new FileWriter(outPathname);
            bw = new BufferedWriter(fw);

            String read;
            while ((read = br.readLine()) != null) {
                bw.write(read);
                bw.newLine();
            }

            bw.flush();
            System.out.println("Stream operation complete！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                fr.close();

                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
