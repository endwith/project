package com.ptteng.accessFilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Configurable
public  class AccessFilter extends ZuulFilter {

    @Autowired
    HttpServletRequest httpServletRequest;
    @Autowired
    HttpServletResponse httpServletResponse;

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String sessionId = httpServletRequest.getSession().getId();
        ctx.addZuulRequestHeader("Cookie", "SESSION=" + sessionId);
        ctx.setSendZuulResponse(true);// 对该请求进行路由
        ctx.setResponseStatusCode(200); // 返回200正确响应
         return ctx;
         }

    @Override
    public String filterType() {
        return null;
    }

    @Override
    public int filterOrder() {
        return 0;
    }
}
