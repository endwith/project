package com.ptteng.controller;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.dao.ModuleMapper;
import com.ptteng.model.FatherModule;
import com.ptteng.model.Module;
import com.ptteng.model.SonModule;
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
public class UserController {
    @Autowired
    private JSONObject jsonObject;
    @Autowired
    private ModuleMapper moduleMapper;
    org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);
    /**
     *44后台登录
     */
    @RequestMapping(value ="/admin/a/login", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject login(String admin,String password) {
        List<Module> list = new ArrayList<Module>();
        Map moduleNameMap = new HashMap();//放置模块名称，url
        Map moduleMap = new HashMap();//放置模块编号，名称
        Map fatherMap = new HashMap();//放置父模块编号，父编号
        Map sonMap = new HashMap();
        int number = moduleMapper.countAll();
        System.out.println(number);
        Module module = new Module();
        List<Module> moduleList = moduleMapper.list();
        for (int i = 1; i <= number; i++) {
            module = moduleMapper.selectByPrimaryKey(i);
            moduleMap.put(module.getOwnId(), module.getModule());
            moduleNameMap.put(module.getModule(), module.getUrl());
            if (module.getOwnId() > 10 && module.getOwnId() < 100) {
                //        System.out.println(module.getOwnId()+": "+module.getModule());
                fatherMap.put(module.getOwnId(), module.getParentId());
            } else if (module.getOwnId() > 100 && module.getOwnId() < 1000) {
                //        System.out.println(module.getOwnId()+": "+module.getModule());
                sonMap.put(module.getOwnId(), module.getParentId());

            }
            List<FatherModule> fatherModules = new ArrayList<>();
            for (Object fatherKey : fatherMap.keySet()) {
                FatherModule fatherModule = new FatherModule();
                fatherModule.setName((String) moduleMap.get(fatherKey));
                System.out.println(fatherKey + " 测试:1 " + moduleMap.get(fatherKey) + " " + fatherMap.get(fatherKey) + " " + fatherModule.getName());
                List<SonModule> sonModules = new ArrayList<>();
                for (Object sonKey : sonMap.keySet()) {
                    if (sonMap.get(sonKey) == fatherKey) {
                        SonModule sonModule = new SonModule();
                        sonModule.setName((String) moduleMap.get(sonKey));
                        sonModule.setUrl((String) moduleNameMap.get(sonModule.getName()));
                        System.out.println(sonKey + " 测试:2 " + moduleMap.get(sonKey) + " " + sonMap.get(sonKey) + " " + sonModule.getName());
                        sonModules.add(sonModule);
                        for (int j = 0; j < sonModules.size(); j++) {
                            System.out.println("sonModules: " + sonModules.get(j).getName());
                        }
                    }

                }
                fatherModule.setSonModules(sonModules);
                fatherModules.add(fatherModule);
                for (int j = 0; j < fatherModules.size(); j++) {
                    System.out.println("fatherModules: " + fatherModules.get(j).getName());
                }
            }
            jsonObject.put("data", fatherModules);
        }
        jsonObject.put("code", 1000);

        return jsonObject;
    }
    /**
     *98密码管理
     */
    @RequestMapping(value ="/admin/a/u/password", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updatePassword(String lastPassword,String newPassword1,String newPassword2){
        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }


}
