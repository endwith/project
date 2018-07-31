package com.ptteng.dao;

import com.ptteng.model.InvestmentContract;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InvestmentContractMapper {
    int deleteByPrimaryKey(Long id);

    int insert(InvestmentContract record);

    int insertSelective(InvestmentContract record);

    InvestmentContract selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InvestmentContract record);

    int updateByPrimaryKey(InvestmentContract record);

    List<InvestmentContract> selectByUserId(@Param("userId") Long userId, @Param("a") Long a, @Param("b") Long b);

    Long selectCount(@Param("userId") Long userId);
    int updateInvestOutOfDate(Long id);
}