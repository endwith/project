package com.ptteng.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class HistoryProduct implements Serializable {
    private Long id;

    private String product;

    private String bankCard;

    private String buyer;

    private Long buyTime;

    private Long arriveTime;

    @Override
    public String toString() {
        return "HistoryProduct{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", bankCard='" + bankCard + '\'' +
                ", buyer='" + buyer + '\'' +
                ", buyTime=" + buyTime +
                ", arriveTime=" + arriveTime +
                ", transactionAction=" + transactionAction +
                ", transactionAmouont=" + transactionAmouont +
                ", phone='" + phone + '\'' +
                ", userId=" + userId +
                ", expectedRate=" + expectedRate +
                '}';
    }

    private Integer transactionAction;

    private BigDecimal transactionAmouont;

    private String phone;
    private Long userId;
    private BigDecimal expectedRate;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard == null ? null : bankCard.trim();
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer == null ? null : buyer.trim();
    }

    public Long getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Long buyTime) {
        this.buyTime = buyTime;
    }

    public Long getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Long arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Integer getTransactionAction() {
        return transactionAction;
    }

    public void setTransactionAction(Integer transactionAction) {
        this.transactionAction = transactionAction;
    }

    public BigDecimal getTransactionAmouont() {
        return transactionAmouont;
    }

    public void setTransactionAmouont(BigDecimal transactionAmouont) {
        this.transactionAmouont = transactionAmouont;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public HistoryProduct() {
    }

    public HistoryProduct(String product, String bankCard, String buyer, Long buyTime, Long arriveTime, Integer transactionAction, BigDecimal transactionAmouont, String phone) {
        this.product = product;
        this.bankCard = bankCard;
        this.buyer = buyer;
        this.buyTime = buyTime;
        this.arriveTime = arriveTime;
        this.transactionAction = transactionAction;
        this.transactionAmouont = transactionAmouont;
        this.phone = phone;
    }

    public BigDecimal getExpectedRate() {
        return expectedRate;
    }

    public void setExpectedRate(BigDecimal expectedRate) {
        this.expectedRate = expectedRate;
    }
}