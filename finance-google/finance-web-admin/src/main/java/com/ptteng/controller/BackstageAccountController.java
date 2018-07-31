package com.ptteng.controller;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.model.BackstageAccount;
import com.ptteng.model.RoleManage;
import com.thoughtworks.xstream.persistence.XmlArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RefreshScope
@Controller
public class BackstageAccountController {
    @Autowired
    private JSONObject jsonObject;
    /**
     *99账号管理入口
     */
    @RequestMapping(value ="/admin/a/u/all-backstage-account", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getAllBackstageAccount(Long page,Long size){
        BackstageAccount bkac=new BackstageAccount();
        bkac.setId(1L);
        bkac.setAdmin("爱丽丝");
        bkac.setAdminRole("管理员");
        bkac.setFounder("admin");
        bkac.setCreateAt(123232323L);
        bkac.setModifier("亚当");
        bkac.setUpdateAt(13231241241L);
        bkac.setStatus(1);
        Map<String,Object> map=new HashMap<>();
        String accountId="accountId"+bkac.getId();
        map.put(accountId,bkac);
        map.put("accountId2",bkac);
        map.put("accountId3",bkac);
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
}
    /**
     *100账号管理查询
     */
    @RequestMapping(value ="/admin/a/u/backstage-account", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getBackstageAccounts(Long page,Long size,Long id,String adminRole,String admin,String founder){
        BackstageAccount bkac=new BackstageAccount();
        bkac.setId(1L);
        bkac.setAdmin("爱丽丝");
        bkac.setAdminRole("管理员");
        bkac.setFounder("admin");
        bkac.setCreateAt(123232323L);
        bkac.setModifier("亚当");
        bkac.setUpdateAt(13231241241L);
        bkac.setStatus(1);
        Map<String,Object> map=new HashMap<>();
        String accountId="accountId"+bkac.getId();
        map.put(accountId,bkac);
        map.put("accountId2",bkac);
        map.put("accountId3",bkac);
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *101账号管理新增-获取角色
     */
    @RequestMapping(value ="/admin/a/u/backstage-account/role", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getAllRole(){
        List<String>s=new ArrayList<>();
        s.add("admin");
        s.add("超级管理员");
        s.add("运维");
        s.add("客服");
        s.add("技术人员");
        s.add("经理");
        jsonObject.put("code",1000);
        jsonObject.put("data",s);
        return jsonObject;
    }
    /**
     *102账号管理新增-保存
     */
    @RequestMapping(value ="/admin/a/u/backstage-account", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addBackstageAccount(String admin,String password,String adminRole,int status){
        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }
    /**
     *103账号管理编辑—获取
     */
    @RequestMapping(value ="/admin/a/u/backstage-account/{id}", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getBackstageAccount(Long id){
        BackstageAccount bkac=new BackstageAccount();
        bkac.setId(1L);
        bkac.setAdmin("爱丽丝");
        bkac.setAdminRole("管理员,运维");
        bkac.setPassword("123456");
        bkac.setStatus(1);
        Map<String,Object> map=new HashMap<>();
        String accountId="accountId"+bkac.getId();
        map.put(accountId,bkac);
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *104账号编辑-保存
     */
    @RequestMapping(value ="/admin/a/u/backstage-account/{id}", produces="application/json",method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject updateBackstageAccount(Long id,String admin,String password,int status,String adminRole){
        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }
    /**
     *105账号管理删除
     */
    @RequestMapping(value ="/admin/a/u/backstage-account/{id}", produces="application/json",method = RequestMethod.DELETE)
    @ResponseBody
    public JSONObject deleteBackstageAccount(Long id){
        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }
}
