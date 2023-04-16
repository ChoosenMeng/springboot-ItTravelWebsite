package com.itbaizhan.travel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itbaizhan.travel.mapper.PermissionMapper;
import com.itbaizhan.travel.pojo.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    //遍历所有权限
    public Page<Permission> findPage(int page,int size){
        Page selectPage = permissionMapper.selectPage(new Page(page,size),null);
        return selectPage;
    }

    //新增权限
    public void add(Permission permission){
        permissionMapper.insert(permission);
    }

    //根据ID查询
    public Permission findById(Integer pid){
        return permissionMapper.selectById(pid);
    }

    //修改权限
    public void update(Permission permission){
        permissionMapper.updateById(permission);
    }

    //删除权限
    public void delete(Integer pid){
        permissionMapper.deleteById(pid);
    }



}
