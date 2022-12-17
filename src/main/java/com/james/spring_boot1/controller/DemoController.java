package com.james.spring_boot1.controller;

import com.james.spring_boot1.bean.bo.demo.InfoBO;
import com.james.spring_boot1.bean.vo.BaseDataVo;
import com.james.spring_boot1.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/app")
public class DemoController {


    @Autowired
    DemoService demoService;

    @RequestMapping("/send-info")
    public BaseDataVo InsertInfo(@RequestBody InfoBO info){
        demoService.insertInfo(info);
        return new BaseDataVo("update success","201");
    }

}
