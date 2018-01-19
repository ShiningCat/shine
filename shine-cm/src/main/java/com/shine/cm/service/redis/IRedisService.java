package com.shine.cm.service.redis;

import com.shine.common.entity.RedisBean;

import java.util.List;

public interface IRedisService {

    public boolean set(String key, Object obj);

    public boolean setExpire(String key, Object obj, long expire);

    public RedisBean get(String key);

    public Boolean del(String key);

    public boolean expire(String key,long expire);

    /**
     * 检查key是否存在
     * @param key
     * @return
     */
    public boolean exists(String key);

//    public <T> boolean setList(String key ,List<T> list);

//    public <T> List<T> getList(String key,Class<T> clz);

    public long lpush(String key,Object obj);

    public long rpush(String key,Object obj);

    public RedisBean lpop(String key);

}
