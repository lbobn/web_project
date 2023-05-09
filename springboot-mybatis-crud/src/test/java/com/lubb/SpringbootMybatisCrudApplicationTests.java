package com.lubb;

import com.lubb.mapper.EmpMapper;
import com.lubb.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testDelete() {
        empMapper.delete1(18);
    }

    @Test
    public void testDelete1() {
        List<Integer> ids = Arrays.asList(17, 18, 19);
        empMapper.deleteByIds(ids);
    }

    @Test
    public void testInsert() {
        Emp emp = new Emp();
        emp.setUsername("TOM1");
        emp.setName("汤姆1");
        emp.setGender((short) 1);
        emp.setImage("1.jpg");
        emp.setJob((short) 1);
        emp.setEntryDate(LocalDate.of(2005, 5, 20));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        empMapper.insert(emp);
        System.out.println(emp.getId());
    }

    @Test
    public void testUpdate() {
        Emp emp = new Emp();
        emp.setUsername("TOM2");
        emp.setName("汤姆2");
        emp.setGender((short) 1);
        emp.setImage("1.jpg");
        emp.setJob((short) 1);
        emp.setEntryDate(LocalDate.of(2005, 5, 20));

        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        empMapper.update(emp);
        System.out.println(emp.getId());
    }

    @Test
    public void testSelect() {
        Emp byId = empMapper.getById(20);
        System.out.println(byId);
    }

    @Test
    public void testList() {
        List<Emp> empList = empMapper.list("张", (short) 1,
                LocalDate.of(2010, 1, 1), LocalDate.of(2020, 1, 1));

//        List<Emp> empList1 = empMapper.list("张", (short) 1, null, null);
        System.out.println(empList);
    }


    @Test
    public void testUpdate2() {
        Emp emp = new Emp();
        emp.setId(20);
        emp.setUsername("TOM2222");
        emp.setName("汤姆22222");
        emp.setGender((short) 2);

        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        empMapper.update2(emp);
        System.out.println(emp.getId());
    }
}
