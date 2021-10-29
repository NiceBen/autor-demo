package com.ofben.autordemo.redis.crud.dao;

import org.springframework.util.CollectionUtils;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 单例模式创建 JedisPool
 *
 * @date 2021-08-26
 * @since 1.0.0
 */
public class RedisHelper2 {

    private RedisHelper2() {
    }

    private static JedisPool pool = null;

    private static Map<Integer, JedisPool> mapJp = new HashMap<>();

    public static JedisPool getPool(int port) {
        if (CollectionUtils.isEmpty(mapJp)) {
            JedisPoolConfig config1 = new JedisPoolConfig();
            config1.setMaxTotal(10);
            config1.setMinIdle(8);
            JedisPool jedisPool1 = new JedisPool(config1, "localhost", 6379);
            mapJp.put(6379, jedisPool1);

            JedisPoolConfig config2 = new JedisPoolConfig();
            config2.setMaxTotal(10);
            config2.setMinIdle(8);
            JedisPool jedisPool2 = new JedisPool(config2, "localhost", 6381);
            mapJp.put(6391, jedisPool2);

            JedisPoolConfig config3 = new JedisPoolConfig();
            config3.setMaxTotal(10);
            config3.setMinIdle(8);
            JedisPool jedisPool3 = new JedisPool(config3, "localhost", 6382);
            mapJp.put(6382, jedisPool3);

            JedisPoolConfig config4 = new JedisPoolConfig();
            config4.setMaxTotal(10);
            config4.setMinIdle(8);
            JedisPool jedisPool4 = new JedisPool(config4, "localhost", 6383);
            mapJp.put(6383, jedisPool4);
        }
        return mapJp.get(port);
    }

    public static synchronized JedisPool getPool() {
        if (pool == null) {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(10);
            config.setMinIdle(8);
            pool = new JedisPool(config, "localhost", 6379);
        }
        return pool;
    }

    public static String getScript(String path) {
        File f = new File(path);
        try {
            FileInputStream fis = new FileInputStream(f);
            byte[] bs = new byte[fis.available()];
            fis.read(bs);
            fis.close();
            return new String(bs);
        } catch (Exception err) {
            err.printStackTrace();
        }
        return "";
    }

}
