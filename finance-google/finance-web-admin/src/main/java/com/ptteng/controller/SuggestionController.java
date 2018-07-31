package com.ptteng.controller;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.model.Suggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@RefreshScope
@Controller
public class SuggestionController {
    @Autowired
    private JSONObject jsonObject;
    /**
     *92意见反馈入口
     */
    @RequestMapping(value ="/admin/a/u/all-suggestion", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getAllSuggestion(Long page,Long size){
        Suggestion sugg=new Suggestion();
        sugg.setId(1L);
        sugg.setSuggeContent("你好");
        sugg.setAdviser("关羽");
        sugg.setPhone("15112344321");
        sugg.setSubmitTime(15112344321L);
        sugg.setReplier("张飞");
        sugg.setReplyTime(15112344321L);
        sugg.setStatus(1);
        Map<String,Object> map=new HashMap<>();
        String suggeId="suggeId"+sugg.getId();
        map.put(suggeId,sugg);
        map.put("suggeId2",sugg);
        map.put("suggeId3",sugg);
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *93意见反馈查询
     */
    @RequestMapping(value ="/admin/a/u/suggestion", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getSuggestions(Long page,Long size,Long id,String suggeContent,String phone){
        Suggestion sugg=new Suggestion();
        sugg.setId(1L);
        sugg.setSuggeContent("你好");
        sugg.setAdviser("关羽");
        sugg.setPhone("15112344321");
        sugg.setSubmitTime(15112344321L);
        sugg.setReplier("张飞");
        sugg.setReplyTime(15112344321L);
        sugg.setStatus(1);
        Map<String,Object> map=new HashMap<>();
        String suggeId="suggeId"+sugg.getId();
        map.put(suggeId,sugg);
        map.put("suggeId2",sugg);
        map.put("suggeId3",sugg);
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *94意见反馈查看详情
     *95意见反馈回复-获取
     */
    @RequestMapping(value ="/admin/a/u/suggestion/{id}", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getSuggestionById(Long id){
        Suggestion sugg=new Suggestion();
        sugg.setId(1L);
        sugg.setSuggeContent("你好");
        sugg.setAdviser("关羽");
        sugg.setSubmitTime(15112344321L);
        sugg.setReplier("张飞");
        sugg.setReplyTime(15112344321L);
        sugg.setStatus(0);
        sugg.setReplyContent("");
        Map<String,Object> map=new HashMap<>();
        String suggeId="suggeId"+sugg.getId();
        map.put(suggeId,sugg);
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *96意见反馈回复
     */
    @RequestMapping(value ="/admin/a/u/suggestion/{id}", produces="application/json",method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject updateSuggestion(Long id,int status,String replyContent){
        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }
    /**
     *97意见反馈删除
     */
    @RequestMapping(value ="/admin/a/u/suggestion/{id}", produces="application/json",method = RequestMethod.DELETE)
    @ResponseBody
    public JSONObject deleteSuggestion(Long id){
        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }

}
