package com.ptteng.controller;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.model.HistoryProduct;
import com.ptteng.model.InvestmentContract;
import com.ptteng.model.User;
import com.ptteng.service.HistoryProductService;
import com.ptteng.service.InvestmentContractService;
import com.ptteng.service.UserService;
import com.ptteng.util.Token;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RefreshScope
@RestController
public class ManageUserController {
    org.slf4j.Logger logger = LoggerFactory.getLogger(ManageUserController.class);
    @Autowired
    private JSONObject jsonObject;
    @Resource
    private UserService userService;
    @Resource
    private HistoryProductService historyProductService;
    @Resource
    private InvestmentContractService investmentContractService;
    @Resource
    private Token token;
    /**
     *45后台登录
     */
    @RequestMapping(value ="/a/u/usersmanage", produces="application/json",method = RequestMethod.GET)
    public JSONObject usersManage(Long page,Long size){
        logger.info("/a/u/usersmanage---GET---the request parameters are page:{},size:{}",page,size);
        Map<String,Object> map=new HashMap<>();
        List<User> users;
        List<User> newUsers=new ArrayList<>();
        Long total;
        try{
        if(page!=null){
            users=userService.forSelect((page-1)*size, size);
        }else {
            users=userService.forSelect(0L,size);
        }
        for(User i:users){
            i.setPhone(token.SolveToken(i.getPhone()));
            i.setTrueName(token.SolveToken(i.getTrueName()));
            i.setBankCard1(token.SolveToken(i.getBankCard1()));
            i.setBankCard2(token.SolveToken(i.getBankCard2()));
            i.setIdCard(token.SolveToken(i.getIdCard()));
            newUsers.add(i);
        }
         total=userService.selectCount();
        }catch (Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        map.put("total",total);
        map.put("users",newUsers);
//        logger.info(users.toString());
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *46模糊查询用户
     */
    @RequestMapping(value ="/a/u/users", produces="application/json",method = RequestMethod.GET)
    public JSONObject getUsers(Long size,Long page,String trueName,String phone,Long id,Integer status){
        logger.info("/a/u/users---GET---the request parameters are size:{},page:{},trueName:{},phone:{},id:{},status:{}",size,page,trueName,phone,id,status);
        Map<String,Object> map=new HashMap<>();
        List<User> newUsers=new ArrayList<>();
        List<User> users;
        Long total;
        try{
        if(page!=null){
            users=userService.select((page-1)*size, size,id,trueName,phone,status);
        }else {
            users=userService.select(0L,size,id,trueName,phone,status);
        }
            for(User i:users){
                i.setPhone(token.SolveToken(i.getPhone()));
                i.setTrueName(token.SolveToken(i.getTrueName()));
                i.setBankCard1(token.SolveToken(i.getBankCard1()));
                i.setBankCard2(token.SolveToken(i.getBankCard2()));
                i.setIdCard(token.SolveToken(i.getIdCard()));
                newUsers.add(i);
            }
        total=userService.selectCountWithCondition();
        }catch (Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        map.put("total",total);
        map.put("users",newUsers);
//        logger.info(users.toString());
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *47冻结账户（点冻结status-1，解冻status-0—默认0）
     *49更换手机
     */
    @RequestMapping(value ="/a/u/user/{id}", produces="application/json",method = RequestMethod.PUT)
    public JSONObject freeze(Integer status,String phone,Long id){
        logger.info("/a/u/user/{id}---PUT---the request parameters are status:{},phone:{},id:{},bankCard1:{},bankCard2:{},",status,phone,id);
        User user=new User();
        if(null!=phone){
            user.setPhone(token.makeToken(phone));
        }
        if(null!=status){
        user.setStatus(status);}
        user.setId(id);
        int a;
        try{
         a=userService.updateByPrimaryKeySelective(user);
        }catch (Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        logger.info(""+a);
        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }
    /**
     *48查看指定用户详情（原型图中银行卡1、2都要显示）
     */
    @RequestMapping(value ="/a/u/user/{id}", produces="application/json",method = RequestMethod.GET)
    public JSONObject getUser( Long id){
        logger.info("/a/u/user/{id}---GET---the request parameters are id:{},",id);
        try{
            User user = userService.selectByPrimaryKey(id);
            user.setPhone(token.SolveToken(user.getPhone()));
            user.setTrueName(token.SolveToken(user.getTrueName()));
            user.setBankCard1(token.SolveToken(user.getBankCard1()));
            user.setBankCard2(token.SolveToken(user.getBankCard2()));
            user.setIdCard(token.SolveToken(user.getIdCard()));
            logger.info(user.toString());
            jsonObject.put("code",1000);
            jsonObject.put("data",user);
        }catch (Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }

        return jsonObject;
    }
    /**
     *51后台查看个人交易记录
     */
    @RequestMapping(value ="/a/u/user/record/{id}", produces="application/json",method = RequestMethod.GET)
    public JSONObject getRecord(Long userId,Long size,Long page){
        logger.info("/a/u/user/record/{id}---GET---the request parameters are userId:{},size:{},page:{}",userId,size,page);
        List<HistoryProduct> historyProducts;
        Long total;
        try{
            if(page!=null){
                historyProducts=historyProductService.selectAllByUserId(userId,(page-1)*size,size);
            }else {
                historyProducts=historyProductService.selectAllByUserId(userId,0L,size);
            }
            total=historyProductService.selectCount(userId);
        }catch (Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        Map<String,Object> map=new HashMap<>();
        map.put("total",total);
        map.put("backstageAccounts",historyProducts);
//        logger.info(historyProducts.toString());
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *52后台查看个人投资合同
     */
    @RequestMapping(value ="/a/u/user/contract", produces="application/json",method = RequestMethod.GET)
    public JSONObject contractAll(Long userId,Long size,Long page){
        logger.info("/a/u/user/contract---GET---the request parameters are id:{},size:{},page:{}",userId,size,page);
        List<InvestmentContract> investmentContracts;
        Long total;
        try{
        if(page!=null){
            investmentContracts=investmentContractService.selectByUserId(userId,(page-1)*size,size);
        }else {
            investmentContracts=investmentContractService.selectByUserId(userId,0L,size);
        }
        total=investmentContractService.selectCount(userId);
        }catch (Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        Map<String,Object> map=new HashMap<>();
        map.put("total",total);
        map.put("backstageAccounts",investmentContracts);
//        logger.info(investmentContracts.toString());
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *53后台查看个人投资合同详情
     */
    @RequestMapping(value ="/a/u/user/contract/{id}", produces="application/json",method = RequestMethod.GET)
    public JSONObject contract( Long id){
        logger.info("/a/u/user/contract/{id}---GET---the request parameters are id:{}",id);
        InvestmentContract investmentContract;
        User user;
        try{
         investmentContract=investmentContractService.selectByPrimaryKey(id);
         user=userService.selectByPrimaryKey(investmentContract.getUserId());
        }catch (Throwable e){
            logger.error("异常"+e);
            jsonObject.put("data","");
            jsonObject.put("code",2001);
            return jsonObject;
        }
        String idCard=token.SolveToken(user.getIdCard());
        Map<String,Object>map=new HashMap<>();
        map.put("idCard",idCard);
        map.put("investmentContract",investmentContract);
        logger.info(investmentContract.toString());
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }

}
