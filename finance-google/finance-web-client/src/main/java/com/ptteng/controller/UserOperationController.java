package com.ptteng.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RefreshScope
@Controller
public class UserOperationController {
    @Autowired
    private  JSONObject jsonObject;
    org.slf4j.Logger logger = LoggerFactory.getLogger(UserOperationController.class);
    private int smsCount;
    /**
     *1获取短信验证码
     */
    @RequestMapping(value ="/client/a/verification-sms-code", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject verify(String phoneNumber,long moduleId){

        Map verifyMap = new HashMap();
        jsonObject.put("code",1000);
        jsonObject.put("data",verifyMap);
        return jsonObject;
    }
    /**
     *2判断手机号码正确性
     */
    @RequestMapping(value ="/client/a/phone-number", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject verifyphone(String phoneNumber,long smsCode,String pictureCode){
        
        if(smsCode!=666666&&smsCount<3){
            jsonObject.put("code",3004);
            smsCount++;
        }else if (smsCode!=666666&&smsCount >= 3){
            jsonObject.put("code",3005);
        }else if(smsCode==666666){
            jsonObject.put("code",1000);
        }else if(smsCode==666666&&pictureCode.equals("zcdy")){
            jsonObject.put("code",1000);
        }
       jsonObject.put("data","");
        return jsonObject;
    }
    /**
     *3获取图形验证码
     */
    @RequestMapping(value ="/client/a/picture-code", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject pictureCode(String phoneNumber){
        Map verifyMap = new HashMap();
        Map pictureData = new HashMap();
        jsonObject.put("code",1000);
        pictureData.put("pictureUrl","http://p9ffg65uy.bkt.clouddn.com/zcdy.jpeg");
        jsonObject.put("data",pictureData);

        return jsonObject;
    }
    /**
     *4注册用户并显示主页面
     */
    @RequestMapping(value ="/client/a/register", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject register(String phoneNumber,String password1,String password2){
        List<Map> mapList = new ArrayList<>();
        for(int i =0;i<5;i++){
            Map dataMap = new HashMap();
            dataMap.put("title","聚金融三周年");
            dataMap.put("bannerPicture","http://p9ffg65uy.bkt.clouddn.com/30.jpg");
            mapList.add(dataMap);
        }
        Map dataMap = new HashMap();
        dataMap.put("product","新手礼");
        dataMap.put("picture","http://p9ffg65uy.bkt.clouddn.com/31.jpg");
        mapList.add(dataMap);
        jsonObject.put("code",1000);
        jsonObject.put("data",mapList);
        return jsonObject;
    }
    /**
     *5登录显示主页面
     */
    @RequestMapping(value ="/client/a/u/signer", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject signer(String phoneNumber,String password){
        JSONObject jsonObject = new JSONObject();
        List<Map> mapList = new ArrayList<>();
        for(int i =0;i<4;i++){
            Map dataMap = new HashMap();
            dataMap.put("title","聚金融三周年");
            dataMap.put("bannerPicture","http://p9ffg65uy.bkt.clouddn.com/30.jpg");
            mapList.add(dataMap);
        }
        Map dataMap = new HashMap();
        dataMap.put("product","新手礼");
        dataMap.put("picture","http://p9ffg65uy.bkt.clouddn.com/31.jpg");
        mapList.add(dataMap);
        jsonObject.put("code",1000);
        jsonObject.put("data",mapList);
        return jsonObject;
    }
    /**
     *6找回密码前验证手机
     */
    @RequestMapping(value ="/client/a/mobile", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject findPassword(String phoneNumber,long smsCode,String pictureCode){

        if (smsCode!=666666&&smsCount >= 3){
            jsonObject.put("code",3005);
        }else if(smsCode!=666666&&smsCount<3){
            jsonObject.put("code",3004);
            smsCount++;
        } else if(smsCode==666666){
            jsonObject.put("code",1000);
        }else if(smsCode==666666&&pictureCode.equals("zcdy")){
            jsonObject.put("code",1000);
        }
        jsonObject.put("data","");
        return jsonObject;
    }
    /**
     *7找回密码
     */
    @RequestMapping(value ="/client/a/password", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getPassword(String phoneNumber,String password1,String password2){

            jsonObject.put("code", 1000);
            jsonObject.put("data", "");

        return jsonObject;
    }
    /**
     *25退出登录
     */
    @RequestMapping(value ="/client/a/u/outer", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject outer(){
        jsonObject.put("code", 1000);
        jsonObject.put("data", "");
        return jsonObject;
    }
    /**
     *43意见反馈
     */
    @RequestMapping(value ="/client/a/u/opinion", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject opinion(String suggestion){

        jsonObject.put("code", 1000);
        jsonObject.put("data", "");
        return jsonObject;
    }


}
