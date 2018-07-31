package com.ptteng.fuiou.api;


import com.fuiou.mpay.encrypt.RSAUtils;
import com.fuiou.util.MD5;
import com.ptteng.fuiou.api.data.CardProtocolXmlBeanReq;
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

public class ProtocolUnbindServlet extends HttpServlet implements APIBaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String version = "3.0";
			String type = "03";
			String userid = req.getParameter("userid");
			String protocolno = req.getParameter("protocolno");
			
			CardProtocolXmlBeanReq beanReq = new CardProtocolXmlBeanReq();
			beanReq.setVersion(version);
			beanReq.setMchntCd(mchntcd);
			beanReq.setUserId(userid);
			beanReq.setProtocolNo(protocolno);
			beanReq.setSign(getSign(beanReq.proUnBindSignStr(key), "MD5", privatekey));
			
			//String url = "http://192.168.8.29:29024/mobile_pay/cardPro/unbindAction.pay";
			String url = ConfigReader.getString("api.protocolunbind_3.0_url");
			Map<String,String> map = new HashMap<String, String>();
			//map.put("MCHNTCD",mchntcd);
			map.put("FMS", XMapUtil.toXML(beanReq, charset));
			String result = new HttpPoster(url).postStr(map);
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
