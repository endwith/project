package com.ptteng.service;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.model.User;
import com.ptteng.service.impl.ManageUserServiceHystric;
import feign.Param;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *提供一个java接口连接服务， 接口中的方法对应url接口就能直接访问了，不需要ribbon实例服务提供者
 */
//@FeignClient声明feign，添加fallback熔断器实现类
@FeignClient(value = "finance-admin",fallback=ManageUserServiceHystric.class)
public interface ManageUserService {
    /**
     *45后台登录
     */
    @RequestMapping(value ="/a/u/usersmanage", produces="application/json",method = RequestMethod.GET)
     JSONObject usersManage(@RequestParam(value = "page",required = false) Long page,
                            @RequestParam(value = "size",required = false)Long size);
    /**
     *46模糊查询用户
     */
    @RequestMapping(value ="/a/u/users", produces="application/json",method = RequestMethod.GET)
     JSONObject getUsers(@RequestParam(value = "size",required = false)Long size,
                         @RequestParam(value = "page",required = false)Long page,
                         @RequestParam(value = "trueName",required = false)String trueName,
                         @RequestParam(value = "phone",required = false)String phone,
                         @RequestParam(value = "id",required = false)Long id,
                         @RequestParam(value = "status",required = false)Integer status);
    /**
     *47冻结账户（点冻结status-0，解冻status-1—默认1）
     *49更换手机
     *50解绑银行卡1-2
     */
    @RequestMapping(value ="/a/u/user/{id}", produces="application/json",method = RequestMethod.PUT)
     JSONObject freeze(@RequestParam(value = "status",required = false)Integer status,@RequestParam(value = "phone",required = false)String phone,
                       @RequestParam(value = "id",required = false)Long id);
    /**
     *48查看指定用户详情（原型图中银行卡1、2都要显示）
     */
    @RequestMapping(value ="/a/u/user/{id}", produces="application/json",method = RequestMethod.GET)
     JSONObject getUser( @RequestParam(value = "id",required = false)Long id);
    /**
     *51后台查看个人交易记录
     */
    @RequestMapping(value ="/a/u/user/record/{id}", produces="application/json",method = RequestMethod.GET)
     JSONObject getRecord(@RequestParam(value = "userId",required = false)Long userId,@RequestParam(value = "size",required = false)Long size,
                          @RequestParam(value = "page",required = false)Long page);
    /**
     *52后台查看个人投资合同
     */
    @RequestMapping(value ="/a/u/user/contract", produces="application/json",method = RequestMethod.GET)
     JSONObject contractAll(@RequestParam(value = "userId",required = false)Long userId,
                            @RequestParam(value = "size",required = false)Long size,
                            @RequestParam(value = "page",required = false)Long page);
    /**
     *53后台查看个人投资合同详情
     */
    @RequestMapping(value ="/a/u/user/contract/{id}", produces="application/json",method = RequestMethod.GET)
     JSONObject contract(@RequestParam(value = "id",required = false)Long id);

}
