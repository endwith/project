package com.ptteng.controller;

import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.*;

@RefreshScope
@Controller
public class FinanceController {
    @Autowired
    private  JSONObject jsonObject;
    /**
     *8首页
     */
    @RequestMapping(value ="/client/a/main-page", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject mainPage(){
        List<Map> mapList = new ArrayList<>();
        for(int i =0;i<6;i++){
            Map dataMap = new HashMap();
            dataMap.put("title","聚金融三周年");
            dataMap.put("bannerPicture","http://p9ffg65uy.bkt.clouddn.com/30.jpg");
            mapList.add(dataMap);
        }
        Map dataMap = new HashMap();
        dataMap.put("product","新手礼");
        dataMap.put("picture","http://p9ffg65uy.bkt.clouddn.com/31.jpg");
        mapList.add(dataMap);
        jsonObject.put("code",1000);
        jsonObject.put("data",dataMap);
        return jsonObject;
    }
    /**
     *9产品详情
     */
    @RequestMapping(value ="/client/a/product", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject product(String product,long id){
        Product product1  = new Product();
        product1.setProductName("新手礼");
        product1.setInvestmentCycle(7);
        product1.setOriginMoney(BigDecimal.valueOf(5000));
        product1.setAddMoney(BigDecimal.valueOf(1000));
        product1.setIntroduce("新手使用的东西，可以赚到钱");
        product1.setReturnInterest(0);
        product1.setExpectedRate(BigDecimal.valueOf(10));
        product1.setId((long)1);
        return null;

    }
    /**
     *10理财
     */
    @RequestMapping(value ="/client/a/u/finances", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject finances(long count){
        jsonObject.put("code",1000);
        List<Product> productList = new ArrayList<>();
        for(int i =0;i<5;i++) {
            Product product = new Product();
            product.setProductName("聚月增");
            product.setExpectedRate(BigDecimal.valueOf(5+2*i));
            product.setInvestmentCycle(180);
            product.setId((long)i);
            productList.add(product);
        }
        jsonObject.put("data",productList);
        return jsonObject;
    }
    /**
     *11立即购买
     */
    @RequestMapping(value ="/client/a/u/buyer", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject buy(long id){
        Map map = new HashMap();
        map.put("productName","聚年盈");
        map.put("originMoney",BigDecimal.valueOf(15000));
        map.put("addMoney",BigDecimal.valueOf(1000));
        map.put("id",1);
        map.put("maximunAmount",50000);
        map.put("bankCard","6217002710000684874");
        map.put("bankType","交通银行");
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *12确认购买
     */
    @RequestMapping(value ="/client/a/u/confirming-payment", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject payment(String money,String bankCard,long id){
        Map map =new HashMap();
        map.put("bankCard",bankCard);
        map.put("bankType","交通银行");
        map.put("trueName","宙斯");
        map.put("idCard","445224122608101795");
        map.put("amount",money);
        map.put("id",id);
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *13支付方式选择
     */
    @RequestMapping(value ="/client/a/u/payment", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject choosePay(){
        List<Map> map = new ArrayList<>();
        Map bank1 = new HashMap();
        bank1.put("bankCard","6217002710000684874");
        bank1.put("bankId",1);
        map.add(bank1);
        Map bank2 = new HashMap();
        bank2.put("bankCard","6217002710000684875");
        bank2.put("bankId",2);
        map.add(bank2);
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *14支付银行卡选择
     */
    @RequestMapping(value ="/client/a/u/one-payment", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject choosePayment(long count){
        Map bank1 = new HashMap();
        bank1.put("bankCard","6217002710000684874");
        bank1.put("bankId",1);
        jsonObject.put("code",1000);
        jsonObject.put("data",bank1);
        return jsonObject;
    }
    /**
     *15确认支付
     */
    @RequestMapping(value ="/client/a/u/real-payment", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject realPayment(String phoneNumber,long smsCode){
        if (smsCode!=666666){
            jsonObject.put("code",3005);
        }else if(smsCode==666666){
            jsonObject.put("code",1000);
        }
        jsonObject.put("data","");
        return jsonObject;
    }
    /**
     *28我的理财(显示已投资部分)
     */
    @RequestMapping(value ="/client/a/u/finance", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject finance(){
        List<Map> financeMap = new ArrayList<>();

        for(int j = 0;j<5;j++){
            Map moneyMap = new HashMap();
            moneyMap.put("id",j);
            moneyMap.put("product","聚月增");
            moneyMap.put("expectedRate",10.00);
            moneyMap.put("purchaseAmount",7000);
            moneyMap.put("expectedIncome",21.23);
            moneyMap.put("expireTime",new Date().getTime());
            String money = "money"+String.valueOf(j);
            financeMap.add(moneyMap);
        }
        jsonObject.put("code",1000);
        jsonObject.put("data",financeMap);
        return jsonObject;
    }

    /**
     *29查看合同
     */
    @RequestMapping(value ="/client/a/u/contract", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject contract(long id){
        Map contractMap = new HashMap();
        contractMap.put("trueName","小红");
        contractMap.put("idCard","445224189901027945");
        contractMap.put("phone","18819478965");
        contractMap.put("contractAmount",50000);
        jsonObject.put("code",1000);
        jsonObject.put("data",contractMap);
        return jsonObject;
    }

    /**
     *30预约续投
     */
    @RequestMapping(value ="/client/a/u/reservation", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject reservation(long id){
        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }

    /**
     *32显示已续投内容
     */
    @RequestMapping(value ="/client/a/u/continuation", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject continuation(){
        List<Map> continueMap = new ArrayList<>();
        for(int i = 0; i<5;i++){
            Map contiMap = new  HashMap<>();
            contiMap.put("id",i);
            contiMap.put("product","聚年盈");
            contiMap.put("exceptedRate",12.00);
            contiMap.put("expectedIncome",21.79);
            contiMap.put("purchaseAmount",5000);
            contiMap.put("expireTime",new Date().getTime());
            String contract = "continue"+String.valueOf(i);
            continueMap.add(contiMap);
        }
        jsonObject.put("code",1000);
        jsonObject.put("data",continueMap);
        return jsonObject;
    }

    /**
     *33显示已退出的内容
     */
    @RequestMapping(value ="/client/a/u/quited-contract", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject quitedContract(){
        List<Map> continueMap = new ArrayList<>();
        for(int i = 0; i<5;i++){
            Map contiMap = new  HashMap<>();
            contiMap.put("id",i);
            contiMap.put("product","聚月盈");
            contiMap.put("exceptedRate",9.00);
            contiMap.put("expectedIncome",21.79);
            contiMap.put("purchaseAmount",5000);
            contiMap.put("expireTime",new Date().getTime());
            String contract = "quit"+String.valueOf(i);
            continueMap.add(contiMap);
        }
        jsonObject.put("code",1000);
        jsonObject.put("data",continueMap);
        return jsonObject;
    }

    /**
     *34交易记录
     */
    @RequestMapping(value ="/client/a/u/records", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject records(){
        List<Map> recordsMap = new ArrayList<>();
        for(int i = 0; i<5;i++){
            Map recordMap = new  HashMap<>();
            recordMap.put("id",i);
            recordMap.put("product","聚月盈");
            recordMap.put("arriveTime",new Date().getTime());
            recordMap.put("transactionAction",0);
            recordMap.put("transactionAmount",10000);
            String record = "record"+String.valueOf(i);
            recordsMap.add(recordMap);
        }
        jsonObject.put("code",1000);
        jsonObject.put("data",recordsMap);
        return jsonObject;
    }

    /**
     *35显示银行卡
     */
    @RequestMapping(value ="/client/a/u/bank-cards", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject bankCards(){
        List<Map> bankCards = new ArrayList<>();
        for(int i=0;i<2;i++) {
            Map bankCard = new HashMap();
            bankCard.put("bankCard","6217002710000684874");
            bankCard.put("bankType","交通银行");
            bankCard.put("bankId",i);
            String bank = "bankCard" +String.valueOf(i) ;
            bankCards.add(bankCard);
        }
        jsonObject.put("code", 1000);
        jsonObject.put("data", bankCards);
        return jsonObject;
    }

    /**
     *36添加银行卡
     */
    @RequestMapping(value ="/client/a/u/bank-card", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject bankCard(){
        Map personMap = new HashMap();
        personMap.put("name","蓝猫");
        personMap.put("idCard","445224199102031654");
        jsonObject.put("code",1000);
        jsonObject.put("data",personMap);
        return jsonObject;
    }

    /**
     *37填写银行卡信息
     */
    @RequestMapping(value ="/client/a/u/bank-message", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject bankMessage(String bankCard){
        Map bankType = new HashMap();
        bankType.put("bankType","工商银行");
        jsonObject.put("code",1000);
        jsonObject.put("data",bankType);
        return jsonObject;
    }

    /**
     *38银行卡验证手机号
     */
    @RequestMapping(value ="/client/a/u/phone-number", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject phoneNumber(String phoneNumber){
        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }
    /**
     *39银行卡绑卡
     */
    @RequestMapping(value ="/client/a/u/new-bank-card", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject newBankCard(long smsCode){
        if (smsCode==666666){
            jsonObject.put("code",1000);
            jsonObject.put("data","");
        }else {
            jsonObject.put("code",3004);

        }

        return jsonObject;
    }

    /**
     *40选择银行卡
     */
    @RequestMapping(value ="/client/a/u/one-bank", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject oneBank(long id){
        Map oneBank = new HashMap();
        oneBank.put("bankCard","6217002710000684874");
        oneBank.put("bankType","中国银行");
        oneBank.put("bankId",1);
        jsonObject.put("code",1000);
        jsonObject.put("data",oneBank);
        return jsonObject;
    }
    /**
     *41银行卡解绑前先验证手机号
     */
    @RequestMapping(value ="/client/a/u/bank-phone-number", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject bankPhoneNumber(){
        Map phoneMap = new HashMap();
        phoneMap.put("phone","18819478996");
        jsonObject.put("code",1000);
        jsonObject.put("data",phoneMap);
        return jsonObject;
    }
    /**
     *42解除绑定
     */
    @RequestMapping(value ="/client/a/u/unbinding-card", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject removeBindCard(String smsCode){

        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }



}
