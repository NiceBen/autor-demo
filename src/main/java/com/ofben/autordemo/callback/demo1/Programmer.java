package com.ofben.autordemo.callback.demo1;

import com.ofben.autordemo.callback.demo1.pool.StudyThread;

/**
 * 程序员类
 */
public class Programmer {

    public void study(CallbackInterface callback) {
        new StudyThread(callback).start();
    }
}
