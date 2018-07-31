package com.ptteng.config;


import com.ptteng.userHandler.UserRoleHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebAppConfigurer  extends WebMvcConfigurerAdapter {

    @Bean
    public UserRoleHandler userRoleHandler(){
        return new UserRoleHandler();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则

        registry.addInterceptor(userRoleHandler()).addPathPatterns("/a/u/**");
        super.addInterceptors(registry);
    }

}