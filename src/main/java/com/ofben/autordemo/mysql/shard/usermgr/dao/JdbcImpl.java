package com.ofben.autordemo.mysql.shard.usermgr.dao;

import com.ofben.autordemo.mysql.shard.usermgr.vo.UserModel;
import com.ofben.autordemo.mysql.shard.usermgr.vo.UserModelRowMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.*;

/**
 * jdbcImpl
 *
 * @date 2021-10-29
 * @since 1.0.0
 */
public class JdbcImpl implements UserDao {

    private DataSource ds = null;

    private String tblName = "";

    private ApplicationContext ctx = null;

    @Override
    public void create(UserModel um) {

        /*
        TODO -- 这里已知我们要找的是“tbl_user”，
         根据这个去查找“tbl_shard”，再查找“tbl_shardDetail”,
         然后再查“tbl_servers”，根据属性配置，找到 DataSource 和 真实的表名
         */
        ds = (DataSource) ctx.getBean("ds" + "s1");
        tblName = "tbl_user_1";


        JdbcTemplate jt = new JdbcTemplate(ds);
        jt.execute("insert into " + tblName +
                " values(" + um.getUuid() + ",'" + um.getName() + "')");
    }

    public List<UserModel> getAll() {
        // 包含 beginNum

        Map<String, String> map = new HashMap<>();
        map.put("s1", "tbl_user_0,tbl_user_1");
//        map.put("s2", "tbl_user");

        List<UserModel> retList = new ArrayList<>();
        Set<String> set = map.keySet();
        for (String dsName : set) {
            ds = (DataSource) ctx.getBean("ds" + dsName);
            JdbcTemplate jt = new JdbcTemplate(ds);
            String tblNames = map.get(dsName);
            if (tblNames.contains(",")) {
                String[] ss = tblNames.split(",");
                for (String s : ss) {
                    String sql = "SELECT * FROM " + s;
//                    List<UserModel> tempList = jt.queryForList(sql, UserModel.class);
                    List<UserModel> tempList = jt.query(sql, new UserModelRowMapper());
                    retList.addAll(tempList);
//                    List<Map<String, Object>> temp = jt.queryForList(sql);
//                    System.out.println(temp);
                }
            } else {
                String sql = "SELECT * FROM " + tblNames;
                System.out.println("sql===" + sql);
//                List<UserModel> tempList = jt.queryForList(sql, UserModel.class);
                List<UserModel> tempList = jt.query(sql, new UserModelRowMapper());
                retList.addAll(tempList);
            }
        }
        System.out.println("retList==" + retList);
        return retList;
    }

    public static void main(String[] args) {
        JdbcImpl t = new JdbcImpl();
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("classpath:/mysql-shards/applicationContext-shard-db.xml");
        t.ctx = appCtx;

        UserModel um = new UserModel();
        um.setUuid(11);
        um.setName("name11");

//        t.create(um);
        t.getAll();
    }
}
