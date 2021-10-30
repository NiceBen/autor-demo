package com.ofben.autordemo.mysql.shard.usermgr.util;

import com.ofben.autordemo.mysql.shard.usermgr.util.dao.TblServers;
import com.ofben.autordemo.mysql.shard.usermgr.util.dao.TblShardDetails;
import com.ofben.autordemo.mysql.shard.usermgr.util.dao.TblShards;
import com.ofben.autordemo.mysql.shard.usermgr.util.dto.ShardDSModel;
import com.ofben.autordemo.mysql.shard.usermgr.util.dto.ShardServerModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.*;

/**
 * 分库分表的DateSource和表查询工具
 *
 * @date 2021-10-29
 * @since 1.0.0
 */
public class ShardDSUtil {

    public static List<ShardServerModel> getShardDSModel(BusFunType type, int num) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/mysql-shards/applicationContext-shard-db.xml");
        DataSource shardDS = (DataSource) ctx.getBean("shardDS");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(shardDS);

        // 查询 tbl_shards
        String shards_sql = "SELECT * FROM `tbl_shards` WHERE tblName = '" + type.getTableName()
                + "' AND (idBegin <= " + num + " AND " + num + " <=idEnd)";
        List<TblShards> shardsList = jdbcTemplate.query(shards_sql,BeanPropertyRowMapper.newInstance(TblShards.class));

        TblShards tblShards = shardsList.get(0);

        String groupId = tblShards.getGroupId();
        int modNum = tblShards.getModNum();
        // 查询 tbl_shardDetails
        String shardDetails_sql = "SELECT * FROM `tbl_shardDetails` WHERE groupId = '" + groupId
                + "' AND (idBegin <= " + num + " AND " + num + " <=idEnd)";
        List<TblShardDetails> shardDetailsList = jdbcTemplate.query(shardDetails_sql,BeanPropertyRowMapper.newInstance(TblShardDetails.class));

        Map<Integer, List<String>> resultMap = new HashMap<>();
        shardDetailsList.forEach(detail -> {
            String modValue = detail.getModValue();
            String[] splitModNum = modValue.split(",");
            List<String> stringList = Arrays.asList(splitModNum);
            int trueModValue = num % modNum;
            if (stringList.contains(""+trueModValue)) {
                // 将这个条数据拿出来用
                int serverUuid = detail.getServerUuid();
                List<String> shardTblNames = resultMap.get(serverUuid);
                if (shardTblNames == null) {
                    shardTblNames = new ArrayList<>();
                }
                String shardTblName = detail.getShardTblName();
                shardTblNames.add(shardTblName);
                resultMap.put(serverUuid, shardTblNames);

            }
        });

        List<ShardServerModel> serverModels = new ArrayList<>();
        Set<Integer> keySet = resultMap.keySet();
        keySet.forEach(key -> {
            // 查询 tbl_servers 表
            String servers_sql = "SELECT * FROM tbl_servers WHERE uuid = 1";
            List<TblServers> servers = jdbcTemplate.query(servers_sql, BeanPropertyRowMapper.newInstance(TblServers.class));
            String sid = servers.get(0).getSid();

            ShardServerModel serverModel = new ShardServerModel();
            serverModel.setServerName(sid);
            serverModel.setTableNames(resultMap.get(key));
            serverModels.add(serverModel);
        });

        return serverModels;
    }

    public static void main(String[] args) {

        List<ShardServerModel> shardDSModel = getShardDSModel(BusFunType.BUS_USER, 12);
        System.out.println("----------------");
        System.out.println(shardDSModel);
    }


}
