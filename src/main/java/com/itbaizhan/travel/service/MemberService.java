package com.itbaizhan.travel.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itbaizhan.travel.bean.Result;
import com.itbaizhan.travel.mapper.MemberMapper;
import com.itbaizhan.travel.pojo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private BCryptPasswordEncoder encoder;


    // 注册
    public Result register(Member member){
        // 1.保存用户
        // 验证用户名是否重复
        QueryWrapper<Member> queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",member.getUsername());
        List<Member> members = memberMapper.selectList(queryWrapper);
        if (members.size() > 0){
            return new Result(false,"用户名已存在");
        }


        // 验证手机是否重复
        QueryWrapper<Member> queryWrapper1 = new QueryWrapper();
        queryWrapper1.eq("phoneNum",member.getPhoneNum());
        List<Member> members1 = memberMapper.selectList(queryWrapper1);
        if (members1.size() > 0){
            return new Result(false,"手机已存在");
        }


        // 验证邮箱是否重复
        QueryWrapper<Member> queryWrapper2 = new QueryWrapper();
        queryWrapper2.eq("email",member.getEmail());
        List<Member> members2 = memberMapper.selectList(queryWrapper2);
        if (members2.size() > 0){
            return new Result(false,"邮箱已存在");
        }


        // 加密密码
        String password = member.getPassword();
        password = encoder.encode(password);
        member.setPassword(password);
        // 设置用户状态为false
        member.setActive(false);
        // 保存用户
        memberMapper.insert(member);
        return new Result(true,"注册成功！");


        // 2.发送激活邮件
    }
}
