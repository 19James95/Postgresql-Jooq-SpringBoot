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

    private final String UPSERT = "/upsert";

    @PostMapping(UPSERT)
    @APILog
    public StudentVO addStudent(@RequestBody StudentBO student) {
        service.upsertStudent(student);
        return new StudentVO().success();
    }
}
