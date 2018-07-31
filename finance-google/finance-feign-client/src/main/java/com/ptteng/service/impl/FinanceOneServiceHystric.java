package com.ptteng.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.model.User;
import com.ptteng.service.FinanceOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class FinanceOneServiceHystric implements FinanceOneService {
    @Autowired
    private JSONObject jsonObject;
    @Override
    public JSONObject finance(Integer status,HttpServletRequest request) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject contract(Long tradeId) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject reservation(Long id,Integer status) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }


    @Override
    public JSONObject quitedContract(HttpServletRequest request) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject records(HttpServletRequest request ) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject bankCards(HttpServletRequest request ) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject bankCard(HttpServletRequest request) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject bankMessage(String bankCard,HttpServletRequest request) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }



    @Override
    public JSONObject newBankCard(String smsCode,String bank,String bankCard,HttpServletRequest request) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }

    @Override
    public JSONObject oneBank(String  bankCard,HttpServletRequest request) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }



    @Override
    public JSONObject unbingCard(String smsCode,String  bankCard,HttpServletRequest request) {
        jsonObject.put("code",2002);
        jsonObject.put("data","");
        return  jsonObject;
    }
}
