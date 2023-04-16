package com.itbaizhan.travel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itbaizhan.travel.bean.PermissionWithStatus;
import com.itbaizhan.travel.mapper.PermissionMapper;
import com.itbaizhan.travel.mapper.RoleMapper;
import com.itbaizhan.travel.pojo.Permission;
import com.itbaizhan.travel.pojo.Role;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    //分页查询
    public Page<Role> findPage(int page,int size){
        return roleMapper.selectPage(new Page(page,size),null);
    }

    //添加角色
    public void add(Role role){
        roleMapper.insert(role);
    }

    //查询角色
    public Role findById(Integer rid){
        return roleMapper.selectById(rid);
    }

    //修改角色
    public void update(Role role){
        roleMapper.updateById(role);
    }

    //删除角色
    public void delete(Integer rid){
        roleMapper.deleteById(rid);
    }

    // 查询角色的权限情况
    public List<PermissionWithStatus> findPermission(Integer rid){
        // 查询所有权限
        List<Permission> permissions = permissionMapper.selectList(null);
        // 查询角色拥有的所有权限id
        List<Integer> pids = permissionMapper.findPermissionIdByRole(rid);


        // 带有状态的权限集合
        List<PermissionWithStatus> permissionList = new ArrayList();
        // 遍历所有权限
        for (Permission permission:permissions){
            // 创建带有状态的权限
            PermissionWithStatus permissionWithStatus = new PermissionWithStatus();
            // 将权限属性复制给带有状态的权限
            BeanUtils.copyProperties(permission,permissionWithStatus);


            // 如果角色拥有该权限
            if(pids.contains(permission.getPid())){
                permissionWithStatus.setRoleHas(true);
            }else {
                permissionWithStatus.setRoleHas(false);
            }
            permissionList.add(permissionWithStatus);
        }
        return permissionList;
    }

    //给角色重新分配权限
    public void updatePermissions(Integer rid,Integer[] ids){
        // 删除角色的所有权限
        roleMapper.deleteRoleAllPermission(rid);
        // 重新给角色添加权限
        for (Integer pid:ids){
            roleMapper.addRolePermission(rid,pid);
        }
    }

}
