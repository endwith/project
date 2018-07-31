package com.ptteng.service;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.model.User;
import com.ptteng.service.impl.FinanceServiceHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *提供一个java接口连接服务， 接口中的方法对应url接口就能直接访问了，不需要ribbon实例服务提供者
 */
//@FeignClient声明feign，添加fallback熔断器实现类
@FeignClient(value = "finance-client",fallback=FinanceServiceHystric.class)
public interface FinanceService {
    /**
     *8首页
     */
    @RequestMapping(value ="/a/main-page", produces="application/json",method = RequestMethod.GET)
    JSONObject mainPage();
    /**
     *9产品详情
     */
    @RequestMapping(value ="/a/product", produces="application/json",method = RequestMethod.GET)
    JSONObject product(@RequestParam(value = "product",required = false)String product);
    /**
     *9 产品的投资记录
     */
    @RequestMapping(value ="/a/product/record", produces="application/json",method = RequestMethod.GET)
    JSONObject productRecord(@RequestParam(value = "product",required = false)String product,@RequestParam(value = "page",required = false)Long page,@RequestParam(value = "size",required = false)Long size);
    /**
     *10理财
     */
    @RequestMapping(value ="/a/finances", produces="application/json",method = RequestMethod.GET)
    JSONObject finances(@RequestParam(value = "count",required = false)long count
            ,@RequestParam(value = "request",required = false)HttpServletRequest request);
    /**
     *11立即购买
     *14支付银行卡选择
     */
    @RequestMapping(value ="/a/u/buyer", produces="application/json",method = RequestMethod.GET)
     JSONObject buy(@RequestParam(value = "id",required = false)Long id
            ,@RequestParam(value = "request",required = false)HttpServletRequest request);
    /**
     *12确认购买
     */
    @RequestMapping(value ="/a/u/confirming-payment", produces="application/json",method = RequestMethod.GET)
     JSONObject payment(@RequestParam(value = "money",required = false)Long money,
                        @RequestParam(value = "bankCard",required = false)String bankCard,@RequestParam(value = "id",required = false)Long id
            ,@RequestParam(value = "request",required = false)HttpServletRequest request);
    /**
     *13支付方式选择
     */
    @RequestMapping(value ="/a/u/payment", produces="application/json",method = RequestMethod.GET)
     JSONObject choosePay(@RequestParam(value = "request",required = false)HttpServletRequest request);
//    /**
//     *15确认支付
//     */
//    @RequestMapping(value ="/a/u/real-payment", produces="application/json",method = RequestMethod.POST)
//     JSONObject realPayment(@RequestParam(value = "id",required = false)Long id);
    /**
     *确认支付-回落后台接口
     */
    @RequestMapping(value ="/a/real-paymentReport", produces="application/json"/*,method = RequestMethod.GET*/)
    JSONObject realPaymentReport(@RequestParam(value = "request",required = false)HttpServletRequest request, @RequestParam(value = "response",required = false)HttpServletResponse response);

}
