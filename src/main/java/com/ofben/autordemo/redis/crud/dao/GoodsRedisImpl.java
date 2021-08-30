package com.ofben.autordemo.redis.crud.dao;

import com.ofben.autordemo.actor.invoke.common.interactive.modulemgr.utils.JsonHelper;
import com.ofben.autordemo.redis.crud.model.GoodsModel;
import com.ofben.autordemo.redis.crud.model.GoodsQueryModel;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Redis 客户端
 *
 * @date 2021-08-26
 * @since 1.0.0
 */
@Service
@Primary
public class GoodsRedisImpl implements GoodsRedisDAO {

    private final JedisPool pool = RedisHelper.getPool();

    private static final String GoodsUuidsL = "GoodsUuidsL";

    @Override
    public void create(GoodsModel m) {
        Jedis jedis = pool.getResource();

        Map<String, String> map = new HashMap<>();
        map.put("uuid", String.valueOf(m.getUuid()));
        map.put("name", m.getName());
        map.put("imgPath", m.getImgPath());
        map.put("description", m.getDescription());

        jedis.hmset("GoodsH:" + m.getUuid(), map);

        // 在 list 中添加 uuid
        jedis.lpush(GoodsUuidsL, String.valueOf(m.getUuid()));

        jedis.close();
    }

    @Override
    public void update(GoodsModel m) {
        Jedis jedis = pool.getResource();

        Map<String, String> map = new HashMap<>();
        map.put("uuid", String.valueOf(m.getUuid()));
        map.put("name", m.getName());
        map.put("imgPath", m.getImgPath());
        map.put("description", m.getDescription());

        jedis.hmset("GoodsH:" + m.getUuid(), map);

        jedis.close();
    }

    @Override
    public void delete(int uuid) {
        Jedis jedis = pool.getResource();
        jedis.del("GoodsH:" + uuid);

        // 在 list 删除
        jedis.lrem(GoodsUuidsL, 1, String.valueOf(uuid));
        jedis.close();
    }

    @Override
    public GoodsModel getByUuid(int uuid) {
        Jedis jedis = pool.getResource();

        Map<String, String> map = jedis.hgetAll("GoodsH:" + uuid);

        GoodsModel gm = new GoodsModel();
        gm.setUuid(uuid);
        gm.setName(map.get("name"));
        gm.setName(map.get("imgPath"));
        gm.setName(map.get("description"));

        // 在 list 删除
        jedis.close();

        return gm;
    }

    @Override
    public List<GoodsModel> getByConditionPage(GoodsQueryModel qm, int nowPage, int pageShow) {
        List<GoodsModel> retList = new ArrayList<>();
        Jedis jedis = pool.getResource();

        List<String> keys = new ArrayList<>();
        List<String> args = new ArrayList<>();

        String qmStr = JsonHelper.object2str(qm);
        args.add(qmStr);
        System.out.println("args=" + args);

        String path = "GoodsDAOGetByCondition.lua";
        String script = RedisHelper.getScript(path);
        if (StringUtils.hasText(script)) {
            Object obj = jedis.eval(script, keys, args);
            List<String> list = (List<String>) obj;
            for (String s : list) {
                if (s.indexOf("totalCount") < 0) {
                    GoodsModel gm = (GoodsModel) JsonHelper.str2Object(s, GoodsModel.class);
                    retList.add(gm);
                } else {
                    int begin = s.indexOf("totalCount") + "totalCount".length();
                    int end = s.lastIndexOf("}");
                    String countStr = s.substring(begin, end);
                    System.out.println("countStr" + countStr);
                    qm.getPage().setTotalCount(Integer.valueOf(countStr));
                }
            }
            System.out.println("obj===" + obj);
        }

        jedis.close();
        return retList;
    }

    public static void main(String[] args) {
        GoodsRedisImpl t = new GoodsRedisImpl();

//        GoodsModel gm = new GoodsModel();
//        gm.setUuid(3);
//        gm.setName("n3");
//        gm.setImgPath("p3");
//        gm.setDescription("d3");
//
//        t.create(gm);


        GoodsQueryModel qm = new GoodsQueryModel();
        qm.setUuid(3);
        qm.setName("n3");

        qm.getPage().setNowPage(1);
        qm.getPage().setPageShow(2);

        List<GoodsModel> list = t.getByConditionPage(qm, 2, 2);
        System.out.println("list" + list);
    }

    @Override
    public List<Integer> getIdsByConditionPage(GoodsQueryModel gqm) {
        return null;
    }

    @Override
    public List<GoodsModel> getByIds(String ids) {
        return null;
    }
}
