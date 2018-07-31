package com.ptteng.controller;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.service.BackstageAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RefreshScope
@RestController
public class BackstageAccountController {
    @Autowired
    BackstageAccountService backstageAccountService;
    /**
     *99账号管理入口
     */
    @RequestMapping(value ="/a/u/all-backstage-account", produces="application/json",method = RequestMethod.GET)
    public JSONObject getAllBackstageAccount(Long page,Long size){
        return backstageAccountService.getAllBackstageAccount(page,size);
    }
    /**
     *100账号管理查询
     */
    @RequestMapping(value ="/a/u/backstage-account", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getBackstageAccounts(Long page,Long size,Long id,String adminRole,String admin,String founder){
        return backstageAccountService.getBackstageAccounts(page,size,id,adminRole,admin,founder);
    }
    /**
     *101账号管理新增-获取角色
     */
    @RequestMapping(value ="/a/u/backstage-account/role", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getAllRole(HttpServletRequest request){
        return backstageAccountService.getAllRole(request);
    }
    /**
     *102账号管理新增-保存
     */
    @RequestMapping(value ="/a/u/backstage-account", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addBackstageAccount(String admin,String password,String adminRole,Integer status,HttpServletRequest request){
        return backstageAccountService.addBackstageAccount(admin,password,adminRole,status,request);
    }
    /**
     *103账号管理编辑—获取
     */
    @RequestMapping(value ="/a/u/backstage-account/{id}", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getBackstageAccount(Long id,HttpServletRequest request){
        return backstageAccountService.getBackstageAccount( id,request);
    }
    /**
     *104账号编辑-保存
     */
    @RequestMapping(value ="/a/u/backstage-account/{id}", produces="application/json",method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject updateBackstageAccount(Long id,String admin,String password,Integer status,String adminRole,HttpServletRequest request){
        return backstageAccountService.updateBackstageAccount(id,admin,password,status,adminRole,request);
    }
    /**
     *105账号管理删除
     */
    @RequestMapping(value ="/a/u/backstage-account/{id}", produces="application/json",method = RequestMethod.DELETE)
    @ResponseBody
    public JSONObject deleteBackstageAccount(Long id,HttpServletRequest request){
        return backstageAccountService.deleteBackstageAccount(id,request);
    }
}
