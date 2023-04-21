package com.itbaizhan.travel.controller.frontdesk;

import com.itbaizhan.travel.bean.Result;
import com.itbaizhan.travel.pojo.Member;
import com.itbaizhan.travel.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/frontdesk/member")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @RequestMapping("/register")
    public ModelAndView register(Member member, String checkCode, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        // 判断验证码是否正确
        String sessionCheckCode = (String) session.getAttribute("checkCode");
        if (!sessionCheckCode.equalsIgnoreCase(checkCode)){
            modelAndView.addObject("message","验证码错误");
            modelAndView.setViewName("/frontdesk/register");
            return modelAndView;
        }
        // 注册
        Result result = memberService.register(member);
        if (!result.isFlag()){ // 注册失败
            modelAndView.addObject("message",result.getMessage());
            modelAndView.setViewName("/frontdesk/register");
        }else {
            // 注册成功
            modelAndView.setViewName("/frontdesk/register_ok");
        }
        return modelAndView;
    }
}
