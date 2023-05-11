package com.lubb.service;

import com.lubb.pojo.Emp;
import com.lubb.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(Integer page, Integer pageSize,
                  String name, Short gender, LocalDate begin, LocalDate end);

    /*
     * 批量删除
     * */
    void delete(List<Integer> ids);

    /*
     * 新增员工
     * */
    void insert(Emp emp);

    /**
     * 员工登录
     *
     * @param emp
     * @return
     */
    Emp login(Emp emp);
}
