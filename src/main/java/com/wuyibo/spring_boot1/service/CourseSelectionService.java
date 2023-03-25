package com.wuyibo.spring_boot1.service;

import com.wuyibo.spring_boot1.bean.bo.SelectionBO;
import com.wuyibo.spring_boot1.bean.dto.CourseWithSelections;
import com.wuyibo.spring_boot1.config.JooqContextProvider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseSelectionService {
    final JooqContextProvider provider;

    public CourseSelectionService(JooqContextProvider provider) {
        this.provider = provider;
    }

    public void addSelection(SelectionBO selection) {

    }

    public void updateSelection(SelectionBO selection) {
        System.out.println("hello");
    }

    public List<CourseWithSelections> getSelectionByCourseId() {
        return null;
    }

    public List<CourseWithSelections> getSelectionByStudentId() {
        return null;
    }
}
