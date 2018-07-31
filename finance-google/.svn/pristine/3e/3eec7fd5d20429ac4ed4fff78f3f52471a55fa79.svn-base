package com.ptteng.util;


import com.ptteng.fuiou.check.data.CheckCardReqData;
import com.ptteng.fuiou.check.data.CheckIdReqData;
import com.ptteng.Constants;
import com.ptteng.fuiou.utils.HttpPostUtil;



import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FuiouUtil {
    //onm--姓名  oCerNo--身份证  ono--银行卡
    public String checkBankCard(String onm,String oCerNo,String ono) throws Exception {
        String type="2";
        String mno = "15083608423";
        String oCerTp = "0";
        String oSsn = "11032302065863805732";
        String ver ="1.30";
        CheckCardReqData data = new CheckCardReqData();
        data.setMno(mno);
        data.setOCerNo(oCerNo);
        data.setOCerTp(oCerTp);
        data.setOnm(onm);
        data.setOno(ono);
        data.setOSsn(oSsn);
        data.setVer(ver);
        String url = Constants.CHECK_CARD_1_REQ_URL;
        if("2".equals(type))
        {
            url = Constants.CHECK_CARD_2_REQ_URL;
        }
        else if("3".equals(type))
        {
            url = Constants.CHECK_CARD_3_REQ_URL;
        }
        Map<String,String> param = new HashMap<String, String>();
        param.put("FM", data.buildReqXml());
        System.out.println("请求消息："+param);
        String respStr = HttpPostUtil.postForward(url, param);
        System.out.println("返回报文:"+respStr);
        return respStr;
}
    public String checkIdCard(String name,String  idno) throws ServletException, IOException
    {
        String respStr=null;
        try
        {
            String version = "1.0";
            String typeId ="NN";
            String mchntOrderid = "0002900F0096235";
            CheckIdReqData data = new CheckIdReqData();
            data.setIdNo(idno);
            data.setMchntOrderid(mchntOrderid);
            data.setName(name);
            data.setTypeId(typeId);
            data.setVersion(version);
            data.setSign("5old71wihg2tqjug9kkpxnhx9hiujoqj");
            System.out.println(data.getSign());
            Map<String, String> params = new HashMap<String, String>();
            params.put("FM", data.buildXml());
            System.out.println("请求报文:"+params);
             respStr = HttpPostUtil.postForward(Constants.CHECK_ID_REQ_URL, params);
            System.out.println("返回报文:"+respStr);}

        catch (Exception e) {

        }
       return respStr;
    }
}
