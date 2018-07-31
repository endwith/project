package com.ptteng.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@RefreshScope
@Controller
public class RoleController {
    @Autowired
    JSONObject jsonObject;
    /**
     *111角色管理查询角色
     */
    @RequestMapping(value ="/admin/a/u/all-role", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getAllRole(long page,long size){
        List<Map> mapList = new ArrayList<>();
        for(int i =0;i<size;i++) {
            Map map  = new HashMap();
            map.put("id",i );
            map.put("roleId","JS0000"+String.valueOf(i));
            map.put("role","路飞");
            map.put("updateAt",new Date().getTime());
            map.put("createAt",new Date().getTime());
            map.put("founder","娜美");
            map.put("modifier","火影");
            mapList.add(map);

        }
        jsonObject.put("code",1000);
        jsonObject.put("data",mapList);
        return jsonObject;
    }
    /**
     *112角色模糊查询
     */
    @RequestMapping(value ="/admin/a/u/roles", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getRoles(String roleId,String role,String founder,
                               String modifier,long page,long size){
        List<Map> mapList = new ArrayList<>();
        for(int i =0;i<size;i++) {
            Map map  = new HashMap();
            map.put("id",i );
            map.put("roleId","JS0000"+String.valueOf(i));
            map.put("role","山治");
            map.put("updateAt",new Date().getTime());
            map.put("createAt",new Date().getTime());
            map.put("founder","鼬");
            map.put("modifier","火影");
            mapList.add(map);

        }
        jsonObject.put("code",1000);
        jsonObject.put("data",mapList);
        return jsonObject;
    }
    /**
     *113角色查找（编辑）
     */
    @RequestMapping(value ="/admin/a/u/role/{id}", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getRoleById(long id){
            Map map  = new HashMap();
            map.put("id",2 );
            map.put("roleId","JS000002");
            map.put("role","路飞");
            map.put("updateAt",new Date().getTime());
            map.put("createAt",new Date().getTime());
            map.put("founder","娜美");
            map.put("modifier","树界降临");
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *114角色删除
     */
    @RequestMapping(value ="/admin/a/u/role/{id}", produces="application/json",method = RequestMethod.DELETE)
    @ResponseBody
    public JSONObject deleteRole(long id){
        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }
    /**
     *115角色更改（编辑好角色后点击保存）
     */
    @RequestMapping(value ="/admin/a/u/role", produces="application/json",method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject updateRole(long id,String role,String[] authority){
        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }

}
