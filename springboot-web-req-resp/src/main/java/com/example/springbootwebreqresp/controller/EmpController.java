package com.example.springbootwebreqresp.controller;

import com.example.springbootwebreqresp.pojo.Emp;
import com.example.springbootwebreqresp.pojo.Result;
import com.example.springbootwebreqresp.service.EmpService;
import com.example.springbootwebreqresp.service.impl.EmpServiceA;
import com.example.springbootwebreqresp.utils.XmlParserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping("/listEmp")
    public Result list() {
        //调用service，获取数据
        List<Emp> empList = empService.listEmp();
        //响应
        return Result.success(empList);
    }

    /*@RequestMapping("/listEmp")
    public Result list() {
        //加载并解析emp.xml
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);

        //对数据转换
        empList.stream().forEach(emp -> {
            //处理gender
            String gender = emp.getGender();
            if ("1".equals(gender)) {
                emp.setGender("男");
            } else if ("2".equals(gender)) {
                emp.setGender("女");
            }

            //处理job
            String job = emp.getJob();
            if ("1".equals(job)) {
                emp.setJob("讲师");
            } else if ("2".equals(job)) {
                emp.setJob("班主任");
            } else if ("3".equals(job)) {
                emp.setJob("就业指导");
            }
        });

        //相应结果
        return Result.success(empList);
    }*/
}
