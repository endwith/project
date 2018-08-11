package com.ptteng.service;

import com.ptteng.model.Product;

import java.util.List;


public interface ProductService {
    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    int insertSelective(Product record);
    Product selectByProduct(String productName);
    Product selectByPrimaryKey(Long id);
    List<Product> selectAll();
    int updateByPrimaryKeySelective(Product record);
    List<Product> forSelectByStatus(Long a, Long b);
    int updateByPrimaryKey(Product record);
    //分页查询
    List<Product> forSelect(Long a, Long b);
    //分页模糊查询
    List<Product> select(Long a, Long b, Long id, String productName, String founder, Integer status);

    Long selectCount();
    Long selectCountWithCondition(Long id,String productName,String founder,Integer status);
}