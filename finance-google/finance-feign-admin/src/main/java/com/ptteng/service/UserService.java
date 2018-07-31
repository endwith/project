package com.ptteng.service;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.service.impl.UserServiceHystric;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *提供一个java接口连接服务， 接口中的方法对应url接口就能直接访问了，不需要ribbon实例服务提供者
 */
//@FeignClient声明feign，添加fallback熔断器实现类
@FeignClient(value = "finance-admin",fallback=UserServiceHystric.class)
public interface UserService {

    /**
     *(没有cookie重定向接口)
     */
    @RequestMapping(value ="/a/outerRecord", produces="application/json",method = RequestMethod.GET)
    JSONObject outerRecord();
    /**
     * 44权限模块显示
     */
    @RequestMapping(value ="/a/u/loginer", produces="application/json",method = RequestMethod.GET)
    JSONObject showRoleModule(@RequestParam(value = "request",required = false)HttpServletRequest request,@RequestParam(value = "response",required = false)HttpServletResponse response);

    /**
     *98密码管理
     */
    @RequestMapping(value ="/a/u/password", produces="application/json",method = RequestMethod.POST)
     JSONObject updatePassword(@RequestParam(value = "lastPassword",required = false) String lastPassword, @RequestParam(value = "newPassword1",required = false)String newPassword1, @RequestParam(value = "newPassword2",required = false)String newPassword2
            ,@RequestParam(value = "request",required = false)HttpServletRequest request);

}
