package com.ofben.autordemo.test.io.bytes;

import java.io.*;

/**
 * {@link InputStream#read()}
 * {@link InputStream#read(byte[])}
 * {@link InputStream#read(byte[], int, int)}
 * {@link BufferedInputStream}
 *
 * @date 2021-09-09
 * @since 1.0.0
 */
public class InputStreamTest {

    public static void main(String[] args) {
        String pathname = "E:" + File.separator + "myJava" + File.separator + "world.txt";
//        testInputSteamReadNone(pathname);
//        testInputSteamReadBuffer(pathname);
//        testInputSteamReadBufferOffLen(pathname);
//        testInputSteamOtherMethods(pathname);

//        testBufferedInputStream(pathname);
    }

    private static void testBufferedInputStream(String pathname) {
        InputStream input = null;
        try {
            File file = new File(pathname);
            input = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(input);
            byte[] buffer = new byte[1024];
            while (bis.read(buffer, 0, 1024) != -1) {
                System.out.println(new String(buffer));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void testInputSteamOtherMethods(String pathname) {
        InputStream input = null;
        try {
            File file = new File(pathname);
            input = new FileInputStream(file);

            System.out.println("available:" + input.available());
//            System.out.println("skip:" + input.skip(50));
            if (input.markSupported()) {
                System.out.println("当前流支持 mark 标记！");
                input.mark(5);
                input.reset();
            } else {
                System.out.println("当前流不支持 mark 标记！");
            }

            byte[] buffer = new byte[100];
            while (input.read(buffer) != -1) {
                System.out.println(new String(buffer));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void testInputSteamReadBufferOffLen(String pathname) {
        InputStream input = null;
        try {
            File file = new File(pathname);
            input = new FileInputStream(file);
            byte[] buffer = new byte[100];
            int index = 0;
            int count = 0;
            while ((count = input.read(buffer, index, 6)) != -1) {
                index = index + count;
                System.out.println(new String(buffer));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void testInputSteamReadNone(String pathname) {
        InputStream input = null;
        try {
            File file = new File(pathname);
            input = new FileInputStream(file);
            int read;
            while ((read = input.read()) != -1) {
                System.out.print((char) read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void testInputSteamReadBuffer(String pathname) {
        InputStream input = null;
        try {
            File file = new File(pathname);
            input = new FileInputStream(file);
            byte[] buffer = new byte[100];
            while (input.read(buffer) != -1) {
                System.out.println(new String(buffer));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
