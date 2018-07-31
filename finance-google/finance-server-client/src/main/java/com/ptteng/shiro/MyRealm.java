//package com.ptteng.shiro;
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.annotation.Resource;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Slf4j
//public class MyRealm extends AuthorizingRealm {
//    @Resource
//    private BackendAccountMapper backendAccountMapper;
//    @Resource
//    private BackendRoleMapper roleMapper;
//    @Resource
//    private ModuleListMapper moduleListMapper;
//    @Autowired
//    private RedisCacheUtil redisCacheUtil;
//
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        System.out.println("进入到授权");
//        String name = (String) principalCollection.getPrimaryPrincipal();
//        List<String> role = roleMapper.selectByUserName(name);
//
//        Set<String> roleNames = new HashSet<>();
//        Set<String> permissions = new HashSet<>();
//        for (String roleName : role) {
//            roleNames.add(roleName);//添加角色
//            log.info("添加角色\t" + roleName);
//        }
//        List<ModuleList> permission = moduleListMapper.selectByUserName(name);
//        log.info("..................doGetAuthorizationInfo...............start...................................");
//        for (ModuleList permissionName : permission) {
//            String perm = String.valueOf(permissionName.getId());
//            permissions.add(perm);  //添加权限
//            log.info("添加权限\t" + permissionName.getId() + "\t" + permissionName.getModuleName());
//        }
//        log.info(".....................doGetAuthorizationInfo............end...................................");
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.setStringPermissions(permissions);
//        info.setRoles(roleNames);
//        log.info("getRoles\t" + info.getRoles());
//        log.info("getStringPermissions\t" + info.getStringPermissions());
//        return info;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
//        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authcToken;
//        String userName = usernamePasswordToken.getUsername();
//        log.info("登录用户:\t" + userName);
//        BackendAccount backendAccount = backendAccountMapper.selectByName(userName);
//        redisCacheUtil.hset("polyfinance-txj-Realm", userName, backendAccount, 24 * 60 * 60);
//        String pwd= String.valueOf(usernamePasswordToken.getPassword());
//        String salt=backendAccount.getSalt();
//        log.info("pwd\t"+pwd);
//        log.info("salt\t"+salt);
//        String s = MD5Util.MD5(pwd + salt);
//        log.info("s\t"+s);
//        log.info("DB.password\t"+backendAccount.getPassword());
//        if (s.equals(backendAccount.getPassword())) {
//            //String pwd = String.valueOf(usernamePasswordToken.getPassword());
//            //if ((pwd).equals(backendAccount.getPassword())) {
//            log.info("密码验证通过");
//            return new SimpleAuthenticationInfo(userName, pwd, getName());
//        } else {
//            throw new AuthenticationException();
//        }
//    }
//}
