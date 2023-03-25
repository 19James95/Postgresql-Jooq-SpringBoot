package com.wuyibo.spring_boot1.bean.dto;

import lombok.Data;

import java.util.List;
import com.wuyibo.db.generate.tables.pojos.Selections;

@Data
public class CourseWithSelections {
    private String courseName;
    private List<Selections> selectionList;
}
