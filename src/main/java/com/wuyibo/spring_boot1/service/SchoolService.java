package com.wuyibo.spring_boot1.service;

import com.wuyibo.db.generate.Tables;
import com.wuyibo.spring_boot1.bean.bo.SchoolBO;
import com.wuyibo.spring_boot1.bean.ex.ResponseCode;
import com.wuyibo.spring_boot1.common.BizException;
import com.wuyibo.spring_boot1.config.JooqContextProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.wuyibo.db.generate.tables.pojos.Students;

import java.util.List;

@Service
public class SchoolService {
    @Autowired
    JooqContextProvider provider;
    public void addSchool(SchoolBO schoolBO) throws BizException {
        try {
            provider.dslContext().insertInto(Tables.SCHOOL).set(Tables.SCHOOL.DELETED, 0).set(Tables.SCHOOL.NAME, schoolBO.getName()).execute();
        } catch (Exception e) {
            throw new BizException(ResponseCode.SCHOOL_ADD_EX);
        }
    }

    @Transactional
    public void updateSchool(SchoolBO schoolBO) throws BizException {
        try {
            provider.dslContext().update(Tables.PROFESSION)
                    .set(Tables.PROFESSION.DELETED, schoolBO.getDeleted())
                    .set(Tables.PROFESSION.NAME, schoolBO.getName())
                    .where(Tables.PROFESSION.ID.eq(schoolBO.getId()))
                    .execute();

        } catch (Exception e) {
            throw new BizException(ResponseCode.SCHOOL_UPDATE_EX);
        }
    }
}
