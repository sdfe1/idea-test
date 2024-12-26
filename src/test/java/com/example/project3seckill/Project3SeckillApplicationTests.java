package com.example.project3seckill;

import com.example.project3seckill.service.MyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import com.example.project3seckill.pojo.User;
@SpringBootTest
class Project3SeckillApplicationTests {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    void contextLoads() {
        try{
            redisTemplate.opsForValue().set("user:100", new User(12,"张三"));
            //获取
            User user =(User) redisTemplate.opsForValue().get("user:100");
            System.out.println(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    void testHash(){
        redisTemplate.opsForHash().put("user:200","name","李四");
    }




}
