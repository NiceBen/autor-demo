package com.ofben.autordemo.actor.invoke.common.interactive.modulemgr.vo;

import lombok.Data;

/**
 * 模块管理的 model
 *
 * @author SL Zhou
 * @date 2021-08-16
 * @since 1.0.0
 */
@Data
public class ModuleModel {

    private String uuid;

    private String moduleId;

    private String moduleName;

    private String deployIP;

    private String deployPort;

    private String interactiveUrl;

    private String depends;
}
