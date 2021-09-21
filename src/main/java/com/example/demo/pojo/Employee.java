package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Constructor;
import java.util.Date;

//员工表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;//0是女 1是男

    private Department department;
    private Date birth;



    public Employee(Integer id,String lastName,String email,Integer gender,Department department){
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        //默认创建日期
        this.birth = new Date();
    }


}
