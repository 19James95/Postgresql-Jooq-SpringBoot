package com.wuyibo.spring_boot1.service;

import com.wuyibo.db.generate.tables.pojos.Students;
import com.wuyibo.spring_boot1.bean.bo.StudentBO;
import com.wuyibo.spring_boot1.bean.entity.Student;

import com.wuyibo.spring_boot1.common.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.wuyibo.spring_boot1.bean.ex.ResponseCode;

@Service
public class StudentsService extends BaseService {
    private static Logger logger = LoggerFactory.getLogger(StudentsService.class);

    public void upsertStudent(StudentBO student) throws BizException {
        Student stu = student.getStudent();
        if (student.getId() == null) {
            try {
                Students studentPojo = new Students();
                BeanUtils.copyProperties(stu, studentPojo);
                studentsDao.insert(studentPojo);
            } catch (Exception e) {
                logger.error("add student failed");
                throw new BizException(ResponseCode.STUDENT_ADD_EX);
            }
        } else {
            try {
                Students studentPojo = new Students();
                BeanUtils.copyProperties(stu, studentPojo);
                studentsDao.update(studentPojo);
            } catch (Exception e) {
                logger.error("update student failed");
                throw new BizException(ResponseCode.STUDENT_UPDATE_EX);

            }
        }
    }
}
