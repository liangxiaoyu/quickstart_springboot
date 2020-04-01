package com.xintaike.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by jay on 2020/4/1.
 */
@Component
public class StringRedisTemplateWrapper {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public String get(String key){

        return stringRedisTemplate.opsForValue().get(key);
    }

    public void set(String key,String value){
        stringRedisTemplate.opsForValue().set(key,value);
    }

}
