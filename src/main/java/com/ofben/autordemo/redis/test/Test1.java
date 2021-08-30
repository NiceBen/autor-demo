package com.ofben.autordemo.redis.test;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.*;
import redis.clients.jedis.util.Sharded;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Redis test
 *
 * @date 2021-08-25
 * @since 1.0.0
 */
public class Test1 {

    public static void main(String[] args) {

        // 通过 Jedis 进行操作
//        doJedisOperation();

        // 通过 Cluster 操作
//        doClusterOperation();

        // 客户端分片
//        doClientShardOperation();

        // 连接池-客户端分片
        doClientShardPoolOperation();

    }

    private static void doClientShardPoolOperation() {
        JedisPoolConfig config = getJedisPoolConfig();
        List<JedisShardInfo> list = new ArrayList<>();
        list.add(new JedisShardInfo("localhost", 6381));
        list.add(new JedisShardInfo("localhost", 6382));

        ShardedJedisPool pool= new ShardedJedisPool(config, list, ShardedJedis.DEFAULT_KEY_TAG_PATTERN);

        try (ShardedJedis shardedJedis = pool.getResource()) {
            String k1 = shardedJedis.get("k1");
            System.out.println(k1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void doClientShardOperation() {
        List<JedisShardInfo> list = new ArrayList<>();
        list.add(new JedisShardInfo("localhost", 6381));
        list.add(new JedisShardInfo("localhost", 6382));

        ShardedJedis shardedJedis = new ShardedJedis(list, ShardedJedis.DEFAULT_KEY_TAG_PATTERN);
        ShardedJedis shardedJedis2 = new ShardedJedis(list, Sharded.DEFAULT_KEY_TAG_PATTERN);

        shardedJedis.set("{K}ingabcd", "king");
        shardedJedis.set("{K}1", "k1");

//        String k1 = shardedJedis.get("k1");
//        String kkk = shardedJedis.get("Kingabcd");
//        System.out.println(k1);


        // 查询使用了哪个 Sharded
        JedisShardInfo shardInfo = shardedJedis.getShardInfo("{K}ingabcd");
        JedisShardInfo shardInfo2 = shardedJedis.getShardInfo("{K}1");
        System.out.println("k1在" + shardInfo + ":" + "k2在" + shardInfo2);
    }

    private static void doClusterOperation() {
        Set<HostAndPort> sets = new HashSet<>();
        sets.add(new HostAndPort("localhost", 6381));
        sets.add(new HostAndPort("localhost", 6382));
        sets.add(new HostAndPort("localhost", 6383));

        JedisCluster cluster = new JedisCluster(sets, 10000, 20);
        String k1 = cluster.get("k1");

        System.out.println(k1);
    }

    private static void doJedisOperation() {
        JedisPool jedisPool = getJedisPool();
        try (Jedis jedis = jedisPool.getResource()) {
            String k1 = jedis.get("k1");
            System.out.println(k1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private static JedisPool getJedisPool() {
        JedisPoolConfig config = getJedisPoolConfig();
        JedisPool jedisPool = new JedisPool(config, "localhost", 6379);
        return jedisPool;
    }

    private static JedisPoolConfig getJedisPoolConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(10);
        config.setMinIdle(3);
        config.setMaxIdle(8);
        return config;
    }


}
