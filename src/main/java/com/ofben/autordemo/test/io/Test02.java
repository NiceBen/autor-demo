package com.ofben.autordemo.test.io;

import java.io.*;

/**
 * change byte[] encoding
 *
 * @date 2021-09-08
 * @since 1.0.0
 */
public class Test02 {

    public static void main(String[] args) throws Exception {
        File file = new File("E:\\Test02.txt");
        // 实例化输出流
        OutputStream out = new FileOutputStream(file);
        // 指定 ISO8859-1 编码
        byte[] b = "hello world ,你好世界".getBytes("ISO8859-1");
        // 保存转码之后的数据
        out.write(b);
        // 关闭输出流
        out.close();
    }
}
