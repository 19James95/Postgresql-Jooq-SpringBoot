package com.wuyibo.spring_boot1.bean.bo;

import lombok.Data;

import java.util.List;

@Data
public class IniBO {
    private String name;
    private List<Seg> data;

    @Data
    public static class Seg {
        private String seg;
        private String content;
    }
}
