package com.ptteng.service;

import com.ptteng.model.ProductRecommend;




public interface ProductRecommendService {
    int deleteByPrimaryKey(Long id);

    int insert(ProductRecommend record);

    int insertSelective(ProductRecommend record);

    ProductRecommend selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductRecommend record);

    int updateByPrimaryKey(ProductRecommend record);
}