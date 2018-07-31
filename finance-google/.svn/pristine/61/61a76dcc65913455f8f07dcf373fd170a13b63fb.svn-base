package com.ptteng.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserServiceHystric implements UserService {
    @Autowired
    private JSONObject jsonObject;
    @Override
    public JSONObject outerRecord() {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject showRoleModule(HttpServletRequest request ,HttpServletResponse response) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject updatePassword(String lastPassword, String newPassword1, String newPassword2, HttpServletRequest request) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }
}
