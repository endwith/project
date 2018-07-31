package com.ptteng.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Trade implements Serializable {
    private Long id;

    public Long getInvestmentContractId() {
        return investmentContractId;
    }

    public void setInvestmentContractId(Long investmentContractId) {
        this.investmentContractId = investmentContractId;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "id=" + id +
                ", investmentContractId=" + investmentContractId +
                ", product='" + product + '\'' +
                ", purchaser='" + purchaser + '\'' +
                ", buyTime=" + buyTime +
                ", delayTime=" + delayTime +
                ", expireTime=" + expireTime +
                ", toBeMatched=" + toBeMatched +
                ", purchaseAmount=" + purchaseAmount +
                ", investmentContract='" + investmentContract + '\'' +
                ", status=" + status +
                ", userId=" + userId +
                ", expectedRate=" + expectedRate +
                '}';
    }

    private Long investmentContractId;

    private String product;

    private String purchaser;

    private Long buyTime;

    private Long delayTime;

    private Long expireTime;

    private BigDecimal toBeMatched;

    private BigDecimal purchaseAmount;

    private String investmentContract;

    private Integer status;

    private Long userId;

    private BigDecimal expectedRate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product == null ? null : product.trim();
    }

    public String getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(String purchaser) {
        this.purchaser = purchaser == null ? null : purchaser.trim();
    }

    public Long getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Long buyTime) {
        this.buyTime = buyTime;
    }

    public Long getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(Long delayTime) {
        this.delayTime = delayTime;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public BigDecimal getToBeMatched() {
        return toBeMatched;
    }

    public void setToBeMatched(BigDecimal toBeMatched) {
        this.toBeMatched = toBeMatched;
    }

    public BigDecimal getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(BigDecimal purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public String getInvestmentContract() {
        return investmentContract;
    }

    public void setInvestmentContract(String investmentContract) {
        this.investmentContract = investmentContract == null ? null : investmentContract.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getExpectedRate() {
        return expectedRate;
    }

    public void setExpectedRate(BigDecimal expectedRate) {
        this.expectedRate = expectedRate;
    }

    public Trade() {
    }

    public Trade(Long investmentContractId, String product, String purchaser, Long buyTime, Long delayTime, Long expireTime, BigDecimal toBeMatched, BigDecimal purchaseAmount, String investmentContract, Integer status, Long userId, BigDecimal expectedRate) {
        this.investmentContractId = investmentContractId;
        this.product = product;
        this.purchaser = purchaser;
        this.buyTime = buyTime;
        this.delayTime = delayTime;
        this.expireTime = expireTime;
        this.toBeMatched = toBeMatched;
        this.purchaseAmount = purchaseAmount;
        this.investmentContract = investmentContract;
        this.status = status;
        this.userId = userId;
        this.expectedRate = expectedRate;
    }



}