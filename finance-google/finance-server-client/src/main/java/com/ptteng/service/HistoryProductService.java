package com.ptteng.service;

import com.ptteng.model.HistoryProduct;

import java.util.List;
import java.util.Map;


public interface HistoryProductService {
    int deleteByPrimaryKey(Long id);

    int insert(HistoryProduct record);

    int insertSelective(HistoryProduct record);

    HistoryProduct selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HistoryProduct record);

    int updateByPrimaryKey(HistoryProduct record);
    List<HistoryProduct> selectAllByUserId(Long userId, Long a, Long b);
    List<HistoryProduct> selectByUserId(Long userId);
    List<HistoryProduct> selectUserProductByUserId(Long userId);
    Long selectCount(Long userId);
    List<Map> selectByProduct(String product, Long a, Long b);
    Long selectByProductCount(String product);
}