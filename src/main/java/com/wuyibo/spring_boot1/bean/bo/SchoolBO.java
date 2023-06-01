package com.wuyibo.spring_boot1.bean.bo;

import lombok.Data;

@Data
public class SchoolBO extends BaseBO{
    private String name;
    private Integer deleted;
}
