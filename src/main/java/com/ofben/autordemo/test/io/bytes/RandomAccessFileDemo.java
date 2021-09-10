package com.ofben.autordemo.test.io.bytes;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * {@link RandomAccessFile} Test
 *
 * @date 2021-09-09
 * @since 1.0.0
 */
public class RandomAccessFileDemo {

    public static void main(String[] args) {
        String pathname = "E:/myJava/world.txt";
        deleteExistsFile(pathname);

        try {
            RandomAccessFile raf = new RandomAccessFile(pathname, "rw");
            String str1 = "晴天，阴天，多云，小雨，大风，中雨，小雪，雷阵雨";
            String str2 = new String(str1.getBytes("GBK"), "ISO-8859-1");
            raf.writeBytes(str2);
            // -----
            System.out.println("当前文件指针的位置：" + raf.getFilePointer());
            raf.seek(0);
            System.out.println("从头文件跳过 6 个字节，现在文件内容如下：");
            byte[] buffer = new byte[2];
            int len = 0;
            while ((len = raf.read(buffer, 0, 2)) != -1) {
                System.out.println("||");
                System.out.println(new String(buffer, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deleteExistsFile(String pathname) {
        try {
            File file = new File(pathname);
            ifExistAndCreate(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ifExistAndCreate(File file) throws IOException {
        if (!file.exists()) {
            String parent = file.getParent();
            System.out.println("parent：" + parent);
            System.out.println("-----");
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            file.createNewFile();
        }
    }
}
