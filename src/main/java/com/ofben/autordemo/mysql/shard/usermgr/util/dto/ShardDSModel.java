package com.ofben.autordemo.mysql.shard.usermgr.util.dto;

import lombok.Data;

import java.util.List;

/**
 * 1.0.0
 *
 * @date 2021-10-29
 * @since 1.0.0
 */
@Data
public class ShardDSModel {

    private List<ShardServerModel> serverModels;
}
