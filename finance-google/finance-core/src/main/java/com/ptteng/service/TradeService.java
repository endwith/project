package com.ptteng.service;

import com.ptteng.model.Trade;



public interface TradeService {
    int deleteByPrimaryKey(Long id);

    int insert(Trade record);

    int insertSelective(Trade record);

    Trade selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Trade record);

    int updateByPrimaryKey(Trade record);
}