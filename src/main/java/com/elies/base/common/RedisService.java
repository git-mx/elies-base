package com.elies.base.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author 牟雪
 * @since 2018/4/16
 */
public class RedisService {
    private static Logger logger = LoggerFactory.getLogger(RedisService.class);
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public RedisService() {
    }

    public RedisTemplate<String, String> getRedisTemplate() {
        return this.redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void set(String key, String value, Long offset, TimeUnit timeUnit) {
        try {
            this.redisTemplate.opsForValue().set(key, value, offset.longValue(), timeUnit);
        } catch (Exception var6) {
            logger.error(var6.getMessage());
        }

    }

    public String get(String key) {
        String result = null;

        try {
            result = (String)this.redisTemplate.opsForValue().get(key);
            return result;
        } catch (Exception var4) {
            logger.error(var4.getMessage());
            return result;
        }
    }

    public void delete(String key) {
        try {
            this.redisTemplate.delete(key);
        } catch (Exception var3) {
            logger.error(var3.getMessage());
        }

    }

    public void incret(String key, Long stepLength) {
        this.redisTemplate.opsForValue().increment(key, stepLength.longValue());
    }

    public void expire(String cacheKey, int seconds) {
        long second = (long)seconds;
        this.redisTemplate.expire(cacheKey, Long.valueOf(second).longValue(), TimeUnit.SECONDS);
    }
}
