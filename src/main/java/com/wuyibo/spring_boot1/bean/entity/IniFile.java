package com.wuyibo.spring_boot1.bean.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IniFile{
    private String section;
    private String key;
    private String value;
}
