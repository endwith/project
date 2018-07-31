package com.ptteng.fuiou.h5.bean;



import com.ptteng.fuiou.utils.XmlBeanUtils;

import javax.xml.bind.JAXBException;

public class H5BankCardPayRequest
{
	//富友分配给各合作商户的唯一识别码
	public String mchntCd = "";
	//交易类型
	public String type = "";
	//接口版本号，请填固定值2.0
	public String version = "";
	//是否隐藏支付页面富友的logo，1隐藏，0显示
	public String logoTp = "";
	//商户订单流水号商户确保唯一
	public String mchntOrderid = "";
	//客户在商户端的唯一编号，即客户ID
	public String userId = "";
	//客户支付订单的总金额，一笔订单一个，以分为单位。不可以为零，不能有小数点，必需符合金额标准
	public String amt = "";
	//支付的银行卡卡号
	public String bankCard = "";
	//商户接收支付结果的后台通知地址
	public String backUrl = "";
	//在富友的支付失败页面跳转到该地址进行重新支付
	public String reUrl = "";
	//在富友的支付成功页面跳转到该地址
	public String homeUrl = "";
	//用户姓名
	public String name = "";
	//0.身份证 1.护照 2.军官证 3.士兵证 4.回乡证 6.户口本 7.其它
	public String idType = "";
	//用户身份证号
	public String idNo = "";
	
	public String rem1 = "";
	
	public String rem2 = "";
	
	public String rem3 = "";
	//md5或rsa
	public String signtp = "";
	//TYPE+"|"+VERSION+"|"+MCHNTCD+"|"+MCHNTORDERID+"|"+USERID+"|"+AMT+"|"+BANKCARD+"|"+BACKURL+"|"+NAME+"|"+IDNO+"|"+IDTYPE+"|"+LOGOTP+"|"+" HOMERUL+"|"+" REURL+"|"+"商户32位密钥key"
	public String sign = "";
	
	public String getMchntCd()
	{
		return mchntCd;
	}
	public void setMchntCd(String mchntCd)
	{
		this.mchntCd = mchntCd;
	}
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public String getVersion()
	{
		return version;
	}
	public void setVersion(String version)
	{
		this.version = version;
	}
	public String getLogoTp()
	{
		return logoTp;
	}
	public void setLogoTp(String logoTp)
	{
		this.logoTp = logoTp;
	}
	public String getMchntOrderid()
	{
		return mchntOrderid;
	}
	public void setMchntOrderid(String mchntOrderid)
	{
		this.mchntOrderid = mchntOrderid;
	}
	public String getUserId()
	{
		return userId;
	}
	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	public String getAmt()
	{
		return amt;
	}
	public void setAmt(String amt)
	{
		this.amt = amt;
	}
	public String getBankCard()
	{
		return bankCard;
	}
	public void setBankCard(String bankCard)
	{
		this.bankCard = bankCard;
	}
	public String getBackUrl()
	{
		return backUrl;
	}
	public void setBackUrl(String backUrl)
	{
		this.backUrl = backUrl;
	}
	public String getReUrl()
	{
		return reUrl;
	}
	public void setReUrl(String reUrl)
	{
		this.reUrl = reUrl;
	}
	public String getHomeUrl()
	{
		return homeUrl;
	}
	public void setHomeUrl(String homeUrl)
	{
		this.homeUrl = homeUrl;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getIdType()
	{
		return idType;
	}
	public void setIdType(String idType)
	{
		this.idType = idType;
	}
	public String getIdNo()
	{
		return idNo;
	}
	public void setIdNo(String idNo)
	{
		this.idNo = idNo;
	}
	public String getRem1()
	{
		return rem1;
	}
	public void setRem1(String rem1)
	{
		this.rem1 = rem1;
	}
	public String getRem2()
	{
		return rem2;
	}
	public void setRem2(String rem2)
	{
		this.rem2 = rem2;
	}
	public String getRem3()
	{
		return rem3;
	}
	public void setRem3(String rem3)
	{
		this.rem3 = rem3;
	}
	public String getSigntp()
	{
		return signtp;
	}
	public void setSigntp(String signtp)
	{
		this.signtp = signtp;
	}
	public String getSign()
	{
		return sign;
	}
	public void setSign(String sign)
	{
		this.sign = sign;
	}
	
	/**
	 * 转成XML格式报文
	 *  */
	public String convert2Xml() throws JAXBException
	{
		return XmlBeanUtils.convertBean2Xml(this);
	}
	/**
	 * 转成XML格式报文，但不包括XML头信息。
	 *  */
	public String convert2XmlWithoutHeader() throws JAXBException
	{
		return XmlBeanUtils.convertBean2Xml(this);
	}
}
