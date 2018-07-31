package com.ptteng.controller;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.model.BackstageAccount;
import com.ptteng.model.ModuleManage;
import com.ptteng.model.ModuleRoleManage;
import com.ptteng.service.BackstageAccountService;
import com.ptteng.service.ModuleManageService;
import com.ptteng.util.Token;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RefreshScope
@RestController
public class ModuleManageController {
    org.slf4j.Logger logger = LoggerFactory.getLogger(ModuleManageController.class);
    @Autowired
    private ModuleManageService moduleManageService;
    @Autowired
    private JSONObject jsonObject;
    @Autowired
    BackstageAccountService backstageAccountService;

    /**
     *106模块管理查询模块
     */
    @RequestMapping(value ="/a/u/all-module", produces="application/json",method = RequestMethod.GET)
    public JSONObject getAllModule(Long page,Long size){
        logger.info("/a/u/all-module---GET---the request parameters are page:{},size:{}",page,size);
        List<ModuleManage> modules;
        long total;
        try {
            if (page != null) {
                modules = moduleManageService.forSelect((page - 1) * size, size);
            } else {
                modules = moduleManageService.forSelect(0L, size);
            }
            total = moduleManageService.selectCount();
            logger.info(modules.toString());
            Map map = new HashMap();
            map.put("total",total);
            map.put("modules",modules);
            logger.info(map.toString());
            jsonObject.put("code", 1000);
            jsonObject.put("data", map);
        } catch (Exception e){
            logger.info("错误",e);
            jsonObject.put("code",2001);
        }
        return jsonObject;
    }
    /**
     *107模块模糊查询查询
     */
    @RequestMapping(value ="/a/u/modules", produces="application/json",method = RequestMethod.GET)
    public JSONObject getModules(Long id,String moduleName,Long parentModule
    ,String founder,Long page,Long size){
        logger.info("/a/u/modules---GET---the request parameters a" +
                        "re id:{},moduleName:{},parentModule:{},founder:{},page:{},size:{}",
                id,moduleName,parentModule,founder,page,size);
        List<ModuleManage> modules;
        try {
            if (page != null) {
                modules = moduleManageService.select((page - 1) * size, size, id, moduleName, parentModule, founder);
            } else {
                modules = moduleManageService.select(0L, size, id, moduleName, parentModule, founder);
            }
            logger.info(modules.toString());
            jsonObject.put("code", 1000);
            jsonObject.put("data", modules);
        }  catch (Exception e){
            logger.info("错误",e);
            jsonObject.put("code",2001);
        }
        return jsonObject;
    }
    /**
     *108模块查找（实际上是编辑按钮）
     */
    @RequestMapping(value ="/a/u/module/{id}", produces="application/json",method = RequestMethod.GET)
    public JSONObject getModuleById(Long id){
        logger.info("/a/u/module/{id}---GET---the request parameters a" +
                        "re id:{}",id);
        try {
           // logger.info(moduleManageService.selectAll().toString());
            ModuleManage module = moduleManageService.selectByPrimaryKey((long)id);
            Map map = new HashMap();
            map.put("id", module.getId());
            map.put("moduleName", module.getModuleName());
            map.put("moduleUrl", module.getModuleUrl());
            map.put("parentModule", module.getParentId());
            map.put("type", module.getType());
            logger.info(module.toString());
            jsonObject.put("code", 1000);
            jsonObject.put("data",map);
        }
        catch (Exception e){
                logger.info("错误",e);
                jsonObject.put("code",2001);
                jsonObject.put("data","");
            }
        return jsonObject;
    }
    /**
     *109模块删除
     */
    @RequestMapping(value ="/a/u/module/{id}", produces="application/json",method = RequestMethod.DELETE)
    public JSONObject deleteModule(Long id){
        logger.info("/a/u/module/{id}---DELETE---the request parameters a" +
                "re id:{}",id);
        try {
            moduleManageService.deleteByPrimaryKey(id);
            moduleManageService.deleteByModuleId(id);
            jsonObject.put("code", 1000);
        } catch (Exception e){
            logger.info("错误",e);
            jsonObject.put("code",2001);
        }
        jsonObject.put("data","");
        return jsonObject;
    }
    /**
     *110模块更改（编辑好角色后点击保存）
     */
    @RequestMapping(value ="/a/u/module", produces="application/json",method = RequestMethod.PUT)
    public JSONObject updateModule(Long id,String moduleName,String moduleUrl
            ,Long parentModule,String type,HttpServletRequest request){
        logger.info("/a/u/module---PUT---the request parameters a" +
                        "re id:{},moduleName:{},moduleUrl {},parentModule:{},type:{}",
                id,moduleName,moduleUrl,parentModule,type);
        String modifier = "";
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userId")) {
                Token token = new Token();
                modifier = backstageAccountService.selectByPrimaryKey(Long.valueOf(token.SolveToken(cookie.getValue()))).getAdmin();
            }
        }
        try {
            ModuleManage module = new ModuleManage();
            module.setId(id);
            module.setModuleName(moduleName);
            module.setModuleUrl(moduleUrl);
            module.setParentId(parentModule);
            module.setModifier(modifier);
            module.setUpdateAt(new Date().getTime());
            module.setType(type);
            moduleManageService.updateByPrimaryKeySelective(module);

            jsonObject.put("code", 1000);
        }catch (Exception e){
            logger.info("错误",e);
            jsonObject.put("code",2001);
        }
        jsonObject.put("data","");

        return jsonObject;
    }

    /**
     *111模块新增（新增好模块后点击保存）
     */
    @RequestMapping(value ="/a/u/module", produces="application/json",method = RequestMethod.POST)
    public JSONObject addModule(String moduleName,String moduleUrl
            ,Long parentModule,String type,HttpServletRequest request){
        logger.info("/a/u/module---POST---the request parameters a" +
                        "re moduleName:{},moduleUrl {},parentModule:{},type:{}",
               moduleName,moduleUrl,parentModule,type);
        Cookie[] cookies = request.getCookies();
        String founder = "";
        String role = "";
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userId")) {
                    Token token = new Token();
                    BackstageAccount backstageAccount = backstageAccountService.selectByPrimaryKey(Long.valueOf(token.SolveToken(cookie.getValue())));
                    founder = backstageAccount.getAdmin();
                    role = backstageAccount.getAdminRole();
                }
            }
        try {
            ModuleManage module = new ModuleManage();
            module.setModuleName(moduleName);
            module.setModuleUrl(moduleUrl);
            module.setParentId(parentModule);
            module.setCreateAt(new Date().getTime());
            module.setType(type);
            module.setFounder(founder);
            moduleManageService.insert(module);
            long moduleNewId = module.getId();
            String[] roleList = role.split(",");
            for(String role1 : roleList){
                if(role1.contains("管理员")){
                    ModuleRoleManage moduleRoleManage = new ModuleRoleManage();
                    moduleRoleManage.setRole(role1);
                    moduleRoleManage.setModuleId(moduleNewId);
                    moduleManageService.insert(moduleRoleManage);
                }
            }
            jsonObject.put("code", 1000);
        }catch (Exception e){
            logger.info("错误",e);
            jsonObject.put("code",2001);
        }
        jsonObject.put("data","");

        return jsonObject;
    }
}
