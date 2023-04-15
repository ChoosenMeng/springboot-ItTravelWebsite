package com.itbaizhan.travel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itbaizhan.travel.pojo.Admin;
import com.itbaizhan.travel.pojo.Role;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {
    //查询用户拥有的所有角色id
    List<Integer> findRoleIdByAdmin(Integer aid);
}

