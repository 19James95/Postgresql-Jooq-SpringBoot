package com.wuyibo.spring_boot1.bean.vo;


import java.util.HashMap;

public class CourseVO<T> extends BaseDataVo {
    private T data;

    public CourseVO success(T course) {
        this.data = course;
        this.code = "1000";
        this.message = "success";
        return this;
    }

    public CourseVO success() {
        this.code = "1000";
        this.message = "success";
        return this;
    }
}
