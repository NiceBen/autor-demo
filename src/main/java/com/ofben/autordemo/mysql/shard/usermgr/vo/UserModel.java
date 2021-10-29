package com.ofben.autordemo.mysql.shard.usermgr.vo;

import java.io.Serializable;

/**
 * Bean
 *
 * @date 2021-10-29
 * @since 1.0.0
 */
public class UserModel implements Serializable {
    private static final long serialVersionUID = 7231318688412486484L;

    private int uuid;

    private String name;

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                '}';
    }
}
