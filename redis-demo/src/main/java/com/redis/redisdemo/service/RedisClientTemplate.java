package com.redis.redisdemo.service;

import com.redis.redisdemo.JedisClusterConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 服务
 *
 * @author kevin
 * @date 2019/5/24 11:24
 * @since
 */
@Service
public class RedisClientTemplate {
    private static final Logger log=LoggerFactory.getLogger(RedisClientTemplate.class);

    @Autowired
    private JedisClusterConfig jedisClusterConfig;

    /**
     *  设置值
     *
     * @param key
     * @param value
     * @return
     */
    public boolean setToRedis(String key,Object value) {
        try {
            String str = jedisClusterConfig.getJedisCluster().set(key, String.valueOf(value));
            if ("OK".equals(str)) {
                return true;
            }
        } catch (Exception ex) {
            log.error("setToRedis:{Key:"+key+",value"+value+"}",ex);
        }
        return false;
    }

    /**
     *  redis服务获取 key对应的值
     *
     * @param key redis 键
     * @return {@code key}对应的值
     */
    public Object getRedis(String key) {
        String str = null;
        try {
             str = jedisClusterConfig.getJedisCluster().get(key);
        } catch (Exception ex) {
            log.error("getRedis:{Key:"+key+"}", ex);
        }
        return str;
    }
    
}