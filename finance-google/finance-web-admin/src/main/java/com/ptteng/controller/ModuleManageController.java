package com.ptteng.controller;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.dao.ModuleMapper;
import com.ptteng.model.FatherModule;
import com.ptteng.model.Module;
import com.ptteng.model.SonModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@RefreshScope
@Controller
public class ModuleManageController {
    @Autowired
    private JSONObject jsonObject;
    @Autowired
    private ModuleMapper moduleMapper;
    /**
     *106模块管理查询模块
     */
    @RequestMapping(value ="/admin/a/u/all-module", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getAllModule(long page,long size){
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
     *107模块模糊查询查询
     */
    @RequestMapping(value ="/admin/a/u/modules", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getModules(String moduleId,String moduleName,String parentModule
    ,String founder,long page,long size){
        List<Map> mapList = new ArrayList<>();
        for(int i =0;i<size;i++) {
            Map map  = new HashMap();
            map.put("id",i );
            map.put("moduleId","MK0000"+String.valueOf(i));
            map.put("name","运营管理");
            map.put("parentModule",0);
            map.put("type","web");
            map.put("updateAt",new Date().getTime());
            map.put("createAt",new Date().getTime());
            map.put("founder","敌法师");
            map.put("modifier","毛太祖");
            mapList.add(map);

        }
        jsonObject.put("code",1000);
        jsonObject.put("data",mapList);
        return jsonObject;
    }
    /**
     *108模块查找（实际上是编辑按钮）
     */
    @RequestMapping(value ="/admin/a/u/module/{id}", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getModuleById(long id){

            Map map  = new HashMap();
            map.put("id",1 );
            map.put("moduleId","MK000001");
            map.put("name","运营管理");
            map.put("parentModule",0);
            map.put("type","web");
            map.put("updateAt",new Date().getTime());
            map.put("createAt",new Date().getTime());
            map.put("founder","波风水门");
            map.put("modifier","螺旋丸");
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *109模块删除
     */
    @RequestMapping(value ="/admin/a/u/module/{id}", produces="application/json",method = RequestMethod.DELETE)
    @ResponseBody
    public JSONObject deleteModule(long id){
        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }
    /**
     *110模块更改（编辑好角色后点击保存）
     */
    @RequestMapping(value ="/admin/a/u/module", produces="application/json",method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject updateModule(long id,String moduleName,String ModuleUrl
            ,String parentModule,String type){
        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }

}
