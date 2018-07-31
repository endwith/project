package com.ptteng.fuiou.api;


import com.fuiou.mpay.encrypt.DESCoderFUIOU;
import com.fuiou.util.MD5;
import com.ptteng.Constants;
import com.ptteng.fuiou.api.data.OrderReqData;
import com.ptteng.fuiou.api.data.OrderRespData;
import com.ptteng.fuiou.data.JsonResultData;
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
 * 
 * @author xiaohao@fuiou.com
 *
 */
public class SmResendServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 5472284402208303387L;
	
	private static final String	BACK_URL			= ConfigReader.getString("api.smReSend_back_url");
	
	private static final String	ORDER_URL			= ConfigReader.getString("api.smReSend_url");


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.getOutputStream().write("不支持GET方式提交".getBytes("utf8"));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		JsonResultData retData = new JsonResultData();
		resp.setContentType("text/json");
		try
		{
			String userId = req.getParameter("userId");
			String amt = req.getParameter("amt");
			String bankCard = req.getParameter("bankCard");
			String name = req.getParameter("name");
			String idType = req.getParameter("idType");
			String idNo = req.getParameter("idNo");
			String mobile = req.getParameter("mobile");
			String userIp = "192.168.199.58";
			String cvn = req.getParameter("cvn");
			String version = "2.3";
			String type = "03";
			String rem1 = "备注1";
			String rem2 = "备注2";
			String rem3 = "备注3";
			String orderid = req.getParameter("orderid");
			String signPlain = type + "|" + version + "|" + Constants.API_MCHNT_CD + "|" + orderid + "|" + userId + "|"
					+ amt + "|" + bankCard + "|" + BACK_URL + "|" + name + "|" + idNo + "|" + idType + "|" + mobile
					+ "|" + userIp + "|" + Constants.API_MCHNT_KEY;
			String sign = MD5.MD5Encode(signPlain);
			System.out.println("[签名明文:]" + signPlain);
			OrderReqData reqData = new OrderReqData();
			reqData.setVersion(version);
			reqData.setMchntcd(Constants.API_MCHNT_CD);
			reqData.setType(type);
			reqData.setOrderId(orderid);
			reqData.setUserid(userId);
			reqData.setAmt(amt);
			reqData.setBankcard(bankCard);
			reqData.setName(name);
			reqData.setBackurl(BACK_URL);
			reqData.setIdtype(idType);
			reqData.setIdno(idNo);
			reqData.setMobile(mobile);
			reqData.setCvn(cvn);
			reqData.setRem1(rem1);
			reqData.setRem2(rem2);
			reqData.setRem3(rem3);
			reqData.setSigntp("md5");
			reqData.setUserip(userIp);
			reqData.setSign(sign);
			String orderPlain = XmlBeanUtils.convertBean2Xml(reqData, "UTF-8",true);
			System.out.println("[订单信息:]" + orderPlain);
			Map <String, String> param = new HashMap <String, String>();
			param.put("MCHNTCD", Constants.API_MCHNT_CD);
			param.put("APIFMS",
					DESCoderFUIOU.desEncrypt(orderPlain, DESCoderFUIOU.getKeyLength8(Constants.API_MCHNT_KEY)));
			System.out.println("[请求信息:]" + param);
			String respStr = HttpPostUtil.postForward(ORDER_URL, param);
			respStr = DESCoderFUIOU.desDecrypt(respStr, DESCoderFUIOU.getKeyLength8(Constants.API_MCHNT_KEY));
			System.out.println("返回数据：" + respStr);
			OrderRespData orderRespData = XmlBeanUtils.convertXml2Bean(respStr, OrderRespData.class);
			//成功就跳到下单页面
			if (Constants.RESP_CODE_SUCCESS.equals(orderRespData.getResponsecode()))
			{
				Map <String,String> retParam = new HashMap<String,String>();
				retParam.put("VERSION", version);
				retParam.put("USERIP", userIp);
				retParam.put("ORDERID", orderid);
				retParam.put("USERID", userId);
				retParam.put("ORDERID", orderRespData.getOrderid());
				retParam.put("BANKCARD", bankCard);
				retParam.put("MOBILE", mobile);
				retParam.put("REM1", rem1);
				retParam.put("REM2", rem2);
				retParam.put("REM3", rem3);
				retParam.put("SIGNPAY", orderRespData.getSignpay());
				retParam.put("AMT", amt);
				retParam.put("NAME", name);
				retParam.put("TYPE", type);
				retData.setRetCode("0000");
				retData.setMessage("短信发送成功");
				retData.setRetObj(retParam);
			}
			else
			{
				retData.setRetCode("5001");
				retData.setMessage(orderRespData.getResponsemsg());
			}
		}
		catch (Exception e)
		{
			retData.setRetCode("5001");
			retData.setMessage("系统异常！");
		}
		resp.getOutputStream().write(retData.toString().getBytes("UTF-8"));
	}
}
