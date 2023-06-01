package com.wuyibo.spring_boot1.bean.bo;

import lombok.Data;

@Data
public class GitRepoBO {
    private String url;
    private String branch;
    private String localPath;
}
