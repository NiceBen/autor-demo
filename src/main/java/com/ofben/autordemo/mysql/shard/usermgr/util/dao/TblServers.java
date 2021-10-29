package com.ofben.autordemo.mysql.shard.usermgr.util.dao;

import lombok.Data;

/**
 * tab_servers
 *
 * @date 2021-10-29
 * @since 1.0.0
 */
@Data
public class TblServers {

    private int uuid;

    private String sid;

    private String ip;

    private int port;

    private String repName;

    private int isMain;

    private int canRead;

    private int canWrite;

    private String state;

    private String equalsServers;
}
