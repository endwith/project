package com.ptteng.service;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.model.User;
import com.ptteng.service.impl.FinanceOneServiceHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FeignClient(value = "finance-client",fallback=FinanceOneServiceHystric.class)
public interface FinanceOneService {
    /**
     *28我的理财(显示已投资部分)
     *32显示已续投内容
     */
    @RequestMapping(value ="/a/u/finance", produces="application/json",method = RequestMethod.GET)
    JSONObject finance(@RequestParam(value = "status",required = false)Integer status
    ,@RequestParam(value = "request",required = false)HttpServletRequest request);

    /**
     *29查看合同
     */
    @RequestMapping(value ="/a/u/contract", produces="application/json",method = RequestMethod.GET)
    JSONObject contract(@RequestParam(value = "tradeId",required = false)Long tradeId);

    /**
     *30预约续投
     *31取消续投
     */
    @RequestMapping(value ="/a/u/reservation", produces="application/json",method = RequestMethod.PUT)
    JSONObject reservation(@RequestParam(value = "id",required = false)Long id,@RequestParam(value = "status",required = false)Integer status);


    /**
     *33显示已退出的内容
     */
    @RequestMapping(value ="/a/u/quited-contract", produces="application/json",method = RequestMethod.GET)
    JSONObject quitedContract(@RequestParam(value = "request",required = false)HttpServletRequest request);

    /**
     *34交易记录
     */
    @RequestMapping(value ="/a/u/records", produces="application/json",method = RequestMethod.GET)
    JSONObject records(@RequestParam(value = "request",required = false)HttpServletRequest request);

    /**
     *35显示银行卡
     */
    @RequestMapping(value ="/a/u/bank-cards", produces="application/json",method = RequestMethod.GET)
    JSONObject bankCards(@RequestParam(value = "request",required = false)HttpServletRequest request);

    /**
     *36添加银行卡
     */
    @RequestMapping(value ="/a/u/bank-card", produces="application/json",method = RequestMethod.GET)
    JSONObject bankCard(@RequestParam(value = "request",required = false)HttpServletRequest request);

    /**
     *37填写银行卡信息
     */
    @RequestMapping(value ="/a/u/bank-message", produces="application/json",method = RequestMethod.GET)
    JSONObject bankMessage(@RequestParam(value = "bankCard",required = false)String bankCard
    ,@RequestParam(value = "request",required = false)HttpServletRequest request);

    /**
     *39银行卡绑卡
     *18绑卡
     */
    @RequestMapping(value ="/a/u/new-bank-card", produces="application/json",method = RequestMethod.PUT)
    JSONObject newBankCard(@RequestParam("smsCode")String smsCode,@RequestParam("bank")String bank,@RequestParam("bankCard")String bankCard,HttpServletRequest request);
    /**
     *40选择银行卡
     */
    @RequestMapping(value ="/a/u/one-bank", produces="application/json",method = RequestMethod.GET)
    JSONObject oneBank(@RequestParam("bankCard")String  bankCard,HttpServletRequest request);

    /**
     *42解除绑定
     */
    @RequestMapping(value ="/a/u/unbinding-card", produces="application/json",method = RequestMethod.POST)
    JSONObject unbingCard(@RequestParam("smsCode")String smsCode,@RequestParam("bankCard")String  bankCard,HttpServletRequest request);




}
