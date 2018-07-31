package com.ptteng.controller;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.model.ModuleRole;
import com.ptteng.model.ModuleRoleManage;
import com.ptteng.model.RoleManage;
import com.ptteng.service.BackstageAccountService;
import com.ptteng.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;


@RefreshScope
@RestController
public class RoleController {
    @Autowired
    RoleService roleService;

    /**
     * 111角色管理查询角色
     */
    @RequestMapping(value = "/a/u/all-role", produces = "application/json", method = RequestMethod.GET)
    public JSONObject getAllRole(Long page, Long size) {
        return roleService.getAllRole(page, size);
    }

    /**
     * 112角色模糊查询
     */
    @RequestMapping(value = "/a/u/roles", produces = "application/json", method = RequestMethod.GET)
    public JSONObject getRoles(Long id, String role, String founder,
                               String modifier, Long page, Long size) {
        return roleService.getRoles(id, role, founder, modifier, page, size);
    }

    /**
     * 113角色查找（编辑）
     */
    @RequestMapping(value = "/a/u/role/{id}", produces = "application/json", method = RequestMethod.GET)
    public JSONObject getRoleById(Long id) {
        return roleService.getRoleById(id);
    }

    /**
     * 114角色删除
     */
    @RequestMapping(value = "/a/u/role/{id}", produces = "application/json", method = RequestMethod.DELETE)
    public JSONObject deleteRole(Long id,HttpServletRequest request)
     {
        return roleService.deleteRole(id,request);
    }

    /**
     * 115角色更改（编辑好角色后点击保存）
     */
    @RequestMapping(value = "/a/u/role", produces = "application/json", method = RequestMethod.PUT)
    public JSONObject updateRole(Long roleId, String role, String moduleIdArray,HttpServletRequest request) {
        return roleService.updateRole(roleId, role, moduleIdArray,request);
    }

    /**
     * 116角色增加
     */
    @RequestMapping(value = "/a/u/role", produces = "application/json", method = RequestMethod.GET)
    public JSONObject addRole() {
        return roleService.addRole();
    }

    /**
     * 117角色保存（增加好角色后点击保存）
     */
    @RequestMapping(value = "/a/u/role", produces = "application/json", method = RequestMethod.POST)
    public JSONObject addRole(String role, String moduleIdArray,HttpServletRequest request) {
        return roleService.addRole(role, moduleIdArray,request);
    }
}