package com.ofben.autordemo.mysql.shard.usermgr.util.dao;

import lombok.Data;

/**
 * tab_shardDetails
 *
 * @date 2021-10-29
 * @since 1.0.0
 */
@Data
public class TblShardDetails {

    private int uuid;

    private String groupId;

    private int serverUuid;

    private int idBegin;

    private int idEnd;

    private String modValue;

    private String shardTblName;
}
