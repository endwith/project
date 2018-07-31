package com.ptteng.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Match implements Serializable {
    private Long id;

    private Long tradeId;

    private Long oblId;

    private BigDecimal amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTradeId() {
        return tradeId;
    }

    public void setTradeId(Long tradeId) {
        this.tradeId = tradeId;
    }

    public Long getOblId() {
        return oblId;
    }

    public void setOblId(Long oblId) {
        this.oblId = oblId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Match() {
    }

    public Match(Long tradeId, Long oblId, BigDecimal amount) {
        this.tradeId = tradeId;
        this.oblId = oblId;
        this.amount = amount;
    }
}