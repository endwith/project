package com.ptteng.dao;

import com.ptteng.model.ObligatoryRight;
import com.ptteng.model.Trade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;


@Mapper
public interface ObligatoryRightMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ObligatoryRight record);

    int insertSelective(ObligatoryRight record);

    ObligatoryRight selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ObligatoryRight record);

    int updateByPrimaryKey(ObligatoryRight record);

    List<ObligatoryRight> forSelect(@Param("a") Long a, @Param("b") Long b);
    List<ObligatoryRight> select(@Param("a") Long a, @Param("b") Long b, @Param("id") Long id, @Param("company") String company, @Param("corporate") String corporate, @Param("status") int status);
    int updateById(@Param("id") Long obligatoryId, @Param("matchingAmount") BigDecimal matchingAmount);
    Long selectCount();
    Long selectCountWithCondition();
    List<Trade> getTrade(long id);
}