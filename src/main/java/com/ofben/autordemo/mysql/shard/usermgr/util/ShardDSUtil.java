package com.ofben.autordemo.mysql.shard.usermgr.util;

import com.ofben.autordemo.mysql.shard.usermgr.util.dao.TblShardDetails;
import com.ofben.autordemo.mysql.shard.usermgr.util.dao.TblShards;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 分库分表的DateSource和表查询工具
 *
 * @date 2021-10-29
 * @since 1.0.0
 */
public class ShardDSUtil {


    public static ShardDSModel getShardDSModel(BusFunType type, int num) {
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
        shardDetailsList.forEach(detail -> {
            String modValue = detail.getModValue();
            String[] splitModNum = modValue.split(",");
            List<String> stringList = Arrays.asList(splitModNum);
            int trueModValue = num % modNum;
            if (stringList.contains(trueModValue)) {
                // 将这个条数据拿出来用
                // TODO -- LL
            }

        });



        return null;
    }

    public static void main(String[] args) {

        getShardDSModel(BusFunType.BUS_USER, 12);
    }


}
