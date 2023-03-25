package com.wuyibo.spring_boot1.bean.entity;

import lombok.Data;

@Data
public class Selection extends AbstractEntity{
    private Integer studentId;
    private Integer courseId;
    private int grade;
}
