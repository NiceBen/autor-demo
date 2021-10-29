package com.ofben.autordemo.mysql.shard.usermgr.util;

import java.util.List;

/**
 * TODO
 *
 * @date 2021-10-29
 * @since 1.0.0
 */
public class ShardServerModel {

    private String serverName;

    private List<ShardTableModel> tableModels;

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public List<ShardTableModel> getTableModels() {
        return tableModels;
    }

    public void setTableModels(List<ShardTableModel> tableModels) {
        this.tableModels = tableModels;
    }
}
