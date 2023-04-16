package com.itbaizhan.travel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itbaizhan.travel.pojo.Admin;
import com.itbaizhan.travel.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {
    //查询用户拥有的所有角色id
    List<Integer> findRoleIdByAdmin(Integer aid);

    // 删除角色的所有权限
    void deleteRoleAllPermission(Integer rid);

    // 给角色添加权限
    void addRolePermission(@Param("rid") Integer rid, @Param("pid") Integer pid);

}

