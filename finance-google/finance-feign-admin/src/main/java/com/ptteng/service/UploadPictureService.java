package com.ptteng.service;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.service.impl.UploadPictureServiceHystric;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "finance-admin",fallback=UploadPictureServiceHystric.class,configuration = {UploadPictureService.MultipartSupportConfig.class})
public interface UploadPictureService {
    /**
     *上传图片
     */
    @RequestMapping(value ="/a/u/picture",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    JSONObject loadPicture(@RequestPart(value = "picture",required = false)MultipartFile picture);
    @Configuration
     class MultipartSupportConfig {

        @Bean
        @Primary
        @Scope("prototype")
        public SpringFormEncoder multipartFormEncoder() {
            return new SpringFormEncoder();
        }

        @Bean
        public feign.Logger.Level multipartLoggerLevel() {
            return feign.Logger.Level.FULL;
        }
    }
}
