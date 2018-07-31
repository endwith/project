//package com.ptteng.shiro;
////shiro配置类本项目没有结合shiro，此处留下配置类。
//import com.ptteng.dao.ModuleListMapper;
//import com.ptteng.model.ModuleList;
//import com.ptteng.shiro.realm.MyRealm;
//import com.ptteng.util.cacheutil.RedisCacheUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.codec.Base64;
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.subject.Subject;
//import org.apache.shiro.web.mgt.CookieRememberMeManager;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.apache.shiro.web.servlet.SimpleCookie;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import javax.annotation.Resource;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//* shiro启动类
//  @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public String login(@RequestBody Map map){
//        //添加用户认证信息
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
//                map.get("username").toString(),
//                map.get("password").toString());
//        //进行验证，这里可以捕获异常，然后返回对应信息
//        subject.login(usernamePasswordToken);
//        return "login";
//    }
//@Configuration
//@Slf4j
//public class ShiroConfig {
//    @Resource
//    private ModuleListMapper moduleListMapper;
//
//    @Bean
//    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
//        List<ModuleList> moduleLists = moduleListMapper.selectAll();
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        // 必须设置 SecurityManager
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        // setLoginUrl 如果不设置值，默认会自动寻找Web工程根目录下的"/loginIn.jsp"页面 或 "/login" 映射
//        //shiroFilterFactoryBean.setLoginUrl("/a/u/login");
//        // 设置无权限时跳转的 url;
//        shiroFilterFactoryBean.setUnauthorizedUrl("/errors");
//        //// 设置拦截器
//        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
//        //游客，允许游客访问的rul    不用登录，所有人可以访问
//        //filterChainDefinitionMap.put("/guest/**", "anon");
//        //后台登录访问的url            只要登录就可以访问
//        //filterChainDefinitionMap.put(" /admin/**", "authc");
//        //授权
//        System.out.println(".....................GetAuthorization............start...................................");
//        for (ModuleList moduleList : moduleLists) {
//            String perm = String.valueOf(moduleList.getId());
//            String url = moduleList.getUrl();
//            String suffix;
//            if (!url.equals("")) {
//                String[] split = url.split("\\.");
//                suffix = "/admin/a/u/" + split[1]+"/**";
//            }else {
//                suffix = "/admin/a/u/";
//            }
//            filterChainDefinitionMap.put(suffix, "perms[" + perm + "]");
//            System.out.println(filterChainDefinitionMap);
//        }
//        System.out.println(".....................GetAuthorization............end...................................");
//        //开放登陆接口
//        filterChainDefinitionMap.put("/login", "anon");
//        //其余接口一律拦截
//        //主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截
//        //filterChainDefinitionMap.put("/**", "authc");
//        // 设置拦截器
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//        //shiroFilterFactoryBean.setFilters(d);
//        System.out.println("Shiro拦截器工厂类注入成功");
//        return shiroFilterFactoryBean;
//    }
//
//    /**
//     * 注入 securityManager
//     */
//    @Bean
//    public SecurityManager securityManager() {
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        // 设置realm.
//        securityManager.setRealm(customRealm());
//        return securityManager;
//    }
//
//    /**
//     * 自定义身份认证 realm;
//     * <p>
//     * 必须写这个类，并加上 @Bean 注解，目的是注入 CustomRealm，
//     * 否则会影响 CustomRealm类 中其他类的依赖注入
//     */
//    @Bean
//    public MyRealm customRealm() {
//        return new MyRealm();
//    }
//
//    //开启shiro aop注解支持
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
//        System.out.println("开启了Shiro注解支持");
//        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
//        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
//        return authorizationAttributeSourceAdvisor;
//    }
//
//    /**
//     * cookie对象;
//     * rememberMeCookie()方法是设置Cookie的生成模版，比如cookie的name，cookie的有效时间等等。
//     *
//     * @return
//     */
//    @Bean
//    public SimpleCookie rememberMeCookie() {
//        //System.out.println("ShiroConfiguration.rememberMeCookie()");
//        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
//        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
//        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
//        simpleCookie.setMaxAge(259200);
//        return simpleCookie;
//    }
//
//    /**
//     * cookie管理对象;
//     * rememberMeManager()方法是生成rememberMe管理器，而且要将这个rememberMe管理器设置到securityManager中
//     *
//     * @return
//     */
//    @Bean
//    public CookieRememberMeManager rememberMeManager() {
//        //System.out.println("ShiroConfiguration.rememberMeManager()");
//        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
//        cookieRememberMeManager.setCookie(rememberMeCookie());
//        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
//        cookieRememberMeManager.setCipherKey(Base64.decode("2AvVhdsgUs0FSA3SDFAdag=="));
//        return cookieRememberMeManager;
//    }
//}
