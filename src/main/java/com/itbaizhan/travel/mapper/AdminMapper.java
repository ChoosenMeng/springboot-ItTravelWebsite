package com.itbaizhan.travel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itbaizhan.travel.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper extends BaseMapper<Admin> {
    //查询用户详情
    Admin findDesc(Integer aid);

    // 删除用户的所有角色
    void deleteAdminAllRoles(Integer aid);


    // 给用户添加角色
    void addAdminRole(@Param("aid") Integer aid, @Param("rid") Integer rid);

}

