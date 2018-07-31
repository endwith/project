package com.ptteng.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class InvestmentContract implements Serializable {
    private Long id;

    private String trueName;

    private String phoneNumber;
    private Long userId;
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }



    @Override
    public String toString() {
        return "InvestmentContract{" +
                "id=" + id +
                ", trueName='" + trueName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", userId='" + userId + '\'' +
                ", product='" + product + '\'' +
                ", investAmount=" + investAmount +
                ", income=" + income +
                ", effectiveTime=" + effectiveTime +
                ", invalidTime=" + invalidTime +
                ", status=" + status +
                '}';
    }
    private String product;

    private BigDecimal investAmount;

    private BigDecimal income;

    private Long effectiveTime;

    private Long invalidTime;

    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName == null ? null : trueName.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product == null ? null : product.trim();
    }

    public BigDecimal getInvestAmount() {
        return investAmount;
    }

    public void setInvestAmount(BigDecimal investAmount) {
        this.investAmount = investAmount;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public Long getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Long effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Long getInvalidTime() {
        return invalidTime;
    }

    public void setInvalidTime(Long invalidTime) {
        this.invalidTime = invalidTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public InvestmentContract() {
    }

    public InvestmentContract(String trueName, Long userId,String phoneNumber, String product, BigDecimal investAmount, BigDecimal income, Long effectiveTime, Long invalidTime, Integer status) {
        this.trueName = trueName;
        this.phoneNumber = phoneNumber;
        this.product = product;
        this.investAmount = investAmount;
        this.income = income;
        this.effectiveTime = effectiveTime;
        this.invalidTime = invalidTime;
        this.status = status;
        this.userId=userId;
    }
}