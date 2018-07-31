package com.ptteng.service;

import com.ptteng.model.Product;
import com.ptteng.model.ProductRecommend;

import java.util.List;


public interface ProductRecommendService {
    int deleteByPrimaryKey(Long id);

    int insert(ProductRecommend record);

    int insertSelective(ProductRecommend record);

    ProductRecommend selectByPrimaryKey(Long id);
    List<ProductRecommend> selectByStatus(Integer type, Integer recommendStatus, Integer bannerStatus);
    int updateByPrimaryKeySelective(ProductRecommend record);

    int updateByPrimaryKey(ProductRecommend record);

    List<ProductRecommend> forSelect(Long a, Long b,  Integer type);

    List<Product> select(Long a, Long b, Integer type, Long id, String title, String product, String founder, String modifier);
    Long selectCount(Integer type);
    Long selectCountWithCondition(Integer type,Long id,String title,String product,String founder,String modifier);
}