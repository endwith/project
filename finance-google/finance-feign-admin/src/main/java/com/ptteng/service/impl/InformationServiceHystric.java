package com.ptteng.service.impl;

import com.alibaba.fastjson.JSONObject;

import com.ptteng.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Component
public class InformationServiceHystric implements InformationService {
   @Autowired
   private JSONObject jsonObject;
    @Override
    public JSONObject getAllInformation(Long page, Long size) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject getInformation(Long page, Long size, String inforTitle, Integer inforStatus, String founder, Long sendBeginTime, Long sendEndTime) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject addInformation( String inforTitle, String inforPicture, String inforContent,
                                      Long sendTime, Integer inforStatus,HttpServletRequest request) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }


    @Override
    public JSONObject getInformationById(Long id) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject updateInformation(Long id, String inforTitle, String inforPicture,
                                        String inforContent, Long sendTime, Integer inforStatus,HttpServletRequest request) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject deleteInformation(Long id) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }


}
