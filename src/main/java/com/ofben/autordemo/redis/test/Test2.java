package com.ofben.autordemo.redis.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Objects;

/**
 * Spring 集成 Jedis
 *
 * @date 2021-08-26
 * @since 1.0.0
 */
public class Test2 extends RedisTemplate {

    public void t1() {
        Object ret = this.execute(
                (RedisCallback) redisConnection ->
                        new String(Objects.requireNonNull(
                                redisConnection.get("k1".getBytes()))));

        System.out.println("ret===" + ret);
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-redis.xml");
        Test2 test2 = (Test2) context.getBean("testClient");

        test2.t1();
    }
}
