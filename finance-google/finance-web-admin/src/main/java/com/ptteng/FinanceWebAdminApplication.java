package com.ptteng;

import com.alibaba.fastjson.JSONObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.ptteng.dao")//将项目中对应的mapper类的路径加进来
public class FinanceWebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinanceWebAdminApplication.class, args);
    }
    @Bean
    public JSONObject JSONObject(){
        return new JSONObject();
    }
}
