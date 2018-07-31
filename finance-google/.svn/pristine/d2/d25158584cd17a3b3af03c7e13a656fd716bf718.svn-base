package com.ptteng.util;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

@Component
//@ConfigurationProperties(prefix = "")
public class MyJedis {

    @Bean
    public JedisPool jedisPool(){
        return  new JedisPool();
    }

}
