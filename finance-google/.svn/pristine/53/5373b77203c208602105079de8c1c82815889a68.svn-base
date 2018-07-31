package com.ptteng.controller;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.model.HistoryProduct;
import com.ptteng.model.InvestmentContract;
import com.ptteng.model.ObligatoryRight;
import com.ptteng.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RefreshScope
@Controller
public class ManageUserController {
    @Autowired
    private JSONObject jsonObject;
    /**
     *45后台登录
     */
    @RequestMapping(value ="/admin/a/u/usersmanage", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject usersManage(Long page,Long size){
        User user=new User();
        user.setId(1L);
        user.setPhone("15112344321");
        user.setTrueName("美杜莎");
        user.setIdCard("432142142351232");
        user.setTotalAssets(BigDecimal.valueOf(5000));
        user.setAccumulIncome(BigDecimal.valueOf(1000));
        user.setCreateAt(100300203L);
        user.setStatus(0);
        User user1=user;
        String accountId="user"+user.getId();
        String accountId1="user"+user1.getId();
        Map<String,User> map=new HashMap<>();
        map.put(accountId,user);
        map.put(accountId1,user1);
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *46模糊查询用户
     */
    @RequestMapping(value ="/admin/a/u/users", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getUsers(Long size,Long page,String trueName,String phone,Long id,Integer status){
        User user=new User();
        user.setId(1L);
        user.setPhone("15112344321");
        user.setTrueName("美杜莎");
        user.setIdCard("432142142351232");
        user.setTotalAssets(BigDecimal.valueOf(5000));
        user.setAccumulIncome(BigDecimal.valueOf(1000));
        user.setCreateAt(100300203L);
        user.setStatus(0);
        User user1=user;
        String accountId="user"+user.getId();
        Map<String,User> map=new HashMap<>();
        map.put(accountId,user);
        map.put("user2",user1);
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *47冻结账户（点冻结status-0，解冻status-1—默认1）
     *49更换手机
     *50解绑银行卡1-2
     */
    @RequestMapping(value ="/admin/a/u/user/{id}", produces="application/json",method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject freeze(int status,String phone,Long id,String bankCard1,String bankCard2){
        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }
    /**
     *48查看指定用户详情（原型图中银行卡1、2都要显示）
     */
    @RequestMapping(value ="/admin/a/u/user/{id}", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getUser(Long id){
        User user=new User();
        user.setId(1L);
        user.setPhone("15112344321");
        user.setBankCard1("4325235325235325");
        user.setBankCard2("4325235325235325");
        user.setTrueName("美杜莎");
        user.setIdCard("432142142351232");
        user.setTotalAssets(BigDecimal.valueOf(5000));
        user.setAccumulIncome(BigDecimal.valueOf(1000));
        user.setCreateAt(100300203L);
        user.setStatus(0);
        User user1=user;
        String accountId="user"+user.getId();
        Map<String,User> map=new HashMap<>();
        map.put(accountId,user);
        map.put("user2",user1);
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *51后台查看个人交易记录
     */
    @RequestMapping(value ="/admin/a/u/user/record/{id}", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getRecord(String phone,Long size,Long page){
        HistoryProduct hp=new HistoryProduct();
        hp.setId(1L);
        hp.setBuyer("骨弓");
        hp.setPhone("15112344321");
        hp.setProduct("聚月增");
        hp.setTransactionAmouont(BigDecimal.valueOf(1000));
        hp.setArriveTime(1324124124L);
        hp.setTransactionAction(1);
        hp.setBankCard("工商银行143325235235321");
        String tradeId="hp"+hp.getId();
        Map<String,HistoryProduct> map=new HashMap<>();
        map.put(tradeId,hp);
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *52后台查看个人投资合同
     */
    @RequestMapping(value ="/admin/a/u/user/contract", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject contractAll(String phone,Long size,Long page){
        InvestmentContract imtc=new InvestmentContract();
        imtc.setId(1L);
        imtc.setTrueName("虚空假面");
        imtc.setPhoneNumber("15112344321");
        imtc.setProduct("聚年增");
        imtc.setInvestAmount(BigDecimal.valueOf(1000));
        imtc.setIncome(BigDecimal.valueOf(7));
        imtc.setEffectiveTime(13213123412L);
        imtc.setInvalidTime(13213123412L);
        imtc.setStatus(1);
        InvestmentContract imtc1=imtc;
        String oblRightId="oblRight"+imtc.getId();
        Map<String,InvestmentContract> map=new HashMap<>();
        map.put(oblRightId,imtc);
        map.put("oblRight2",imtc1);
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *53后台查看个人投资合同详情
     */
    @RequestMapping(value ="/admin/a/u/user/contract/{id}", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject contract(Long id){
        InvestmentContract imtc=new InvestmentContract();
        imtc.setId(1L);
        imtc.setTrueName("虚空假面");
        imtc.setPhoneNumber("15112344321");
        imtc.setInvestAmount(BigDecimal.valueOf(1000));
        imtc.setEffectiveTime(13213123412L);
        String oblRightId="oblRight"+imtc.getId();
        String idCard="43254235235223324";
        Map<String,Object> map=new HashMap<>();
        map.put(oblRightId,imtc);
        map.put("idCard",idCard);
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }

}
