package com.ptteng.service;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.service.impl.RoleServiceHystric;

import org.springframework.cloud.netflix.feign.FeignClient;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 *提供一个java接口连接服务， 接口中的方法对应url接口就能直接访问了，不需要ribbon实例服务提供者
 */
//@FeignClient声明feign，添加fallback熔断器实现类
@FeignClient(value = "finance-admin",fallback=RoleServiceHystric.class)
public interface RoleService {
    /**
     *111角色管理查询角色
     */
    @RequestMapping(value ="/a/u/all-role", produces="application/json",method = RequestMethod.GET)
     JSONObject getAllRole(@RequestParam(value = "page",required = false)Long page, @RequestParam(value = "size",required = false)Long size);
    /**
     *112角色模糊查询
     */
    @RequestMapping(value ="/a/u/roles", produces="application/json",method = RequestMethod.GET)
     JSONObject getRoles(@RequestParam(value = "id",required = false)Long id,@RequestParam(value = "role",required = false)String role,@RequestParam(value = "founder",required = false)String founder,
                         @RequestParam(value = "modifier",required = false)String modifier,@RequestParam(value = "page",required = false)Long page,@RequestParam(value = "size",required = false)Long size);
    /**
     *113角色查找（编辑）
     */
    @RequestMapping(value ="/a/u/role/{id}", produces="application/json",method = RequestMethod.GET)
     JSONObject getRoleById(@RequestParam(value = "id",required = false)Long id);
    /**
     *114角色删除
     */
    @RequestMapping(value ="/a/u/role/{id}", produces="application/json",method = RequestMethod.DELETE)
     JSONObject deleteRole(@RequestParam(value = "id",required = false)Long id,
                           @RequestParam(value = "request",required = false)HttpServletRequest request);
    /**
     *115角色更改（编辑好角色后点击保存）
     */
    @RequestMapping(value ="/a/u/role", produces="application/json",method = RequestMethod.PUT)
     JSONObject updateRole(@RequestParam(value = "roleId",required = false)Long roleId,
                           @RequestParam(value = "role",required = false)String role, @RequestParam(value = "moduleIdArray",required = false)String moduleIdArray
            ,@RequestParam(value = "request",required = false)HttpServletRequest request);

    /**
     * 116角色增加
     */
    @RequestMapping(value = "/a/u/role", produces = "application/json", method = RequestMethod.GET)
     JSONObject addRole() ;

    /**
     * 117角色保存（增加好角色后点击保存）
     */
    @RequestMapping(value = "/a/u/role", produces = "application/json", method = RequestMethod.POST)
     JSONObject addRole(@RequestParam(value = "role",required = false)String role,@RequestParam(value = "moduleIdArray",required = false) String moduleIdArray
            ,@RequestParam(value = "request",required = false)HttpServletRequest request);

}
