package com.ptteng.controller;

import com.alibaba.fastjson.JSONObject;

import com.ptteng.service.ManageUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ManageUserController {
    @Autowired
    ManageUserService manageUserService;

    /**
     *45后台登录
     */
    @RequestMapping(value ="/a/u/usersmanage", produces="application/json",method = RequestMethod.GET)
    public JSONObject usersManage(Long page,Long size){
        return manageUserService.usersManage(page,size);
    }
    /**
     *46模糊查询用户
     */
    @RequestMapping(value ="/a/u/users", produces="application/json",method = RequestMethod.GET)
    public JSONObject getUsers(Long size,Long page,String trueName,
                               String phone,Long id,Integer status){
        return manageUserService.getUsers(size,page,trueName,phone,id,status);
    }
    /**
     *47冻结账户（点冻结status-0，解冻status-1—默认1）
     *49更换手机
     *50解绑银行卡1-2
     */
    @RequestMapping(value ="/a/u/user/{id}", produces="application/json",method = RequestMethod.PUT)
    public JSONObject freeze(Integer status,String phone,Long id ){
        return manageUserService.freeze(status,phone,id);
    }
    /**
     *48查看指定用户详情（原型图中银行卡1、2都要显示）
     */
    @RequestMapping(value ="/a/u/user/{id}", produces="application/json",method = RequestMethod.GET)
    public JSONObject getUser( Long id){
        return manageUserService.getUser(id);
    }
    /**
     *51后台查看个人交易记录
     */
    @RequestMapping(value ="/a/u/user/record/{id}", produces="application/json",method = RequestMethod.GET)
    public JSONObject getRecord(Long userId,Long size,Long page){
        return manageUserService.getRecord(userId,size,page);
    }
    /**
     *52后台查看个人投资合同
     */
    @RequestMapping(value ="/a/u/user/contract", produces="application/json",method = RequestMethod.GET)
    public JSONObject contractAll(Long userId,Long size,Long page){
        return manageUserService.contractAll(userId,size,page);
    }
    /**
     *53后台查看个人投资合同详情
     */
    @RequestMapping(value ="/a/u/user/contract/{id}", produces="application/json",method = RequestMethod.GET)
    public JSONObject contract(Long id){
        return manageUserService.contract(id);
    }

}
