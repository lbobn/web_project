package com.example.springbootwebreqresp.controller;

import com.example.springbootwebreqresp.pojo.Address;
import com.example.springbootwebreqresp.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ResponseController {

    /*
     * 统一响应结果
     * */
    @RequestMapping("/hello")
    public Result hello() {
        System.out.println("hello world");
        //return new Result(1,"success","hello world");
        return Result.success("hello world");
    }


    /*如果返回值为对象或集合，会先转为JSON再返回*/

    @RequestMapping("/getAddr")
    public Result getAddr() {
        Address addr = new Address();
        addr.setCity("北京");
        addr.setProvince("北京");
        return Result.success(addr);
    }

    @RequestMapping("/listAddr")
    public Result listAddr() {
        List<Address> list = new ArrayList<>();

        Address addr1 = new Address();
        addr1.setCity("北京");
        addr1.setProvince("北京");

        Address addr2 = new Address();
        addr2.setCity("广州");
        addr2.setProvince("广东");

        Address addr3 = new Address();
        addr3.setCity("西安");
        addr3.setProvince("陕西");
        list.add(addr1);
        list.add(addr2);
        list.add(addr3);

        return Result.success(list);
    }

    /*@RequestMapping("/hello")
    public String hello(){
        System.out.println("hello world");
        return "hello world";
    }


    *//*如果返回值为对象或集合，会先转为JSON再返回*//*

    @RequestMapping("/getAddr")
    public Address getAddr(){
        Address addr = new Address();
        addr.setCity("北京");
        addr.setProvince("北京");
        return addr;
    }

    @RequestMapping("/listAddr")
    public List<Address> listAddr(){
        List<Address> list = new ArrayList<>();

        Address addr1 = new Address();
        addr1.setCity("北京");
        addr1.setProvince("北京");

        Address addr2 = new Address();
        addr2.setCity("广州");
        addr2.setProvince("广东");

        Address addr3 = new Address();
        addr3.setCity("西安");
        addr3.setProvince("陕西");
        list.add(addr1);
        list.add(addr2);
        list.add(addr3);

        return list;
    }*/

}
