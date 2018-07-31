package com.ptteng;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.config.FeignHystrixConcurrencyStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

@EnableEurekaClient
@EnableFeignClients   //@EnableFeignClients注解开启Feign的功能
@SpringBootApplication
public class FinanceFeignAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinanceFeignAdminApplication.class, args);
    }
    @Bean
    @Lazy
    public JSONObject JSONObject(){
        return new JSONObject();
    }
    @Bean
    public FeignHystrixConcurrencyStrategy feignHystrixConcurrencyStrategy() {
        return new FeignHystrixConcurrencyStrategy();
    }
}
