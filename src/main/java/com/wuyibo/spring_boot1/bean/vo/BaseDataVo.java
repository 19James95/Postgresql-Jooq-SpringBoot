package com.wuyibo.spring_boot1.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseDataVo {
    String message;
    String code;

    public BaseDataVo success() {
        this.message = "success";
        this.code = "1000";
        return this;
    }
}
