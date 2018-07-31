package com.ptteng.controller;



import com.alibaba.fastjson.JSONObject;
import com.ptteng.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class UserMessageController  {
    @Autowired
    private UserMessageService userMessageService ;
    /**
     *16我的
     */
    @RequestMapping(value ="/a/u/my-messages", produces="application/json",method = RequestMethod.GET)
    public JSONObject myMessage(HttpServletRequest request){
        return userMessageService.myMessage(request);
    }
    /**
     *16显示个人信息
     */
    @RequestMapping(value ="/a/u/own-messages", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getMessages(HttpServletRequest request){
        return userMessageService.getMessages(request);
    }
    /**
     *17实名验证
     */
    @RequestMapping(value ="/a/u/real-name", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject realName(String realName,String idCard,String bankCard,HttpServletRequest request){
        return userMessageService.realName(realName, idCard, bankCard,request);
    }

    /**
     *20需要短信验证（更换手机时）
     */
    @RequestMapping(value ="/a/u/sms-code", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject smsCode(HttpServletRequest request){
        return userMessageService.smsCode(request);
    }

    /**
     *23更换手机
     */
    @RequestMapping(value ="/a/u/new-phone-number", produces="application/json",method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject newPhone(String phoneNumber,Long smsCode,HttpServletRequest request){
        return userMessageService.newPhone(request,phoneNumber, smsCode);
    }
    /**
     *24修改密码
     */
    @RequestMapping(value ="/a/u/new-password", produces="application/json",method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject newPassword(String lastPassword,String newPassword1,String newPassword2,HttpServletRequest request){
        return userMessageService.newPassword(lastPassword, newPassword1, newPassword2,request);
    }
    /**
     *26消息中心(应用消息)
     */
    @RequestMapping(value ="/a/u/information-center", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject informationCenter(Long size ,Long count,HttpServletRequest request){
        return userMessageService.informationCenter(request,size, count);
    }
    /**
     *27消息阅读(应用消息)
     */
    @RequestMapping(value ="/a/u/information", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject information(Long  id,HttpServletRequest request){
        return userMessageService.information(request,id);
    }
    /**
     *26消息中心(用户建议)
     */
    @RequestMapping(value ="/a/u/sugge-center", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject suggeCenter(Long size ,Long count,HttpServletRequest request) {
        return userMessageService.suggeCenter(request,size, count);
    }
    /**
     *27消息阅读(用户建议)
     */
    @RequestMapping(value ="/a/u/sugge", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject sugge(Long id) {
        return userMessageService.sugge(id);
    }

}
