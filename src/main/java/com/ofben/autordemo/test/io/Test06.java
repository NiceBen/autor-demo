package com.ofben.autordemo.test.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;

/**
 * {@link File#list(FilenameFilter)} Test
 *
 * @date 2021-09-09
 * @since 1.0.0
 */
public class Test06 {

    public static void main(String[] args) {
        String filePath = "E:\\DingDingTalk\\DingDing";
        File file = new File(filePath);
        String[] list = file.list(new ImageFilter());
        for (String path : list) {
            File innerFile = new File(filePath + File.separator + path);
            System.out.print(innerFile.getName() + "\t\t");
            System.out.print(innerFile.isFile() ? "File" : "Directory");
            System.out.println("\t\t" + innerFile.length());
        }
    }
}

class ImageFilter implements FilenameFilter {

    @Override
    public boolean accept(File dir, String name) {
        if (name.endsWith(".exe") || name.endsWith(".txt")) {
            return true;
        }
        return false;
    }
}
