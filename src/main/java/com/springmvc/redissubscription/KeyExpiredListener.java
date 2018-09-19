package com.springmvc.redissubscription;

import com.springmvc.utils.RedisDao;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisPubSub;


public class KeyExpiredListener extends JedisPubSub {

    JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");

    Jedis jedis = pool.getResource();

    @Override  
    public void onPSubscribe(String pattern, int subscribedChannels) {  
        System.out.println("onPSubscribe "  
                + pattern + " " + subscribedChannels);  
    }  
  
    @Override  
    public void onPMessage(String pattern, String channel, String message) {
        System.out.println(jedis.get("message"));
        System.out.println("onPMessage pattern "  
                        + pattern + " ||| " + channel + " ||| " + message);
    }

    @Override
    public void onMessage(String channel, String message) {
        System.out.println(message+"我是你你哥哥");
    }
}