package com.ofben.autordemo.test.reflect.collection;

import javax.swing.*;
import java.util.Date;

/**
 * ObjectFactory
 *
 * @date 2021-09-14
 * @since 1.0.0
 */
public class ObjectFactory {

    public static <T> T getInstance(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Date date = ObjectFactory.getInstance(Date.class);
        JFrame jFrame = ObjectFactory.getInstance(JFrame.class);
    }
}
