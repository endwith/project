package com.ptteng.controller;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.model.ProductRecommend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RefreshScope
@Controller
public class ProductRecommendController {
    @Autowired
    private JSONObject jsonObject;
    /**
     *70运营管理中的banner图入口
     *77鼎力推荐入口
     */
    @RequestMapping(value ="/admin/a/u/product-recommend", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getAllProductRecommend(Long page,Long size,int type){
        ProductRecommend prd=new ProductRecommend();
        Map<String,Object> map=new HashMap<>();
        if(type==0)
        { prd.setId(1L);
        prd.setTitle("超级划算");
        prd.setPicture("https://endwith.oss-cn-shenzhen.aliyuncs.com/student152769177116310850.jpg");
        prd.setInterval(7);
        prd.setFounder("admin");
        prd.setCreateAt(123412412L);
        prd.setUpdateAt(123412412L);
        prd.setModifier("admin");
        prd.setBannerStatus(1);
        String pdrd="pdrd"+prd.getId();
        map.put(pdrd,prd);
        map.put("pdrd2",prd);
        map.put("pdrd3",prd);
        map.put("pdrd4",prd);
        map.put("pdrd5",prd);
        }else if(type==1){
            prd.setId(1L);
            prd.setProduct("聚划算");
            prd.setPicture("https://endwith.oss-cn-shenzhen.aliyuncs.com/student152769177116310850.jpg");
            prd.setInterval(7);
            prd.setFounder("admin");
            prd.setCreateAt(123412412L);
            prd.setUpdateAt(123412412L);
            prd.setModifier("admin");
            prd.setStatus(1);
            String pdrd="pdrd"+prd.getId();
            map.put(pdrd,prd);
            map.put("pdrd2",prd);
            map.put("pdrd3",prd);
            map.put("pdrd4",prd);
            map.put("pdrd5",prd);
        }
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;

    }
    /**
     *71运营管理中的banner图模糊查询
     *78鼎力推荐查询
     */
    @RequestMapping(value ="/admin/a/u/product-recommends", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getProductRecommends(Long page,Long size,int type,Long id,String title,String product,String founder,String modifier){
        ProductRecommend prd=new ProductRecommend();
        Map<String,Object> map=new HashMap<>();
        if(type==0) {
            prd.setId(1L);
            prd.setTitle("超级划算");
            prd.setPicture("https://endwith.oss-cn-shenzhen.aliyuncs.com/student152769177116310850.jpg");
            prd.setInterval(7);
            prd.setFounder("admin");
            prd.setCreateAt(123412412L);
            prd.setUpdateAt(123412412L);
            prd.setModifier("admin");
            prd.setBannerStatus(1);
            String pdrd = "pdrd" + prd.getId();
            map.put(pdrd, prd);
            map.put("pdrd2", prd);
            map.put("pdrd3", prd);
            map.put("pdrd4", prd);
            map.put("pdrd5", prd);
        }else if(type==1){
            prd.setId(1L);
            prd.setProduct("聚划算");
            prd.setPicture("https://endwith.oss-cn-shenzhen.aliyuncs.com/student152769177116310850.jpg");
            prd.setFounder("admin");
            prd.setCreateAt(123412412L);
            prd.setUpdateAt(123412412L);
            prd.setModifier("admin");
            prd.setStatus(1);
            String pdrd = "pdrd" + prd.getId();
            map.put(pdrd, prd);
            map.put("pdrd2", prd);
            map.put("pdrd3", prd);
            map.put("pdrd4", prd);
            map.put("pdrd5", prd);
        }
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *72banner图新增
     *79鼎力推荐新增
     */
    @RequestMapping(value ="/admin/a/u/product-recommend", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addProductRecommend(String title,String product,int interval, MultipartFile picture,int type){
        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }
    /**
     *73banner图编辑—获取
     *80鼎力推荐编辑-获取
     */
    @RequestMapping(value ="/admin/a/u/product-recommend/{id}", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getProductRecommendById(Long id){
        ProductRecommend prd=new ProductRecommend();
        prd.setId(1L);
        prd.setTitle("超级划算");
        prd.setProduct("聚划算");
        prd.setPicture("https://endwith.oss-cn-shenzhen.aliyuncs.com/student152769177116310850.jpg");
        prd.setInterval(7);
        prd.setUrl("http://");
        jsonObject.put("code",1000);
        jsonObject.put("data",prd);
        return jsonObject;
    }
    /**
     *74banner图编辑—保存
     *75banner图上下架
     *81鼎力推荐编辑-更改保存
     *82鼎力推荐上下架
     */
    @RequestMapping(value ="/admin/a/u/product-recommend/{id}", produces="application/json",method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject updateProductRecommend(String title,String product,Long id,int interval,MultipartFile picture,String url,int bannerStatus,int status){
        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }
    /**
     *76banner图删除
     *83鼎力推荐删除
     */
    @RequestMapping(value ="/admin/a/u/product-recommend/{id}", produces="application/json",method = RequestMethod.DELETE)
    @ResponseBody
    public JSONObject deleteProductRecommend(Long id){
        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }

}
