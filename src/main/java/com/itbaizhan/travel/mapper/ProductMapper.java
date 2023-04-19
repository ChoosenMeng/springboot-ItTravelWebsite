package com.itbaizhan.travel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itbaizhan.travel.pojo.Product;

public interface ProductMapper extends BaseMapper<Product> {
    Page<Product> findProductPage(Page<Product> page);
}
