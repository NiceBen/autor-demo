package com.ofben.autordemo.test.reflect.demo;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * {@link Method}
 * {@link Student}
 *
 * @date 2021-09-14
 * @since 1.0.0
 */
public class PropertiesTest {

    public static void main(String[] args) throws Exception {
        //通过反射获取Class对象
        Class<?> aClass = Class.forName(getValue("className"));
        //2获取show()方法
        Method method = aClass.getMethod(getValue("methodName"));
        //3.调用show()方法
        method.invoke(aClass.getConstructor().newInstance());
    }

    private static String getValue(String key) throws IOException {
        Properties prop = new Properties();
        FileReader fr = new FileReader("E:/MyTestWorkspace2020/autor-demo/src/main/resources/pro.txt");
        prop.load(fr);
        fr.close();
        return prop.getProperty(key);
    }
}
