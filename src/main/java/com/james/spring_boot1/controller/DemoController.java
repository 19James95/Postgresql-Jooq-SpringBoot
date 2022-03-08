package com.james.spring_boot1.controller;

import com.james.spring_boot1.bean.bo.Info;
import com.james.spring_boot1.bean.vo.BaseDataVo;
import com.james.spring_boot1.service.DemoService;
import com.james.spring_boot1.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/app")
public class DemoController {

    @Autowired
    DemoService validateInfoService;

    @Autowired
    StoreService storeService;

    @RequestMapping("/send-info")
    public BaseDataVo receiveInfo(@RequestBody Info info){
        boolean isValidate = validateInfoService.validateInfo(info);
        if(isValidate){
            Integer integer = storeService.insertRecord(info);
            if(integer == 1 ){
                System.out.println("insert new record successfully");
                return new BaseDataVo("is validate","200");
            }
            return new BaseDataVo("store record failed","202");
        }
        return new BaseDataVo("is not validate","201");
    }

}
