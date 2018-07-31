package com.ptteng.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Configuration
@EnableFeignClients(basePackages = "com.ptteng")
public class FeignClientsConfigurationCustom implements RequestInterceptor {

        @Override
    public void apply(RequestTemplate template) {

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return;
        }

        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                Enumeration<String> values = request.getHeaders(name);
                while (values.hasMoreElements()) {
                    String value = values.nextElement();
                    System.out.println("value*****************" + value);
                    System.out.println("name*****************" + name);
                    Cookie[] cookie = request.getCookies();
                    String keys = null;
                    String userId = null;
                    for (Cookie c : cookie) {  // 遍历Cookie
                        if ("userTime".equals(c.getName()))
                            keys = c.getValue();
                        System.out.println("keys*****************" + keys);
                        if ("userId".equals(c.getName()))
                            userId = c.getValue();
                        System.out.println("userId*****************" + userId);
                    }
                    template.header(name, value);
                }
            }
        }

    }

}

