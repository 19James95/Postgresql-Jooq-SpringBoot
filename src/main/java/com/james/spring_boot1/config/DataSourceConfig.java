package com.james.spring_boot1.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.yaml")
public class DataSourceConfig {

    public static final String TM = "transactionManager";

    @Bean
    public PlatformTransactionManager transactionManager (
        @Autowired
        @Qualifier("dataSource")
        DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public DataSource dataSource(
        @Value("${spring.datasource.username}")
                String userName,
        @Value("${spring.datasource.password}")
                String password,
        @Value("${spring.datasource.url}")
                String url
        ){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(userName);
        config.setPassword(password);

        return new TransactionAwareDataSourceProxy(new HikariDataSource(config));
    }
}
