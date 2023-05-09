package com.lubb.mapper;

import com.lubb.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper   //运行时，框架自动生成实现类对象，交给IOC容器管理
public interface UserMapper {
    //查询全部用户信息
    @Select("select * from user")
    public List<User> list();
}
