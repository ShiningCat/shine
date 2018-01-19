package com.shine.redis.action.redis;
import com.shine.cm.service.redis.IRedisService;

import com.shine.common.entity.RedisBean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedisAction {

    @Autowired
    private IRedisService redisService;

    @PostMapping(value = "/redis")
    public Boolean putRedis(@RequestBody RedisBean redisBean) {
        Boolean set;
        if(redisBean.getExpire() != null && redisBean.getExpire() != 0) {
            set = redisService.setExpire(redisBean.getKey(),redisBean.getValue(),redisBean.getExpire());
        } else {
            set = redisService.set(redisBean.getKey(),redisBean.getValue());
        }
        return set;
    }
    @GetMapping(value = "/redis")
    public RedisBean getRedis(@RequestParam String key) {
        return redisService.get(key);
    }


    @PutMapping(value = "/redis")
    public Boolean setRedis(@RequestBody RedisBean redisBean) {
        boolean set;
        if (redisService.exists(redisBean.getKey())) {
            return false;
        } else {
            if(redisBean.getExpire() != null && redisBean.getExpire() != 0) {
                set = redisService.setExpire(redisBean.getKey(),redisBean.getValue(),redisBean.getExpire());
            } else {
                set = redisService.set(redisBean.getKey(),redisBean.getValue());
            }
        }
        return set;
    }

    @DeleteMapping(value = "/redis")
    public Boolean delRedis(@RequestParam String key) {
        return redisService.del(key);
    }
    @GetMapping(value = "/redis/exists")
    public Boolean exists(@RequestParam String key) {
        return redisService.exists(key);
    }
}
