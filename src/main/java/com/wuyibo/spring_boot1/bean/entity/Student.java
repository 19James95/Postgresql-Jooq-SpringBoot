package com.wuyibo.spring_boot1.bean.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Student extends AbstractEntity implements Serializable {
    private String name;
    private String gender;
    private String birthdate;
    private int grade;
    private String major;
    private String clazz; // 本科生班级
    private String headteacher; // 本科生班主任
    private String direction; // 研究生研究方向
    private String supervisor; // 研究生导师

    public Student (String name, String gender){
        this.name = name;
        this.gender = gender;
    }
}
