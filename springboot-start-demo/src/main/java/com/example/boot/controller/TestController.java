package com.example.boot.controller;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IDEA
 * author:YunGui Hhuang
 * Date:2022/12/11
 * Time:11:48
 */
@RestController
public class TestController {

    @Autowired
    RedissonClient redissonClient;
    @GetMapping("/test")
    public String get(){
        RBucket<Object> bucket = redissonClient.getBucket("test");
        if (bucket.get()==null){
            bucket.set("succees");
        }
        return bucket.get().toString();
    }
}
