package com.ofben.autordemo.test.io.bytes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * {@link OutputStream}
 *
 * @date 2021-09-09
 * @since 1.0.0
 */
public class OutputStreamTest {

    public static void main(String[] args) {
        String pathname = "E:" + File.separator + "myJava" + File.separator + "world2.txt";
        OutputStream output = null;
        try {
            File file = new File(pathname);
            output = new FileOutputStream(file);

//            testOutputSteamWriteNone(output);

//            testOutputSteamWriteByte(output);

            testOutputSteamWriteByteOffLen(output);

            // 冲刷输出流
            output.flush();
            System.out.println("输出完成！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void testOutputSteamWriteByteOffLen(OutputStream output) throws IOException {
        String str = "helloworld123你好";
        byte[] bytes = str.getBytes();
        output.write(bytes, 0, 10);
    }

    private static void testOutputSteamWriteByte(OutputStream output) throws IOException {
        String str = "helloworld123你好";
        byte[] bytes = str.getBytes();
        output.write(bytes);
    }

    private static void testOutputSteamWriteNone(OutputStream output) throws IOException {
        output.write(110);
        output.write(111);
        output.write(112);
        output.write(112);
    }
}
