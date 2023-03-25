package com.wuyibo.spring_boot1.controller;

import com.wuyibo.spring_boot1.bean.bo.SelectionBO;
import com.wuyibo.spring_boot1.bean.dto.CourseWithSelections;
import com.wuyibo.spring_boot1.bean.dto.StudentWithSelections;
import com.wuyibo.spring_boot1.bean.vo.CourseSelectionVO;
import com.wuyibo.spring_boot1.common.APILog;
import com.wuyibo.spring_boot1.common.BizException;
import com.wuyibo.spring_boot1.service.CourseSelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/selections")
public class SelectionController {
    @Autowired
    private CourseSelectionService service;
    private final String UPSERT = "/upsert";

    private final String GET_SELECTION_BY_COURSE = "/course/{id}";
    private final String GET_SELECTION_BY_STUDENT = "/student/{id}";

    @PostMapping(UPSERT)
    @APILog
    public CourseSelectionVO addStudent(@RequestBody SelectionBO selection) throws BizException {
        service.upsertSelection(selection);
        return new CourseSelectionVO().success();
    }

    @GetMapping(GET_SELECTION_BY_COURSE)
    public CourseSelectionVO getSelectionByCourseId(@PathVariable Integer id) throws BizException {
        CourseWithSelections selections = service.getSelectionByCourseId(id);
        return new CourseSelectionVO().success(selections);
    }

    @GetMapping(GET_SELECTION_BY_STUDENT)
    public CourseSelectionVO getSelectionByStudentId(@PathVariable Integer id) throws BizException {
        StudentWithSelections selections = service.getSelectionByStudentId(id);
        return new CourseSelectionVO().success(selections);
    }
}
