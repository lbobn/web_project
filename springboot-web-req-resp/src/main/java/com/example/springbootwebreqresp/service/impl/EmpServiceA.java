package com.example.springbootwebreqresp.service.impl;

import com.example.springbootwebreqresp.dao.EmpDao;
import com.example.springbootwebreqresp.dao.empl.EmpDaoA;
import com.example.springbootwebreqresp.pojo.Emp;
import com.example.springbootwebreqresp.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component
@Service
public class EmpServiceA implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    public List<Emp> listEmp() {
        List<Emp> empList = empDao.listEmp();
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
        return empList;
    }
}
