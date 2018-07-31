package com.ptteng.service.impl;

import com.ptteng.dao.ProductMapper;
import com.ptteng.model.Product;
import com.ptteng.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
@Resource
private ProductMapper productMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Product record) {
        return this.productMapper.insert(record);
    }

    @Override
    public int insertSelective(Product record) {
        return productMapper.insertSelective(record);
    }
    @Override
    public   List<Product> selectAll(){
        return this.productMapper.selectAll();
    }
    @Override
    public Product selectByPrimaryKey(Long id) {
        return productMapper.selectByPrimaryKey(id);
    }
    @Override
    public    Product selectByProduct(String product){
        return this.productMapper.selectByProduct(product);
    }
    @Override
    public int updateByPrimaryKeySelective(Product record) {
        return productMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Product record) {
        return productMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Product> forSelect(Long a, Long b) {
        return this.productMapper.forSelect(a,b);
    }

    @Override
    public List<Product> select(Long a, Long b, Long id, String productName, String founder, int status) {
        return this.productMapper.select(a,b,id,productName,founder,status);
    }

    @Override
    public Long selectCount() {
        return this.productMapper.selectCount();
    }

    @Override
    public Long selectCountWithCondition(Long id, String productName, String founder, Integer status) {
        return this.productMapper.selectCountWithCondition(id, productName, founder, status);
    }


}