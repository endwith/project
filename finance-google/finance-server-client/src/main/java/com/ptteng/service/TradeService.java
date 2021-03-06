package com.ptteng.service;

import com.ptteng.model.Trade;

import java.math.BigDecimal;
import java.util.List;


public interface TradeService {
    int deleteByPrimaryKey(Long id);

    int insert(Trade record);

    int insertSelective(Trade record);

    Trade selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Trade record);

    int updateByPrimaryKey(Trade record);

    List<Object> matchSelect(Long id, Long a, Long b);
    List<Object> limitMatchSelect(Long id, Long loanTerm, Long repayTime, BigDecimal matchingAmount);
    int updateByTradeId(Long tradeId, BigDecimal toBeMatched);

    List<Trade> selectByUserId(Long userId, int a, int b);
    int updateStatusByID(Long id, int status);
}