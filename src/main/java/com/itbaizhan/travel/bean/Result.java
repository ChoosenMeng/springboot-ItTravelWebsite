package com.itbaizhan.travel.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

// 结果对象  封装用户注册时返回的结果
@Data
@AllArgsConstructor
public class Result {
    private boolean flag;// 结果
    private String message;//提示信息
    private Object data;//返回数据


    public Result(boolean flag, String message) {
        this(flag,message,null);
    }
}
