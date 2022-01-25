package com.ofben.autordemo.callback.demo2;

import java.util.List;

public interface CallBackInterface<T> {
    <T> T process(List<Object> param);
}
