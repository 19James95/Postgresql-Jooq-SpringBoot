package com.wuyibo.spring_boot1.service;

import com.wuyibo.db.generate.tables.pojos.Selections;
import com.wuyibo.spring_boot1.bean.bo.SelectionBO;
import com.wuyibo.spring_boot1.bean.dto.CourseWithSelections;
import com.wuyibo.spring_boot1.bean.entity.Course;
import com.wuyibo.spring_boot1.bean.entity.Selection;
import com.wuyibo.spring_boot1.config.JooqContextProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseSelectionService extends BaseService {
    private static Logger logger = LoggerFactory.getLogger(CourseSelectionService.class);
    final JooqContextProvider provider;

    public CourseSelectionService(JooqContextProvider provider) {
        this.provider = provider;
    }

    public void upsertSelection(SelectionBO selection) {
        Integer id = selection.getId();
        Selection sel = selection.getSelection();
        if (id == null) {
            try {
                Selections selectionPojo = new Selections();
                BeanUtils.copyProperties(sel, selectionPojo);
                selectionsDao.insert(selectionPojo);
            } catch (Exception e) {
                logger.error("add selection failed!", e);
            }
        } else {
            try {
                Selections selectionPojo = new Selections();
                BeanUtils.copyProperties(sel, selectionPojo);
                selectionsDao.update(selectionPojo);
            } catch (Exception e) {
                logger.error("update selection failed!", e);
            }
        }
    }

    public List<CourseWithSelections> getSelectionByCourseId() {
        return null;
    }

    public List<CourseWithSelections> getSelectionByStudentId() {
        return null;
    }
}
