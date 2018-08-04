package com.ptteng.controller;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.config.ParameterJudgement;
import com.ptteng.model.Suggestion;
import com.ptteng.service.BackstageAccountService;
import com.ptteng.service.SuggestionService;
import com.ptteng.util.Token;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RefreshScope
@RestController
public class SuggestionController {
    org.slf4j.Logger logger = LoggerFactory.getLogger(SuggestionController.class);
    @Autowired
    private JSONObject jsonObject;
    @Resource
    private SuggestionService suggestionService;
    @Resource
    private Token token;
    @Resource
    private BackstageAccountService backstageAccountService;

    /**
     *92意见反馈入口
     */
    @RequestMapping(value ="/a/u/all-suggestion", produces="application/json",method = RequestMethod.GET)
    public JSONObject getAllSuggestion(Long page,Long size){
        logger.info("/a/u/all-suggestion---GET---the request parameters are page:{},size:{}",page,size);
        List<Suggestion> suggestions;
        Long total;
        try{
        if(page!=null){
            suggestions=suggestionService.forSelect((page-1)*size, size);
        }else {
            suggestions=suggestionService.forSelect(0L,size);
        }
        for(Suggestion suggestion :suggestions){
            suggestion.setAdviser(token.SolveToken(suggestion.getAdviser()));
            suggestion.setPhone(token.SolveToken(suggestion.getPhone()));
        }
        total=suggestionService.selectCount();
        }catch (Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        String phone = "";
        String adviser;

        for(Suggestion suggestion:suggestions ){
            phone = token.SolveToken(suggestion.getPhone());
            suggestion.setPhone(phone);
            adviser = token.SolveToken(suggestion.getAdviser());
            suggestion.setAdviser(adviser);

        }
        Map<String,Object> map=new HashMap<>();
        map.put("total",total);
        map.put("products",suggestions);
//        logger.info(suggestions.toString());
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *93意见反馈查询
     */
    @RequestMapping(value ="/a/u/suggestion", produces="application/json",method = RequestMethod.GET)
    public JSONObject getSuggestions(Long page,Long size,Long id,String suggeContent,String adviser, String phone){
        logger.info("/a/u/suggestion---GET---the request parameters are size:{},page:{},id:{},suggeContent:{},adviser:{},phone:{}",id,suggeContent,adviser,phone);
        List<Suggestion> suggestions;
        Long total;
        if(adviser!=null) {
            adviser = token.makeToken(adviser);
        }
        if(phone!=null) {
            phone = token.makeToken(phone);
        }
        try{
        if(page!=null){
            suggestions=suggestionService.select((page-1)*size, size,id,suggeContent,adviser,phone);
        }else {
            suggestions=suggestionService.select(0L,size,id,suggeContent,adviser,phone);
        }
            for(Suggestion suggestion :suggestions){
                suggestion.setAdviser(token.SolveToken(suggestion.getAdviser()));
                suggestion.setPhone(token.SolveToken(suggestion.getPhone()));
            }
        total=suggestionService.selectCountWithCondition(id, suggeContent, adviser, phone);
        }catch (Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        Map<String,Object> map=new HashMap<>();
        map.put("total",total);
        map.put("products",suggestions);
//        logger.info(suggestions.toString());
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *94意见反馈查看详情
     *95意见反馈回复-获取
     */
    @RequestMapping(value ="/a/u/suggestion/{id}", produces="application/json",method = RequestMethod.GET)
    public JSONObject getSuggestionById(Long id){
        logger.info("/a/u/suggestion/{id}---GET---the request parameters are id:{}", id);
        //参数判空
        List<Object> list = new ArrayList<>();
        list.add(id);
        int judgeStatus = ParameterJudgement.isNullOrBlank(list);
        if(judgeStatus==0){
            jsonObject.put("code",1002);
            jsonObject.put("data","");
            return jsonObject;
        }
        Suggestion suggestion;
        try{
         suggestion=suggestionService.selectByPrimaryKey(id);
        }catch (Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        String phone = "";
        String adviser ="";
            phone = token.SolveToken(suggestion.getPhone());
            suggestion.setPhone(phone);
            adviser = token.SolveToken(suggestion.getAdviser());
            suggestion.setAdviser(adviser);
        logger.info(suggestion.toString());
        jsonObject.put("code",1000);
        jsonObject.put("data",suggestion);
        return jsonObject;
    }
    /**
     *96意见反馈回复
     */
    @RequestMapping(value ="/a/u/suggestion/{id}", produces="application/json",method = RequestMethod.PUT)
    public JSONObject updateSuggestion(Long id, Integer status, String replyContent,HttpServletRequest request){
        logger.info("/a/u/suggestion/{id}---PUT---the request parameters are id:{},status:{},replyContent:{}",id,status,replyContent);
        //参数判空
        List<Object> list = new ArrayList<>();
        list.add(id);
        list.add(status);
        list.add(replyContent);
        int judgeStatus = ParameterJudgement.isNullOrBlank(list);
        if(judgeStatus==0){
            jsonObject.put("code",1002);
            jsonObject.put("data","");
            return jsonObject;
        }
        String thisId = null;
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            for (Cookie c : cookie) {  // 遍历Cookie
                if("userId".equals(c.getName()))
                    thisId=c.getValue();
            }
        }
        Suggestion suggestion=new Suggestion();
        suggestion.setId(id);
        suggestion.setStatus(status);
        suggestion.setReplyContent(replyContent);
        suggestion.setReadyStatus(0);
        suggestion.setStatus(1);
        int a;
        try{
        Long userId=Long.valueOf(token.SolveToken(thisId));
        suggestion.setReplier(backstageAccountService.selectByPrimaryKey(userId).getAdmin());
        suggestion.setReplyTime(System.currentTimeMillis());
         a=suggestionService.updateByPrimaryKeySelective(suggestion);
        }catch (Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        if(a>0)
            jsonObject.put("code",1000);
        else
            jsonObject.put("code",1001);
        jsonObject.put("data","");
        return jsonObject;
    }
    /**
     *97意见反馈删除
     */
    @RequestMapping(value ="/a/u/suggestion/{id}", produces="application/json",method = RequestMethod.DELETE)
    public JSONObject deleteSuggestion(Long id){
        logger.info("/a/u/suggestion/{id}---DELETE---the request parameters are id:{}", id);
        //参数判空
        List<Object> list = new ArrayList<>();
        list.add(id);
        int judgeStatus = ParameterJudgement.isNullOrBlank(list);
        if(judgeStatus==0){
            jsonObject.put("code",1002);
            jsonObject.put("data","");
            return jsonObject;
        }
        int a;
        try{
         a=suggestionService.deleteByPrimaryKey(id);
        }catch (Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        if(a>0)
            jsonObject.put("code",1000);
        else
            jsonObject.put("code",1001);
        jsonObject.put("data","");
        return jsonObject;
    }

}
