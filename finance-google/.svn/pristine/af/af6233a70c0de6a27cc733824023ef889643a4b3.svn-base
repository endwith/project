package com.ptteng.controller;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.model.Product;
import com.thoughtworks.xstream.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RefreshScope
@Controller
public class ProductController {
    @Autowired
    private JSONObject jsonObject;
    /**
     *63产品管理入口
     */
    @RequestMapping(value ="/admin/a/u/allproduct", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getAllProduct(Long page,Long size){
        Product product=new Product();
        product.setId(1L);
        product.setProductName("聚月增");
        product.setExpectedRate(BigDecimal.valueOf(7));
        product.setInvestmentCycle(30);
        product.setOriginMoney(BigDecimal.valueOf(5000));
        product.setAddMoney(BigDecimal.valueOf(1000));
        product.setFounder("牛魔王");
        product.setCreateAt(139293923L);
        product.setStatus(1);
        product.setModifier("猪八戒");
        product.setUpdateAt(139293923L);
        String productId="productId"+product.getId();
        Map<String,Object> map=new HashMap<>();
        map.put(productId,product);
        map.put("productId2",product);
        map.put("productId3",product);
        map.put("productId4",product);
        map.put("productId5",product);
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *64产品模糊查询
     */
    @RequestMapping(value ="/admin/a/u/products", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getProducts(Long page,Long size,Long id,String productName,String founer,int status){
        Product product=new Product();
        product.setId(1L);
        product.setProductName("聚月增");
        product.setExpectedRate(BigDecimal.valueOf(7));
        product.setInvestmentCycle(30);
        product.setOriginMoney(BigDecimal.valueOf(5000));
        product.setAddMoney(BigDecimal.valueOf(1000));
        product.setFounder("牛魔王");
        product.setCreateAt(139293923L);
        product.setStatus(1);
        product.setModifier("猪八戒");
        product.setUpdateAt(139293923L);
        String productId="productId"+product.getId();
        Map<String,Object> map=new HashMap<>();
        map.put(productId,product);
        map.put("productId2",product);
        map.put("productId3",product);
        map.put("productId4",product);
        map.put("productId5",product);
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *65产品新增
     */
    @RequestMapping(value ="/admin/a/u/product", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addProduct(String productName,BigDecimal expectedRate,int investmentCycle,BigDecimal originMoney,BigDecimal addMoney,byte returnInterest,String introduce,String moreInformation){
        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }
    /**
     *66产品编辑—获取该产品信息
     */
    @RequestMapping(value ="/admin/a/u/product/{id}", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getProduct(Long id){
        Product product=new Product();
        product.setId(1L);
        product.setProductName("聚月增");
        product.setExpectedRate(BigDecimal.valueOf(7));
        product.setInvestmentCycle(30);
        product.setOriginMoney(BigDecimal.valueOf(5000));
        product.setAddMoney(BigDecimal.valueOf(1000));
        product.setReturnInterest(1);
        product.setIntroduce("产品介绍");
        product.setMoreInformation("产品跟多详情");
        String productId="productId"+product.getId();
        Map<String,Object> map=new HashMap<>();
        map.put(productId,product);
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *67产品编辑—更新该产品
     *68产品上下架
     */
    @RequestMapping(value ="/admin/a/u/product/{id}", produces="application/json",method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject updateProduct(Long id,String productName,BigDecimal expectedRate,int investmenCycle,BigDecimal originMoney,BigDecimal addMoney,int returnInterest,String introduce,String moreInformation,int status){
        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }
    /**
     *69产品删除
     */
    @RequestMapping(value ="/admin/a/u/product/{id}", produces="application/json",method = RequestMethod.DELETE)
    @ResponseBody
    public JSONObject deleteProduct(Long id){
        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }

}
