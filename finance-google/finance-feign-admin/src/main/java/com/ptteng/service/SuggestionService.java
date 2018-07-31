package com.ptteng.service;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.model.Suggestion;
import com.ptteng.service.impl.SuggestionServiceHystric;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 *提供一个java接口连接服务， 接口中的方法对应url接口就能直接访问了，不需要ribbon实例服务提供者
 */
//@FeignClient声明feign，添加fallback熔断器实现类
@FeignClient(value = "finance-admin",fallback=SuggestionServiceHystric.class)
public interface SuggestionService {
    /**
     *92意见反馈入口
     */
    @RequestMapping(value ="/a/u/all-suggestion", produces="application/json",method = RequestMethod.GET)
     JSONObject getAllSuggestion(@RequestParam(value = "page",required = false)Long page, @RequestParam(value = "size",required = false)Long size);
    /**
     *93意见反馈查询
     */
    @RequestMapping(value ="/a/u/suggestion", produces="application/json",method = RequestMethod.GET)
     JSONObject getSuggestions(@RequestParam(value = "page",required = false)Long page,@RequestParam(value = "size",required = false)Long size,@RequestParam(value = "id",required = false)Long id,@RequestParam(value = "suggeContent",required = false)String suggeContent,
                               @RequestParam(value = "adviser",required = false)String adviser, @RequestParam(value = "phone",required = false)String phone);
    /**
     *94意见反馈查看详情
     *95意见反馈回复-获取
     */
    @RequestMapping(value ="/a/u/suggestion/{id}", produces="application/json",method = RequestMethod.GET)
     JSONObject getSuggestionById(@RequestParam(value = "id",required = false)Long id);
    /**
     *96意见反馈回复
     */
    @RequestMapping(value ="/a/u/suggestion/{id}", produces="application/json",method = RequestMethod.PUT)
     JSONObject updateSuggestion(@RequestParam(value = "id",required = false)Long id, @RequestParam(value = "status",required = false)Integer status,
                                 @RequestParam(value = "replyContent",required = false)String replyContent
            ,@RequestParam(value = "request",required = false)HttpServletRequest request);
    /**
     *97意见反馈删除
     */
    @RequestMapping(value ="/a/u/suggestion/{id}", produces="application/json",method = RequestMethod.DELETE)
     JSONObject deleteSuggestion(@RequestParam(value = "id",required = false)Long id);

}
