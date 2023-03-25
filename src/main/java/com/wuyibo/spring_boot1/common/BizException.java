package com.wuyibo.spring_boot1.common;


import com.wuyibo.spring_boot1.bean.ex.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BizException extends Exception {
    private static final Logger logger = LoggerFactory.getLogger(BizException.class);
    private String code;
    private String msg;


    public BizException(ResponseCode r) {
        this.code = r.getCode();
        this.msg = r.getMsg();
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    @Override
    public String toString() {
        return "code:" + code + " msg:" +msg;
    }
}
