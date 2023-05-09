package com.example.springbootwebreqresp.dao.empl;

import com.example.springbootwebreqresp.dao.EmpDao;
import com.example.springbootwebreqresp.pojo.Emp;
import com.example.springbootwebreqresp.utils.XmlParserUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Component
@Repository
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        //加载并解析emp.xml
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
