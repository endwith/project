package com.ptteng.controller;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.model.*;
import com.ptteng.pay.client.util.DateUtils;
import com.ptteng.pay.client.util.StringUtils;
import com.ptteng.service.*;
import com.ptteng.util.ElTest;
import com.ptteng.util.FuiouUtil;
import com.ptteng.util.Token;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Decoder;
import sun.security.pkcs11.Secmod;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.DecimalFormat;
import java.util.*;



@RefreshScope
@RestController
public class FinanceController {
    org.slf4j.Logger logger = LoggerFactory.getLogger(FinanceController.class);
    @Autowired
    private  JSONObject jsonObject;
    @Resource
    private TradeService tradeService;
    @Resource
    private InvestmentContractService investmentContractService;
    @Resource
    private HistoryProductService historyProductService;
    @Resource
    private UserService userService;
    @Resource
    private RedisTemplate redisTemplate;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRecommendService productRecommendService;
    @Resource
    private Token token;
    @Resource
    private ElTest elTest;

    /**
     *8首页
     */
    @RequestMapping(value ="/a/main-page", produces="application/json",method = RequestMethod.GET)
    public JSONObject mainPage(){
        logger.info("/client/a/register---POST---" +
                "the request parameters are null");
        //0是banner图，1是鼎力推荐
        List<Map> mapList = new ArrayList<>();
        List<ProductRecommend> recommendList=null;

        try {
            List<ProductRecommend> bannerList = productRecommendService.selectByStatus(0, 0, 1);
            int i = 0;
            for (ProductRecommend banner : bannerList) {
                Map bannerMap = new HashMap();
                bannerMap.put("title", banner.getTitle());
                bannerMap.put("url",banner.getUrl());
                bannerMap.put("bannerPicture", banner.getPicture());
                mapList.add(bannerMap);
                i++;
            }
            recommendList = productRecommendService.selectByStatus(1, 1, 0);
        }catch(Throwable e){
            logger.error("异常"+e);
            jsonObject.put("code",2001);
            jsonObject.put("data","");
            return jsonObject;
        }
        //未登录都是新手
        for(ProductRecommend recommend :recommendList){
            if(recommend.getProduct().equals("新手礼")){
                Product product = productService.selectByProduct(recommend.getProduct());
                Map recommendMap = new HashMap();
                recommendMap.put("product",recommend.getProduct());
                recommendMap.put("picture",recommend.getPicture());
                recommendMap.put("productId",product.getId());
                mapList.add(recommendMap);
            }
        }
        jsonObject.put("data",mapList);
//        logger.info(mapList.toString());
        jsonObject.put("code",1000);
        return jsonObject;
    }
    /**
     *9产品详情
     */
    @RequestMapping(value ="/a/product", produces="application/json",method = RequestMethod.GET)
    public JSONObject product(String product){
        logger.info("/client/a/verification-sms-code---GET---the request parameters are " +
                "product ：{},",
                product);
        Product product1 = new Product();
        Map productMap = new HashMap();
        if(product==null){
            product="000000";
        }
       try{
            if(product!="000000"){
                product1 = productService.selectByProduct(product);
            }
        productMap.put("productName",product1.getProductName());
        productMap.put("investmentCycle",product1.getInvestmentCycle());
        productMap.put("originMoney",product1.getOriginMoney());
        productMap.put("addMoney",product1.getAddMoney());
        productMap.put("introduce",product1.getIntroduce());
        productMap.put("expectedRate", product1.getExpectedRate());
        productMap.put("id",product1.getId());
        jsonObject.put("data",productMap);
        logger.info(productMap.toString());
        jsonObject.put("code",1000);
        }catch (Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        return jsonObject;
    }
    /**
     *9 产品的投资记录
     */
    @RequestMapping(value ="/a/product/record", produces="application/json",method = RequestMethod.GET)
    public JSONObject productRecord(String product,Long page,Long size){
        logger.info("/client/a/product/record---GET---the request parameters are product:{},page:{},size:{}",product,page,size);
        List<Map> historyProducts;
        ElTest elTest=new ElTest();
        Long total;
        Map<String,Object> map=new HashMap<>();
        try{
            if(page!=null){
                historyProducts =historyProductService.selectByProduct(product,(page-1)*size, size);
            }else {
                historyProducts=historyProductService.selectByProduct(product,0L,size);
            }
            for(Map i:historyProducts){
                i.put("trueName",elTest.getNameWith(token.SolveToken(String.valueOf(i.get("trueName")))));
            }
            total=historyProductService.selectByProductCount(product);
        }catch (Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
//        logger.info(historyProducts.toString());
        map.put("total",total);
        map.put("informationManages",historyProducts);
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *10理财
     */
    @RequestMapping(value ="/a/finances", produces="application/json",method = RequestMethod.GET)
    public JSONObject finances(Long count,HttpServletRequest request){
        //判断是否新手
        List<Product> productList = new ArrayList<>();
        try{
            int buyNoviceGiftStatus = 0;
            if(request.getCookies()!=null){
                Cookie[] cookies = request.getCookies();
                for (Cookie cookie : cookies) {
                    if ("userId".equals(cookie.getName())) {
                        long id = Long.valueOf(token.SolveToken(cookie.getValue()));
                        User user = userService.selectByPrimaryKey(id);
                        buyNoviceGiftStatus = user.getIsNoviceGift();
                    }
                }
                if(buyNoviceGiftStatus==0){
                    if(count!=null){
                        productList =productService.forSelect(count*5, 5l);
                    }else {
                        productList =productService.forSelect(0l, 5l);
                    }
                }else {
                    if(count!=null){
                        productList =productService.forSelectNotNovice(count*5, 5l);
                    }else {
                        productList =productService.forSelectNotNovice(0l, 5l);
                    }
                }
            }else {
                if(count!=null){
                    productList =productService.forSelect(count*5, 5l);
                }else {
                    productList =productService.forSelect(0l, 5l);
                }
            }

        }catch(Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        jsonObject.put("data",productList);
        jsonObject.put("code",1000);
        if(productList.size()==0){
            jsonObject.put("data","nothing");
        }

        return jsonObject;
    }
    /**
     *11立即购买
     *14支付银行卡选择
     */
    @RequestMapping(value ="/a/u/buyer", produces="application/json",method = RequestMethod.GET)
    public JSONObject buy(Long id, HttpServletRequest request){
        logger.info("/client/a/u/buyer---GET---the request parameters are");
        Map<String,Object> map=new HashMap<>();
        String thisId = null;
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            for (Cookie c : cookie) {  // 遍历Cookie
                if("userId".equals(c.getName()))
                    thisId=c.getValue();
            }
        }
        String bankCard;
        Product product;
        try {
            User user = userService.selectByPrimaryKey(Long.valueOf(token.SolveToken(thisId)));
            if("".equals(token.SolveToken(user.getTrueName()))){
                jsonObject.put("data","");
                jsonObject.put("code",3011);
                return jsonObject;
            }
            if("".equals(token.SolveToken(user.getBankCard1()))&&"".equals(token.SolveToken(user.getBankCard2()))){
                jsonObject.put("data","");
                jsonObject.put("code",3014);
                return jsonObject;
            }
            bankCard = elTest.getOneWithBank(token.SolveToken(user.getBankCard1()));
            product = productService.selectByPrimaryKey(id);
        }catch(Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        BigDecimal originMoney=product.getOriginMoney();
        BigDecimal addMoney=product.getAddMoney();
        map.put("originMoney",originMoney);
        map.put("addMoney",addMoney);
        map.put("bankCard",bankCard);
        map.put("id",id);
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *12确认购买
     */
    @RequestMapping(value ="/a/u/confirming-payment", produces="application/json",method = RequestMethod.GET)
    public JSONObject payment(Long money,String bankCard,Long id, HttpServletRequest request){
        logger.info("/client/a/u/confirming-payment---GET---the request parameters are money:{},bankCard:{},id:{}",money,bankCard,id);
        Map<String,Object> map=new HashMap<>();
        String thisId = null;
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            for (Cookie c : cookie) {  // 遍历Cookie
                if("userId".equals(c.getName()))
                    thisId=c.getValue();
            }
        }
        User user;
        try{
            user=userService.selectByPrimaryKey(Long.valueOf(token.SolveToken(thisId)));
        }catch (Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        String tradeBankCard;
        String bank;
        if (bankCard.equals(elTest.getOneWithBank(token.SolveToken(user.getBankCard1())))){
            tradeBankCard=elTest.getOneWithNum(token.SolveToken(user.getBankCard1()));
            bank=elTest.getBank(token.SolveToken(user.getBankCard1()));
        }else {
            tradeBankCard=elTest.getOneWithNum(token.SolveToken(user.getBankCard2()));
            bank=elTest.getBank(token.SolveToken(user.getBankCard2()));
        }
        DecimalFormat j = new DecimalFormat("#.00");
        if(money%1000!=0) {
            jsonObject.put("code", 1008);
        }else {
            //富友字段 金额 order_amt
            String order_amt = String.valueOf(money);
            //富友字段 身份证 cert_no
            String cert_no=token.SolveToken(user.getIdCard());
            //富友字段 卡号--card_no
            String card_no=tradeBankCard;
            //富友字段 用户ID--user_id
            String user_id=token.SolveToken(user.getPhone());
            //富友字段 姓名--cardholder_name
            String cardholder_name=token.SolveToken(user.getTrueName());
            jsonObject.put("code", 1000);
            map.put("order_amt",order_amt);
            map.put("cert_no",cert_no);
            map.put("card_no",card_no);
            map.put("user_id",user_id);
            map.put("cardholder_name",cardholder_name);
            map.put("bank",bank);
            map.put("id",id);
        }
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *13支付方式选择
     */
    @RequestMapping(value ="/a/u/payment", produces="application/json",method = RequestMethod.GET)
    public JSONObject choosePay(HttpServletRequest request){
        logger.info("/client/a/u/payment---GET---the request parameters are");
        Map<String,Object> map1=new HashMap<>();
        Map<String,Object> map2=new HashMap<>();
        List<Map> list=new ArrayList<>();
        String thisId = null;
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            for (Cookie c : cookie) {  // 遍历Cookie
                if("userId".equals(c.getName()))
                    thisId=c.getValue();
            }
        }
        User user;
        try{
            user=userService.selectByPrimaryKey(Long.valueOf(token.SolveToken(thisId)));
        }catch (Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        if(!user.getBankCard1().equals("")){
            String bankCard1=elTest.getOneWithBank(token.SolveToken(user.getBankCard1()));
            map1.put("bankCard",bankCard1);
            list.add(map1);
        }
        if(!user.getBankCard2().equals("")){
            String bankCard2=elTest.getOneWithBank(token.SolveToken(user.getBankCard2()));
            map2.put("bankCard",bankCard2);
            list.add(map2);
        }
        jsonObject.put("code",1000);
        jsonObject.put("data",list);
        return jsonObject;
    }

//    /**
//     *15确认支付
//     */
//    @RequestMapping(value ="/a/u/real-payment", produces="application/json")
//    public String realPayment(Long id, ModelMap model){
//        response.addHeader("Access-Control-Allow-Origin", "*");
//        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
//        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
//        response.addHeader("Access-Control-Max-Age", "1800");//30 min
//        Map<String,Object> map=new HashMap<>();
//        try {
//            String s= DateUtils.getCurrentDate("yyMMddHHmmssSSS")+DateUtils.getNewRandomCode(5)+id;
//            String mchnt_cd = StringUtils.nvl("0002230F0348879");
//            String order_id = StringUtils.nvl(s);
//            String order_amt = StringUtils.nvl(request.getParameter("order_amt"));
//            String user_id = StringUtils.nvl(request.getParameter("user_id"));
//            String card_no = StringUtils.nvl(request.getParameter("card_no"));
//            String page_notify_url = StringUtils.nvl("http://118.126.113.248:20404/a/real-paymentReport");
//            String cert_type = StringUtils.nvl("1");
//            String cert_no = StringUtils.nvl(request.getParameter("cert_no"));
//            String user_type = StringUtils.nvl("0");
//            String cardholder_name = StringUtils.nvl(request.getParameter("cardholder_name"));
//            String back_notify_url="http://118.126.113.248:20404/a/real-paymentReport";
//            String pri_key="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKfboTpVTiZV9SWxpJxkO4/JhNKzOgUJLty2TorqQ7jLrFmutVKgaGt3p6PU9drjbW6q8MSmauudkFok7TLtL/qeJY3PBlDlqNaj3b1kfQeuqwPgMQ1QTIFOPxT162fHHsnXBkW0/OAd3cWtRKPVFWOnLlADjSWzb0oPYOElT+gXAgMBAAECgYAGEVFdq3G8vwSyjR5XLOReSTmM6D+jqPZRsiFasicqieo7/628Q+IiaFvd9ze/5tKw2msDoMRiqfpq18TfP2WpiU5KYrFb0SSKyTFdFAEEwphxTbeVjxSgK4tybsGStPLLcUWNotv5jY62gE+VO/3baRK1b+pKKBieKHpL6cg4qQJBAPe5GDnN+qu93W8oiW0bEy8nz1BYaeHNjvl+3yeJgdy474aEpsd1VLgJI65pbtKh7dwYy6XODQyxQa/ZQSMPM+sCQQCtd2gvWESqeuueYHPmTF45kv5MGmsq1C5Jjb9ZBqSylVuoeDq1mFuTns+0EWVAXGY9ZrmS1axwaUjEoIuTlQ2FAkBjcvVcz2pg5Bovc/Cn0oTDG5JIyRXIxsMtOlfQAY4W1E+ki0CBNoNKVrDyZfVNriBVicbHy47Fl6utMuTJdGL9AkAqkmeLVwpjHI++6sUG/C8TyjOG0eUDOdeyTYtseejpuyYnjno6Hw46iHtJIgvLY+Hjp9ZbZv1PCUfGmfAnZClRAkEAgDZc4hbOsdToFV0yrqTE6nLcZS3+AC73Ru9rwm8AnFjM+4Yi8hSJbNfhq0JOdxW7ly9X6G2dHig7jxH0I0ohpg==";
//            String	signDataStr = mchnt_cd + "|" + user_id+ "|" +order_id+ "|" +order_amt+ "|" +
//                    card_no+ "|" +cardholder_name+ "|" +cert_type+ "|" +cert_no+ "|" +
//                    page_notify_url+"|"+back_notify_url;
//            byte[] bytesKey = (new BASE64Decoder()).decodeBuffer(pri_key.trim());
//            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(bytesKey);
//            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//            PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);
//            Signature signature = Signature.getInstance("MD5WithRSA");
//            signature.initSign(priKey);
//            signature.update(signDataStr.getBytes("GBK"));
//            String RSA ="MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJMr8NnRV7ve7Y5FEBium/TsU0fK5NvzvFpsYxPAQhBXY+EN0Bi2JEg790C1njk9Q3U36u2JBDHAiDIomlgh6wWkJsFn7dghV/fCWSX1VVJ+dRINZy1432fRaJ8GqspvMneBpeLjBe94IwlWKpN+AOR+BNX8QL/uHmfCPlVQXos9AgMBAAECgYAzqbMs434m50UBMmFKKNF6kxNRGnpodBFktLO7FTybu/HF6TFp21a1PMe5IYhfk5AAsBZ6OCUOygWFhhdYZN+5W+dweF3kp1rLE4y5CjwqNlk/g22TAndf9znh/ltHFLvITToqu/eh /34tE1gyNxRbsi1olw/1wv8ZRjM3vtM9QQJBANvNwFq+CJHUyFzkXQB7+ycQFnY8wDq8Uw2Hv9ZMjgIntH7FSlJtdu5mAYPPo6f74slO5tFUMNP7EVppqsjYaNkCQQCraD6iKHo+OIlvvYIKiMXatJGD7N1GNhq5CrhUNPWLHwv/Ih2D3JJdF8IUZOPIJfUxTfM2fZYI+EVdsv6s4RcFAkAGjNYbnighOGcUJZYD6q3sVxVkRqEv3ubWs2HrH/Lna4l8caKqXCq8JfwLkod8/QugFiLYwBqIZqX4vMdjHtfZAkBsAl9dbWZCaPvpxp/4JWGPxDLhz9NLV/KU4bVvkoObq++yUHwKyGYOdVcd5MlIKOsNq5Hzp0Vw14lWVuF2bMxFAkBuNrZksvUULNIaWDKd4rQ6GVzUxXuIZW0ZE6atHYDiXPB4jVAjKRtLxZAV1qH9cr1zNJlcg+RbGYUdF9t4A9n5";
//            model.addAttribute("RSA",RSA);
//            model.addAttribute("mchnt_cd",mchnt_cd);
//            model.addAttribute("order_id",order_id);
//            model.addAttribute("order_amt",order_amt);
//            model.addAttribute("user_type",user_type);
//            model.addAttribute("card_no",card_no);
//            model.addAttribute("page_notify_url",page_notify_url);
//            model.addAttribute("back_notify_url",back_notify_url);
//            model.addAttribute("cert_type",cert_type);
//            model.addAttribute("cert_no",cert_no);
//            model.addAttribute("cardholder_name",cardholder_name);
//            model.addAttribute("user_id",user_id);
//        }catch(Exception e){
//            logger.error("异常"+e);
//            jsonObject.put("data","");
//            jsonObject.put("code",2001);
//            return "error";
//        }
//        jsonObject.put("code",1000);
//        jsonObject.put("data",map);
//        return "send_dirpay";
//    }

    /**
     *确认支付-回落后台接口
     */
    @RequestMapping(value ="/a/real-paymentReport", produces="application/json"/*,method = RequestMethod.GET*/)
    public JSONObject realPaymentReport(HttpServletRequest request, HttpServletResponse response){
        logger.info("/a/real-paymentReport---POST---the request parameters are");
        Map<String,Object> map=new HashMap<>();
        logger.error("userId"+request.getParameter("user_id"));
        logger.error("******"+token.makeToken(request.getParameter("user_id")));
        User user=userService.selectByPhoneNumber(token.makeToken(request.getParameter("user_id")));
        //fuiou代码
        logger.error("******"+1);
        String order_pay_code = null;
        String order_pay_msg = null;
        String order_id = null;
        String order_amt=null;
        String card_no=null;
        try {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache,no-store,max-age=0");
            response.setDateHeader("Expires", 0);
            request.setCharacterEncoding("UTF-8");
            String mchnt_cd = StringUtils.nvl(request.getParameter("mchnt_cd"));
            order_id = StringUtils.nvl(request.getParameter("order_id"));
            order_amt = StringUtils.nvl(request.getParameter("order_amt"));
            String order_date = StringUtils.nvl(request.getParameter("order_date"));
            String order_st = StringUtils.nvl(request.getParameter("order_st"));
            order_pay_code = StringUtils.nvl(request.getParameter("order_pay_code"));
            order_pay_msg = StringUtils.nvl(request.getParameter("order_pay_msg"));
            String fy_ssn = StringUtils.nvl(request.getParameter("fy_ssn"));
            String user_id = StringUtils.nvl(request.getParameter("user_id"));
            card_no = StringUtils.nvl(request.getParameter("card_no"));
            String RSA = StringUtils.nvl(request.getParameter("RSA"));
            String publicKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCn26E6VU4mVfUlsaScZDuPyYTSszoFCS7ctk6K6kO4y6xZrrVSoGhrd6ej1PXa421uqvDEpmrrnZBaJO0y7S/6niWNzwZQ5ajWo929ZH0HrqsD4DENUEyBTj8U9etnxx7J1wZFtPzgHd3FrUSj1RVjpy5QA40ls29KD2DhJU/oFwIDAQAB";
            String	signDataStr = mchnt_cd + "|" + user_id+ "|" +order_id+ "|" +order_amt+ "|" +
                    order_date+ "|" +card_no+ "|" +fy_ssn;
            byte[] keyBytes = (new BASE64Decoder()).decodeBuffer(publicKey);
            // 构造X509EncodedKeySpec对象
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
            // KEY_ALGORITHM 指定的加密算法
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            // 取公钥匙对象
            PublicKey pubKey = keyFactory.generatePublic(keySpec);
            Signature signature = Signature.getInstance("MD5withRSA");
            signature.initVerify(pubKey);
            signature.update(signDataStr.getBytes("gbk"));
            // 验证签名是否正常
            boolean ret = signature.verify((new BASE64Decoder()).decodeBuffer(RSA));
            System.out.println("RSA验签结果：" + ret);
            if(!ret){
                System.out.println("验签失败");
            }
        }
        catch(Exception e){
            System.out.println("你好");
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        if(order_pay_code.equals("0000")){
            /**
             插入逻辑,先获取productId，然后在 InvestmentContract,Trade和historyProduct表插入数据
             */
            Long productId=Long.valueOf(order_id.substring(20));
            logger.error("***"+productId);
            Trade trade=new Trade();
            HistoryProduct historyProduct=new HistoryProduct();
            InvestmentContract investmentContract=new InvestmentContract();
            try{
                //判断是否是新手,如果是新手购买产品更新状态
                if(user.getIsNoviceGift()==0){
                    user.setIsNoviceGift(1);
                    userService.updateByPrimaryKeySelective(user);
                }
                //投资及时是生效
                Long thisTime=System.currentTimeMillis();
                Product product=productService.selectByPrimaryKey(productId);
                //投资合同字段 trueName;phoneNumber;product;investAmount;income;effectiveTime;invalidTime;status;
                investmentContract.setTrueName(token.SolveToken(user.getTrueName()));
                investmentContract.setPhoneNumber(token.SolveToken(user.getPhone()));
                investmentContract.setProduct(product.getProductName());
                investmentContract.setInvestAmount(BigDecimal.valueOf(Long.valueOf(order_amt)));
                investmentContract.setIncome(product.getExpectedRate());
                investmentContract.setEffectiveTime(thisTime);
                investmentContract.setInvalidTime(thisTime+product.getInvestmentCycle()*24*60*60*1000l);
                investmentContract.setStatus(1);
                investmentContract.setUserId(user.getId());
                logger.info("{}",investmentContract);
                //插入InvestmentContract投资合同
                investmentContractService.insertSelective(investmentContract);
                Long investmentContractId=investmentContract.getId();
                //交易trade字段tradeId;product;purchaser;buyTime;delayTime;expireTime;toBeMatched;purchaseAmount;status;userId;expectedRate;
                trade.setInvestmentContractId(investmentContractId);
                trade.setProduct(product.getProductName());
                trade.setPurchaser(token.SolveToken(user.getTrueName()));
                trade.setBuyTime(thisTime);
                trade.setDelayTime(Long.valueOf(product.getInvestmentCycle()));
                trade.setExpireTime(thisTime+product.getInvestmentCycle()*24*60*60*1000l);
                trade.setExpectedRate(product.getExpectedRate());
                trade.setToBeMatched(BigDecimal.valueOf(Long.valueOf(order_amt)));
                trade.setPurchaseAmount(BigDecimal.valueOf(Long.valueOf(order_amt)));
                trade.setStatus(0);
                trade.setUserId(user.getId());
                logger.info("{}",trade);
                //插入有效交易Trade
                tradeService.insertSelective(trade);

                //历史记录表HistoryProduct表字段product;bankCard;buyer;buyTime;arriveTime;transactionAction;transactionAmouont;phone;
                historyProduct.setProduct(product.getProductName());
                historyProduct.setBankCard(card_no);
                historyProduct.setBuyer(token.SolveToken(user.getTrueName()));
                historyProduct.setBuyTime(thisTime);
                historyProduct.setArriveTime(thisTime+product.getInvestmentCycle()*24*60*60*1000l);
                historyProduct.setTransactionAction(2);
                historyProduct.setTransactionAmouont(BigDecimal.valueOf(Long.valueOf(order_amt)));
                historyProduct.setPhone(user.getPhone());
                historyProduct.setUserId(user.getId());
                historyProduct.setExpectedRate(product.getExpectedRate());
                logger.info("{}",historyProduct);
                //插入交易记录HistoryProduct
                historyProductService.insertSelective(historyProduct);
                //用户加上对应的金钱
                user.setTotalAssets(user.getTotalAssets().add(BigDecimal.valueOf(Long.valueOf(order_amt))));
                logger.info("{}",user);
                userService.updateByPrimaryKeySelective(user);
                jsonObject.put("code",1000);
            } catch (Throwable e){
                logger.error("异常"+e);
                jsonObject.put("data","");
                jsonObject.put("code",2001);
                return jsonObject;
            }
        }else
        {
            jsonObject.put("code",1001);
        }
        map.put("order_pay_msg",order_pay_msg);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *28我的理财(显示已投资部分)
     * 32显示已续投内容
     */
    @RequestMapping(value ="/a/u/finance", produces="application/json",method = RequestMethod.GET)
    public JSONObject finance(Integer status,HttpServletRequest request){
        logger.info("/client/a/u/finance---GET---the request parameters are");
        String thisId = null;
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            for (Cookie c : cookie) {  // 遍历Cookie
                if("userId".equals(c.getName()))
                    thisId=c.getValue();
            }
        }
        Long id=Long.valueOf(token.SolveToken(thisId));
        List<Trade> trades;

        try{
            if(status==0){
                int a=0;
                int b=1;
                trades=tradeService.selectByUserId(id,a,b);
                if(null==trades)
                {
                    jsonObject.put("code",1000);
                    jsonObject.put("data",0);
                    return jsonObject;
                }
            }else {
                int a=2;
                int b=3;
                trades=tradeService.selectByUserId(id,a,b);
                if(null==trades)
                {
                    jsonObject.put("code",1000);
                    jsonObject.put("data",0);
                    return jsonObject;
                }
            }
        }catch(Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
//        logger.info(trades.toString());
        jsonObject.put("code",1000);
        jsonObject.put("data",trades);
        return jsonObject;

    }

    /**
     *29查看合同
     */
    @RequestMapping(value ="/a/u/contract", produces="application/json",method = RequestMethod.GET)
    public JSONObject contract(Long tradeId){
        logger.info("/client/a/u/contract---GET---the request parameters are tradeId:{}",tradeId);
        InvestmentContract investmentContract;
        User user;
        Map map = new HashMap();
        try{
            investmentContract=investmentContractService.selectByPrimaryKey(tradeId);
             user = userService.selectByPrimaryKey(investmentContract.getUserId());
        }catch(Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
//        logger.info(investmentContract.toString());
        jsonObject.put("code",1000);
        map.put("phone",investmentContract.getPhoneNumber());
        map.put("trueName",investmentContract.getTrueName());
        map.put("purchaseAmount",investmentContract.getInvestAmount());
        map.put("buyTime",investmentContract.getEffectiveTime());
        map.put("phone",investmentContract.getPhoneNumber());
        map.put("idCard",token.SolveToken(user.getIdCard()));
        jsonObject.put("data",map);
        return jsonObject;
    }

    /**
     *30预约续投
     *31取消续投
     */
    @RequestMapping(value ="/a/u/reservation", produces="application/json",method = RequestMethod.PUT)
    public JSONObject reservation(Long id,Integer status){
        logger.info("/client/a/u/reservation---PUT---the request parameters are id:{}",id);
        int a;
        try{
            Trade trade=tradeService.selectByPrimaryKey(id);
            if(status==0){
                trade.setStatus(trade.getStatus()-1);
            }else {
                trade.setStatus(trade.getStatus()+1);
            }
            a=tradeService.updateByPrimaryKey(trade);
        }catch (Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        if(a>0){
            jsonObject.put("code",1000);
        }else {
            jsonObject.put("code",2001);
        }
        jsonObject.put("data","");
        return jsonObject;
    }


    /**
     *33显示已退出的内容
     */
    @RequestMapping(value ="/a/u/quited-contract", produces="application/json",method = RequestMethod.GET)
    public JSONObject quitedContract(HttpServletRequest request){
        logger.info("/client/a/u/reservation---GET---the request parameters are userId:{}");
        String id = null;
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            for (Cookie c : cookie) {  // 遍历Cookie
                if("userId".equals(c.getName()))
                    id=c.getValue();
            }
        }
        List<HistoryProduct> historyProducts;
        try{
            historyProducts=historyProductService.selectByUserId(Long.valueOf(token.SolveToken(id)));
            if(null==historyProducts)
            {
                jsonObject.put("code",1000);
                jsonObject.put("data",0);
                return jsonObject;
            }
        }catch (Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        List<HistoryProducts> historyProductsList = new ArrayList<>();
        for(HistoryProduct historyProduct:historyProducts){
            HistoryProducts historyProducts1 = new HistoryProducts();
            historyProducts1.setDelayTime((historyProduct.getArriveTime()-historyProduct.getBuyTime())/1000/3600/24);
            historyProducts1.setExpectedRate(historyProduct.getExpectedRate());
            historyProducts1.setProduct(historyProduct.getProduct());
            historyProducts1.setArriveTime(historyProduct.getArriveTime());
            historyProducts1.setBuyTime(historyProduct.getBuyTime());
            historyProducts1.setTransactionAmouont(historyProduct.getTransactionAmouont());
            historyProducts1.setPhone(historyProduct.getPhone());
            historyProducts1.setBankCard(historyProduct.getBankCard());

            historyProductsList.add(historyProducts1);

        }
        jsonObject.put("code",1000);
        jsonObject.put("data",historyProductsList);
        return jsonObject;
    }

    /**
     *34交易记录
     */
    @RequestMapping(value ="/a/u/records", produces="application/json",method = RequestMethod.GET)
    public JSONObject records(HttpServletRequest request){
        logger.info("/client/a/u/reservation---GET---the request parameters are userId:{}");
        String id = null;
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            for (Cookie c : cookie) {  // 遍历Cookie
                if("userId".equals(c.getName()))
                    id=c.getValue();
            }
        }
        List<HistoryProduct> historyProducts;
        try{
            historyProducts=historyProductService.selectUserProductByUserId(Long.valueOf(token.SolveToken(id)));
        }catch(Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        jsonObject.put("code",1000);
        jsonObject.put("data",historyProducts);
        return jsonObject;
    }

    /**
     *35显示银行卡
     */

    @RequestMapping(value ="/a/u/bank-cards", produces="application/json",method = RequestMethod.GET)
    public JSONObject bankCards(HttpServletRequest request){
        logger.info("/client/a/u/bank-cards---GET---the request parameters are userId:{}");
        String id = null;
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            for (Cookie c : cookie) {  // 遍历Cookie
                if("userId".equals(c.getName()))
                    id=c.getValue();
            }
        }
        User user;
        try{
            user=userService.selectByPrimaryKey(Long.valueOf(token.SolveToken(id)));
        }catch(Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        String bankCard1=token.SolveToken(user.getBankCard1());
        String bankCard2=token.SolveToken(user.getBankCard2());
        if (bankCard1.equals("")&&bankCard2.equals("")){
            jsonObject.put("code", 3014);
            jsonObject.put("data", "");
            return jsonObject;
        }
        List<Map> list=new ArrayList<>();
        if(!("".equals(bankCard1))){
            Map<String,String> map1=new HashMap<>();
        String bankCardWithNumber1=elTest.getOne(bankCard1);
        String bank1=elTest.getBank(bankCard1);
            map1.put("bank",bank1);
            map1.put("card",bankCardWithNumber1);
            list.add(map1);
        }
        if(!("".equals(bankCard2))){
            Map<String,String> map2=new HashMap<>();
        String bankCardWithNumber2=elTest.getOne(bankCard2);
        String bank2=elTest.getBank(bankCard2);
            map2.put("bank",bank2);
            map2.put("card",bankCardWithNumber2);
            list.add(map2);
        }
        logger.info(""+list);
        jsonObject.put("code", 1000);
        jsonObject.put("data", list);
        return jsonObject;
    }

    /**
     *36添加银行卡-获取个人信息
     */
    @RequestMapping(value ="/a/u/bank-card", produces="application/json",method = RequestMethod.GET)
    public JSONObject bankCard(HttpServletRequest request){
        logger.info("/client/a/u/bank-card---GET---the request parameters are userId:{}");
        String id = null;
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            for (Cookie c : cookie) {  // 遍历Cookie
                if("userId".equals(c.getName()))
                    id=c.getValue();
            }
        }
        User user;
        try{
            user=userService.selectByPrimaryKey(Long.valueOf(token.SolveToken(id)));
            user.setTrueName(token.SolveToken(user.getTrueName()));
            user.setPhone(token.SolveToken(user.getPhone()));
            user.setIdCard(token.SolveToken(user.getIdCard()));
        }catch(Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        if(!(token.SolveToken(user.getBankCard1()).equals(""))&&!(token.SolveToken(user.getBankCard2()).equals(""))){
            jsonObject.put("code",3013);
            jsonObject.put("data","");
            return jsonObject;
        }
        if("".equals(user.getTrueName())){
            jsonObject.put("code",3011);
            jsonObject.put("data","");
        }else {
            jsonObject.put("code",1000);
            jsonObject.put("data",user);
        }
        return jsonObject;
    }

    /**
     *37填写银行卡信息-下一步
     */
    @RequestMapping(value ="/a/u/bank-message", produces="application/json",method = RequestMethod.GET)
    public JSONObject bankMessage(String bankCard, HttpServletRequest request) throws Exception {
        logger.info("/client/a/u/bank-message---GET---the request parameters are userId:{}");
        FuiouUtil fuiouUtil=new FuiouUtil();
        Map<String,String>map=new HashMap<>();
        String id = null;
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            for (Cookie c : cookie) {  // 遍历Cookie
                if("userId".equals(c.getName()))
                    id=c.getValue();
            }
        }
        User user;
        try{
            user=userService.selectByPrimaryKey(Long.valueOf(token.SolveToken(id)));
        }catch (Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        String respStr=fuiouUtil.checkBankCard(token.SolveToken(user.getTrueName()),token.SolveToken(user.getIdCard()),bankCard);
        String reg = "[^\u4e00-\u9fa5]";
        respStr = respStr.replaceAll(reg, "");
        if(respStr.contains("成功")){
            respStr = respStr.replaceAll("成功", "");
            if(respStr.contains("中国")){
            respStr = respStr.replaceAll("中国", "");
            }
            logger.info(""+respStr);
            map.put("bank",respStr);
            map.put("bankCard",bankCard);
            map.put("phone",token.SolveToken(user.getPhone()));
            jsonObject.put("code",1000);
        }else {
            jsonObject.put("code",3012);
        }
        jsonObject.put("data",map);
        return jsonObject;
    }

    /**
     *39银行卡绑卡
     */
    @RequestMapping(value ="/a/u/new-bank-card", produces="application/json",method = RequestMethod.PUT)
    public JSONObject newBankCard(String smsCode,String bank,String bankCard,HttpServletRequest request){
        logger.info("/client/a/u/new-bank-card---GET---the request parameters are smsCode:{},bank:{},bankCard:{}",smsCode,bank,bankCard);
        String id = null;
        Cookie[] cookie = request.getCookies();
        User user;
        if (cookie != null) {
            for (Cookie c : cookie) {  // 遍历Cookie
                if("userId".equals(c.getName()))
                    id=c.getValue();
            }
        }
        user=userService.selectByPrimaryKey(Long.valueOf(token.SolveToken(id)));
//        if(redisTemplate.hasKey("googleSmsCode3"+phone)){
//            String code=(String)redisTemplate.opsForValue().get("googleSmsCode3"+phone);
            if(smsCode != null /*&&smsCode.equals(code)*/)
            {
                if(token.SolveToken(user.getBankCard1()).equals("")){
                    if(!("".equals(token.SolveToken(user.getBankCard2())))&&token.SolveToken(user.getBankCard2()).equals(bank+bankCard))
                    {
                        jsonObject.put("data","");
                        jsonObject.put("code",2005);
                        return jsonObject;
                    }
                    user.setBankCard1(token.makeToken(bank+bankCard));
                }else if(token.SolveToken(user.getBankCard2()).equals("")){
                    if(!("".equals(token.SolveToken(user.getBankCard1())))&&token.SolveToken(user.getBankCard1()).equals(bank+bankCard))
                    {
                        jsonObject.put("data","");
                        jsonObject.put("code",2005);
                        return jsonObject;
                    }
                    user.setBankCard2(token.makeToken(bank+bankCard));
                }else {
                    jsonObject.put("data","");
                    jsonObject.put("code",3013);
                    return jsonObject;
                }
                try{
                    userService.updateByPrimaryKeySelective(user);
                }catch (Throwable e){
                    logger.error("异常"+e);
                    jsonObject.put("data","");
                    jsonObject.put("code",2001);
                    return jsonObject;
                }
                jsonObject.put("code",1000);
            }else{
                jsonObject.put("code",3004);
            }
//        }else{
//            jsonObject.put("code",3003);
//        }
        jsonObject.put("data","");
        return jsonObject;
    }

    /**
     *40选择银行卡
     */
    @RequestMapping(value ="/a/u/one-bank", produces="application/json",method = RequestMethod.GET)
    public JSONObject oneBank(String  bankCard,HttpServletRequest request){
        Map<String,String> map=new HashMap<>();
        List<String> bankCards=new ArrayList<>();
        String id = null;
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            for (Cookie c : cookie) {  // 遍历Cookie
                if("userId".equals(c.getName()))
                    id=c.getValue();
            }
        }
        User user;
        try{
            user=userService.selectByPrimaryKey(Long.valueOf(token.SolveToken(id)));
        }catch(Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        String bankCard1=token.SolveToken(user.getBankCard1());
        if(bankCard.equals(elTest.getOne(bankCard1))){
            bankCards.add(bankCard1);
            map=elTest.get(bankCards);
        }else {
            bankCards.add(token.SolveToken(user.getBankCard2()));
            map=elTest.get(bankCards);
        }
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }

    /**
     *42解除绑定
     */
    @RequestMapping(value ="/a/u/unbinding-card", produces="application/json",method = RequestMethod.POST)
    public JSONObject removeBindCard(String smsCode,String  bankCard,HttpServletRequest request){
        logger.info("/client/a/u/new-bank-card---GET---the request parameters are smsCode:{},bankCard:{}",smsCode,bankCard);
        String id = null;
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            for (Cookie c : cookie) {  // 遍历Cookie
                if("userId".equals(c.getName()))
                    id=c.getValue();
            }
        }
        User user;
        try{
            user=userService.selectByPrimaryKey(Long.valueOf(token.SolveToken(id)));
        }catch(Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        String phone=token.SolveToken(user.getPhone());
//        if(redisTemplate.hasKey("googleSmsCode3"+phone)){
//            String code=(String)redisTemplate.opsForValue().get("googleSmsCode3"+phone);
            if(smsCode != null/* &&smsCode.equals(code)*/)
            {
                if(elTest.getOneWithNum(elTest.getOneWithNum(token.SolveToken(user.getBankCard1()))).equals(bankCard)){
                    user.setBankCard1(token.makeToken(""));
                }else {
                    user.setBankCard2(token.makeToken(""));
                }
                try{
                    userService.updateByPrimaryKeySelective(user);
                }catch(Throwable e){
                    logger.error("异常"+e);
                    jsonObject.put("data","");
                    jsonObject.put("code",2001);
                    return jsonObject;
                }
                jsonObject.put("code",1000);
            }else{
                jsonObject.put("code",3004);
            }
//        }else{
//            jsonObject.put("code",3003);
//        }
        jsonObject.put("data","");
        return jsonObject;
    }



}
