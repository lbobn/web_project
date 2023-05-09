package com.lubb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id;
    private Integer age;
    private String username;
    private String password;
    private String name;
    private Short gender;
    private String image;
    private Short job;
    private Integer deptId;
    private LocalDate entryDate;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
