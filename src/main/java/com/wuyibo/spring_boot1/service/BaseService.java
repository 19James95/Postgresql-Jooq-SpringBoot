package com.wuyibo.spring_boot1.service;

import com.wuyibo.db.generate.tables.daos.CoursesDao;
import com.wuyibo.db.generate.tables.daos.SelectionsDao;
import com.wuyibo.db.generate.tables.daos.StudentsDao;
import com.wuyibo.spring_boot1.config.JooqContextProvider;
import org.springframework.beans.factory.annotation.Autowired;
import com.wuyibo.db.generate.tables.daos.LogDao;

import javax.annotation.PostConstruct;

public class BaseService {
    @Autowired
    JooqContextProvider provider;

    protected StudentsDao studentsDao;
    protected CoursesDao coursesDao;
    protected SelectionsDao selectionsDao;
    protected LogDao logDao;

    @PostConstruct
    public void setCommon () {
        selectionsDao = new SelectionsDao(provider.dslContext().configuration());
        coursesDao = new CoursesDao(provider.dslContext().configuration());
        studentsDao = new StudentsDao(provider.dslContext().configuration());
        logDao = new LogDao(provider.dslContext().configuration());
    }
}
