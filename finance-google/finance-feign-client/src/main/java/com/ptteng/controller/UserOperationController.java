package com.ptteng.controller;


import com.alibaba.fastjson.JSONObject;
import com.ptteng.service.UserOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserOperationController {
    @Autowired
    private UserOperationService userOperationService ;
    /**
     *1获取短信验证码
     */
    @RequestMapping(value ="/a/verification-sms-code", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject verify(String phoneNumber,Long moduleId,HttpServletRequest request){
        return userOperationService.verify(phoneNumber,moduleId,request);
    }
    /**
     *2判断手机号码正确性
     */
    @RequestMapping(value ="/a/phone-number", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject verifyphone(String phoneNumber,Long smsCode,String pictureCode){
        return userOperationService.verifyphone(phoneNumber, smsCode, pictureCode);
    }
    /**
     *3获取图形验证码
     */
    @RequestMapping(value ="/a/picture-code", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject pictureCode(String phoneNumber){
        return userOperationService.pictureCode(phoneNumber);
    }
    /**
     *4注册用户并显示主页面
     */
    @RequestMapping(value ="/a/register", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject register(String phoneNumber,String password1,String password2,HttpServletResponse response){
        return userOperationService.register(phoneNumber, password1, password2,response);
    }
    /**
     *5登录显示主页面
     */
    @RequestMapping(value ="/a/signer", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject signer(String phoneNumber,String password,HttpServletResponse response){
        return userOperationService.signer(phoneNumber,password,response);
    }
    /**
     *6找回密码前验证手机
     */
    @RequestMapping(value ="/a/mobile", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject findPassword(String phoneNumber,Long smsCode,String pictureCode){
        return userOperationService.findPassword(phoneNumber, smsCode, pictureCode);
    }
    /**
     *7找回密码
     */
    @RequestMapping(value ="/a/password", produces="application/json",method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject getPassword(String phoneNumber,String password1,String password2){
        return userOperationService.getPassword(phoneNumber, password1, password2);
    }
    /**
     *25(没有cookie重定向接口)
     */
    @RequestMapping(value ="/a/outerRecord", produces="application/json",method = RequestMethod.GET)
    public JSONObject outerRecord() {
           return userOperationService.outerRecord();
    }
    /**
     *25退出登录
     */
    @RequestMapping(value ="/a/u/outer", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject outer(HttpServletRequest request, HttpServletResponse response){
        return userOperationService.outer(request,response);
    }
    /**
     *43意见反馈
     */
    @RequestMapping(value ="/a/u/opinion", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject opinion(@RequestParam("suggestion")String suggestion,HttpServletRequest request){
        return userOperationService.opinion(suggestion,request);
    }


}
