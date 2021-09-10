package com.ofben.autordemo.test.io.chars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * {@link InputStreamReader}
 * {@link System#in}
 *
 * @date 2021-09-10
 * @since 1.0.0
 */
public class InputStreamReaderSystemInTest {

    public static void main(String[] args) {
        InputStreamReader isr = null;
        BufferedReader br = null;

        try {
            InputStream in;
            isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);

            String read;
            while ((read = br.readLine()) != null) {
                if (read.equals("exit")) {
                    System.exit(1);
                }
                System.out.println("input data : " + read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
