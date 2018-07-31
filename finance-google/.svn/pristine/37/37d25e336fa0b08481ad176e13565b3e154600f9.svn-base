package com.ptteng.service;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.model.Product;
import com.ptteng.service.impl.ProductServiceHystric;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 *提供一个java接口连接服务， 接口中的方法对应url接口就能直接访问了，不需要ribbon实例服务提供者
 */
//@FeignClient声明feign，添加fallback熔断器实现类
@FeignClient(value = "finance-admin",fallback=ProductServiceHystric.class)
public interface ProductService {
    /**
     *63产品管理入口
     */
    @RequestMapping(value ="/a/u/allproduct", produces="application/json",method = RequestMethod.GET)
     JSONObject getAllProduct(@RequestParam(value = "page",required = false)Long page, @RequestParam(value = "size",required = false)Long size);
    /**
     *64产品模糊查询
     */
    @RequestMapping(value ="/a/u/products", produces="application/json",method = RequestMethod.GET)
     JSONObject getProducts(@RequestParam(value = "page",required = false)Long page,@RequestParam(value = "size",required = false)Long size,@RequestParam(value = "id",required = false)Long id,
                            @RequestParam(value = "productName",required = false)String productName,@RequestParam(value = "founder",required = false)String founder,
                            @RequestParam(value = "status",required = false)Integer status);
    /**
     *65产品新增
     */
    @RequestMapping(value ="/a/u/product", produces="application/json",method = RequestMethod.POST)
     JSONObject addProduct(@RequestParam(value = "productName",required = false)String productName, @RequestParam(value = "expectedRate",required = false)BigDecimal expectedRate,
                           @RequestParam(value = "investmentCycle",required = false)Integer investmentCycle, @RequestParam(value = "originMoney",required = false)BigDecimal originMoney, @RequestParam(value = "addMoney",required = false)BigDecimal addMoney, @RequestParam(value = "returnInterest",required = false)Integer returnInterest,
                           @RequestParam(value = "introduce",required = false)String introduce, @RequestParam(value = "moreInformation",required = false)String moreInformation
                            , @RequestParam(value = "request",required = false)HttpServletRequest request);
    /**
     *66产品编辑—获取该产品信息
     */
    @RequestMapping(value ="/a/u/product/{id}", produces="application/json",method = RequestMethod.GET)
     JSONObject getProduct(@RequestParam(value = "id",required = false)Long id);
    /**
     *67产品编辑—更新该产品
     *68产品上下架
     */
    @RequestMapping(value ="/a/u/product/{id}", produces="application/json",method = RequestMethod.PUT)
     JSONObject updateProduct(@RequestParam(value = "id",required = false)Long id, @RequestParam(value = "productName",required = false)String productName, @RequestParam(value = "expectedRate",required = false)BigDecimal expectedRate, @RequestParam(value = "investmenCycle",required = false)Integer investmenCycle,
                              @RequestParam(value = "originMoney",required = false)BigDecimal originMoney, @RequestParam(value = "addMoney",required = false)BigDecimal addMoney, @RequestParam(value = "returnInterest",required = false)Integer returnInterest,
                              @RequestParam(value = "introduce",required = false)String introduce, @RequestParam(value = "moreInformation",required = false)String moreInformation, @RequestParam(value = "status",required = false)Integer status
            , @RequestParam(value = "request",required = false)HttpServletRequest request);
    /**
     *69产品删除
     */
    @RequestMapping(value ="/a/u/product/{id}", produces="application/json",method = RequestMethod.DELETE)
     JSONObject deleteProduct(@RequestParam(value = "id",required = false)Long id);

}
