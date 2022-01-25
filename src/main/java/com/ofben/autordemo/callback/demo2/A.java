package com.ofben.autordemo.callback.demo2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class A {
    public List<String> wordList = loadList();

    public <T> T execute(CallBackInterface callback) {
        // 执行其他逻辑

        T result = (T) callback.process(wordList);
        return result;
    }

    // 加载词库到内存
    public List<String> loadList() {
        List<String> worldList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            worldList.add(Integer.toString(i));
        }
        return worldList;
    }

    public static void main(String[] args) {
        File file = new File("hello");
    }
}
