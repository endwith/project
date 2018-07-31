package com.ptteng.fuiou.h5.bean;

import javax.xml.bind.annotation.XmlElement;

/**
 * 银行卡认证支付(2016/11/11)
 * @author XiaoHao
 *
 */
public class H5BankPay
{
	//交易类型
	private String type;
	//接口版本号
	private String version;
	//客户在商户端的唯一编号，即客户ID
	private String userId;
	//支付的银行卡卡号
	private String bankCard;
	//商户接收支付结果的后台通知地址
	private String backUrl;
	//在富友的支付失败页面跳转到该地址进行重新支付
	private String reUrl;
	//在富友的支付成功页面跳转到该地址
	private String homeUrl;
	//用户姓名
	private String name;
	//0.身份证 1.护照 2.军官证 3.士兵证 4.回乡证 6.户口本 7.其它
	private String idType;
	//用户身份证号
	private String idNo;
	
	private String rem1;
	
	private String rem2;
	
	private String rem3;

	public String getType()
	{
		return type;
	}

	@XmlElement(name="TYPE")
	public void setType(String type)
	{
		this.type = type;
	}

	public String getVersion()
	{
		return version;
	}
	@XmlElement(name="VERSION")
	public void setVersion(String version)
	{
		this.version = version;
	}

	public String getUserId()
	{
		return userId;
	}
	@XmlElement(name="USERID")
	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getBankCard()
	{
		return bankCard;
	}
	@XmlElement(name="BANKCARD")
	public void setBankCard(String bankCard)
	{
		this.bankCard = bankCard;
	}

	public String getBackUrl()
	{
		return backUrl;
	}
	@XmlElement(name="BACKURL")
	public void setBackUrl(String backUrl)
	{
		this.backUrl = backUrl;
	}

	public String getReUrl()
	{
		return reUrl;
	}
	@XmlElement(name="REURL")
	public void setReUrl(String reUrl)
	{
		this.reUrl = reUrl;
	}

	public String getHomeUrl()
	{
		return homeUrl;
	}
	@XmlElement(name="HOMEURL")
	public void setHomeUrl(String homeUrl)
	{
		this.homeUrl = homeUrl;
	}

	public String getName()
	{
		return name;
	}
	@XmlElement(name="NAME")
	public void setName(String name)
	{
		this.name = name;
	}

	public String getIdType()
	{
		return idType;
	}
	
	@XmlElement(name="IDTYPE")
	public void setIdType(String idType)
	{
		this.idType = idType;
	}

	public String getIdNo()
	{
		return idNo;
	}
	@XmlElement(name="IDNO")
	public void setIdNo(String idNo)
	{
		this.idNo = idNo;
	}

	public String getRem1()
	{
		return rem1;
	}
	
	@XmlElement(name="REM1")
	public void setRem1(String rem1)
	{
		this.rem1 = rem1;
	}

	public String getRem2()
	{
		return rem2;
	}
	
	@XmlElement(name="REM2")
	public void setRem2(String rem2)
	{
		this.rem2 = rem2;
	}

	public String getRem3()
	{
		return rem3;
	}
	
	@XmlElement(name="REM3")
	public void setRem3(String rem3)
	{
		this.rem3 = rem3;
	}
}
