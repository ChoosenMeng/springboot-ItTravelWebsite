package com.itbaizhan.travel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itbaizhan.travel.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

public interface ProductMapper extends BaseMapper<Product> {
    Page<Product> findProductPage(Page<Product> page);
    Product findOne(int pid);

    int findFavoritePidAndMid(@Param("pid")Integer pid,@Param("mid")Integer mid);
    void addFavorite(@Param("pid")Integer pid,@Param("mid")Integer mid);
    void delFavorite(@Param("pid")Integer pid,@Param("mid")Integer mid);
    Page<Product> findMemberFavorite(Page<Product> page,Integer mid);
}
