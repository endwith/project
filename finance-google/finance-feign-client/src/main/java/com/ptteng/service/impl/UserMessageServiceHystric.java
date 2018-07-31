package com.ptteng.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Component
public class UserMessageServiceHystric implements UserMessageService {
    @Autowired
    private JSONObject jsonObject;

    @Override
    public JSONObject myMessage(HttpServletRequest request){
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }
    @Override
    public JSONObject getMessages(HttpServletRequest request) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject realName(String realName,String idCard,String bankCard,HttpServletRequest request) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject smsCode(HttpServletRequest request) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }



    @Override
    public JSONObject newPhone( HttpServletRequest request,String phoneNumber,Long smsCode) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject newPassword(String lastPassword,String newPassword1,String newPassword2,HttpServletRequest request) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject informationCenter(HttpServletRequest request,Long size ,Long count) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject information(HttpServletRequest request,Long  id) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject suggeCenter(HttpServletRequest request,Long size ,Long count) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject sugge(Long  id) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }
}
