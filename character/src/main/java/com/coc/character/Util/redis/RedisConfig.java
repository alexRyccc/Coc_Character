package com.coc.character.Util.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author ran_ych
 * @create 2019-10-18  17:49
 * @desc
 */
@Configuration
public class RedisConfig {
    @Bean
    RedisTemplate template(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

}
