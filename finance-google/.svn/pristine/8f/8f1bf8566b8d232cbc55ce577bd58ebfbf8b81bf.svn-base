package com.ptteng.controller;


import com.alibaba.fastjson.JSONObject;
import com.ptteng.model.User;
import com.ptteng.service.FinanceOneService;
import com.ptteng.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class FinanceController {

    @Autowired
    private FinanceService financeService;
    @Autowired
    private FinanceOneService financeOneService;
    /**
     *8首页
     */
    @RequestMapping(value ="/a/main-page", produces="application/json",method = RequestMethod.GET)
    public JSONObject mainPage(){
        return financeService.mainPage();
    }
    /**
     *9产品详情
     */
    @RequestMapping(value ="/a/product", produces="application/json",method = RequestMethod.GET)
    public JSONObject product(String product){
        return financeService.product(product);
    }
    /**
     *9 产品的投资记录
     */
    @RequestMapping(value ="/a/product/record", produces="application/json",method = RequestMethod.GET)
    public JSONObject productRecord(String product,Long page,Long size){
        return financeService.productRecord(product, page, size);
    }
    /**
     *10理财
     */
    @RequestMapping(value ="/a/finances", produces="application/json",method = RequestMethod.GET)
    public JSONObject finances(long count,HttpServletRequest request){
        return financeService.finances(count,request);
    }
    /**
     *11立即购买
     * 14支付银行卡选择
     */
    @RequestMapping(value ="/a/u/buyer", produces="application/json",method = RequestMethod.GET)
    public JSONObject buy(Long id, HttpServletRequest request){
        return financeService.buy(id,request);
    }
    /**
     *12确认购买
     */
    @RequestMapping(value ="/a/u/confirming-payment", produces="application/json",method = RequestMethod.GET)
    public JSONObject payment(Long money,String bankCard,Long id, HttpServletRequest request){
        return financeService.payment(money, bankCard, id,request);
    }
    /**
     *13支付方式选择
     */
    @RequestMapping(value ="/a/u/payment", produces="application/json",method = RequestMethod.GET)
    public JSONObject choosePay(HttpServletRequest request){
        return financeService.choosePay(request);
    }

//    /**
//     *15确认支付
//     */
//    @RequestMapping(value ="/a/u/real-payment", produces="application/json",method = RequestMethod.POST)
//    public JSONObject realPayment(Long id){
//        return financeService.realPayment(id);
//    }
    /**
     *确认支付-回落后台接口
     */
    @RequestMapping(value ="/a/real-paymentReport", produces="application/json"/*,method = RequestMethod.GET*/)
    public JSONObject realPaymentReport(HttpServletRequest request, HttpServletResponse response) {
        return financeService.realPaymentReport(request,response);
    }
        /**
         *28我的理财(显示已投资部分)
         *32显示已续投内容
         */
    @RequestMapping(value ="/a/u/finance", produces="application/json",method = RequestMethod.GET)
    public JSONObject finance(Integer status,HttpServletRequest request){
        return financeOneService.finance(status,request);
    }

    /**
     *29查看合同
     */
    @RequestMapping(value ="/a/u/contract", produces="application/json",method = RequestMethod.GET)
    public JSONObject contract(Long tradeId){
        return financeOneService.contract(tradeId);
    }

    /**
     *30预约续投
     *31取消续投
     */
    @RequestMapping(value ="/a/u/reservation", produces="application/json",method = RequestMethod.PUT)
    public JSONObject reservation(Long id,Integer status){
        return financeOneService.reservation(id, status);
    }


    /**
     *33显示已退出的内容
     */
    @RequestMapping(value ="/a/u/quited-contract", produces="application/json",method = RequestMethod.GET)
    public JSONObject quitedContract(HttpServletRequest request){
        return financeOneService.quitedContract(request);
    }

    /**
     *34交易记录
     */
    @RequestMapping(value ="/a/u/records", produces="application/json",method = RequestMethod.GET)
    public JSONObject records(HttpServletRequest request){
        return financeOneService.records(request);
    }

    /**
     *35显示银行卡
     */
    @RequestMapping(value ="/a/u/bank-cards", produces="application/json",method = RequestMethod.GET)
    public JSONObject bankCards(HttpServletRequest request){
        return financeOneService.bankCards(request);
    }

    /**
     *36添加银行卡
     */
    @RequestMapping(value ="/a/u/bank-card", produces="application/json",method = RequestMethod.GET)
    public JSONObject bankCard(HttpServletRequest request){
        return financeOneService.bankCard(request);
    }

    /**
     *37填写银行卡信息
     */
    @RequestMapping(value ="/a/u/bank-message", produces="application/json",method = RequestMethod.GET)
    public JSONObject bankMessage(String bankCard,HttpServletRequest request){
        return financeOneService.bankMessage(bankCard,request);
    }


    /**
     *39银行卡绑卡
     *18绑卡
     */
    @RequestMapping(value ="/a/u/new-bank-card", produces="application/json",method = RequestMethod.PUT)
    public JSONObject newBankCard(String smsCode,String bank,String bankCard,HttpServletRequest request){
        return financeOneService.newBankCard(smsCode, bank, bankCard, request);
    }

    /**
     *40选择银行卡
     */
    @RequestMapping(value ="/a/u/one-bank", produces="application/json",method = RequestMethod.GET)
    public JSONObject oneBank(String  bankCard,HttpServletRequest request){
        return financeOneService.oneBank(bankCard,request);
    }

    /**
     *42解除绑定
     */
    @RequestMapping(value ="/a/u/unbinding-card", produces="application/json",method = RequestMethod.POST)
    public JSONObject unbingCard(String smsCode,String  bankCard,HttpServletRequest request){
        return financeOneService.unbingCard(smsCode, bankCard,request);
    }

}
