package com.wuyibo.spring_boot1.bean.bo;

import lombok.Data;

@Data
public class ProfessionBO extends BaseBO {
    private String name;
    private Integer deleted;
}
