package com.ptteng.dao;

import com.ptteng.model.ProductRecommend;

public interface ProductRecommendMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductRecommend record);

    int insertSelective(ProductRecommend record);

    ProductRecommend selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductRecommend record);

    int updateByPrimaryKey(ProductRecommend record);
}