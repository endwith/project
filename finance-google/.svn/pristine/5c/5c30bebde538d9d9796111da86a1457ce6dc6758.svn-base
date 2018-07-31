package com.ptteng;


import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

@RefreshScope
@SpringBootApplication
public class FinanceServerClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinanceServerClientApplication.class, args);
    }
    @Bean
    @Lazy
    public JSONObject JSONObject(){
        return new JSONObject();
    }
}
