package com.wuyibo.spring_boot1.bean.dto;

import com.wuyibo.spring_boot1.bean.entity.Selection;
import lombok.Data;

import java.util.List;

@Data
public class StudentWithSelections {
    private String studentName;
    private List<Selection> selectionList;
}
