package com.coc.character.Util.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author ran_ych
 * @create 2019-10-18  17:52
 * @desc
 */
@Component
public class RedisUtil {
    @Bean
    RedisUtil util(RedisTemplate template){

        return new RedisUtil(template);
    }

    private RedisTemplate template;

    public RedisUtil(RedisTemplate template){
        this.template = template;
    }


    //value

    public boolean setValue(Object key, Object value){
        try{
            template.opsForValue().set(key, value);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Object getValue(Object key){
        return template.opsForValue().get(key);
    }

    //setnx
    public boolean setNx(Object key, Object value, int min){

        return     template.opsForValue().setIfAbsent(key,value,min,TimeUnit.SECONDS);

    }

    public void delete(String str){
        template.delete(str);
    }

}
