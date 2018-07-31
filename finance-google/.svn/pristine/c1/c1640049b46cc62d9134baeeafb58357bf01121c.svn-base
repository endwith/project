package com.ptteng.fuiou.api;


import com.fuiou.mpay.encrypt.DESCoderFUIOU;
import com.fuiou.mpay.encrypt.RSAUtils;
import com.fuiou.util.MD5;
import com.ptteng.Constants;
import com.ptteng.fuiou.api.data.OrderReqData;
import com.ptteng.fuiou.api.data.OrderRespData;
import com.ptteng.fuiou.utils.ConfigReader;
import com.ptteng.fuiou.utils.DateTimeUtil;
import com.ptteng.fuiou.utils.HttpPostUtil;
import com.ptteng.fuiou.utils.XmlBeanUtils;

import javax.servlet.RequestDispatcher;
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
public class OrderServlet extends HttpServlet
{
	private static final long	serialVersionUID	= 1419376384387536955L;

	private static final String	BACK_URL			= ConfigReader.getString("api.order_back_url");
	private static final String	ORDER_URL			= ConfigReader.getString("api.order_url");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.getOutputStream().write("不支持GET方式提交".getBytes("utf8"));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
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
			String indate = req.getParameter("indate");
			String cvn2 = "";
			if(cvn != null && !"".equals(cvn.trim())&& indate!=null && !"".equals(indate.trim())){
				cvn2 = RSAUtils.encryptByPublicKey(cvn+";"+indate, Constants.FUIOU_PUB_KEY);
			}
			String version = "2.3";
			String type = "03";
			String rem1 = "";
			String rem2 = "";
			String rem3 = "";
			String orderId = "FY" + DateTimeUtil.getCurrentDate("yyyyMMddHHmmssSSS");
			String signPlain = type + "|" + version + "|" + Constants.API_MCHNT_CD + "|" + orderId + "|" + userId + "|"
					+ amt + "|" + bankCard + "|" + BACK_URL + "|" + name + "|" + idNo + "|" + idType + "|" + mobile
					+ "|" + userIp + "|" + Constants.API_MCHNT_KEY;
			String sign = MD5.MD5Encode(signPlain);
			System.out.println("[签名明文:]" + signPlain);
			OrderReqData reqData = new OrderReqData();
			reqData.setVersion(version);
			reqData.setMchntcd(Constants.API_MCHNT_CD);
			reqData.setType(type);
			reqData.setMchntorderid(orderId);
			reqData.setUserid(userId);
			reqData.setAmt(amt);
			reqData.setBankcard(bankCard);
			reqData.setName(name);
			reqData.setBackurl(BACK_URL);
			reqData.setIdtype(idType);
			reqData.setIdno(idNo);
			reqData.setMobile(mobile);
			reqData.setCvn(cvn2);
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
			System.out.println("返回数据：" + respStr);
			respStr = DESCoderFUIOU.desDecrypt(respStr, DESCoderFUIOU.getKeyLength8(Constants.API_MCHNT_KEY));
			System.out.println("返回数据：" + respStr);
			OrderRespData orderRespData = XmlBeanUtils.convertXml2Bean(respStr, OrderRespData.class);
			//成功就跳到下单页面
			resp.setContentType("text/html");
			if (Constants.RESP_CODE_SUCCESS.equals(orderRespData.getResponsecode()))
			{
				req.setAttribute("VERSION", version);
				req.setAttribute("USERIP", userIp);
				req.setAttribute("MCHNTORDERID", orderId);
				req.setAttribute("USERID", userId);
				req.setAttribute("ORDERID", orderRespData.getOrderid());
				req.setAttribute("BANKCARD", bankCard);
				req.setAttribute("IDNO", idNo);
				req.setAttribute("IDTYPE", idType);
				req.setAttribute("MOBILE", mobile);
				req.setAttribute("REM1", rem1);
				req.setAttribute("REM2", rem2);
				req.setAttribute("REM3", rem3);
				req.setAttribute("SIGNPAY", orderRespData.getSignpay());
				req.setAttribute("AMT", amt);
				req.setAttribute("NAME", name);
				req.setAttribute("TYPE", type);
				req.setAttribute("CVN", cvn);
				req.setAttribute("INDATE", indate);
				RequestDispatcher requsetdispatcher = req
						.getRequestDispatcher("pay.jsp");
				requsetdispatcher.forward(req, resp);
			}
			else
			{
				resp.getOutputStream().write(("下单失败："+orderRespData.getResponsemsg()).getBytes("utf8"));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			resp.getOutputStream().write("系统异常".getBytes("utf8"));
			return;
		}
	}
}
