package com.ptteng.controller;

import com.alibaba.fastjson.JSONObject;

import com.ptteng.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RefreshScope
@RestController
public class SuggestionController {
    @Autowired
    SuggestionService suggestionService;

    /**
     *92意见反馈入口
     */
    @RequestMapping(value ="/a/u/all-suggestion", produces="application/json",method = RequestMethod.GET)
    public JSONObject getAllSuggestion(Long page,Long size){
        return suggestionService.getAllSuggestion(page, size);
    }
    /**
     *93意见反馈查询
     */
    @RequestMapping(value ="/a/u/suggestion", produces="application/json",method = RequestMethod.GET)
    public JSONObject getSuggestions(Long page,Long size,Long id,String suggeContent,String adviser, String phone){
        return suggestionService.getSuggestions(page, size, id, suggeContent, adviser, phone);
    }
    /**
     *94意见反馈查看详情
     *95意见反馈回复-获取
     */
    @RequestMapping(value ="/a/u/suggestion/{id}", produces="application/json",method = RequestMethod.GET)
    public JSONObject getSuggestionById(Long id){
        return suggestionService.getSuggestionById(id);
    }
    /**
     *96意见反馈回复
     */
    @RequestMapping(value ="/a/u/suggestion/{id}", produces="application/json",method = RequestMethod.PUT)
    public JSONObject updateSuggestion( Long id, Integer status, String replyContent,HttpServletRequest request){
        return suggestionService.updateSuggestion( id, status, replyContent,request);
    }
    /**
     *97意见反馈删除
     */
    @RequestMapping(value ="/a/u/suggestion/{id}", produces="application/json",method = RequestMethod.DELETE)
    public JSONObject deleteSuggestion(Long id){
        return suggestionService.deleteSuggestion(id);
    }

}
