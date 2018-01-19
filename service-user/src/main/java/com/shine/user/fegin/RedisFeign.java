package com.shine.user.fegin;


import com.shine.common.entity.RedisBean;

import com.shine.common.vo.ResultDO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "service-redis")
public interface RedisFeign {

    @PostMapping(value = "/redis")
    Boolean putRedis(@RequestBody RedisBean redisBean);

    @GetMapping(value = "/redis")
    RedisBean getRedis(@RequestParam("key") String key);

    @PutMapping(value = "/redis")
    Boolean setRedis(@RequestBody RedisBean redisBean);

    @DeleteMapping(value = "/redis")
    Boolean delRedis(@RequestParam("key") String key);

    @GetMapping(value = "/redis/exists")
    Boolean exists(@RequestParam("key") String key);
}
