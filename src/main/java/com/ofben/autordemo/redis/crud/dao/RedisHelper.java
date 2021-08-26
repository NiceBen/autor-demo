package com.ofben.autordemo.redis.crud.dao;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.File;
import java.io.FileInputStream;

/**
 * 单例模式创建 JedisPool
 *
 * @author SL Zhou
 * @date 2021-08-26
 * @since 1.0.0
 */
public class RedisHelper {

    private RedisHelper() {
    }

    private static JedisPool pool = null;

    public static synchronized JedisPool getPool() {
        if (pool == null) {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(10);
            config.setMinIdle(8);
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
