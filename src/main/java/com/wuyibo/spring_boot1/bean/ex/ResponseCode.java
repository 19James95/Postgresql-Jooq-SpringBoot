package com.wuyibo.spring_boot1.bean.ex;

public enum ResponseCode {

    STUDENT_ADD_EX("10001", "add student failed"),
    STUDENT_UPDATE_EX("10002", "update student failed"),
    COURSE_ADD_EX("20001", "add course failed"),
    COURSE_UPDATE_EX("20002", "update course failed"),
    SELECTION_ADD_EX("30001", "add selection failed"),
    SELECTION_UPDATE_EX("30002", "update selection failed"),
    SELECTION_GET_BY_STUDENT_EX("30003", "get selection by student failed"),
    SELECTION_GET_BY_COURSE_EX("30004", "get selection by course failed");


    private String code;
    private String msg;
    ResponseCode (String code, String msg) {
        this.code = code;
        this.msg =msg;
    }

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }
}
