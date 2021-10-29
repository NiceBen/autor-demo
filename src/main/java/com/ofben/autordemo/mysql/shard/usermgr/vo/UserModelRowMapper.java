package com.ofben.autordemo.mysql.shard.usermgr.vo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 通过表映射，解决template查询返回对象错误
 *
 * @date 2021-10-29
 * @since 1.0.0
 */
public class UserModelRowMapper implements RowMapper<UserModel> {
    @Override
    public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        // 对数据的返回处理
        UserModel um = new UserModel();
        um.setUuid(rs.getInt("uuid"));
        um.setName(rs.getString("name"));
        return um;
    }
}
