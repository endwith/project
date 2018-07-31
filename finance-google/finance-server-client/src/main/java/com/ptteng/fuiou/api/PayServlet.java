package com.ptteng.fuiou.api;


import com.fuiou.mpay.encrypt.DESCoderFUIOU;
import com.fuiou.util.MD5;
import com.ptteng.Constants;
import com.ptteng.fuiou.api.data.PayReqData;
import com.ptteng.fuiou.api.data.PayRespData;
import com.ptteng.fuiou.utils.ConfigReader;
import com.ptteng.fuiou.utils.HttpPostUtil;
import com.ptteng.fuiou.utils.XmlBeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * API下单(2016-09-30)
 * 
 * @author xiaohao@fuiou.com
 *
 */
public class PayServlet extends HttpServlet
{
	private static final long	serialVersionUID	= 1419376384387536955L;

	private static final String	PAY_URL				= ConfigReader.getString("api.pay_url");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.getOutputStream().write("不支持GET方式提交".getBytes("utf8"));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.setContentType("text/xml");
		try
		{
			String userId = req.getParameter("userId");
			String bankCard = req.getParameter("bankCard");
			String mobile = req.getParameter("mobile");
			String userIp = req.getParameter("userip");
			String version = "2.3";
			String type = req.getParameter("type");
			String rem1 = req.getParameter("rem1");
			String rem2 = req.getParameter("rem2");
			String rem3 = req.getParameter("rem3");
			String mchntorderid = req.getParameter("mchntorderid");
			String orderid = req.getParameter("orderid");
			String vercd = req.getParameter("vercd");
			String signpay = req.getParameter("signpay");
			PayReqData payReqData = new PayReqData();
			payReqData.setBankcard(bankCard);
			payReqData.setMchntcd(Constants.API_MCHNT_CD);
			payReqData.setMchntorderid(mchntorderid);
			payReqData.setMobile(mobile);
			payReqData.setOrderid(orderid);
			payReqData.setRem1(rem1);
			payReqData.setRem2(rem2);
			payReqData.setRem3(rem3);

			payReqData.setSignpay(signpay);
			payReqData.setSigntp("md5");
			payReqData.setType(type);
			payReqData.setUserid(userId);
			payReqData.setUserip(userIp);
			payReqData.setVercd(vercd);
			payReqData.setVersion(version);
			String signPlain = payReqData.getType() + "|" + payReqData.getVersion() + "|" + Constants.API_MCHNT_CD + "|"
					+ payReqData.getOrderid() + "|" + payReqData.getMchntorderid() + "|" + payReqData.getUserid() + "|"
					+ payReqData.getBankcard() + "|" + payReqData.getVercd() + "|" + payReqData.getMobile() + "|"
					+ payReqData.getUserip() + "|" + Constants.API_MCHNT_KEY;
			String sign = MD5.MD5Encode(signPlain);
			payReqData.setSign(sign);
			System.out.println("[签名明文:]" + signPlain);
			String apiFms = XmlBeanUtils.convertBean2Xml(payReqData);
			System.out.println("[订单信息:]" + apiFms);
			Map <String, String> param = new HashMap <String, String>();
			param.put("MCHNTCD", Constants.API_MCHNT_CD);
			param.put("APIFMS", DESCoderFUIOU.desEncrypt(apiFms, DESCoderFUIOU.getKeyLength8(Constants.API_MCHNT_KEY)));
			System.out.println("[请求信息:]" + param);
			String respStr = HttpPostUtil.postForward(PAY_URL, param);
			respStr = DESCoderFUIOU.desDecrypt(respStr, DESCoderFUIOU.getKeyLength8(Constants.API_MCHNT_KEY));
			System.out.println("返回数据：" + respStr);
			PayRespData orderRespData = XmlBeanUtils.convertXml2Bean(respStr, PayRespData.class);
			//respStr ="<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"+ respStr;
			// 成功就跳到下单页面
			if (Constants.RESP_CODE_SUCCESS.equals(orderRespData.getResponsecode()))
			{
				resp.getOutputStream().write(respStr.getBytes("UTF-8"));
			}
			else
			{
				resp.getOutputStream().write(("支付失败：" + orderRespData.getResponsemsg()).getBytes("UTF-8"));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			resp.getOutputStream().write("系统异常".getBytes());
			return;
		}
	}
}
