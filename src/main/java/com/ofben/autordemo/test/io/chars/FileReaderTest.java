package com.ofben.autordemo.test.io.chars;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * {@link FileReader}
 *
 * @date 2021-09-09
 * @since 1.0.0
 */
public class FileReaderTest {

    public static void main(String[] args) {
        String pathname = "E:/MyTestWorkspace2020/autor-demo/src/main/java/com/ofben/autordemo/test/io/chars/FileReaderTest.java";

        FileReader fr = null;
        try {
            fr = new FileReader(new File(pathname));

//            testFileReaderNone(fr);

            testFileReaderBuffer(fr);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void testFileReaderBuffer(FileReader fr) throws IOException  {
        int read;
        char[] buffer = new char[1024];
        while ((read = fr.read(buffer, 0, buffer.length)) != -1) {
            System.out.print(new String(buffer,0, read));
        }
    }

    private static void testFileReaderNone(FileReader fr) throws IOException {
        int read;
        while ((read = fr.read()) != -1) {
            System.out.print((char) read);
        }
    }
}
