package com.wuyibo.spring_boot1.service;

import com.wuyibo.db.generate.tables.pojos.Courses;
import com.wuyibo.db.generate.tables.pojos.Selections;
import com.wuyibo.db.generate.tables.pojos.Students;
import com.wuyibo.spring_boot1.bean.bo.SelectionBO;
import com.wuyibo.spring_boot1.bean.dto.CourseWithSelections;
import com.wuyibo.spring_boot1.bean.dto.StudentWithSelections;
import com.wuyibo.spring_boot1.bean.entity.Course;
import com.wuyibo.spring_boot1.bean.entity.Selection;
import com.wuyibo.spring_boot1.bean.ex.ResponseCode;
import com.wuyibo.spring_boot1.common.BizException;
import com.wuyibo.spring_boot1.config.JooqContextProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseSelectionService extends BaseService {
    private static Logger logger = LoggerFactory.getLogger(CourseSelectionService.class);

    public void upsertSelection(SelectionBO selection) throws BizException {
        Integer id = selection.getId();
        Selection sel = selection.getSelection();
        if (id == null) {
            try {
                Selections selectionPojo = new Selections();
                BeanUtils.copyProperties(sel, selectionPojo);
                selectionsDao.insert(selectionPojo);
            } catch (Exception e) {
                logger.error("add selection failed!", e);
                throw new BizException(ResponseCode.SELECTION_ADD_EX);
            }
        } else {
            try {
                Selections selectionPojo = new Selections();
                BeanUtils.copyProperties(sel, selectionPojo);
                selectionsDao.update(selectionPojo);
            } catch (Exception e) {
                logger.error("update selection failed!", e);
                throw new BizException(ResponseCode.SELECTION_UPDATE_EX);
            }
        }
    }

    public CourseWithSelections getSelectionByCourseId(Integer id) throws BizException {
        try {
            Courses courses = coursesDao.fetchOneById(id);
            List<Selections> selections = selectionsDao.fetchByCourseId(id);
            CourseWithSelections courseWithSelections = new CourseWithSelections();
            courseWithSelections.setCourseName(courses.getName());
            courseWithSelections.setSelectionList(selections);
            return courseWithSelections;
        } catch (Exception e) {
            logger.error("get selections by course id failed");
            throw new BizException(ResponseCode.SELECTION_GET_BY_COURSE_EX);
        }
    }

    public StudentWithSelections getSelectionByStudentId(Integer id) throws BizException {
        try {
            List<Selections> selections = selectionsDao.fetchByStudentId(id);
            Students students = studentsDao.fetchOneById(id);
            StudentWithSelections studentWithSelections = new StudentWithSelections();
            studentWithSelections.setStudentName(students.getName());
            studentWithSelections.setSelectionList(selections);
            return studentWithSelections;
        } catch (Exception e) {
            logger.error("get selections by student failed");
            throw new BizException(ResponseCode.SELECTION_GET_BY_STUDENT_EX);
        }
    }
}
