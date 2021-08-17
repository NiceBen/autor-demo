package com.ofben.autordemo.actor.invoke.common.interactive.modulemgr.utils;

import com.alibaba.fastjson.JSON;
import com.ofben.autordemo.actor.invoke.common.interactive.InteractiveModel;

/**
 * 模块交互调用的辅助工具类
 *
 * @author SL Zhou
 * @date 2021-08-16
 * @since 1.0.0
 */
public class InteractiveUtil {

    private InteractiveUtil() {}

    public static InteractiveModel paramJson2Model(String jsonParam) {
        return JSON.parseObject(jsonParam, InteractiveModel.class);
    }

    public static <T> T retJson2Model(String json, Class<T> cls) {
        return JSON.parseObject(json, cls);
    }
}
