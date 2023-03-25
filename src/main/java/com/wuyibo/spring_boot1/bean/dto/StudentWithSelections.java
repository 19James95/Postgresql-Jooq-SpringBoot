package com.wuyibo.spring_boot1.bean.dto;

import lombok.Data;
import com.wuyibo.db.generate.tables.pojos.Selections;

import java.util.List;

@Data
public class StudentWithSelections {
    private String studentName;
    private List<Selections> selectionList;
}
