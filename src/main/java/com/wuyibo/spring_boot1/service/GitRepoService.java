package com.wuyibo.spring_boot1.service;

import com.google.gson.JsonObject;
import com.wuyibo.spring_boot1.bean.bo.GitRepoBO;
import com.wuyibo.spring_boot1.bean.bo.IniBO;
import com.wuyibo.spring_boot1.bean.entity.IniFile;
import com.wuyibo.spring_boot1.bean.ex.ResponseCode;
import com.wuyibo.spring_boot1.common.BizException;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.ini4j.Ini;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.attribute.PosixFilePermission;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class GitRepoService {
    private static final String TOKEN = "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";

    public void copyRepo(GitRepoBO gitRepoBO) throws BizException, IOException {
        try {
            Git.cloneRepository()
                    .setCredentialsProvider(new UsernamePasswordCredentialsProvider(TOKEN, ""))
                    .setBranch(gitRepoBO.getBranch() == null ? "master" : gitRepoBO.getBranch())
                    .setURI(gitRepoBO.getUrl())
                    .setDirectory(new File(gitRepoBO.getLocalPath()))
                    .call();
        } catch (GitAPIException e) {
            e.printStackTrace();
            throw new BizException(ResponseCode.GIT_REPO_COPY_EX);
        }

        Set<PosixFilePermission> per = new HashSet<>();
        per.add(PosixFilePermission.GROUP_EXECUTE);
        per.add(PosixFilePermission.GROUP_WRITE);
        per.add(PosixFilePermission.GROUP_READ);
        per.add(PosixFilePermission.OWNER_READ);
        per.add(PosixFilePermission.OWNER_EXECUTE);
        per.add(PosixFilePermission.OWNER_WRITE);
        per.add(PosixFilePermission.OTHERS_READ);
        per.add(PosixFilePermission.OTHERS_EXECUTE);
        per.add(PosixFilePermission.OTHERS_WRITE);

        File file = new File(gitRepoBO.getLocalPath());

        File file1 = new File(file, "conf.ini");
        System.out.println(file1.exists());
        changePermissions(file);
    }

    public void changePermissions(File folder) {
        if (!folder.exists()) {
            return;
        }
        try {
            if (folder.isDirectory()) {
                // 修改文件夹权限
                folder.setExecutable(false);
                folder.setReadable(false);
                folder.setWritable(false);

                // 递归进入子文件夹修改权限
                File[] files = folder.listFiles();
                if (files != null) {
                    for (File file : files) {
                        changePermissions(file);
                    }
                }
            } else {
                // 修改文件权限
                folder.setExecutable(false);
                folder.setReadable(false);
                folder.setWritable(false);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void createIni(IniBO iniBO) {
        List<IniFile> fileContent = parseIniSourceData(iniBO.getData());
        iniWrite(fileContent);
    }

    private List<IniFile> parseIniSourceData(List<IniBO.Seg> data) {
        ArrayList<IniFile> iniSeg = new ArrayList<>();
        data.forEach(it -> {
            String content = it.getContent();
            String seg = it.getSeg();
            String replace = content.replace("{", "").replace("}", "");
            String[] split = replace.split(",");
            for (String s : split) {
                String[] kv = s.split(":");
                String k = kv[0].replace("\"", "");
                String v = kv[1].trim().replace("\"", "");
                IniFile iniFile = new IniFile();
                iniFile.setSection(seg);
                iniFile.setKey(k);
                iniFile.setValue(v);
                iniSeg.add(iniFile);
            }
        });
        return iniSeg;
    }

    private void iniWrite(List<IniFile> fileContent) {
        try {
            File file = new File("C:\\jianhe3\\code\\Postgresql-Jooq-SpringBoot\\src\\main\\resources\\conf2.ini");
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            Ini ini = new Ini();
            ini.load(file);
            fileContent.stream().forEach((seg) -> {
                ini.add(seg.getSection(), seg.getKey(), seg.getValue() == null ? "" : seg.getValue());
            });
            //将文件内容保存到文件中
            ini.store(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, HashMap<String, HashMap<String, String>>> readIni(String path) throws IOException {
        File file = new File("C:\\jianhe3\\code\\Postgresql-Jooq-SpringBoot\\src\\main\\resources\\conf2.ini");
        Ini ini = new Ini();
        ini.load(file);
        HashMap<String, HashMap<String,HashMap<String, String>>> result = new HashMap<>();
        HashMap<String, HashMap<String, String>> map1 = new HashMap<>();
        ini.forEach((k,v) -> {
            HashMap<String, String> m1 = new HashMap<>(v);
            map1.put(k,m1);
        });
        result.put("data", map1);
        result.put("data2", map1);
        return result;
    }

    public void findFiles() throws IOException {
        try {
            URL url = new URL("https://api.github.com/repos/19James95/Postgresql-Jooq-SpringBoot/contents");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            InputStream inputStream = con.getInputStream();
            String result = new BufferedReader(new InputStreamReader(inputStream))
                    .lines().collect(Collectors.joining("\n"));
            JsonObject jsonObject = new JsonObject();
            JsonObject asJsonObject = jsonObject.getAsJsonObject(result);
            String content = asJsonObject.get("content").getAsString();
            System.out.println(content);

            System.out.println("Response Code for " + url.getHost() + " : " + responseCode);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
