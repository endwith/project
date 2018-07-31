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
public class UserMessageController  {
    @Autowired
    private JSONObject jsonObject;
    /**
     *16显示个人信息
     */
    @RequestMapping(value ="/client/a/u/own-messages", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getMessages(){
        Map person = new HashMap();
        person.put("phone","18819422220");
        person.put("is",1);
        jsonObject.put("code",1000);
        jsonObject.put("data",person);
        return jsonObject;
    }
    /**
     *17实名验证
     */
    @RequestMapping(value ="/client/a/u/real-name", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject realName(String realName,String idCard,String bankCard){
        Map bank = new HashMap();
        bank.put("bankType","交通银行");
        jsonObject.put("code",1000);
        jsonObject.put("data",bank);
        return jsonObject;
    }
    /**
     *18绑卡
     */
    @RequestMapping(value ="/client/a/u/tieing-bank-card", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject tieBankCard(String bankPhoneNumber){

        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }
    /**
     *19实名验证（点击下一步）
     */
    @RequestMapping(value ="/client/a/u/true-name", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject trueName(long smsCode){
        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }/**
     *20需要短信验证（更换手机时）
     */
    @RequestMapping(value ="/client/a/u/sms-code", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject smsCode(){
        Map phoneNumber = new HashMap();
        phoneNumber.put("phoneNumber","18819459990");
        jsonObject.put("code",1000);
        jsonObject.put("data",phoneNumber);
        return jsonObject;
    }
    /**
     *21发送验证码（这个是不用输入手机号码的）
     */
    @RequestMapping(value ="/client/a/u/verification-code", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject verificationCode(long moduleId){
        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }
    /**
     *22验证码检验（下一步）
     */
    @RequestMapping(value ="/client/a/u/checked-code", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject checkedCode(long smsCode) {
        if (smsCode == 666666) {
            jsonObject.put("code", 1000);
            jsonObject.put("data", "");

        }else {
            jsonObject.put("code", 3004);
            jsonObject.put("data", "");
        }
        return jsonObject;
    }
    /**
     *23更换手机
     */
    @RequestMapping(value ="/client/a/u/new-phone-number", produces="application/json",method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject newPhone(String phoneNumber,long smsCode){
        if (smsCode == 666666) {
            jsonObject.put("code", 1000);
            jsonObject.put("data", "");

        }else {
            jsonObject.put("code", 3004);
            jsonObject.put("data", "");
        }
        return jsonObject;
    }
    /**
     *24修改密码
     */
    @RequestMapping(value ="/client/a/u/new-password", produces="application/json",method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject newPassword(String lastPassword,String newPassword1,String newPassword2){
        if (lastPassword.equals("666666")) {
            jsonObject.put("code", 1000);
            jsonObject.put("data", "");

        }else {
            jsonObject.put("code", 1007);
            jsonObject.put("data", "");
        }
        return jsonObject;
    }
    /**
     *26消息中心
     */
    @RequestMapping(value ="/client/a/u/information-center", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject informationCenter(){
        List<Map> informationMap = new ArrayList<>();
        for(int i = 0;i<10;i++){
            Map inforMap = new HashMap();
            inforMap.put("id",i);
            inforMap.put("inforTitle","六一快乐");
            inforMap.put("sendTime",new Date().getTime());
            inforMap.put("status",0);
            informationMap.add(inforMap);
        }
        jsonObject.put("code",1000);
        jsonObject.put("data",informationMap);
        return jsonObject;
    }
    /**
     *27消息阅读
     */
    @RequestMapping(value ="/client/a/u/information", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject information(long id){
        Map inforMap = new HashMap();
        inforMap.put("inforContent","六一儿童节快乐，祝您的孩子健康成长，快快乐乐");
        inforMap.put("inforPicture","http://p9ffg65uy.bkt.clouddn.com/31.jpg");
        jsonObject.put("code",1000);
        jsonObject.put("data",inforMap);
        return jsonObject;
    }





}
