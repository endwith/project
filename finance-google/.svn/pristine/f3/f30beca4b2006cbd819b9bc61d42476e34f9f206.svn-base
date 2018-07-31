package com.ptteng.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.service.UploadPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class UploadPictureServiceHystric implements UploadPictureService {
    @Autowired
    private JSONObject jsonObject;


    @Override
    public JSONObject loadPicture(MultipartFile picture) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }
}
