package com.ofben.autordemo.actor.invoke.common.interactive;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 封装客户端调用传递过来的参数的 model
 *
 * @date 2021-08-16
 * @since 1.0.0
 */
@Data
public class InteractiveModel {

    private String opeType;

    private Map<String, Object> map = new HashMap<>();
}
