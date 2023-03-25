package com.wuyibo.spring_boot1.service;

import com.wuyibo.spring_boot1.bean.bo.StudentBO;
import com.wuyibo.spring_boot1.config.JooqContextProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentsService {
    @Autowired
    JooqContextProvider provider;

    public void addStudent(StudentBO student) {
        try {
//            provider.dslContext().insertInto()
        } catch (Exception e) {

        }
    }

    public void updateStudent(StudentBO student) {

    }
}
