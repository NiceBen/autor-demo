package com.ofben.autordemo.test.io;

import java.io.File;
import java.util.Date;

/**
 * 常量属性打印
 *
 * @date 2021-09-08
 * @since 1.0.0
 */
public class Test03 {

    public static void main(String[] args) {
        String path = "E:/MyTestWorkspace2020/autor-demo/src/main/java/com/ofben/autordemo/test/io/";
        File f = new File(path, "Test03.java");
        System.out.println("Test03.java 文件信息如下：");
        System.out.println("-------------------------");
        System.out.println("文件长度：" + f.length() + "字节");
        System.out.println("文件或者目录：" + (f.isFile()?"是文件":"不是文件"));
        System.out.println("文件或者目录：" + (f.isDirectory()?"是目录":"不是目录"));
        System.out.println("是否可读：" + (f.canRead()?"可读":"不可读"));
        System.out.println("是否可写：" + (f.canWrite()?"可写":"不可写"));
        System.out.println("是否隐藏：" + (f.isHidden()?"隐藏":"显示"));
        System.out.println("最后修改日期：" + new Date(f.lastModified()));
        System.out.println("文件名称：" + f.getName());
        System.out.println("文件路径：" + f.getPath());
        System.out.println("绝对路径：" + f.getAbsolutePath());
    }
}
