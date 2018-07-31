package com.ptteng.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ObligatoryRight implements Serializable {
    private Long id;

    private String company;

    private String mobile;

    private String idCard;

    private BigDecimal loanSum;

    private Long loanTerm;

    private Long loanTime;

    private Long repayTime;

    private BigDecimal matchingAmount;

    private Integer status;

    private String corporate;

    private String founder;

    private Long createAt;

    private String modifier;

    private Long updateAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public BigDecimal getLoanSum() {
        return loanSum;
    }

    public void setLoanSum(BigDecimal loanSum) {
        this.loanSum = loanSum;
    }

    public Long getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(Long loanTerm) {
        this.loanTerm = loanTerm;
    }

    public Long getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(Long loanTime) {
        this.loanTime = loanTime;
    }

    public Long getRepayTime() {
        return repayTime;
    }

    public void setRepayTime(Long repayTime) {
        this.repayTime = repayTime;
    }

    public BigDecimal getMatchingAmount() {
        return matchingAmount;
    }

    public void setMatchingAmount(BigDecimal matchingAmount) {
        this.matchingAmount = matchingAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCorporate() {
        return corporate;
    }

    public void setCorporate(String corporate) {
        this.corporate = corporate == null ? null : corporate.trim();
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder == null ? null : founder.trim();
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public ObligatoryRight() {
    }

    public ObligatoryRight(String company, String mobile, String idCard, BigDecimal loanSum, Long loanTerm, Long loanTime, Long repayTime, BigDecimal matchingAmount, Integer status, String corporate, String founder, Long createAt, String modifier, Long updateAt) {
        this.company = company;
        this.mobile = mobile;
        this.idCard = idCard;
        this.loanSum = loanSum;
        this.loanTerm = loanTerm;
        this.loanTime = loanTime;
        this.repayTime = repayTime;
        this.matchingAmount = matchingAmount;
        this.status = status;
        this.corporate = corporate;
        this.founder = founder;
        this.createAt = createAt;
        this.modifier = modifier;
        this.updateAt = updateAt;
    }
}