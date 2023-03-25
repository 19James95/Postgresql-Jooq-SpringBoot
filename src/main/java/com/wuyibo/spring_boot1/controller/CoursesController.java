package com.wuyibo.spring_boot1.controller;

import com.wuyibo.spring_boot1.bean.bo.CourseBO;
import com.wuyibo.spring_boot1.bean.vo.CourseVO;
import com.wuyibo.spring_boot1.common.APILog;
import com.wuyibo.spring_boot1.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "/courses")
public class CoursesController {

    @Autowired
    private CoursesService service;
    private final String UPSERT = "/upsert";

    @PostMapping(UPSERT)
    @APILog
    public CourseVO upsertCourse(@RequestBody CourseBO course) {
        service.upsertCourse(course);
        return new CourseVO().success();
    }
}
