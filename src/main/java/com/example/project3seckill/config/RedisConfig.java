package com.example.project3seckill.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory connectionFactory){
        //创建redisTemplate对象
        RedisTemplate<String,Object> temp = new RedisTemplate<>();
        //设置连接工厂
        temp.setConnectionFactory(connectionFactory);
        //创建json序列化工具
        GenericJackson2JsonRedisSerializer jsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        //设置key的序列化
        temp.setKeySerializer(RedisSerializer.string());
        temp.setHashKeySerializer(RedisSerializer.string());
        //设置value的序列化
        temp.setValueSerializer(jsonRedisSerializer);
        temp.setHashValueSerializer(jsonRedisSerializer);
        //返回
        return temp;
    }
}
