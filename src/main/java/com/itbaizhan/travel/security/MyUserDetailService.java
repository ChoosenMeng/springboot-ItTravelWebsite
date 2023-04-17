package com.itbaizhan.travel.security;

import com.itbaizhan.travel.pojo.Admin;
import com.itbaizhan.travel.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private AdminService adminService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //1.认证
        Admin admin = adminService.findByAdminName(username);
        if (admin == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        if (!admin.isStatus()){
            throw new UsernameNotFoundException("用户不可用");
        }

        //2.封装为UserDetails对象
        UserDetails build = User.withUsername(admin.getUsername())
                .password(admin.getPassword())
                .authorities(new ArrayList())
                .build();
        return build;
    }
}
