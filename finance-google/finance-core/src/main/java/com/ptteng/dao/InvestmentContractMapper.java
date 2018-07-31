package com.ptteng.dao;

import com.ptteng.model.InvestmentContract;

public interface InvestmentContractMapper {
    int deleteByPrimaryKey(Long id);

    int insert(InvestmentContract record);

    int insertSelective(InvestmentContract record);

    InvestmentContract selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InvestmentContract record);

    int updateByPrimaryKey(InvestmentContract record);
}