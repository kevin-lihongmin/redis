package com.redis.redisdemo.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 *  spring 配置信息加载成 spring Bean
 *
 * @author kevin
 * @date 2019/5/24 11:22
 * @since
 */
@Configuration
@ConfigurationProperties("spring.redis.cache")
public class RedisClusterProperties {

    /**
     *  超时时间，单位毫秒
     */
    private int expireSeconds;

    /**
     *  节点地址
     */
    private String clusterNodes;

    /**
     *  命令超时时间
     */
    private int commandTimeout;

    /**
     *  最大空闲连接数
     */
    private int maxIdle;

    /**
     *  最大连接数, 默认8个
     */
    private int maxTotal;

    /**
     *  最小空闲连接数, 默认0
     */
    private int minIdle;

    /**
     *  获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),
     *  如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
     */
    private int maxWaitMillis;

    /**
     *  对拿到的connection进行validateObject校验
     */
    private boolean testOnBorrow;

    public int getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(int expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    public String getClusterNodes() {
        return clusterNodes;
    }

    public void setClusterNodes(String clusterNodes) {
        this.clusterNodes = clusterNodes;
    }

    public int getCommandTimeout() {
        return commandTimeout;
    }

    public void setCommandTimeout(int commandTimeout) {
        this.commandTimeout = commandTimeout;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public int getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(int maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }
}
