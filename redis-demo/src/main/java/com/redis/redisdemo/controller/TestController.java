package com.redis.redisdemo.controller;

import com.redis.redisdemo.service.RedisClientTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @Autowired
    RedisClientTemplate redisClientTemplate;

    @GetMapping(value = "/set/{key}/{value}")
    public String set(@PathVariable String key, @PathVariable String value) {
        redisClientTemplate.setToRedis(key, value);
        Object redis = redisClientTemplate.getRedis(key);
        String str = String.valueOf(redis);
        System.out.println(str);
        return str;
    }

    @GetMapping(value = "/get/{key}")
    public String get(@PathVariable String key) {
        Object redis = redisClientTemplate.getRedis(key);
        String str = String.valueOf(redis);
        System.out.println(str);
        return str;
    }

}