package com.ptteng.userHandler;

import com.ptteng.service.BackstageAccountService;
import com.ptteng.service.UserService;
import com.ptteng.util.OOSUtil;
import com.ptteng.util.Token;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserRoleHandler extends UserHandler {
    @Resource
    private BackstageAccountService backstageAccountService;
    @Resource
    private UserService userService;
    @Resource
    private Token token;
    private static final Logger logger = LoggerFactory.getLogger(UserRoleHandler.class);
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String key = null;
        String userId = null;
        Cookie[] cookie = request.getCookies();
        logger.info("***"+cookie);
        if (null != cookie) {
            for (Cookie c : cookie) {  // 遍历Cookie
                if ("userTime".equals(c.getName()))
                    key = c.getValue();
                if ("userId".equals(c.getName()))
                    userId = c.getValue();
            }}else {
//            feign不能重定向，直接返回false
            response.sendRedirect(request.getContextPath() +"/a/outerRecord");
            return false;
        }
        if(null==userId||("".equals(userId))){
            logger.info("用户Id:::*************" + userId);
            response.sendRedirect(request.getContextPath() +"/a/outerRecord");
            return false;
        }
        logger.info("用户Id:::" + userId);
        logger.info("key：" + key);
            Long id = Long.valueOf(token.SolveToken(userId));
        logger.info("Id:::" + id);
            if (null != userService.selectByPrimaryKey(id) && null != key) {
                Long keytime = Long.valueOf(token.SolveToken(key));
                logger.info("keytime:" + keytime);
                Long thistime = System.currentTimeMillis();
                Long gettime = thistime - keytime;
                logger.info("gettime:" + gettime);
                logger.info("keytime:" + keytime);
                logger.info("cookiekey值：" + key);
                if (gettime < 6*60*60 * 1000) {//加密规则正确，说明已经登录
//                if (gettime < 60 * 1000) {//加密规则正确，说明已经登录
                    System.out.println(key);
                    return true;
                } else {
                    response.sendRedirect(request.getContextPath() +"/a/outerRecord");
                    logger.info("cookie失效");
                    return false;
                }
            }
            response.sendRedirect(request.getContextPath() +"/a/outerRecord");
            return false;

}
}