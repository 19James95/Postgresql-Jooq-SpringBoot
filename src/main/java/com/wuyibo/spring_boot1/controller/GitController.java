package com.wuyibo.spring_boot1.controller;

import com.wuyibo.spring_boot1.bean.bo.GitRepoBO;
import com.wuyibo.spring_boot1.bean.bo.IniBO;
import com.wuyibo.spring_boot1.bean.vo.BaseDataVo;
import com.wuyibo.spring_boot1.bean.vo.CourseVO;
import com.wuyibo.spring_boot1.bean.vo.IniVO;
import com.wuyibo.spring_boot1.common.BizException;
import com.wuyibo.spring_boot1.service.GitRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/git")
public class GitController {
    @Autowired
    GitRepoService service;

    @PostMapping("/repo/copy")
    public BaseDataVo copyGitRepo(@RequestBody GitRepoBO gitRepoBO) throws BizException, IOException {
        service.copyRepo(gitRepoBO);
        return new BaseDataVo("1000", "success");
    }

    @PostMapping("/ini/write")
    public BaseDataVo writeIni(@RequestBody IniBO iniBO) {
        service.createIni(iniBO);
        return new BaseDataVo("1000", "success");
    }
    @GetMapping("/ini/read/{path}")
    public IniVO readIni(@PathVariable String path) throws IOException {
        HashMap<String, HashMap<String, HashMap<String, String>>> data = service.readIni(path);
        System.out.println(data);
        return new IniVO(data);
    }

    @GetMapping("/content")
    public BaseDataVo getContent() throws IOException {
        service.findFiles();
        return new BaseDataVo("1000", "success");
    }
}
