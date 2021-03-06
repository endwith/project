package com.ptteng.service;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.service.impl.UserOperationServiceHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *提供一个java接口连接服务， 接口中的方法对应url接口就能直接访问了，不需要ribbon实例服务提供者
 */
//@FeignClient声明feign，添加fallback熔断器实现类
@FeignClient(value = "finance-client",fallback=UserOperationServiceHystric.class)
public interface UserOperationService {
    /**
     *1获取短信验证码
     */
    @RequestMapping(value ="/a/verification-sms-code", produces="application/json",method = RequestMethod.GET)
     JSONObject verify(@RequestParam(value = "phoneNumber",required = false)String phoneNumber,@RequestParam(value = "moduleId",required = false)Long moduleId
            ,@RequestParam(value = "request",required = false)HttpServletRequest request);
    /**
     *2判断手机号码正确性
     */
    @RequestMapping(value ="/a/phone-number", produces="application/json",method = RequestMethod.POST)
     JSONObject verifyphone(@RequestParam(value = "phoneNumber",required = false)String phoneNumber,@RequestParam(value = "smsCode",required = false)Long smsCode,@RequestParam(value = "pictureCode",required = false)String pictureCode);
    /**
     *3获取图形验证码
     */
    @RequestMapping(value ="/a/picture-code", produces="application/json",method = RequestMethod.POST)
     JSONObject pictureCode(@RequestParam(value = "phoneNumber",required = false)String phoneNumber);
    /**
     *4注册用户并显示主页面
     */
    @RequestMapping(value ="/a/register", produces="application/json",method = RequestMethod.POST)
     JSONObject register(@RequestParam(value = "phoneNumber",required = false)String phoneNumber, @RequestParam(value = "password1",required = false)String password1, @RequestParam(value = "password2",required = false)String password2
            ,@RequestParam(value = "request",required = false)HttpServletResponse response);
    /**
     *5登录显示主页面
     */
    @RequestMapping(value ="/a/signer", produces="application/json",method = RequestMethod.GET)
     JSONObject signer(@RequestParam(value = "phoneNumber",required = false)String phoneNumber,@RequestParam(value = "password",required = false)String password
            ,@RequestParam(value = "request",required = false)HttpServletResponse response);
    /**
     *6找回密码前验证手机
     */
    @RequestMapping(value ="/a/mobile", produces="application/json",method = RequestMethod.POST)
     JSONObject findPassword(@RequestParam(value = "phoneNumber",required = false)String phoneNumber,@RequestParam(value = "smsCode",required = false)Long smsCode,@RequestParam(value = "pictureCode",required = false)String pictureCode);
    /**
     *7找回密码
     */
    @RequestMapping(value ="/a/password", produces="application/json",method = RequestMethod.PUT)
     JSONObject getPassword(@RequestParam(value = "phoneNumber",required = false)String phoneNumber,@RequestParam(value = "password1",required = false)String password1,@RequestParam(value = "password2",required = false)String password2);
    /**
     *25(没有cookie重定向接口)
     */
    @RequestMapping(value ="/a/outerRecord", produces="application/json",method = RequestMethod.GET)
     JSONObject outerRecord();
    /**
     *25退出登录
     */
    @RequestMapping(value ="/a/u/outer",  produces="application/json",method = RequestMethod.POST)
     JSONObject outer(@RequestParam(value = "request",required = false)HttpServletRequest request, @RequestParam(value = "response",required = false)HttpServletResponse response);
    /**
     *43意见反馈
     */
    @RequestMapping(value ="/a/u/opinion", produces="application/json",method = RequestMethod.POST)
     JSONObject opinion(@RequestParam(value = "suggestion",required = false) String suggestion,@RequestParam(value = "request",required = false)HttpServletRequest request);


}
