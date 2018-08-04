package com.fangyuyang.controller;

import com.fangyuyang.pay.client.util.DateUtils;
import com.fangyuyang.pay.client.util.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;


@Controller
public class FinanceController {
    org.slf4j.Logger logger = LoggerFactory.getLogger(FinanceController.class);

    @Autowired
    HttpServletRequest request;

    @RequestMapping(value ="/index")
    public String hello(){
        return "index";
    }
    /**
     *15确认支付
     */
    @RequestMapping(value ="/a/real-payment")
    public String realPayment(Long id, ModelMap model){
        logger.info("/a/real-paymentReport---POST---the request parameters are id:{}",id);
        try {
            String s= DateUtils.getCurrentDate("yyMMddHHmmssSSS")+DateUtils.getNewRandomCode(5)+id;
            String mchnt_cd = StringUtils.nvl("0002230F0348879");
            String order_id = StringUtils.nvl(s);

            String order_amt = StringUtils.nvl(request.getParameter("order_amt"));
            String user_id = StringUtils.nvl(request.getParameter("user_id"));
            String card_no = StringUtils.nvl(request.getParameter("card_no"));
            String page_notify_url = StringUtils.nvl("http://www-1.fuiou.com:8888/pay_test/result.jsp");
            String cert_type = StringUtils.nvl("1");
            String cert_no = StringUtils.nvl(request.getParameter("cert_no"));
            String user_type = StringUtils.nvl("0");
            String cardholder_name = StringUtils.nvl(request.getParameter("cardholder_name"));
            String back_notify_url="http://118.126.113.248:20404/a/real-paymentReport";
            String pri_key="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKfboTpVTiZV9SWxpJxkO4/JhNKzOgUJLty2TorqQ7jLrFmutVKgaGt3p6PU9drjbW6q8MSmauudkFok7TLtL/qeJY3PBlDlqNaj3b1kfQeuqwPgMQ1QTIFOPxT162fHHsnXBkW0/OAd3cWtRKPVFWOnLlADjSWzb0oPYOElT+gXAgMBAAECgYAGEVFdq3G8vwSyjR5XLOReSTmM6D+jqPZRsiFasicqieo7/628Q+IiaFvd9ze/5tKw2msDoMRiqfpq18TfP2WpiU5KYrFb0SSKyTFdFAEEwphxTbeVjxSgK4tybsGStPLLcUWNotv5jY62gE+VO/3baRK1b+pKKBieKHpL6cg4qQJBAPe5GDnN+qu93W8oiW0bEy8nz1BYaeHNjvl+3yeJgdy474aEpsd1VLgJI65pbtKh7dwYy6XODQyxQa/ZQSMPM+sCQQCtd2gvWESqeuueYHPmTF45kv5MGmsq1C5Jjb9ZBqSylVuoeDq1mFuTns+0EWVAXGY9ZrmS1axwaUjEoIuTlQ2FAkBjcvVcz2pg5Bovc/Cn0oTDG5JIyRXIxsMtOlfQAY4W1E+ki0CBNoNKVrDyZfVNriBVicbHy47Fl6utMuTJdGL9AkAqkmeLVwpjHI++6sUG/C8TyjOG0eUDOdeyTYtseejpuyYnjno6Hw46iHtJIgvLY+Hjp9ZbZv1PCUfGmfAnZClRAkEAgDZc4hbOsdToFV0yrqTE6nLcZS3+AC73Ru9rwm8AnFjM+4Yi8hSJbNfhq0JOdxW7ly9X6G2dHig7jxH0I0ohpg==";
            String	signDataStr = mchnt_cd + "|" + user_id+ "|" +order_id+ "|" +order_amt+ "|" +
                    card_no+ "|" +cardholder_name+ "|" +cert_type+ "|" +cert_no+ "|" +
                    page_notify_url+"|"+back_notify_url;
            byte[] bytesKey = (new BASE64Decoder()).decodeBuffer(pri_key.trim());
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(bytesKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);
            Signature signature = Signature.getInstance("MD5WithRSA");
            signature.initSign(priKey);
            signature.update(signDataStr.getBytes("GBK"));
            String RSA ="MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJMr8NnRV7ve7Y5FEBium/TsU0fK5NvzvFpsYxPAQhBXY+EN0Bi2JEg790C1njk9Q3U36u2JBDHAiDIomlgh6wWkJsFn7dghV/fCWSX1VVJ+dRINZy1432fRaJ8GqspvMneBpeLjBe94IwlWKpN+AOR+BNX8QL/uHmfCPlVQXos9AgMBAAECgYAzqbMs434m50UBMmFKKNF6kxNRGnpodBFktLO7FTybu/HF6TFp21a1PMe5IYhfk5AAsBZ6OCUOygWFhhdYZN+5W+dweF3kp1rLE4y5CjwqNlk/g22TAndf9znh/ltHFLvITToqu/eh /34tE1gyNxRbsi1olw/1wv8ZRjM3vtM9QQJBANvNwFq+CJHUyFzkXQB7+ycQFnY8wDq8Uw2Hv9ZMjgIntH7FSlJtdu5mAYPPo6f74slO5tFUMNP7EVppqsjYaNkCQQCraD6iKHo+OIlvvYIKiMXatJGD7N1GNhq5CrhUNPWLHwv/Ih2D3JJdF8IUZOPIJfUxTfM2fZYI+EVdsv6s4RcFAkAGjNYbnighOGcUJZYD6q3sVxVkRqEv3ubWs2HrH/Lna4l8caKqXCq8JfwLkod8/QugFiLYwBqIZqX4vMdjHtfZAkBsAl9dbWZCaPvpxp/4JWGPxDLhz9NLV/KU4bVvkoObq++yUHwKyGYOdVcd5MlIKOsNq5Hzp0Vw14lWVuF2bMxFAkBuNrZksvUULNIaWDKd4rQ6GVzUxXuIZW0ZE6atHYDiXPB4jVAjKRtLxZAV1qH9cr1zNJlcg+RbGYUdF9t4A9n5";
            model.addAttribute("RSA",RSA);
            model.addAttribute("mchnt_cd",mchnt_cd);
            model.addAttribute("order_id",order_id);
            model.addAttribute("order_amt",order_amt);
            model.addAttribute("user_type",user_type);
            model.addAttribute("card_no",card_no);
            model.addAttribute("page_notify_url",page_notify_url);
            model.addAttribute("back_notify_url",back_notify_url);
            model.addAttribute("cert_type",cert_type);
            model.addAttribute("cert_no",cert_no);
            model.addAttribute("cardholder_name",cardholder_name);
            model.addAttribute("user_id",user_id);
        }catch(Exception e){
            logger.error("异常"+e);
            return "error";
        }
        return "send_dirpay";
    }


}
