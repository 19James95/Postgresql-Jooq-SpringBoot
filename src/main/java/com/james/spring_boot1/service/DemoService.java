package com.james.spring_boot1.service;

import com.james.spring_boot1.bean.bo.demo.InfoBO;
import com.james.spring_boot1.config.JooqContextProvider;
import org.springframework.stereotype.Service;
import com.james.db.generate.Tables;

@Service
public class DemoService {
    final JooqContextProvider provider;

    public DemoService(JooqContextProvider provider) {
        this.provider = provider;
    }

    public void insertInfo(InfoBO info){
        provider.dslContext().insertInto(Tables.INFO).set(Tables.INFO.AGE, info.getAge())
                .set(Tables.INFO.NAME, info.getName())
                .execute();
    }
}
