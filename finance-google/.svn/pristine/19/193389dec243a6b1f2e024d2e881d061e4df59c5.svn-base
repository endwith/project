package com.ptteng.controller;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.model.MessageRelationship;
import com.ptteng.model.Suggestion;
import com.ptteng.model.User;
import com.ptteng.service.InformationManageService;
import com.ptteng.service.MessageRelationshipService;
import com.ptteng.service.SuggestionService;
import com.ptteng.service.UserService;
import com.ptteng.util.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RefreshScope
@RestController
public class UserMessageController  {
    org.slf4j.Logger logger = LoggerFactory.getLogger(FinanceController.class);
    @Autowired
    private JSONObject jsonObject;
    @Resource
    private Token token;
    @Resource
    private ElTest elTest;
    @Resource
    UserService userService;
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private InformationManageService informationManageService;
    @Resource
    private MessageRelationshipService messageRelationshipService;
    @Resource
    private SuggestionService suggestionService;

    /**
     *16我的
     */
    @RequestMapping(value ="/a/u/my-messages", produces="application/json",method = RequestMethod.GET)
    public JSONObject myMessage(HttpServletRequest request){
        logger.info("/client/a/u/my-messages---GET---the request parameters are");
        Map<String,Object> map=new HashMap<>();
        String thisId = null;
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            for (Cookie c : cookie) {  // 遍历Cookie
                if("userId".equals(c.getName()))
                    thisId=c.getValue();

            }
        }
        User user;
        long noReadCount;
        try{
            user=userService.selectByPrimaryKey(Long.valueOf(token.SolveToken(thisId)));
            logger.info("id -------  {}",token.SolveToken(thisId));
            List countInfor = messageRelationshipService.selectByUserId(Long.valueOf(token.SolveToken(thisId)));
            long countSuggestion = suggestionService.selectSuggeNoReadCount(Long.valueOf(token.SolveToken(thisId)));
            long inforCount = informationManageService.selectCount();
            noReadCount = inforCount - countInfor.size()  +  countSuggestion ;
            if(noReadCount<0){
                noReadCount=0;
            }

        }catch(Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }

        String name = token.SolveToken(user.getTrueName());
        String phone=token.SolveToken(user.getPhone());
        map.put("phone",phone);
        map.put("trueName",name);
        map.put("totalAssets",user.getTotalAssets());
        map.put("noReadCount",noReadCount);
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *16显示个人信息
     */
    @RequestMapping(value ="/a/u/own-messages", produces="application/json",method = RequestMethod.GET)
    public JSONObject getMessages(HttpServletRequest request){
        logger.info("/client/a/u/own-messages---GET---the request parameters are");
        Map<String,Object> map=new HashMap<>();
        String thisId = null;
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            for (Cookie c : cookie) {  // 遍历Cookie
                if("userId".equals(c.getName()))
                    thisId=c.getValue();
            }
        }
        User user;
        try{
            user=userService.selectByPrimaryKey(Long.valueOf(token.SolveToken(thisId)));
        }catch(Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        int a;
        if("".equals(token.SolveToken(user.getTrueName()))){
            a=0;
        }else
        {
            a=1;
        }
        String phone=token.SolveToken(user.getPhone());
        map.put("phone",phone);
        map.put("isToVerifiedRealname",a);
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *17实名验证(下一步)
     */
    @RequestMapping(value ="/a/u/real-name", produces="application/json",method = RequestMethod.POST)
    public JSONObject realName(String realName,String idCard,String bankCard,HttpServletRequest request) throws Exception {
        logger.info("/client/a/u/real-name---POST---the request parameters are realName:{},idCard:{},bankCard:{}",realName,idCard,bankCard);
        String id = null;
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            for (Cookie c : cookie) {  // 遍历Cookie
                if("userId".equals(c.getName()))
                    id=c.getValue();
            }
        }
        User user;
        try{
            user=userService.selectByPrimaryKey(Long.valueOf(token.SolveToken(id)));
            if(!("".equals(token.SolveToken(user.getTrueName())))){
                jsonObject.put("data","");
                jsonObject.put("code",2004);
                return jsonObject;
            }

        }catch (Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        FuiouUtil fuiouUtil=new FuiouUtil();
        Map<String,String> map=new HashMap<>();
        String str=null;
        str=fuiouUtil.checkBankCard(realName,idCard,bankCard);
        if (str.contains("成功")) {
            String reg = "[^\u4e00-\u9fa5]";
            str = str.replaceAll(reg, "");
            user.setTrueName(token.makeToken(realName));
            user.setIdCard(token.makeToken(idCard));
            str=str.replace("成功","");
            if(str.contains("中国")){
            str=str.replace("中国","");
            }
            user.setBankCard1(token.makeToken(str+bankCard));
            userService.updateByPrimaryKeySelective(user);
            jsonObject.put("code",1000);
        }else {
            String reg = "[^\u4e00-\u9fa5]";
            str = str.replaceAll(reg, "");
            jsonObject.put("code",1001);
            jsonObject.put("data",str);
            return jsonObject;
        }
        map.put("bank",str);
        map.put("bankCard",bankCard);
        map.put("phone",token.SolveToken(user.getPhone()));
        jsonObject.put("data",map);
        return jsonObject;
    }

    /**
     *20更换手机
     */
    @RequestMapping(value ="/a/u/sms-code", produces="application/json",method = RequestMethod.GET)
    public JSONObject smsCode(HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        String id = null;
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            for (Cookie c : cookie) {  // 遍历Cookie
                if("userId".equals(c.getName()))
                    id=c.getValue();
            }
        }
        User user;
        try{
            user=userService.selectByPrimaryKey(Long.valueOf(token.SolveToken(id)));
        }catch (Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        String phoneNumber=token.SolveToken(user.getPhone());
        jsonObject.put("code",1000);
        map.put("phoneNumber",phoneNumber);
        jsonObject.put("data",map);
        return jsonObject;
    }


    /**
     *23更换手机
     */
    @RequestMapping(value ="/a/u/new-phone-number", produces="application/json",method = RequestMethod.PUT)
    public JSONObject newPhone(String phoneNumber,Long smsCode,HttpServletRequest request){
        logger.info("/client/a/u/new-phone-number---PUT---the request parameters are phoneNumber:{},smsCode:{}",phoneNumber,smsCode);
        CheckPhone checkPhone=new CheckPhone();
        if(!checkPhone.isPhone(phoneNumber)){
            jsonObject.put("code", 1002);
            jsonObject.put("data", "");
            return jsonObject;
        }
        Map<String,Object> map=new HashMap<>();
        String id = null;
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            for (Cookie c : cookie) {  // 遍历Cookie
                if("userId".equals(c.getName()))
                    id=c.getValue();
            }
        }
        Long userId=Long.valueOf(token.SolveToken(id));
        User user;
        try
        {
            String phoneWithToken=token.makeToken(phoneNumber);
            if(userService.selectByPhoneNumber(phoneWithToken)!=null){
                jsonObject.put("code", 2003);
                jsonObject.put("data", "");
                return jsonObject;
            }
            user=userService.selectByPrimaryKey(userId);
        }catch (Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        String phone=token.SolveToken(user.getPhone());
//        if(redisTemplate.hasKey(""+phone)){
//            String code=(String)redisTemplate.opsForValue().get("googleSmsCode3"+phone);
            if(smsCode != null/* &&smsCode.equals(code)*/){
                user.setPassword(token.makeToken(phoneNumber));
                try{
                    userService.insertSelective(user);
                }catch (Throwable e){
                    logger.error("异常"+e);
                    jsonObject.put("data","");
                    jsonObject.put("code",2001);
                    return jsonObject;
                }
                jsonObject.put("code",1000);
            }else{
                jsonObject.put("code",3004);
            }
//        }else{
//            jsonObject.put("code",3003);
//        }
        jsonObject.put("code", 3004);
        jsonObject.put("data", "");
        return jsonObject;
    }
    /**
     *24修改密码
     */
    @RequestMapping(value ="/a/u/new-password", produces="application/json",method = RequestMethod.PUT)
    public JSONObject newPassword(String lastPassword,String newPassword1,String newPassword2,HttpServletRequest request){
        logger.info("/client/a/u/new-password---PUT---the request parameters are lastPassword:{},newPassword1:{},newPassword2:{}",lastPassword,newPassword1,newPassword2);
        Map<String,Object> map=new HashMap<>();
        String id = null;
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            for (Cookie c : cookie) {  // 遍历Cookie
                if("userId".equals(c.getName()))
                    id=c.getValue();
            }
        }
        logger.info("***************************"+id);
        if(newPassword1.equals(newPassword2)){
            User user;
            try{
                user=userService.selectByPrimaryKey(Long.valueOf(token.SolveToken(id)));
            }catch (Throwable e){
                logger.error("异常"+e);
                jsonObject.put("data","");
                jsonObject.put("code",2001);
                return jsonObject;
            }
            String passwordWithSalt=Md5Utils.mixPasswordWithSalt(lastPassword,user.getSalt());
            if(user.getPassword().equals(passwordWithSalt)){
                try{
                    user.setPassword(Md5Utils.mixPasswordWithSalt(newPassword1,user.getSalt()));
                    userService.updateByPrimaryKeySelective(user);
                }catch (Throwable e){
                    logger.error("异常"+e);
                    jsonObject.put("data","");
                    jsonObject.put("code",2001);
                    return jsonObject;
                }
                jsonObject.put("code", 1000);
            }else {
                jsonObject.put("code", 1007);
            }
        }else {
            jsonObject.put("code", 1002);
        }
        jsonObject.put("data", "");
        return jsonObject;
    }
    /**
     *26消息中心(应用消息)
     */
    @RequestMapping(value ="/a/u/information-center", produces="application/json",method = RequestMethod.GET)
    public JSONObject informationCenter(Long size ,Long count,HttpServletRequest request){
        size =100l;
        logger.info("/client/a/u/information-center---GET---the request parameters are size:{},count:{}",size,count);
        String id = null;
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            for (Cookie c : cookie) {  // 遍历Cookie
                if("userId".equals(c.getName()))
                    id=c.getValue();
            }
        }
        Long userId=Long.valueOf(token.SolveToken(id));
        List<Object> informations = new ArrayList<>();
        try{
            //先获取用户已读message的id，在去获取用户已读和未读取的
            List<Long> s =messageRelationshipService.selectByUserId(userId);
            logger.info("------"+s);
            if(s.size()!=0) {
                informations = informationManageService.selectInforByReadList(s, size * count);
            }else {
                informations= informationManageService.selectInforByReadListAll(size*count);
            }
        }catch (Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        logger.info("{}",informations);
        jsonObject.put("code",1000);
        jsonObject.put("data",informations);
        return jsonObject;
    }
    /**
     *27消息阅读(应用消息),点击阅读同时修改数据库MessageRelationship表，将未读状态改为已读
     */
    @RequestMapping(value ="/a/u/information", produces="application/json",method = RequestMethod.GET)
    public JSONObject information(Long  id,HttpServletRequest request){
        logger.info("/client/a/u/information---GET---the request parameters are id:{}",id);
        String userId = null;
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            for (Cookie c : cookie) {  // 遍历Cookie
                if("userId".equals(c.getName()))
                    userId=c.getValue();
            }
        }
        Long thisUserId=Long.valueOf(token.SolveToken(userId));
        List<Object> informationContent;
        try{
            List<Long> s =messageRelationshipService.selectByUserId(thisUserId);
            if(!s.contains(id)){
                MessageRelationship messageRelationship=new MessageRelationship();
                messageRelationship.setInforId(id);
                messageRelationship.setUserId(thisUserId);
                messageRelationshipService.insert(messageRelationship);
            }
            informationContent=informationManageService.selectContent(id);}
        catch (Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        jsonObject.put("code",1000);
        jsonObject.put("data",informationContent);
        return jsonObject;
    }


    /**
     *26消息中心(用户建议)
     */
    @RequestMapping(value ="/a/u/sugge-center", produces="application/json",method = RequestMethod.GET)
    public JSONObject suggeCenter(Long size ,Long count,HttpServletRequest request){
        size =101l;
        logger.info("/client/a/u/sugge-center---GET---the request parameters are size:{},count:{}",size,count);
        String id = null;
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            for (Cookie c : cookie) {  // 遍历Cookie
                if("userId".equals(c.getName()))
                    id=c.getValue();
            }
        }
        Long userId=Long.valueOf(token.SolveToken(id));
        List<Object> sugges;
        try{
            sugges=suggestionService.selectSuggeByRead(userId,size*count);
        }catch (Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        jsonObject.put("code",1000);
        jsonObject.put("data",sugges);
        return jsonObject;
    }
    /**
     *27消息阅读(用户建议)
     */
    @RequestMapping(value ="/a/u/sugge", produces="application/json",method = RequestMethod.GET)
    public JSONObject sugge(Long  id){
        logger.info("/client/a/u/sugge---GET---the request parameters are id:{}",id);
        List<Object> sugge;
        try{
            Suggestion suggestion=suggestionService.selectByPrimaryKey(id);
            if (suggestion.getReadyStatus()==0){
                suggestion.setReadyStatus(1);
                suggestionService.updateByPrimaryKeySelective(suggestion);
            }
            sugge=suggestionService.selectSuggeContentById(id);
        }catch (Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        jsonObject.put("code",1000);
        jsonObject.put("data",sugge);
        return jsonObject;
    }


}
