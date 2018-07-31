package com.ptteng.fuiou.v15.data;


import com.fuiou.util.MD5;
import com.ptteng.Constants;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="FM")
public class CreateOrderRespData
{
	private String rcd;
	
	private String rDesc;
	
	private String orderId;
	
	private String sign;

	public String getRcd()
	{
		return rcd;
	}
	@XmlElement(name="Rcd")
	public void setRcd(String rcd)
	{
		this.rcd = rcd;
	}

	public String getrDesc()
	{
		return rDesc;
	}
	@XmlElement(name="RDesc")
	public void setrDesc(String rDesc)
	{
		this.rDesc = rDesc;
	}

	public String getOrderId()
	{
		return orderId;
	}
	@XmlElement(name="OrderId")
	public void setOrderId(String orderId)
	{
		this.orderId = orderId;
	}

	public String getSign()
	{
		return sign;
	}
	@XmlElement(name="Sign")
	public void setSign(String sign)
	{
		this.sign = sign;
	}
	
	public void verifySign() throws Exception{
		StringBuffer s = new StringBuffer();
		s.append(this.rcd).append("|").append(this.orderId).append("|").append(Constants.H5_MCHNT_KEY);
		if(!MD5.MD5Encode(s.toString()).equals(this.sign))
		{
			throw new Exception("返回结果验签失败~");
		}
	}
}
