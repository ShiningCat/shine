package com.shine.common.entity;

import java.io.Serializable;

public class RedisBean implements Serializable{

    private String key;

    private Object value;

    private Long expire;

    public RedisBean() {
    }

    public RedisBean(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public RedisBean(String key, Object value, Long expire) {
        this.key = key;
        this.value = value;
        this.expire = expire;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Long getExpire() {
        return expire;
    }

    public void setExpire(Long expire) {
        this.expire = expire;
    }

    @Override
    public String toString() {
        return "RedisBean{" +
                "key='" + key + '\'' +
                ", value=" + value +
                ", expire=" + expire +
                '}';
    }
}
