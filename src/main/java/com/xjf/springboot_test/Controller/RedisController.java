package com.xjf.springboot_test.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Refrain_ouc
 * @create 2021-07-22 15:55
 */
@RestController
public class RedisController {
    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/redistest")
    public String xjf01(){
        redisTemplate.opsForValue().set("customer","gxh");
        return (String) redisTemplate.opsForValue().get("customer");
    }
}
