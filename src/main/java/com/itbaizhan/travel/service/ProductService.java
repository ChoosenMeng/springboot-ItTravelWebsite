package com.itbaizhan.travel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itbaizhan.travel.mapper.ProductMapper;
import com.itbaizhan.travel.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductMapper productMapper;


    public Page<Product> findPage(int page, int size){
        Page selectPage = productMapper.findProductPage(new Page(page, size));
        return selectPage;
    }

    public void add(Product product){
        productMapper.insert(product);
    }

    public Product findOne(int pid){
        return productMapper.findOne(pid);
    }

    public void update(Product product){
        productMapper.updateById(product);
    }

    public void updateStatus(Integer pid){
        Product product = productMapper.selectById(pid);
        product.setStatus(!product.getStatus());
        productMapper.updateById(product);
    }
}