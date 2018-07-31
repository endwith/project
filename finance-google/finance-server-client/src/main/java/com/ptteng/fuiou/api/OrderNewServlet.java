package com.ptteng.fuiou.api;


import com.fuiou.mpay.encrypt.DESCoderFUIOU;
import com.fuiou.mpay.encrypt.RSAUtils;
import com.fuiou.util.MD5;
import com.ptteng.Constants;
import com.ptteng.fuiou.api.data.APIOrderXmlBeanReq;
import com.ptteng.fuiou.base.APIBaseServlet;
import com.ptteng.fuiou.utils.ConfigReader;
import com.ptteng.fuiou.utils.HttpPoster;
import com.ptteng.fuiou.utils.XMapUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OrderNewServlet extends HttpServlet implements APIBaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		resp.getOutputStream().write("不支持GET方式提交".getBytes("utf8"));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		
		try {
			String version = "3.0";
			String type = "03";
			String userid = req.getParameter("userid");
			String mchntorderid = req.getParameter("mchntorderid");
			String amt = req.getParameter("amt");
			String name = req.getParameter("name");
			String bankcard = req.getParameter("bankcard");
			String idtype = req.getParameter("idtype");
			String idno = req.getParameter("idno");
			String mobile = req.getParameter("mobile");
			String userip = "192.168.199.58";
			String cvn = req.getParameter("cvn");
			String indate = req.getParameter("indate");
			String orderalivetime = req.getParameter("orderalivetime");
			String cvn2 = "";
			String rem1 = "";
			String rem2 = "";
			String rem3 = "";
			if(cvn != null && !"".equals(cvn.trim())&& indate!=null && !"".equals(indate.trim())){
				try {
					cvn2 = RSAUtils.encryptByPublicKey(cvn+";"+indate, Constants.FUIOU_PUB_KEY);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			APIOrderXmlBeanReq BeanReq = new APIOrderXmlBeanReq();
			BeanReq.setVersion(version);
			BeanReq.setMchntcd(mchntcd);
			BeanReq.setType(type);
			BeanReq.setMchntorderid(mchntorderid);
			BeanReq.setUserid(userid);
			BeanReq.setAmt(amt);
			BeanReq.setBankcard(bankcard);
			BeanReq.setName(name);
			BeanReq.setIdtype(idtype);
			BeanReq.setIdno(idno);
			BeanReq.setMobile(mobile);
			BeanReq.setCvn(cvn2);
			String backUrl = backnotifyurl;
			BeanReq.setBackurl(backUrl);
			BeanReq.setRem1(rem1);
			BeanReq.setRem2(rem2);
			BeanReq.setRem3(rem3);
			BeanReq.setOrderalivetime(orderalivetime);
			BeanReq.setUserip(userip);
			BeanReq.setSigntp(signtp);
			BeanReq.setSign(getSign(BeanReq.md5StrIP(key), signtp, privatekey));
			
			Map<String,String> map = new HashMap<String, String>();
			//String url = "http://localhost:8881/mobile_pay/apipropay/payAction.pay";
			String url = ConfigReader.getString("api.order_3.0_url");
			String APIFMS =XMapUtil.toXML(BeanReq, charset);;
			APIFMS = DESCoderFUIOU.desEncrypt(APIFMS, DESCoderFUIOU.getKeyLength8(key));
			map.put("MCHNTCD",mchntcd);
			map.put("APIFMS", APIFMS);
			String result = new HttpPoster(url).postStr(map);
			result = DESCoderFUIOU.desDecrypt(result,DESCoderFUIOU.getKeyLength8(key));
			System.out.println("result:"+result);
			resp.getOutputStream().write(result.getBytes("utf8"));
		} catch (Exception e) {
			e.printStackTrace();
			resp.getOutputStream().write(e.getMessage().getBytes("utf8"));
		}
		
		
	}
	
	/**
	 * 获取签名
	 * @param signStr  签名串
	 * @param signtp   签名类型
	 * @param key      密钥
	 * @return
	 * @throws Exception
	 */
	public static String getSign(String signStr,String signtp,String key) throws  Exception{
		String sign = "";
		if ("md5".equalsIgnoreCase(signtp)) {
			sign = MD5.MD5Encode(signStr);
		} else {
			sign =	RSAUtils.sign(signStr.getBytes("utf-8"), key);
		}
		return sign;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(Constants.FUIOU_PUB_KEY);
		 String cvn = RSAUtils.encryptByPublicKey("470;2006",Constants.FUIOU_PUB_KEY);
		 System.out.println(cvn);
		 String privatekey ="MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAIEJy9QOTDc42xXHtHOH0gmgoq6vAGcpKMkQlstdBYMog9ky2bFwdrmM27o6ClDQFq05iXingGaAfcfNXBbKfqIM6wOXHBl7MXMCu0+O0QKrbjWd+agaFvP2UyvtPnrJjk+EBPCzfYObVlBtjwO+wW9N7aEqCYgZtlDTfSx5Gd9LAgMBAAECgYBHv4KuLiUCr4Jh4eDcPDD1WXQbXQMEWUZsReUSvm5KN0TYiAWzO61IDqI+Mfd6Z7m0J8HgbIJgfCFz7yO9KGqwMjlDdZKQrGLQuz9fREmZd6b5e2c/v2gWZvICoaP8tVlZ4KZ8/HnX8Ao8W2uqbQdBeA3q923xqStXTb2gfCSTgQJBANzL9/XCl1yqnRw1uTWs0oFcorDbJBVhBGfq7gTkTrCVtADx33SIEVGGFReUJqq42Dkw1On/nDNapyVyddZPV2kCQQCVnJ3upCglsjABf3/0QLLE2IVdZ9ZOutc6RRrBeF1Dz4d9c6OTNrjdYnA9Bq5emg0qjFSdYkNpnFkUIE60vX6TAkAzSytCq78wJu6y1AQ/5PNOXC/reC1szgoQ/jHnbwac3Vpg8c/gqY+kacrSnHdTJ/gLaT29UsV95Kx59ZpMfEgpAkA9HeGWXxDXdVcPBZqrmNJuf1Tbt1NgjgrmDtzDM/xFez2KDfdAaBZUuaXICDarBptiSjk2obGQLwJkql38j3xpAkANwko143RhaBadMF4+DR9rQvFUvUv7s1UAEvATmH002Q3NQxC7K+UposMHr35OcV8FJ+ehd9MbchNGkZ7MbPJZ";
		 String value = RSAUtils.decryptByPrivateKey(cvn, privatekey);
		 System.out.println(cvn+":"+value);
	}

}
