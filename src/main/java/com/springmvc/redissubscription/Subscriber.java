package com.springmvc.redissubscription;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;


/**\
 * 这个表示消息的订阅者密室
 */
public class Subscriber {
    public static void main(String[] args) {
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "127.0.0.1");



        Jedis jedis = pool.getResource();

        KeyExpiredListener n = new KeyExpiredListener();


        config(jedis);//最重要的部分
        //jedis.psubscribe(new KeyExpiredListener(), "__keyevent@0__:expired");

        jedis.subscribe(n,"redisChat");


    }
    private static void config(Jedis jedis){
        String parameter = "notify-keyspace-events";
        List<String> notify = jedis.configGet(parameter);
        if(notify.get(1).equals("")){
            jedis.configSet(parameter, "Ex"); //过期事件
        }
    }
}
