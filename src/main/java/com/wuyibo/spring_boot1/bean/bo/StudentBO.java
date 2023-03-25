package com.wuyibo.spring_boot1.bean.bo;

import com.wuyibo.spring_boot1.bean.entity.Student;
import lombok.Data;

@Data
public class StudentBO extends BaseBO{
    private Student student;
}
