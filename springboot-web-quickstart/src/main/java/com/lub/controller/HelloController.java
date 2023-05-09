package com.lub.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//请求处理类
@RestController
public class HelloController {
    @RequestMapping("/hello")   //浏览器请求 /hello 地址就会调用下面的方法
    //请求处理方法
    public String hello() {
        System.out.println("Hello World~~");
        return "Hello World~~";
    }
}
