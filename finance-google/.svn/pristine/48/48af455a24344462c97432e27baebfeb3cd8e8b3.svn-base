package com.ptteng.service;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.service.impl.ProductRecommendServiceHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;


/**
 *提供一个java接口连接服务， 接口中的方法对应url接口就能直接访问了，不需要ribbon实例服务提供者
 */
//@FeignClient声明feign，添加fallback熔断器实现类
@FeignClient(value = "finance-admin",fallback=ProductRecommendServiceHystric.class)
public interface ProductRecommendService {
    /**
     *70运营管理中的banner图入口
     */
    @RequestMapping(value ="/a/u/product-recommend", produces="application/json",method = RequestMethod.GET)
     JSONObject getAllBanner(@RequestParam(value = "id",required = false)Long page,@RequestParam(value = "size",required = false)Long size,@RequestParam(value = "type",required = false)Integer type);
    /**
     *71运营管理中的banner图模糊查询
     * 78鼎力推荐查询模糊查询
     */
    @RequestMapping(value ="/a/u/product-recommends", produces="application/json",method = RequestMethod.GET)
     JSONObject getBanners(@RequestParam(value = "page",required = false)Long page,@RequestParam(value = "size",required = false)Long size,@RequestParam(value = "type",required = false)Integer type,@RequestParam(value = "id",required = false)Long id,
                           @RequestParam(value = "title",required = false)String title,@RequestParam(value = "product",required = false)String product,
                           @RequestParam(value = "founder",required = false)String founder,@RequestParam(value = "modifier",required = false)String modifier);

    /**
     *上传图片
     */
    @RequestMapping(value ="/a/u/picture", produces="application/json",method = RequestMethod.POST)
    JSONObject loadPicture(@RequestParam(value = "picture",required = false)MultipartFile picture);

    /**
     *72banner图新增
     * 79鼎力推荐新增
     */
    @RequestMapping(value ="/a/u/product-recommend", produces="application/json",method = RequestMethod.POST)
     JSONObject addBanner(@RequestParam(value = "title",required = false)String title, @RequestParam(value = "product",required = false)String product, @RequestParam(value = "interval",required = false)Integer interval,
                          @RequestParam(value = "pictureFile",required = false) String pictureFile,
                          @RequestParam(value = "type",required = false)Integer type
            , @RequestParam(value = "url",required = false)String url,@RequestParam(value = "request",required = false)HttpServletRequest request  );
    /**
     *73banner图编辑—获取
     * 80鼎力推荐编辑-获取
     */
    @RequestMapping(value ="/a/u/product-recommend/{id}", produces="application/json",method = RequestMethod.GET)
     JSONObject getBannerById(@RequestParam(value = "id",required = false)Long id);
    /**
     *74banner图编辑—保存
     *75banner图上下架
     *81鼎力推荐编辑-更改保存
     *82鼎力推荐上下架
     */
    @RequestMapping(value ="/a/u/product-recommend/{id}", produces="application/json",method = RequestMethod.PUT)
     JSONObject updateBanner(@RequestParam(value = "title",required = false)String title,@RequestParam(value = "product",required = false)String product,
                             @RequestParam(value = "id",required = false)Long id,@RequestParam(value = "interval",required = false)Integer interval,
                             @RequestParam(value = "pictureFile",required = false)String pictureFile,@RequestParam(value = "url",required = false)String url,
                             @RequestParam(value = "bannerStatus",required = false)Integer bannerStatus,@RequestParam(value = "status",required = false)Integer status
            ,@RequestParam(value = "request",required = false)HttpServletRequest request);
    /**
     *76banner图删除
     *83鼎力推荐删除
     */
    @RequestMapping(value ="/a/u/product-recommend/{id}", produces="application/json",method = RequestMethod.DELETE)
     JSONObject deleteBanner(@RequestParam(value = "id",required = false)Long id);

}
