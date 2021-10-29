package com.ofben.autordemo.mysql.shard.usermgr.util;

import java.util.List;

/**
 * 1.0.0
 *
 * @date 2021-10-29
 * @since 1.0.0
 */
public class ShardDSModel {

    private List<ShardServerModel> serverModels;

    public List<ShardServerModel> getServerModels() {
        return serverModels;
    }

    public void setServerModels(List<ShardServerModel> serverModels) {
        this.serverModels = serverModels;
    }
}
