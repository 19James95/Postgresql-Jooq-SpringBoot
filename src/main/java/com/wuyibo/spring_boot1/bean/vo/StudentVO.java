package com.wuyibo.spring_boot1.bean.vo;

import lombok.Data;

@Data
public class StudentVO<T> extends BaseDataVo {
    private T data;

    public StudentVO success(T student) {
        this.data = student;
        this.code = "1000";
        this.message = "success";
        return this;
    }

    public StudentVO success() {
        this.code = "1000";
        this.message = "success";
        return this;
    }
}
