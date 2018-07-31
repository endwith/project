package com.ptteng.fuiou.com.fuiou.h5;


import com.fuiou.mpay.encrypt.DESCoderFUIOU;
import com.fuiou.util.MD5;
import com.ptteng.Constants;
import com.ptteng.fuiou.h5.bean.H5BankPay;
import com.ptteng.fuiou.h5.bean.H5CommonPayRequest;
import com.ptteng.fuiou.h5.bean.H5WechatPay;
import com.ptteng.fuiou.utils.ConfigReader;
import com.ptteng.fuiou.utils.HttpFormUtil;
import com.ptteng.fuiou.utils.XmlBeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BankAndWechatPayServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -2760880169804837646L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		try
		{
			String version = req.getParameter("version");
			String goodsDes = req.getParameter("goods_des");
			String mchntOrderNo = req.getParameter("mchnt_order_no");
			String mchntCd = req.getParameter("mchnt_cd");
			String mchntKey = req.getParameter("mchnt_key");
			String goodsDetail = req.getParameter("goods_detail");
			String amt = req.getParameter("order_amt");
			String bankCard = req.getParameter("bankCard");
			String productId = req.getParameter("productId");
			String subAppid = req.getParameter("appid");
			String subOpenid = req.getParameter("openid");
			String IdNo = req.getParameter("IdNo");
			String idType = req.getParameter("idType");
			String name = req.getParameter("name");
			String type =  req.getParameter("type");
			H5CommonPayRequest data = new H5CommonPayRequest();
			
			H5WechatPay wechatPay = new H5WechatPay();
			wechatPay.setAddnInf("");
			wechatPay.setGoodsDes(goodsDes);
			wechatPay.setGoodsDetail(goodsDetail);
			wechatPay.setGoodsTag("");
			wechatPay.setNotifyUrl(ConfigReader.getString("wechat.back_url"));
			wechatPay.setHomeurl(ConfigReader.getString("wechat.home_url"));
			wechatPay.setProductId(productId);
			wechatPay.setAppid(subAppid);
			wechatPay.setOpenid(subOpenid);
			wechatPay.setTermIp("127.0.0.1");
			wechatPay.setVersion("1.0");
			
			H5BankPay bankPay = new H5BankPay();
			bankPay.setBankCard(bankCard);
			bankPay.setBackUrl(ConfigReader.getString("h5.back_url"));
			bankPay.setHomeUrl(ConfigReader.getString("h5.home_url"));
			bankPay.setIdNo(IdNo);
			bankPay.setIdType(idType);
			bankPay.setName(name);
			bankPay.setRem1("Rem1");
			bankPay.setRem2("Rem2");
			bankPay.setRem3("Rem3");
			bankPay.setReUrl(ConfigReader.getString("h5.return_url"));
			bankPay.setType(type);
			bankPay.setUserId("999999");
			bankPay.setVersion(version);
			
			data.setWechatPay(wechatPay);
			data.setBankPay(bankPay);
			data.setMchntCd(mchntCd);
			data.setLogoTp("0");
			data.setMchntOrderId(mchntOrderNo);
			data.setSignTp("md5");
			data.setAmt(amt);
			Map<String, String> keyMap = new HashMap<String, String>();
			keyMap.put(Constants.H5_MCHNT_CD, Constants.H5_MCHNT_KEY);
			StringBuffer sb = new StringBuffer();
			sb.append(bankPay.getBackUrl()).append("|").append(bankPay.getBankCard()).append("|")
					.append(wechatPay.getGoodsDes()).append("|").append(bankPay.getIdNo()).append("|")
					.append(bankPay.getIdType()).append("|").append(bankPay.getName()).append("|")
					.append(wechatPay.getNotifyUrl()).append("|").append(wechatPay.getAppid()).append("|")
					.append(wechatPay.getOpenid()).append("|").append(wechatPay.getTermIp()).append("|").append(keyMap.get(mchntCd));
			System.out.println("银行卡微信支付请求签名明文："+sb.toString());
			String sign = MD5.MD5Encode(sb.toString());
			data.setSign(sign);
			
			Map <String, String> params = new HashMap <String, String>();
			params.put("MCHNTCD", mchntCd);
			String plainXml = XmlBeanUtils.convertBean2Xml(data, "UTF-8",true);
			System.out.println("请求明文："+plainXml);
			params.put("FM", DESCoderFUIOU.desEncrypt(plainXml,DESCoderFUIOU.getKeyLength8(mchntKey)));
			System.out.println("请求密文：" + params);
			String s = HttpFormUtil.formForward(Constants.PAY_COMMON_REQ_URL, params);
			resp.setContentType("text/html");
			resp.getOutputStream().write(s.getBytes("UTF-8"));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
