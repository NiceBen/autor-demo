package com.ofben.autordemo.test.io;

import org.apache.commons.lang3.ArrayUtils;

import java.io.File;

/**
 * File list
 *
 * @date 2021-09-08
 * @since 1.0.0
 */
public class Test05 {

    /*
        http://c.biancheng.net/view/1133.html
     */
    public static void main(String[] args) {
        String prefix = "E:" + File.separator + "DingDingTalk" + File.separator;
        File file = new File(prefix);
        System.out.println("文件名称\t\t文件类型\t\t文件大小");
        System.out.println("-----------------------------");
        int retract = -1;
        show(file, retract);
    }

    private static void show(File file, int retract) {
        retract++;
        String[] list = file.list();
        if (ArrayUtils.isNotEmpty(list)) {
            for (int i = 0, length = list.length; i < length; i++) {
                String absolutePath = file.getAbsolutePath();
                String filePath = absolutePath + File.separator + list[i];
                System.out.println("path：" + filePath);

                for (int j = 0; j < retract; j++) {
                    System.out.print("\t\t");
                }
                System.out.print(list[i] + "\t\t");
                System.out.print((new File(filePath).isFile()?"是文件":"目录") + "\t\t");
                System.out.println((new File(filePath).length() + "字节"));
                if (new File(filePath).isDirectory()) {
                    show(new File(filePath), retract);
                }
            }
        }
    }
}
