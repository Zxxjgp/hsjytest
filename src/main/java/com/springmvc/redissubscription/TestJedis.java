package com.springmvc.redissubscription;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class TestJedis {
  
    public static void main(String[] args) throws Exception {

        JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
  
        Jedis jedis = pool.getResource();
        jedis.set("notify", "你还在吗");  
        jedis.expire("notify", 60);

        jedis.publish("redisChat", "Redis is a great caching technique");
        Thread.sleep(5000);
        jedis.publish("redisChat", "build your dream");
        Thread.sleep(5000);
        jedis.publish("redisChat", "over");

    }  
}