package com.ofben.autordemo.staticize;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * 生成 HTML
 *
 * @author SL Zhou
 * @date 2021-08-19
 * @since 1.0.0
 */
public class GenHtml {

    // 存放在内存中的HTML静态文件
    public static Map<String, byte[]> mapHtml = new HashMap<>();

    /**
     * 生成静态的html
     */
    public void genStaticHtml() {
        try {
            // 1.直接使用 url 去获取内容
//            String urlStr = "http://localhost:9080/front/toIndex?gen=true";
            String urlStr = "http://192.168.1.106:8080/front/toIndex?gen=true";
            URL url = new URL(urlStr);

            BufferedInputStream bin = new BufferedInputStream(url.openStream());
//            byte[] bs = new byte[bin.available()];
            byte[] bs = new byte[10000];
            bin.read(bs);
            // 2.存储方式：1写入内存；2写入文件中
            if (bs != null && bs.length > 1) {
                mapHtml.put("toIndex", bs);
            } else {
                System.out.println("未读取到数据！");
            }
            bin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 启动生成静态html的线程
     */
    public void startGenStaticHtml() {
        Thread t = new GenHtmlThread();
        t.start();
    }

    private class GenHtmlThread extends Thread {
        @Override
        public void run() {
            // 将当前线程启动自循环
            while (true){
                try {
                    // 1.休息
                    Thread.sleep(20000L);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // 2.调用生成
                genStaticHtml();
            }
        }
    }
}
