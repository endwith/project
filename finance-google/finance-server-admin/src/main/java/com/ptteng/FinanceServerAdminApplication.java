package com.ptteng;

import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import redis.clients.jedis.JedisPool;

@RefreshScope
@SpringBootApplication
public class FinanceServerAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinanceServerAdminApplication.class, args);
    }
    @Bean
    @Lazy
    public JSONObject JSONObject(){
        return new JSONObject();
    }
    @Bean
    public JedisPool jedisPool(){
        return  new JedisPool();
    }
}
