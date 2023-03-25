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
    private final String ADD = "/add";
    private final String UPDATE = "/update";
    private final String GET_COURSE = "/course/{id}";
    private final String GET_COURSES = "/";

    @PostMapping(ADD)
    @APILog
    public CourseVO addStudent(@RequestBody CourseBO course) {
        service.addCourse(course);
        return new CourseVO().success();
    }

    @PostMapping(UPDATE)
    @APILog
    public CourseVO updateStudent(@RequestBody CourseBO course) {
        service.updateCourse(course);
        return new CourseVO().success();
    }

}
