package com.ptteng.service;

import com.ptteng.model.ObligatoryRight;
import com.ptteng.model.Trade;

import java.math.BigDecimal;
import java.util.List;


public interface ObligatoryRightService {
    int deleteByPrimaryKey(Long id);

    int insert(ObligatoryRight record);

    int insertSelective(ObligatoryRight record);

    ObligatoryRight selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ObligatoryRight record);

    int updateByPrimaryKey(ObligatoryRight record);
    List<ObligatoryRight> forSelect(Long a, Long b);
    List<ObligatoryRight> select(Long a, Long b, Long id, String company, String corporate, Integer status);
    int updateById(Long obligatoryId, BigDecimal matchingAmount);
    Long selectCount();
    Long selectCountWithCondition();
    List<Trade> getTrade(long id);
}