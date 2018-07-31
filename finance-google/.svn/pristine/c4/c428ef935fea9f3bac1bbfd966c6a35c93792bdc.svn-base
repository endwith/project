package com.ptteng.dao;

import com.ptteng.model.HistoryProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface HistoryProductMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HistoryProduct record);

    int insertSelective(HistoryProduct record);

    HistoryProduct selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HistoryProduct record);

    int updateByPrimaryKey(HistoryProduct record);

    List<HistoryProduct> selectAllByUserId(@Param("userId") Long userId, @Param("a") Long a, @Param("b") Long b);

    List<HistoryProduct> selectByUserId(@Param("userId") Long userId);
    List<HistoryProduct> selectUserProductByUserId(@Param("userId") Long userId);
    Long selectCount(@Param("userId") Long userId);
    List<Map> selectByProduct(@Param("product") String product, @Param("a") Long a, @Param("b") Long b);
    Long selectByProductCount(@Param("product") String product);

}