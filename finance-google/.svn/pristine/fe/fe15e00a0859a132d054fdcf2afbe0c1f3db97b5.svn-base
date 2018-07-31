package com.ptteng.controller;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.model.InvestmentContract;
import com.ptteng.model.ObligatoryRight;
import com.ptteng.model.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RefreshScope
@Controller
public class ObligatoryRightController {
    @Autowired
    private JSONObject jsonObject;
    /**
     *54债权管理模块
     */
    @RequestMapping(value ="/admin/a/u/obligatory-right", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getAllOblRight(Long page,Long size){
        ObligatoryRight oblRt=new ObligatoryRight();
        oblRt.setId(1L);
        oblRt.setCompany("东北卷烟厂1");
        oblRt.setCorporate("炸弹人");
        oblRt.setMobile("15112344321");
        oblRt.setIdCard("51243124124124112");
        oblRt.setLoanSum(BigDecimal.valueOf(1000));
        oblRt.setLoanTerm(90L);
        oblRt.setLoanTime(13124214214L);
        oblRt.setRepayTime(12312321312L);
        oblRt.setMatchingAmount(BigDecimal.valueOf(30000));
        oblRt.setStatus(1);
        oblRt.setFounder("赵子龙");
        oblRt.setCreateAt(13124214124L);
        oblRt.setModifier("赵云");
        oblRt.setUpdateAt(13124214124L);
        ObligatoryRight oblRt1= oblRt;
        String oblNumber="oblNumber"+oblRt.getId();
        String investmentId="zjht1,zjht2,zjht3";
        String investmentAmount="8000,6000,5000";
        String financialPeriod="90,60,90";
        Map<String,Object> map=new HashMap<>();
        map.put(oblNumber,oblRt);
        map.put("oblNumber2",oblRt1);
        map.put("investmentId",investmentId);
        map.put("investmentAmount",investmentAmount);
            map.put("financialPeriod",financialPeriod);
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
}
    /**
     *55模糊查询债权管理
     */
    @RequestMapping(value ="/admin/a/u/obligatory-rights", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getOblRights(Long page,Long size,Long id,String company,String corporate,String status){
        ObligatoryRight oblRt=new ObligatoryRight();
        oblRt.setId(1L);
        oblRt.setCompany("东北卷烟厂2");
        oblRt.setCorporate("炸弹人");
        oblRt.setMobile("15112344321");
        oblRt.setIdCard("51243124124124112");
        oblRt.setLoanSum(BigDecimal.valueOf(1000));
        oblRt.setLoanTerm(90L);
        oblRt.setLoanTime(13124214214L);
        oblRt.setRepayTime(12312321312L);
        oblRt.setMatchingAmount(BigDecimal.valueOf(30000));
        oblRt.setStatus(1);
        oblRt.setFounder("赵子龙");
        oblRt.setCreateAt(13124214124L);
        oblRt.setModifier("赵云");
        oblRt.setUpdateAt(13124214124L);
        ObligatoryRight oblRt1= oblRt;
        String oblNumber="oblNumber"+oblRt.getId();
        String investmentId="oblRight1,oblRight2,oblRight3";
        String investmentAmount="8000,6000,5000";
        String financialPeriod="90,60,90";
        Map<String,Object> map=new HashMap<>();
        map.put(oblNumber,oblRt);
        map.put("oblNumber2",oblRt1);
        map.put("investmentId",investmentId);
        map.put("investmentAmount",investmentAmount);
        map.put("financialPeriod",financialPeriod);
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *56添加债权
     */
    @RequestMapping(value ="/admin/a/u/obligatory-right", produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addOblRight(String company,String corporate,String mobile,String idCard,Long loanTime,BigDecimal loanSum,Long loanTerm){
        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }
    /**
     *57编辑获取债权
     */
    @RequestMapping(value ="/admin/a/u/obligatory-right/{id}", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getOblRight(Long id){
        ObligatoryRight oblRt=new ObligatoryRight();
        oblRt.setId(1L);
        oblRt.setCompany("东北卷烟厂3");
        oblRt.setCorporate("炸弹人");
        oblRt.setMobile("15112344321");
        oblRt.setIdCard("51243124124124112");
        oblRt.setLoanSum(BigDecimal.valueOf(1000));
        oblRt.setLoanTerm(90L);
        oblRt.setLoanTime(13124214214L);
        oblRt.setRepayTime(12312321312L);
        String oblNumber="oblNumber"+oblRt.getId();
        Map<String,Object> map=new HashMap<>();
        map.put(oblNumber,oblRt);
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *58编辑-保存债权
     */
    @RequestMapping(value ="/admin/a/u/obligatory-right", produces="application/json",method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject updateOblRight(Long id,String company,String corporate,String mobile,String idCard,Long loanTime,BigDecimal loanSum,Long loanTerm){
        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }
    /**
     *59删除债权
     */
    @RequestMapping(value ="/admin/a/u/obligatory-right/{id}", produces="application/json",method = RequestMethod.DELETE)
    @ResponseBody
    public JSONObject deleteOblRight(Long id){
        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }
    /**
     *60债权配置管理
     */
    @RequestMapping(value ="/admin/a/u/unmatched-obligatory-right", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getUnmatchedOblRight(Long obligatoryId){
        Trade trade=new Trade();
        trade.setId(1L);
        trade.setTradeId("oblRight1");
        trade.setToBeMatched(BigDecimal.valueOf(5000));
        Map<String,Object> map=new HashMap<>();
        map.put("oblRight1",trade);
        map.put("oblRight2",trade);
        map.put("oblRight3",trade);
        map.put("obligatoryId",1L);
        map.put("oblNumber","oblNumber1");
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *61债权配置管理-所有投资
     */
    @RequestMapping(value ="/admin/a/u/matched-contract", produces="application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getMatchedContract(Long page,Long size,Long obligatoryId){
        Trade trade=new Trade();
        trade.setId(1L);
        trade.setTradeId("oblRight1");
        trade.setToBeMatched(BigDecimal.valueOf(5000));
        Map<String,Object> map=new HashMap<>();
        map.put("oblRight1",trade);
        map.put("oblRight2",trade);
        map.put("oblRight3",trade);
        jsonObject.put("code",1000);
        jsonObject.put("data",map);
        return jsonObject;
    }
    /**
     *62债权配置管理-匹配
     */
    @RequestMapping(value ="/admin/a/u/matching-obligatory-right", produces="application/json",method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject matchingOblRight(BigDecimal matchingAmount,Long obligatoryId,HttpServletRequest request){
        String S=request.getParameter("JSON");
        System.out.println("*********"+S);
        Map<String,Object> map=new HashMap<>();
        map.put("数据",S);
        jsonObject.put("code",1000);
        jsonObject.put("data","");
        return jsonObject;
    }

}
