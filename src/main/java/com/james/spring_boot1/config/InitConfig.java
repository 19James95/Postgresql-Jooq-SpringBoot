package com.james.spring_boot1.config;

import org.jooq.impl.DataSourceConnectionProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class InitConfig {
    private static final Logger logger = LoggerFactory.getLogger(InitConfig.class);

    private final DataSource dataSource;

    public InitConfig(@Qualifier("dataSource") DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public DataSourceConnectionProvider connectionProvider(){
        return new DataSourceConnectionProvider(new TransactionAwareDataSourceProxy(dataSource));
    }
}
