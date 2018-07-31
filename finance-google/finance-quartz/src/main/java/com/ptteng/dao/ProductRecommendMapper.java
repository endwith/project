package com.ptteng.dao;

import com.ptteng.model.Product;
import com.ptteng.model.ProductRecommend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductRecommendMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductRecommend record);

    int insertSelective(ProductRecommend record);

    ProductRecommend selectByPrimaryKey(Long id);
    List<ProductRecommend> selectByStatus(@Param("type") int type, @Param("recommendStatus") int recommendStatus, @Param("bannerStatus") int bannerStatus);
    int updateByPrimaryKeySelective(ProductRecommend record);

    int updateByPrimaryKey(ProductRecommend record);

    List<ProductRecommend> forSelect(@Param("a") Long a, @Param("b") Long b, @Param("type") Integer type);
    //分页模糊查询
    List<Product> select(@Param("a") Long a, @Param("b") Long b, @Param("type") Integer type, @Param("id") Long id, @Param("title") String title, @Param("product") String product, @Param("founder") String founder, @Param("modifier") String modifier);
    Long selectCount(@Param("type") Integer type);
    Long selectCountWithCondition(@Param("type") Integer type, @Param("id") Long id, @Param("title") String title, @Param("product") String product, @Param("founder") String founder, @Param("modifier") String modifier);
}