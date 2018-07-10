package com.springmvc.utils;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class RedisDao extends
        AbstractBaseRedisDao<String, HashMap<String, Object>> {
    /**
     * 新增键值对
     * 
     * @param key
     * @param value
     * @return
     */
    public boolean addString(final String key, final String value) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] jkey = serializer.serialize(key);
                byte[] jvalue = serializer.serialize(value);
                return connection.setNX(jkey, jvalue);
            }
        });
        return result;
    }

    /**
     * 新增(拼接字符串)
     * 
     * @param key
     * @param value
     * @return
     */
    public boolean appendString(final String key, final String value) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] jkey = serializer.serialize(key);
                byte[] jvalue = serializer.serialize(value);
                if (connection.exists(jkey)) {
                    connection.append(jkey, jvalue);
                    return true;
                } else {
                    return false;
                }
            }
        });
        return result;
    }
    /*HMSET myhash field1 "Hello" field2 "World"  HGET myhash field1 and HGET myhash field2*/
  /*==============================================================================================================*/
    /**
     * 新增(存储Map)
     * 
     * @param key
     * @param value
     * @return
     */
    public String addMap(String key, Map<String, String> map) {
        Jedis jedis = getJedis();
        String result = jedis.hmset(key, map);
        jedis.close();
        return result;
    }

    /**
     * 获取map
     * 
     * @param key
     * @return
     */
    public Map<String, String> getMap(String key) {
        Jedis jedis = getJedis();
        Map<String, String> map = new HashMap<String, String>();
        Iterator<String> iter = jedis.hkeys(key).iterator();
        while (iter.hasNext()) {
            String ikey = iter.next();
            map.put(ikey, jedis.hmget(key, ikey).get(0));
        }
        jedis.close();
        return map;
    }


    /*==============================================================================================================*/
    /**
     * 新增(存储List)
     * 
     * @param key
     * @param pd
     * @return
     */
    public void addList(String key, List<String> list) {
        Jedis jedis = getJedis();
        jedis.del(key); // 开始前，先移除所有的内容
        for (String value : list) {
            jedis.rpush(key, value);
            /*将所有指定的值插入到存于 key 的列表的头部 rpush*/
                /*将所有指定的值插入到存于 key 的列表的尾部部 lpush*/
        }
        jedis.close();
    }

    /**
     * 获取List
     * 
     * @param key
     * @return
     */
    public List<String> getList(String key) {
        Jedis jedis = getJedis();
        List<String> list = jedis.lrange(key, 0, -1);
        jedis.close();
        return list;
    }
    /*获取和设置多个的set*/
/*==============================================================================================================*/
    /**
     * 新增(存储set)
     * 
     * @param key
     * @param set
     */
    public void addSet(String key, Set<String> set) {
        Jedis jedis = getJedis();
        jedis.del(key);
        for (String value : set) {
            jedis.sadd(key, value);
        }
        jedis.close();
    }

    /**
     * 获取Set
     * 用于获取所有的key
     * @param key
     * @return
     */

    public Set<String> getSet(String key) {
        Jedis jedis = getJedis();
        Set<String> set = jedis.smembers(key);
        jedis.close();
        return set;
    }
    /*获取单个String*/
/*==============================================================================================================*/
    /**
     * 添加string
     * 成功返回OK，失败返回0
     */
    public String setString(String key, String value){
        Jedis jedis = null;
        try {
            jedis = getJedis();
            return jedis.set(key,value);
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        } finally {
            jedis.close();
        }
    }

    /**
     * 得到String获取单个key
     * @param key
     * @return
     */
    public String getString(String key){
        Jedis jedis = null;
        String value = null;
        try {
            jedis = getJedis();
            return jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        } finally {
        }
    }

    /**
     * 对key进行重新命名
     * @param olakey
     * @param newkey
     * @return
     */
    public String renamekey(String olakey , String newkey){
        Jedis jedis = null;
        String value = null;
        try {
            jedis = getJedis();

            value = jedis.rename(olakey, newkey);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
        return value;
    }
    /*==============================================================================================================*/

    /**
     * 如果key不存在就返回0
     * @param key
     * @param value
     * @return
     */
    public String incrby(String key, Long value){
        String temp = getString(key);
        if (temp != null && temp.equals("")){
            Jedis jedis = null;
            Long result = null;
            try {
                jedis = getJedis();
                result = jedis.incrBy(key,value);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                jedis.close();
            }
        }
        return "0";
    }
    /*==============================================================================================================*/

    /**
     * 通过key向指定的value值追加值
     *
     * @param key
     * @param str
     * @return 成功返回 添加后value的长度 失败 返回 添加的 value 的长度 异常返回0L
     */
    public Long append(String key, String str) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = getJedis();
            res = jedis.append(key, str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        } finally {
            if(jedis!=null){
                jedis.close();
            }
        }
        return res;
    }

    /**
     * 删除指定的key,也可以传入一个包含key的数组
     *
     * @param keys 一个key 也可以使 string 数组
     * @return 返回删除成功的个数
     */
    public Long del(String... keys) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            return jedis.del(keys);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        } finally {
            if(jedis!=null){
                jedis.close();
            }
        }
    }
      /*==============================================================================================================*/
    /**
     * 判断key是否存在
     *
     * @param key
     * @return true OR false
     */
    public Boolean exists(String key) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            return jedis.exists(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if(jedis!=null){
                jedis.close();
            }
        }
    }
    /*===============================================================================================*/
    /**
     * 设置key value并制定这个键值的有效期
     *
     * @param key
     * @param value
     * @param seconds 单位:秒
     * @return 成功返回OK 失败和异常返回null
     */
    public String setex(String key, String value, int seconds) {
        Jedis jedis = null;
        String res = null;
        try {
            jedis = getJedis();
            res = jedis.setex(key, seconds, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(jedis!=null){
                jedis.close();
            }
        }
        return res;
    }
    /**
     * 通过key 和offset 从指定的位置开始将原先value替换 下标从0开始,offset表示从offset下标开始替换
     * 如果替换的字符串长度过小则会这样 example: value : bigsea@zto.cn str : abc 从下标7开始替换 则结果为
     * RES : bigsea.abc.cn
     *
     * @param key
     * @param str
     * @param offset 下标位置
     * @return 返回替换后 value 的长度
     */
    public Long setrange(String key, String str, int offset) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            return jedis.setrange(key, offset, str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        } finally {
            if(jedis!=null){
                jedis.close();
            }
        }
    }
    /**
     * 通过批量的key获取批量的value
     *
     * @param keys string数组 也可以是一个key
     * @return 成功返回value的集合, 失败返回null的集合 ,异常返回空
     */
    public List<String> mget(String... keys) {
        Jedis jedis = null;
        List<String> values = null;
        try {
            jedis = getJedis();
            values = jedis.mget(keys);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(jedis!=null){
                jedis.close();
            }
        }
        return values;
    }
    /**
     * 批量的设置key:value,可以一个 example: obj.mset(new String[]{"key2","value1","key2","value2"})
     *
     * @param keysvalues
     * @return 成功返回OK 失败 异常 返回 null
     *
     */
    public String mset(String... keysvalues) {
        Jedis jedis = null;
        String res = null;
        try {
            jedis = getJedis();
            res = jedis.mset(keysvalues);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(jedis!=null){
                jedis.close();
            }
        }
        return res;
    }
    /**
     * 批量的设置key:value,
     * 可以一个,如果key已经存在则会失败,操作会回滚 example: obj.msetnx(new String[]{"key2","value1","key2","value2"})
     *
     * @param keysvalues
     * @return 成功返回1 失败返回0
     */
    public Long msetnx(String... keysvalues) {
        Jedis jedis = null;
        Long res = 0L;
        try {
            jedis = getJedis();
            res = jedis.msetnx(keysvalues);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(jedis!=null){
                jedis.close();
            }
        }
        return res;
    }
    /**
     * 设置key的值,并返回一个旧值
     *
     * @param key
     * @param value
     * @return 旧值 如果key不存在 则返回null
     */
    public String getset(String key, String value) {
        Jedis jedis = null;
        String res = null;
        try {
            jedis = getJedis();
            res = jedis.getSet(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(jedis!=null){
                jedis.close();
            }
        }
        return res;
    }
    /**
     * 通过下标 和key 获取指定下标位置的 value
     *
     * @param key
     * @param startOffset 开始位置 从0 开始 负数表示从右边开始截取
     * @param endOffset
     * @return 如果没有返回null
     */
    public String getrange(String key, int startOffset, int endOffset) {
        Jedis jedis = null;
        String res = null;
        try {
            jedis = getJedis();
            res = jedis.getrange(key, startOffset, endOffset);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(jedis!=null){
                jedis.close();
            }
        }
        return res;
    }
    /**
     * 通过key 对value进行加值+1操作,当value不是int类型时会返回错误,当key不存在是则value为1
     *
     * @param key
     * @return 加值后的结果
     */
    public Long incr(String key) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = getJedis();
            res = jedis.incr(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(jedis!=null){
                jedis.close();
            }
        }
        return res;
    }
    /**
     * 通过key给指定的value加值,如果key不存在,则这是value为该值
     *
     * @param key
     * @param integer
     * @return
     */
    public Long incrBy(String key, Long integer) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = getJedis();
            res = jedis.incrBy(key, integer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(jedis!=null){
                jedis.close();
            }
        }
        return res;
    }
    /*===============================================================================================*/

    /**
     * 删除 (non-Javadoc)
     * 
     * @see com.fh.dao.redis.RedisDao#delete(String)
     */
    public boolean delete(final String key) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] jkey = serializer.serialize(key);
                if (connection.exists(jkey)) {
                    connection.del(jkey);
                    return true;
                } else {
                    return false;
                }
            }
        });
        return result;
    }

    /**
     * 删除多个 (non-Javadoc)
     * 

     */
    public void delete(List<String> keys) {
        redisTemplate.delete(keys);
    }

    /**
     * 修改 (non-Javadoc)
     * 
     *
     */
    public boolean eidt(String key, String value) {
        if (delete(key)) {
            addString(key, value);
            return true;
        }
        return false;
    }
    /**
     * 先删除后添加
     * @param key
     * @param value
     */
    public void del_add(String key, String value){
        delete(key);

        addString(key, value);
    }

    /**
     * 通过key获取值 (non-Javadoc)
     * 
     * 
     */
    public String get(final String keyId) {
        String result = redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection)
                    throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] jkey = serializer.serialize(keyId);
                byte[] jvalue = connection.get(jkey);
                if (jvalue == null) {
                    return null;
                }
                return serializer.deserialize(jvalue);
            }
        });
        return result;
    }

    /**
     * 获取Jedis
     * 
     * @return
     */
    public Jedis getJedis() {
        Properties pros = getPprVue();
        String isopen = pros.getProperty("redis_isopen"); // 地址
        String host = pros.getProperty("redis_hostName"); // 地址
        String port = pros.getProperty("redis_port"); // 端口
        String pass = pros.getProperty("redis_password"); // 密码
        if ("yes".equals(isopen)) {
            Jedis jedis = new Jedis(host, Integer.parseInt(port));
            jedis.auth(pass);
            return jedis;
        } else {
            return null;
        }
    }

    /**
     * 读取redis.properties 配置文件
     * 
     * @return
     * @throws IOException
     */
    public Properties getPprVue() {
        InputStream inputStream =getClass().getResourceAsStream("config.properties");
        Properties p = new Properties();
        try {
            p.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            // 读取配置文件出错
            e.printStackTrace();
        }
        return p;
    }

}