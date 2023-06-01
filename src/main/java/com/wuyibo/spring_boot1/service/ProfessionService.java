package com.wuyibo.spring_boot1.service;

import com.wuyibo.db.generate.Tables;
import com.wuyibo.spring_boot1.bean.bo.ProfessionBO;
import com.wuyibo.spring_boot1.bean.ex.ResponseCode;
import com.wuyibo.spring_boot1.common.BizException;
import com.wuyibo.spring_boot1.config.JooqContextProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfessionService {
    @Autowired
    JooqContextProvider provider;

    public void addProfession(ProfessionBO professionBO) throws BizException {
        try {
            provider.dslContext().insertInto(Tables.PROFESSION)
                    .set(Tables.PROFESSION.DELETED, 0)
                    .set(Tables.PROFESSION.NAME, professionBO.getName())
                    .execute();
        } catch (Exception e) {
            throw new BizException(ResponseCode.PROFESSION_ADD_EX);
        }
    }

    @Transactional
    public void updateProfession(ProfessionBO professionBO) throws BizException {
        try {
            provider.dslContext().update(Tables.PROFESSION)
                    .set(Tables.PROFESSION.DELETED, professionBO.getDeleted())
                    .set(Tables.PROFESSION.NAME, professionBO.getName())
                    .where(Tables.PROFESSION.ID.eq(professionBO.getId()))
                    .execute();
        } catch (Exception e) {
            throw new BizException(ResponseCode.PROFESSION_UPDATE_EX);
        }
    }
}
