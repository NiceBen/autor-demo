package com.ofben.autordemo.mysql.shard.usermgr.dao;

import com.ofben.autordemo.mysql.shard.usermgr.vo.UserModel;

/**
 * DAO
 *
 * @date 2021-10-29
 * @since 1.0.0
 */
public interface UserDao {

    void create(UserModel um);
}
