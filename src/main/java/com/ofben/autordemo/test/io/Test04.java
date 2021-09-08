package com.ofben.autordemo.test.io;

import java.io.File;
import java.io.IOException;

/**
 * 创建和删除文件
 *
 * @date 2021-09-08
 * @since 1.0.0
 */
public class Test04 {

    public static void main(String[] args) throws IOException {

        String filePath = "e:" + File.separator + "hello" + File.separator + "world.txt";
        File file = new File(filePath);
//        String fileName = filePath.substring(filePath.lastIndexOf("/")+1);
        String fileDirectory = filePath.substring(0, filePath.lastIndexOf(File.separator) + 1);

        if (file.exists()) {
            boolean delete = file.delete();
            if (delete) {
                file.createNewFile();
            } else {
                System.out.println("文件存在，删除失败！");
            }
        } else {
            File fileD = new File(fileDirectory);
            if (fileD.exists()) {
                file.createNewFile();
            } else {
                boolean mkdirs = fileD.mkdirs();
                if (mkdirs) {
                    file.createNewFile();
                }
            }
        }
    }

}
