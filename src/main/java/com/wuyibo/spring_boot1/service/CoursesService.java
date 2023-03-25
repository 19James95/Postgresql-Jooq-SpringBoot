package com.wuyibo.spring_boot1.service;

import com.wuyibo.db.generate.tables.pojos.Courses;
import com.wuyibo.spring_boot1.bean.bo.CourseBO;
import com.wuyibo.spring_boot1.bean.entity.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


@Service
public class CoursesService extends BaseService {
    private static Logger logger = LoggerFactory.getLogger(CoursesService.class);

    public void upsertCourse(CourseBO course) {
        Integer id = course.getId();
        Course cou = course.getCourse();
        if (id == null) {
            try {
                Courses coursePojo = new Courses();
                BeanUtils.copyProperties(cou, coursePojo);
                coursesDao.insert(coursePojo);
            } catch (Exception e) {
                logger.error("add Course failed!", e);
            }
        } else {
            try {
                Courses coursePojo = new Courses();
                BeanUtils.copyProperties(cou, coursePojo);
                coursesDao.update(coursePojo);
            } catch (Exception e) {
                logger.error("update Course failed!", e);
            }
        }
    }
}
