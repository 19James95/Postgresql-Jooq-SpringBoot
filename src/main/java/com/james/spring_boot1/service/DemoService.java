package com.james.spring_boot1.service;

import com.james.spring_boot1.bean.bo.Info;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    public boolean validateInfo(Info info){
        return info != null;
    }
}
