package com.ofben.autordemo.callback.demo2;

import java.util.List;
import java.util.logging.Logger;

public class test {
    private final Logger logger = Logger.getLogger(getClass().getName());

    public static void main(String[] args) {
        A a = new A();
        // 实现词库元素的删除
        a.execute(new CallBackInterface() {
            @Override
            public Object process(List param) {
                param.remove("1");
                return true;
            }
        });

        // 实现词库元素的添加
        a.execute(new CallBackInterface() {
            @Override
            public Object process(List param) {
                param.add("24");
                return true;
            }
        });
    }
}
