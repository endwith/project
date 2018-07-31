package com.ptteng.fuiou.api;


import com.fuiou.mpay.encrypt.DESCoderFUIOU;
import com.fuiou.mpay.encrypt.RSAUtils;
import com.fuiou.util.MD5;
import com.ptteng.fuiou.api.data.APIProOrderXmlBeanReq;
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

public class SmResendProServlet extends HttpServlet implements APIBaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String version = "3.0";
			String type = "03";
			String userid = req.getParameter("userid");
			//String mchntorderid = req.getParameter("mchntorderid");
			String orderid = req.getParameter("orderid");
			String protocolno = req.getParameter("protocolno");
			String amt = req.getParameter("amt");
			String userip = "192.168.199.58";
		//	String cvn = req.getParameter("cvn");
			String rem1 = "";
			String rem2 = "";
			String rem3 = "";
			
			APIProOrderXmlBeanReq beanReq = new APIProOrderXmlBeanReq();
			beanReq.setVersion(version);
			beanReq.setMchntcd(mchntcd);
			beanReq.setType(type);
			beanReq.setOrderid(orderid);
			beanReq.setUserid(userid);
			beanReq.setAmt(amt);
			beanReq.setProtocolno(protocolno);
			beanReq.setBackurl(backnotifyurl);
			beanReq.setRem1(rem1);
			beanReq.setRem2(rem2);
			beanReq.setRem3(rem3);
			beanReq.setUserip(userip);
			beanReq.setSigntp(signtp);
			beanReq.setSign(getSign(beanReq.signStrMsgReSend(key), signtp, privatekey));
			
			Map<String,String> map = new HashMap<String, String>();
			//String url = "http://localhost:8881/mobile_pay/apipropay/messageAction.pay";
			String url = ConfigReader.getString("api.promsresend_3.0_url");
			String APIFMS =XMapUtil.toXML(beanReq, charset);;
			APIFMS = DESCoderFUIOU.desEncrypt(APIFMS, DESCoderFUIOU.getKeyLength8(key));
			map.put("MCHNTCD",mchntcd);
			map.put("APIFMS", APIFMS);
			String result = new HttpPoster(url).postStr(map);
			result = DESCoderFUIOU.desDecrypt(result,DESCoderFUIOU.getKeyLength8(key));
			System.out.println(result);
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
	

}
