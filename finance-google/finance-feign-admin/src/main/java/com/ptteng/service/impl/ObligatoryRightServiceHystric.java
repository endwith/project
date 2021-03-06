package com.ptteng.service.impl;

import com.alibaba.fastjson.JSONObject;

import com.ptteng.service.ObligatoryRightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@Component
public class ObligatoryRightServiceHystric implements ObligatoryRightService {
    @Autowired
    private JSONObject jsonObject;

    @Override
    public JSONObject getAllOblRight(Long page, Long size) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject getOblRights(Long page, Long size, Long id, String company, String corporate, Integer status) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject addOblRight(String company, String corporate, String mobile,
                                  String idCard, Long loanTime, BigDecimal loanSum,
                                  Long loanTerm,HttpServletRequest request) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject getOblRight(Long id) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject updateOblRight(Long id, String company, String corporate, String mobile,
                                     String idCard, Long loanTime, BigDecimal loanSum,
                                     Long loanTerm,HttpServletRequest request) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject deleteOblRight(Long id) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject getUnmatchedOblRight(Long id) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject getMatchedContract(Long page, Long size, Long id) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject matchingOblRight(String  json,
                                       Long obligatoryId,
                                       BigDecimal matchingAmount
            , HttpServletRequest request) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }
}
