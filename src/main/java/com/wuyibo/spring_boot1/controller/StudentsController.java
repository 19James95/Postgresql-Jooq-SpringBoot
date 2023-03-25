package com.wuyibo.spring_boot1.controller;

import com.wuyibo.spring_boot1.bean.bo.StudentBO;
import com.wuyibo.spring_boot1.bean.vo.StudentVO;
import com.wuyibo.spring_boot1.common.APILog;
import com.wuyibo.spring_boot1.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/students")
public class StudentsController {

    @Autowired
    private StudentsService service;
    private final String ADD = "/add";
    private final String UPDATE = "/update";
    private final String GET_STUDENT = "/student/{id}";
    private final String GET_STUDENTS = "/";

    @PostMapping(ADD)
    @APILog
    public StudentVO addStudent(@RequestBody StudentBO student) {
        service.addStudent(student);
        return new StudentVO().success();
    }

    @PostMapping(UPDATE)
    @APILog
    public StudentVO updateStudent(@RequestBody StudentBO student) {
        service.updateStudent(student);
        return new StudentVO().success();
    }
}
