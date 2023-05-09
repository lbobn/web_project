package com.example.springbootwebreqresp.controller;

import com.example.springbootwebreqresp.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


/*
 * 测试请求参数接收
 * */
@RestController
/*@RestController = @Controller + @ResponseBody
 * @ResponseBody 注解表示该类的所有方法返回值都作为响应数据
 * */
public class RequestController {

    /*原生方式*/
    /*@RequestMapping("/simpleParam")
    public String simpleParam(HttpServletRequest request){
        //获取请求参数
        String name = request.getParameter("name");
        String agr = request.getParameter("age");

        int age = Integer.parseInt(agr);
        System.out.println(name + " : " + age);
        return "OK";
    }*/

    //springboot方式
    @RequestMapping("/simpleParam")
    public String simpleParam(String name, Integer age) {
        /*
         * 若加上@RequsetParam(name="name")
         * 则该参数必须传递，否则报错
         *
         * 若加上@RequsetParam(name="name",required=false)
         * 则该参数可传可不传
         * */
        System.out.println(name + " : " + age);
        return "OK";
    }


    /*实体参数*/
    //请求的参数名与形参对象属性名相同
    @RequestMapping("/simplePojo")
    public String simplePojo(User user) {
        //user中的address通过address.province=北京来封装
        System.out.println(user);
        return "OK";
    }

    /*数组集合参数*/
    //数组，变量名与请求参数名相同
    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby) {
        System.out.println(Arrays.toString(hobby));
        return "OK";
    }

    //集合，变量名与请求参数名相同，并通过@RequestParam绑定参数关系
    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby) {
        System.out.println(hobby);
        return "OK";
    }


    /*日期时间*/
    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime) {
        System.out.println(updateTime);
        return "OK";
    }

    /*json参数*/
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user) {
        System.out.println(user);
        return "OK";
    }

    /*路径参数*/
    @RequestMapping("/path/{id}")
    public String pathParam(@PathVariable Integer id) {
        System.out.println(id);
        return "OK";
    }

    @RequestMapping("/path/{id}/{name}")
    public String pathParam(@PathVariable Integer id, @PathVariable String name) {
        System.out.println(id + " " + name);
        return "OK";
    }
}
