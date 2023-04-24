package com.itbaizhan.travel.controller.frontdesk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/frontdesk/favorite")
public class FavoriteController {
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "测试";
    }
}
