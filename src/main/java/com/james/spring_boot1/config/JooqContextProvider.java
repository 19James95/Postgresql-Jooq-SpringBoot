package com.james.spring_boot1.config;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class JooqContextProvider {
    @Autowired
    InitConfig initConfig;

    public JooqContextProvider(){
    }

    public DSLContext dslContext(){
        return DSL.using(initConfig.connectionProvider(), SQLDialect.POSTGRES);
    }
}
