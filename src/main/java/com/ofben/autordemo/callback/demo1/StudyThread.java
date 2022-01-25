package com.ofben.autordemo.callback.demo1.pool;

import com.ofben.autordemo.callback.demo1.CallbackInterface;

public class StudyThread extends Thread {

    private CallbackInterface callback;

    public StudyThread(CallbackInterface callback) {
        this.callback = callback;
    }

    @Override
    public void run() {
        int result = 0;
        do {
            result++;
            System.out.println("第 " + result + " 次研究的结果");
        } while (!callback.check(result));
        System.out.println("调研任务结束");
    }
}
