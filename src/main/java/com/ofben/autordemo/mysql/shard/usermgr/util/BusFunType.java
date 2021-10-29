package com.ofben.autordemo.mysql.shard.usermgr.util;

/**
 * 业务类型
 *
 * @date 2021-10-29
 * @since 1.0.0
 */
public enum BusFunType {

    BUS_USER("tbl_user"),
    BUS_ORDER("tbl_order");

    private String tableName;

    BusFunType(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }
}
