package com.wuyibo.spring_boot1.controller;

import com.wuyibo.spring_boot1.bean.bo.ProfessionBO;
import com.wuyibo.spring_boot1.bean.vo.BaseDataVo;
import com.wuyibo.spring_boot1.common.BizException;
import com.wuyibo.spring_boot1.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/profession")
public class ProfessionController {

    @Autowired
    ProfessionService service;

    @PostMapping("/add")
    public BaseDataVo add(@RequestBody ProfessionBO professionBO) throws BizException {
        service.addProfession(professionBO);
        return new BaseDataVo("success", "1000");
    }

    @PostMapping("/update")
    public BaseDataVo delete(@RequestBody ProfessionBO professionBO) throws BizException {
        service.updateProfession(professionBO);
        return new BaseDataVo("success", "1000");
    }
}
