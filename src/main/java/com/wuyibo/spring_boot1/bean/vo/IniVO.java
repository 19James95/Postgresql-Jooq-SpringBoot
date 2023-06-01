package com.wuyibo.spring_boot1.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IniVO {
    private HashMap<String, HashMap<String, HashMap<String, String>>> data;
}
