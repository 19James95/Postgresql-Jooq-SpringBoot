package com.wuyibo.spring_boot1.common;

import com.wuyibo.spring_boot1.config.JooqContextProvider;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Aspect
@Component
public class LogAspect {

    @Autowired
    JooqContextProvider provider;
    private static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(com.wuyibo.spring_boot1.common.APILog)")
    public void APILogCut() {}

    @AfterReturning(pointcut = "APILogCut()", returning = "returnValue")
    public void doAfter (JoinPoint joinPoint, Object returnValue) {
        try {
//            provider.dslContext().insertInto(insertInto)
        } catch (Exception e) {
            logger.error("Decode Response error");
        }
    }
}

