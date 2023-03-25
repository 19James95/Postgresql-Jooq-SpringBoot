package com.wuyibo.spring_boot1.bean.entity;

import lombok.Data;

@Data
public class Selection extends AbstractEntity{
    private Student student;
    private Course course;
    private int grade;
}
