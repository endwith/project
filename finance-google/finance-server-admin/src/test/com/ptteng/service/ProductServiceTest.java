package com.ptteng.service;

import com.ptteng.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Test
    public void updateByPrimaryKeySelective() {
        Product product = new Product();
        product.setId(13l);
        product.setIntroduce("赚钱了啊啊啊");
        productService.updateByPrimaryKeySelective(product);
        System.out.println(productService.selectByPrimaryKey(13l).getIntroduce());
    }

    @Test
    public void updateByPrimaryKey() {
    }
}