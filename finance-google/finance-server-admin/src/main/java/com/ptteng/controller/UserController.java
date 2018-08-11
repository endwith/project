package com.ptteng.controller;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.config.ParameterJudgement;
import com.ptteng.model.BackstageAccount;


import com.ptteng.model.FirstModule;
import com.ptteng.model.ModuleRole;
import com.ptteng.service.BackstageAccountService;
import com.ptteng.service.ModuleManageService;


import com.ptteng.util.Md5Utils;
import com.ptteng.util.Token;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RefreshScope
@RestController
public class UserController {
    @Autowired
    private JSONObject jsonObject;
    @Autowired
    private BackstageAccountService backstageAccountService;
    @Autowired
    private ModuleManageService moduleManageService;
    @Autowired Token token;


    org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);
    /**
     *44后台登录
     */
    @RequestMapping(value ="/a/b/login", produces="application/json",method = RequestMethod.POST)
    public JSONObject login(Long id ,String password,HttpServletResponse response){
        logger.info("/a/login---POST---" +
                "the request parameters are id:{},password:{},response;{}",id , password, response);
        //参数判空
        List<Object> list = new ArrayList<>();
        list.add(id);
        list.add(password);
        int judgeStatus = ParameterJudgement.isNullOrBlank(list);
        if(judgeStatus==0){
            jsonObject.put("code",1002);
            jsonObject.put("data","");
            return jsonObject;
        }
//        String salt= UUID.randomUUID().toString();
        logger.info(""+id);
        logger.info(password);
        //Token 和 md5
        String passwordWithMD5= Md5Utils.MD5(password);
        logger.info("登录密码:::"+passwordWithMD5);
        List<ModuleRole> moduleManages;
        Map map  =new HashMap();
        try{
        BackstageAccount backstageAccount=backstageAccountService.selectByPrimaryKey(id);
            //没有该用户
            if(null==backstageAccount)
            {
                jsonObject.put("code",1005);
                jsonObject.put("data","");
                return jsonObject;
            }
        map.put("id",id);
        map.put("role",backstageAccount.getAdminRole());
        map.put("admin",backstageAccount.getAdmin());
        //密码错误
        if(!(backstageAccount.getPassword().equals(passwordWithMD5)))
        {
            jsonObject.put("code",1007);
            jsonObject.put("data","");
            return jsonObject;
        }
        }catch (Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        Long thisTime=System.currentTimeMillis();
        //加密登录时间，用户名
        String psw=token.makeToken(String.valueOf(thisTime));
        String idWithToken=token.makeToken(String.valueOf(id));
        Cookie userCookie=new Cookie("userId",idWithToken);//添加用户名
        userCookie.setMaxAge(7*24*60*60);
        userCookie.setPath("/");
        response.addCookie(userCookie);
        //cookie添加登录时间
        Cookie c = new Cookie("key",psw);//添加登录时间
        c.setPath("/");
        c.setMaxAge(7*24*60*60);
        response.addCookie(c);
            jsonObject.put("code",1000);
        jsonObject.put("data",map);
            return jsonObject;
    }
    /**
     *(没有cookie重定向接口)
     */
    @RequestMapping(value ="/a/outerRecord", produces="application/json",method = RequestMethod.GET)
    public JSONObject outerRecord() {
        jsonObject.put("code", 5555);
        jsonObject.put("data", "");
        return jsonObject;
    }
    /**
     *退出登录
     */
    @RequestMapping(value ="/a/b/u/outer", produces="application/json",method = RequestMethod.POST)
    public JSONObject outer(HttpServletRequest request, HttpServletResponse response) {
        logger.info("/client/a/u/outer---POST---" +
                "the request parameters are null:{}");
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {

            for (Cookie cookie : cookies) {
                if ("userId".equals(cookie.getName())) {
                    cookie.setValue(null);
                    cookie.setMaxAge(0);// 立即销毁cookie
                    cookie.setPath("/");
                    System.out.println("*****************"+123456);
                    response.addCookie(cookie);
                }
                if ("userTime".equals(cookie.getName())) {
                    cookie.setValue(null);
                    cookie.setMaxAge(0);// 立即销毁cookie
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }
                jsonObject.put("code", 1000);
                jsonObject.put("data", "");

            }
        }
        return jsonObject;
    }
    /**
     * 44权限模块显示
     */
    @RequestMapping(value ="/a/u/loginer", produces="application/json",method = RequestMethod.GET)
    public JSONObject showRoleModule(HttpServletRequest request,HttpServletResponse response){
        logger.info("/admin/a/loginer---GET---" +
                "the request parameters are null");
        long id = 0l;
        List<ModuleRole> moduleManages;
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
            if("userId".equals(cookie.getName())){
                id = Long.valueOf(token.SolveToken(cookie.getValue()));
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        List<FirstModule> nestModules = new ArrayList<>();
        try{
            BackstageAccount backstageAccount=backstageAccountService.selectByPrimaryKey(id);
            String adminRole = backstageAccount.getAdminRole();
            String[] roles ;
            roles = adminRole.split(",");
            moduleManages = moduleManageService.selectByRole(Arrays.asList(roles));
            List moduleId = new ArrayList();

            for(ModuleRole moduleRole :moduleManages){
                if(moduleRole.getParentId()==0) {
                    FirstModule firstModule = new FirstModule();
                    firstModule.setId(moduleRole.getId());
                    firstModule.setModuleName(moduleRole.getModuleName());
                    long firstModuleId = moduleRole.getId();
                    List<ModuleRole> secondModules = new ArrayList<>();//第二级
                    for (ModuleRole moduleRole1 : moduleManages) {
                        if (moduleRole1.getParentId() == firstModuleId) {
                            secondModules.add(moduleRole1);
                        }

                    }
                    firstModule.setSecondModules(secondModules);
                    nestModules.add(firstModule);
                }
                stringBuffer.append(moduleRole.getModuleName()+"1");
            }

        }catch (Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        String cookieRoles = String.valueOf(stringBuffer);
        logger.info(cookieRoles);
        Cookie roleCookie = new Cookie("roleCookie",cookieRoles);//添加登录角色
        roleCookie.setMaxAge(7*24*60*60);
        response.addCookie(roleCookie);
        jsonObject.put("code",1000);
        jsonObject.put("data",nestModules);
//        logger.info(nestModules.toString());
        return jsonObject;
    }

    /**
     *98密码管理
     */
    @RequestMapping(value ="/a/u/password", produces="application/json",method = RequestMethod.POST)
    public JSONObject updatePassword(String lastPassword, String newPassword1, String newPassword2,HttpServletRequest request){
        logger.info("/a/u/password---POST---" +
                "the request parameters are lastPassword:{},newPassword1:{},newPassword2;{}",
                lastPassword,newPassword1,newPassword2);
        //参数判空
        List<Object> list = new ArrayList<>();
        list.add(lastPassword);
        list.add(newPassword1);
        list.add(newPassword2);
        int judgeStatus = ParameterJudgement.isNullOrBlank(list);
        if(judgeStatus==0){
            jsonObject.put("code",1002);
            jsonObject.put("data","");
            return jsonObject;
        }
        Cookie[] cookies = request.getCookies();
        long id = 0;
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("userId")){
                    id = Long.valueOf(token.SolveToken(cookie.getValue()));
                }
            }
        }
        try{
        if(backstageAccountService.selectByPrimaryKey(id).getPassword().equals(Md5Utils.MD5(lastPassword))) {
            if (newPassword1.equals(newPassword2)) {
                BackstageAccount backstageAccount = new BackstageAccount();
                String passwordWithMD5 = Md5Utils.MD5(newPassword1);
                backstageAccount.setPassword(passwordWithMD5);
                backstageAccount.setId(id);
                backstageAccountService.updateByPrimaryKeySelective(backstageAccount);
                jsonObject.put("code", 1000);
            }else {
                jsonObject.put("data","");
                jsonObject.put("code",1002);
            }
        }else {
            jsonObject.put("data","");
            jsonObject.put("code",1007);
        }
        }catch (Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        jsonObject.put("data","");
        return jsonObject;
    }


}
