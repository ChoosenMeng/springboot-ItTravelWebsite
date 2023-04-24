package com.itbaizhan.travel.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从session中获取用户信息
        Object member = request.getSession().getAttribute("member");
        if (null == member){
            response.sendRedirect(request.getContextPath()+"/frontdesk/login");
            return false;
        }
        return true;
    }
}
