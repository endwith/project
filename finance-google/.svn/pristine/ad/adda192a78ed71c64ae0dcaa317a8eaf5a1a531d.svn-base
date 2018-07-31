package com.ptteng.service;

import com.ptteng.model.InvestmentContract;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface InvestmentContractService {
    int deleteByPrimaryKey(Long id);

    int insert(InvestmentContract record);

    int insertSelective(InvestmentContract record);

    InvestmentContract selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InvestmentContract record);

    int updateByPrimaryKey(InvestmentContract record);
    List<InvestmentContract> selectByUserId(Long userId, Long a, Long b);

    Long selectCount(Long userId);
    int updateInvestOutOfDate(Long id);
}