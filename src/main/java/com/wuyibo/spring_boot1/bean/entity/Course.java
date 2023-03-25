package com.wuyibo.spring_boot1.bean.entity;

import lombok.Data;

@Data
public class Course extends AbstractEntity {
    private String name;
    private String teacher;
    private String info;
    private int credit;
    private int capacity;
    private int selectedNum;
}
