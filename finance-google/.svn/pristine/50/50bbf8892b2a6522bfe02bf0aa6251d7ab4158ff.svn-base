package com.ptteng.fuiou.h5.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * H5支付请求。包括银行卡认证支付和微信支付(2016/11/11)
 * @author XiaoHao
 *
 */
@XmlRootElement (name = "FM")
public class H5CommonPayRequest
{
	//富友分配给各合作商户的唯一识别码
	private String	mchntCd;
	//流水号
	private String mchntOrderId;
	//是否隐藏支付页面富友的logo，1隐藏，0显示
	private String	logoTp;
	//交易金额
	private String	amt;
	// 签名类型：md5或rsa
	private String	signTp;
	// 签名
	private String	sign;
	//银行卡支付内容
	private H5BankPay bankPay;
	//微信支付内容
	private H5WechatPay wechatPay;
	
	public String getMchntCd()
	{
		return mchntCd;
	}

	@XmlElement (name = "MCHNTCD")
	public void setMchntCd(String mchntCd)
	{
		this.mchntCd = mchntCd;
	}

	public String getMchntOrderId()
	{
		return mchntOrderId;
	}
	@XmlElement (name = "MCHNTORDERID")
	public void setMchntOrderId(String mchntOrderId)
	{
		this.mchntOrderId = mchntOrderId;
	}

	public String getLogoTp()
	{
		return logoTp;
	}

	@XmlElement (name = "LOGOTP")
	public void setLogoTp(String logoTp)
	{
		this.logoTp = logoTp;
	}
	
	public String getAmt()
	{
		return amt;
	}

	@XmlElement (name = "AMT")
	public void setAmt(String amt)
	{
		this.amt = amt;
	}

	public String getSignTp()
	{
		return signTp;
	}

	@XmlElement (name = "SIGNTP")
	public void setSignTp(String signTp)
	{
		this.signTp = signTp;
	}

	public String getSign()
	{
		return sign;
	}

	@XmlElement (name = "SIGN")
	public void setSign(String sign)
	{
		this.sign = sign;
	}
	
	public H5BankPay getBankPay()
	{
		return bankPay;
	}

	@XmlElement(name="BANK_PAY")
	public void setBankPay(H5BankPay bankPay)
	{
		this.bankPay = bankPay;
	}
	
	public H5WechatPay getWechatPay()
	{
		return wechatPay;
	}
	@XmlElement(name="WECHAT_PAY")
	public void setWechatPay(H5WechatPay wechatPay)
	{
		this.wechatPay = wechatPay;
	}
}
