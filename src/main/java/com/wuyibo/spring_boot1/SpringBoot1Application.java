package com.wuyibo.spring_boot1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableSwagger2
@EnableScheduling
public class SpringBoot1Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot1Application.class, args);
    }
}
