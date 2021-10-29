package com.ofben.autordemo.mysql.shard.usermgr.util.dto;

import lombok.Data;

import java.util.List;

/**
 * TODO
 *
 * @date 2021-10-29
 * @since 1.0.0
 */
@Data
public class ShardServerModel {

    private String serverName;

    private List<ShardTableModel> tableModels;

    private List<String> tableNames;
}
