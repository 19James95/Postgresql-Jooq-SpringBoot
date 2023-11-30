//package com.wuyibo.spring_boot1.common;
//
//import com.google.gson.Gson;
//import com.wuyibo.db.generate.tables.pojos.Log;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Arrays;
//import java.util.HashMap;
//
//
//@Aspect
//@Component
//public class LogAspect extends BaseService {
//
//    @Autowired
//    private Gson gson;
//    private static Logger logger = LoggerFactory.getLogger(LogAspect.class);
//    private HashMap<String, String> context = new HashMap<>();
//
//    private String URL = "url";
//    private final String REQ = "request";
//    private final String RES = "response";
//
//    @Pointcut("@annotation(com.wuyibo.spring_boot1.common.APILog)")
//    public void APILogCut() {}
//
//    @Before("APILogCut()")
//    public void doBefore(JoinPoint joinPoint) {
//        try {
//            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//            if (requestAttributes == null) return;
//            HttpServletRequest request = requestAttributes.getRequest();
//            context.put(URL, request.getRequestURL().toString());
//            Object[] args = joinPoint.getArgs();
//            context.put(REQ, Arrays.toString(args));
//        } catch (Exception e) {
//            logger.error("Decode request failed");
//        }
//    }
//
//    @AfterReturning(pointcut = "APILogCut()", returning = "returnValue")
//    public void doAfter (JoinPoint joinPoint, Object returnValue) {
//        try {
//            String res = gson.toJson(returnValue);
//            Log log = new Log();
//            log.setRequest(context.get(REQ));
//            log.setResponse(res);
//            log.setUrl(context.get(URL));
//            logDao.insert(log);
//        } catch (Exception e) {
//            logger.error("Decode Response error");
//        }
//    }
//}
//
