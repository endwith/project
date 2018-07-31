package com.ptteng.controller;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.model.InformationManage;
import com.ptteng.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RefreshScope
@Controller
public class InformationController {
    @Autowired
    private JSONObject jsonObject;
    /**
     *84消息管理入口
     */
    @RequestMapping(value ="/admin/a/u/all-information", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getAllInformation(Long page,Long size){
        InformationManage infor=new InformationManage();
        infor.setId(1L);
        infor.setInforTitle("六一儿童节");
        infor.setFounder("儿童节");
        infor.setCreateAt(1243124124L);
        infor.setModifier("父亲节");
        infor.setUpdateAt(1243124124L);
        infor.setInforStatus(1);
        infor.setSendTime(123323232323L);
        Map<String,Object> map=new HashMap<>();
        map.put("1",infor);
        map.put("2",infor);
        map.put("3",infor);
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *85消息管理查询
     */
    @RequestMapping(value ="/admin/a/u/information", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getInformation(Long page,Long size,String inforTitle,String inforStatus,String founder,Long sendBeginTime,Long sendEndTime){
        InformationManage infor=new InformationManage();
        infor.setId(1L);
        infor.setInforTitle("六一儿童节");
        infor.setFounder("儿童节");
        infor.setCreateAt(1243124124L);
        infor.setModifier("父亲节");
        infor.setUpdateAt(1243124124L);
        infor.setInforStatus(1);
        infor.setSendTime(123323232323L);
        Map<String,Object> map=new HashMap<>();
        map.put("1",infor);
        map.put("2",infor);
        map.put("3",infor);
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *86消息管理新增
     */
    @RequestMapping(value ="/admin/a/u/information", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addInformation(String inforTitle,MultipartFile inforPicture,String inforContent,Long sendTime,int inforStatus){
        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }
    /**
     *87消息管理编辑-获取
     *90消息管理查看详情
     */
    @RequestMapping(value ="/admin/a/u/information/{id}", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getInformationById(Long id){
        InformationManage infor=new InformationManage();
        infor.setId(1L);
        infor.setInforTitle("六一儿童节");
        infor.setInforPicture("https://endwith.oss-cn-shenzhen.aliyuncs.com/student152769177116310850.jpg");
        infor.setInforContent("六一儿童节快乐六一儿童节快乐六一儿童节快乐六一儿童节快乐");
        infor.setInforStatus(1);
        infor.setSendTime(123323232323L);
        jsonObject.put("code",1000);
        jsonObject.put("data",infor);
        return jsonObject;
    }
    /**
     *88消息管理编辑-更改
     *89消息管理取消推送
     */
    @RequestMapping(value ="/admin/a/u/information/{id}", produces="application/json",method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject updateInformation(Long id,String inforTitle,MultipartFile inforPicture,String inforContent,Long sendTime,int inforStatus){
        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }
    /**
     *91消息管理删除
     */
    @RequestMapping(value ="/admin/a/u/information/{id}", produces="application/json",method = RequestMethod.DELETE)
    @ResponseBody
    public JSONObject deleteInformation(Long id){
        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }


}
