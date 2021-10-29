package com.ofben.autordemo.mysql.shard.usermgr.util.dao;

import lombok.Data;

/**
 * tab_shards
 *
 * @date 2021-10-29
 * @since 1.0.0
 */
@Data
public class TblShards {

    private int uuid;

    private String tblName;

    private int idBegin;

    private int idEnd;

    private String groupId;

    private int modNum;
}
