package com.wuyibo.spring_boot1.bean.vo;

public class CourseSelectionVO<T> extends BaseDataVo {
    private T data;

    public CourseSelectionVO success(T course) {
        this.data = course;
        this.code = "1000";
        this.message = "success";
        return this;
    }

    public CourseSelectionVO success() {
        this.code = "1000";
        this.message = "success";
        return this;
    }
}
