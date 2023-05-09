package com.lubb.mapper;


import com.lubb.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface EmpMapper {

    //根据ID删除数据
    @Delete("delete from emp where id=#{id}")   //根据id删除员工信息，预编译方式，通过？占位
    public void delete1(Integer id);
//    public int delete(Integer id);

    @Delete("delete from emp where id=${id}")   //根据id删除员工信息,拼接方式，会有SQL注入风险
    public void delete2(Integer id);

    //插入数据
    @Options(keyProperty = "id", useGeneratedKeys = true)  //keyProperty :封装到哪个属性，useGeneratedKeys：拿到生成的主键值
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            " VALUES (#{username},#{name},#{gender},#{image},#{job},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    public void insert(Emp emp);

    //更新数据
    @Update("update emp set username=#{username},name=#{name},gender=#{gender},image=#{image},job=#{job}," +
            "entrydate=#{entryDate},dept_id=#{deptId},update_time=#{updateTime} where id = 19")
    public void update(Emp emp);


    //根据id查询员工
    //@Select("select * from emp where id=#{id}")
    //public Emp getById(Integer id);

    //方案三
    @Select("select * from emp where id=#{id}")
    public Emp getById(Integer id);
    //方案一  起别名
    /*@Select("select id, username, password, name, gender, image, job, entrydate," +
            " dept_id deptId, create_time createTime, update_time updateTime from emp where id=#{id}")
    public Emp getById(Integer id);*/


    //方案二  手动结果映射
    /*@Results({
            @Result(column = "dept_id", property = "deptId"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    @Select("select id, username, password, name, gender, image, job, entrydate," +
            " dept_id deptId, create_time createTime, update_time updateTime from emp where id=#{id}")
    public Emp getById(Integer id);*/


    //条件查询员工
    /*@Select("select * from emp where name like '%${name}%' and gender=#{gender} and entrydate between #{start} and #{end}")
    public List<Emp> list(String name, short gender, LocalDate start, LocalDate end);*/

    // @Select("select * from emp where name like concat('%', #{name}, '%') and gender=#{gender} and entrydate between #{start} and #{end}")
    //public List<Emp> list(String name, short gender, LocalDate start, LocalDate end);

    public List<Emp> list(String name, Short gender, LocalDate start, LocalDate end);

    //动态更新数据

    public void update2(Emp emp);

    //根据id删除员工信息,拼接方式，会有SQL注入风险
    public void deleteByIds(List<Integer> ids);
}
