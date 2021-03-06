package com.ptteng.service.impl;

import com.alibaba.fastjson.JSONObject;

import com.ptteng.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class SuggestionServiceHystric implements SuggestionService {
    @Autowired
    private JSONObject jsonObject;

    @Override
    public JSONObject getAllSuggestion(Long page, Long size) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject getSuggestions(Long page, Long size, Long id, String suggeContent, String adviser, String phone) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject getSuggestionById(Long id) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject updateSuggestion(Long id, Integer status, String replyContent,HttpServletRequest request) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject deleteSuggestion(Long id) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }
}
