package com.shine.redis.service.redis;

import com.shine.cm.service.redis.IRedisService;
import com.shine.common.entity.RedisBean;
import com.shine.common.util.JSONUtil;
import com.shine.common.util.SerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements IRedisService {

    @Autowired
    private RedisTemplate<String, ?> redisTemplate;

    /**
     * 修改数据,返回boolean
     * @param key
     * @param obj
     * @return true or false
     */
    @Override
    public boolean set(final String key, final Object obj) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                connection.set(SerializeUtil.serialize(key), SerializeUtil.serialize(obj));
                return true;
            }
        });
        return result;
    }

    /**
     * 设置带过期时间的key
     * @param key
     * @param obj
     * @param expire 过期时间(单位:秒)
     * @return
     */
    @Override
    public boolean setExpire(final String key,final Object obj, long expire){
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                connection.setEx(SerializeUtil.serialize(key), expire, SerializeUtil.serialize(obj));
                return true;
            }
        });
        return result;
    }

    /**
     * 获取数据,返回String
     * @param key
     * @return String
     */
    public RedisBean get(final String key){
        RedisBean result = redisTemplate.execute(new RedisCallback<RedisBean>() {
            @Override
            public RedisBean doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] value =  connection.get(SerializeUtil.serialize(key));
                return new RedisBean(key,SerializeUtil.unserialize(value));
            }
        });
        return result;
    }

    @Override
    public Boolean del(String key) {
        return this.delete(key) == 0 ? false : true;
    }

    /**
     * 删除redis单个对象 ,依赖key.
     * @param key
     */
    private Long delete(final String key) {
        Long result = redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.del(SerializeUtil.serialize(key));
            }
        });
        return result;
    }

    /**
     * 设置数据过期时间
     * @param key
     * @param expire 时间,单位(秒)
     * @return
     */
    @Override
    public boolean expire(final String key, long expire) {
        return redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }


    @Override
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }


    /**
     * 在key 对应 list的头部添加字符串元素
     * @param key
     * @param obj
     * @return
     */
    @Override
    public long lpush(final String key, Object obj) {
        final String value = JSONUtil.toJson(obj);
        long result = redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                long count = connection.lPush(SerializeUtil.serialize(key), SerializeUtil.serialize(value));
                return count;
            }
        });
        return result;
    }

    /**
     * 在key 对应 list 的尾部添加字符串元素
     * @param key
     * @param obj
     * @return
     */
    @Override
    public long rpush(final String key, Object obj) {
        final String value = JSONUtil.toJson(obj);
        long result = redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                long count = connection.rPush(SerializeUtil.serialize(key), SerializeUtil.serialize(value));
                return count;
            }
        });
        return result;
    }

    /**
     * 列表的第一个元素。 当列表 key 不存在时，返回 nil
     * @param key
     * @return
     */
    @Override
    public RedisBean lpop(final String key) {
        RedisBean result = redisTemplate.execute(new RedisCallback<RedisBean>() {
            @Override
            public RedisBean doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] res =  connection.lPop(SerializeUtil.serialize(key));
                return new RedisBean(key,SerializeUtil.unserialize(res));
            }
        });
        return result;
    }

}