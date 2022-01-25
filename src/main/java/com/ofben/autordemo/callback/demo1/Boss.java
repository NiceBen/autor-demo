package com.ofben.autordemo.callback.demo1;


/**
 * Boss 执行类
 */
public class Boss {

    public static void main(String[] args) {
        Manager manager = new Manager(new Programmer());
        manager.entrust();
    }
}
