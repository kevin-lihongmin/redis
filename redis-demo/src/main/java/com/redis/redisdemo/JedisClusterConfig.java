package com.redis.redisdemo;

import com.redis.redisdemo.property.RedisClusterProperties;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 *  Jedis的Cluster配置初始化
 *
 * @author kevin
 * @date 2019/5/24 15:05
 * @since
 */
@Configuration
public class JedisClusterConfig implements InitializingBean {

    @Autowired
    private RedisClusterProperties redisClusterProperties;

    private JedisCluster jedisCluster = null;

    public RedisClusterProperties getRedisClusterProperties() {
        return redisClusterProperties;
    }

    public void setRedisClusterProperties(RedisClusterProperties redisClusterProperties) {
        this.redisClusterProperties = redisClusterProperties;
    }

    public JedisCluster getJedisCluster() {
        return jedisCluster;
    }

    public void setJedisCluster(JedisCluster jedisCluster) {
        this.jedisCluster = jedisCluster;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        String[] serverArray = redisClusterProperties.getClusterNodes().split(",");
        Set<HostAndPort> nodes = new HashSet<>();

        for (String ipPort : serverArray) {
            String[] ipPortPair = ipPort.split(":");
            nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
        }

        // Jedis连接池配置
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大空闲连接数, 默认8个
        jedisPoolConfig.setMaxIdle(redisClusterProperties.getMaxIdle());
        // 最大连接数, 默认8个
        jedisPoolConfig.setMaxTotal(redisClusterProperties.getMaxTotal());
        //最小空闲连接数, 默认0
        jedisPoolConfig.setMinIdle(redisClusterProperties.getMinIdle());
        // 获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
        jedisPoolConfig.setMaxWaitMillis(redisClusterProperties.getMaxWaitMillis());
        //对拿到的connection进行validateObject校验
        jedisPoolConfig.setTestOnBorrow(redisClusterProperties.isTestOnBorrow());

        JedisCluster jedisCluster = new JedisCluster(nodes, redisClusterProperties.getCommandTimeout(), jedisPoolConfig);
        setJedisCluster(jedisCluster);
    }

}