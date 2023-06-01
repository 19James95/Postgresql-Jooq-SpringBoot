package com.wuyibo.spring_boot1.controller;

import com.wuyibo.spring_boot1.bean.bo.ProfessionBO;
import com.wuyibo.spring_boot1.bean.bo.SchoolBO;
import com.wuyibo.spring_boot1.bean.vo.BaseDataVo;
import com.wuyibo.spring_boot1.common.BizException;
import com.wuyibo.spring_boot1.service.ProfessionService;
import com.wuyibo.spring_boot1.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/school")
public class SchoolController {
    @Autowired
    SchoolService service;
    @PostMapping("/add")
    public BaseDataVo add(@RequestBody SchoolBO schoolBO) throws BizException {
        service.addSchool(schoolBO);
        return new BaseDataVo("success", "1000");
    }

    @PostMapping("/update")
    public BaseDataVo delete(@RequestBody SchoolBO schoolBO) throws BizException {
        service.updateSchool(schoolBO);
        return new BaseDataVo("success", "1000");
    }
}
