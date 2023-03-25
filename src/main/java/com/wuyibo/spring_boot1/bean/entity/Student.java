package com.wuyibo.spring_boot1.bean.entity;

import lombok.Data;

@Data
public class Student extends AbstractEntity{
    private String name;
    private String gender;
    private String birthdate;
    private int grade;
    private String major;
    private String clazz; // 本科生班级
    private String headteacher; // 本科生班主任
    private String direction; // 研究生研究方向
    private String supervisor; // 研究生导师
}
