package com.ptteng.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class FinanceServiceHystric implements FinanceService {
    @Autowired
    private JSONObject jsonObject;
    @Override
    public JSONObject mainPage() {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject product(String product) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject productRecord(String product,Long page,Long size) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject finances(long count, HttpServletRequest request) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject buy(Long id,HttpServletRequest request) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject payment(Long money,String bankCard,Long id,HttpServletRequest request) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject choosePay(HttpServletRequest request) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }


//    @Override
//    public JSONObject realPayment(Long id) {
//        jsonObject.put("code",2002);
//        jsonObject.put("data","");
//        return  jsonObject;
//    }

    @Override
    public JSONObject realPaymentReport(HttpServletRequest request, HttpServletResponse response) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }


}
