package com.ptteng;

import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class FinanceWebClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinanceWebClientApplication.class, args);
    }
    @Bean
    public JSONObject JSONObject(){
        return new JSONObject();
    }
}
