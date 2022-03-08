package com.james.spring_boot1.service;

import com.james.db.generate.Tables;
import com.james.db.generate.tables.daos.UserInfoDao;
import com.james.spring_boot1.bean.bo.Info;
import com.james.spring_boot1.config.JooqContextProvider;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    @Autowired
    JooqContextProvider jooqContextProvider;

    UserInfoDao userInfoDao;

    public Integer insertRecord(Info info){
        DSLContext dslContext = jooqContextProvider.dslContext();
        return dslContext.insertInto(Tables.USER_INFO)
                .set(Tables.USER_INFO.AGE,info.getAge())
                .set(Tables.USER_INFO.ID,info.getId())
                .set(Tables.USER_INFO.NAME,info.getName())
                .execute();
    }
}
