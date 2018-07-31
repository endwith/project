package com.ptteng.service;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.service.impl.BackstageAccountServiceHystric;
import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 *提供一个java接口连接服务， 接口中的方法对应url接口就能直接访问了，不需要ribbon实例服务提供者
 */
//@FeignClient声明feign，添加fallback熔断器实现类
@FeignClient(value = "finance-admin",fallback=BackstageAccountServiceHystric.class)
public interface BackstageAccountService {

    /**
     *99账号管理入口
     */
    @RequestMapping(value ="/a/u/all-backstage-account", produces="application/json",method = RequestMethod.GET)
     JSONObject getAllBackstageAccount(@RequestParam(value = "page",required = false) Long page, @RequestParam(value = "size",required = false) Long size);
    /**
     *100账号管理查询
     */
    @RequestMapping(value ="/a/u/backstage-account", produces="application/json",method = RequestMethod.GET)
     JSONObject getBackstageAccounts(@RequestParam(value = "page",required = false)Long page,@RequestParam(value = "size",required = false)Long size,@RequestParam(value = "id",required = false)Long id,
                                     @RequestParam(value = "adminRole",required = false)String adminRole,@RequestParam(value = "admin",required = false)String admin,@RequestParam(value = "founder",required = false)String founder);
    /**
     *101账号管理新增-获取角色
     */
    @RequestMapping(value ="/a/u/backstage-account/role", produces="application/json",method = RequestMethod.GET)
     JSONObject getAllRole(@RequestParam(value = "request",required = false)HttpServletRequest request);
    /**
     *102账号管理新增-保存
     */
    @RequestMapping(value ="/a/u/backstage-account", produces="application/json",method = RequestMethod.POST)
     JSONObject addBackstageAccount(@RequestParam(value = "admin",required = false)String admin,@RequestParam(value = "password",required = false)String password,@RequestParam(value = "adminRole",required = false)String adminRole,
                                    @RequestParam(value = "status",required = false)Integer status,@RequestParam(value = "request",required = false)HttpServletRequest request);
    /**
     *103账号管理编辑—获取
     */
    @RequestMapping(value ="/a/u/backstage-account/{id}", produces="application/json",method = RequestMethod.GET)
     JSONObject getBackstageAccount(@RequestParam(value = "id",required = false)Long id,@RequestParam(value = "request",required = false)HttpServletRequest request);
    /**
     *104账号编辑-保存
     */
    @RequestMapping(value ="/a/u/backstage-account/{id}", produces="application/json",method = RequestMethod.PUT)
     JSONObject updateBackstageAccount(@RequestParam(value = "id",required = false)Long id,@RequestParam(value = "admin",required = false)String admin,@RequestParam(value = "password",required = false)String password,
                                       @RequestParam(value = "status",required = false)Integer status,@RequestParam(value = "adminRole",required = false)String adminRole,@RequestParam(value = "request",required = false)HttpServletRequest request);
    /**
     *105账号管理删除
     */
    @RequestMapping(value ="/a/u/backstage-account/{id}", produces="application/json",method = RequestMethod.DELETE)
    @ResponseBody
     JSONObject deleteBackstageAccount(@RequestParam(value = "id",required = false)Long id,@RequestParam(value = "request",required = false)HttpServletRequest request);
}
