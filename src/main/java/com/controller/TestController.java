package com.controller;

import com.alibaba.excel.EasyExcel;
import com.config.FtpConfig;
import com.entity.TaskMark;
import com.service.ReadFtpFileService;
import com.service.TaskMarkService;
import com.tool.DateUtil;
import com.util.FtpUtil;
import com.util.ReadFtpFile;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    FtpConfig ftpConfig;

    @Autowired
    ReadFtpFileService readFtpFileService;

    @Autowired
    private TaskMarkService taskMarkService;

    @RequestMapping(value = "test")
    public String test(){
        System.out.println("hello...");
        return "test";
    }


    @RequestMapping(value = "getFile")
    @Transactional
    public void getFile(){
        //readFile();
        //getLastTime();
        readFile2();
    }

    public static void main(String[] args) {
        /*SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        Date date=new Date();
        Calendar c=Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH,-2);
        date=c.getTime();
        String str=sdf.format(date);
        System.out.println(str);*/
        /*String fileName="111.txt";
        String[] arr=fileName.split(",");
        for(String str:arr){
            System.out.printf("str:"+str);
        }*/
    }

    public void readFile(){
        List<String> excelFileList=ftpConfig.getExcelFileName();
        //SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        if(excelFileList!=null && excelFileList.size()>0){
            for(String fileName:excelFileList){
                String simpName="";
                String ext="";
                String fullFileName="";
                if(fileName.contains(".")){
                    simpName=fileName.split("\\.")[0];
                    ext=fileName.split("\\.")[1];
                }
                fullFileName=simpName+"_"+ DateUtil.getYesterdayStr()+"."+ext;
                for(int i=20201201;i<=20201207;i++){
                    fullFileName=simpName+"_"+i+"."+ext;
                    String filePath=ftpConfig.getFtpPath() + File.separatorChar + fullFileName;
                    readFtpFileService.read(filePath,ftpConfig.getFtpUserName(),ftpConfig.getFtpPassword(),ftpConfig.getFtpHost(),ftpConfig.getFtpPort(),fullFileName);
                }
               // String filePath=ftpConfig.getFtpPath() + File.separatorChar + fullFileName;
                //readFtpFileService.read(filePath,ftpConfig.getFtpUserName(),ftpConfig.getFtpPassword(),ftpConfig.getFtpHost(),ftpConfig.getFtpPort(),fullFileName);

            }
        }
    }


    public void readAllFile(){
        String filePath=ftpConfig.getFtpPath() + File.separatorChar;
        List<String> names=readFtpFileService.getAllFileName(filePath,ftpConfig.getFtpUserName(),ftpConfig.getFtpPassword(),ftpConfig.getFtpHost(),ftpConfig.getFtpPort());
        for(String fileName:names){
             filePath=ftpConfig.getFtpPath() + File.separatorChar + fileName;
            readFtpFileService.readAll(filePath,ftpConfig.getFtpUserName(),ftpConfig.getFtpPassword(),ftpConfig.getFtpHost(),ftpConfig.getFtpPort(),fileName);
        }
    }

    public String getLastTime(){
        String filePath=ftpConfig.getFtpPath() + File.separatorChar;
       return readFtpFileService.getLastTime(filePath,ftpConfig.getFtpUserName(),ftpConfig.getFtpPassword(),ftpConfig.getFtpHost(),ftpConfig.getFtpPort());
    }


    public void readFile2(){
        List<String> excelFileList=ftpConfig.getExcelFileName();
        //SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        Map<String,String> mark=new HashMap<>();
        int num=0;
        Set<String> set=new HashSet<>();
        String uploadFileName="";
        if(excelFileList!=null && excelFileList.size()>0) {
            for (String fileName : excelFileList) {
                String simpName = "";
                String ext = "";
                String fullFileName = "";
                /*if (fileName.contains(".")) {
                    simpName = fileName.split("\\.")[0];
                   // ext = fileName.split("\\.")[1];
                }*/
                fullFileName = fileName;
                String filePath = ftpConfig.getFtpPath() + File.separatorChar;
                Map<String,Object> map=readFtpFileService.read2(filePath, ftpConfig.getFtpUserName(), ftpConfig.getFtpPassword(), ftpConfig.getFtpHost(), ftpConfig.getFtpPort(),fullFileName);
                if(map!=null && map.size()>0){
                    num+=Integer.parseInt(map.get("num").toString());
                    uploadFileName+=map.get("uploadFileName").toString();
                }
            }
        }

        if(num>0){
            //保存记录
            String newTimeStr=getLastTime();
            TaskMark taskMark=new TaskMark();
            taskMark.setUploadTime(newTimeStr);
            taskMark.setUploadNum(num+"");
            if(!StringUtils.isEmpty(uploadFileName)){
                uploadFileName=uploadFileName.substring(0,uploadFileName.length()-1);
                taskMark.setUploadFileName(uploadFileName);
            }
            taskMarkService.insert(taskMark);
            String[] fileNames=uploadFileName.split(",");
            if(fileNames!=null && fileNames.length>0){
                for(String name:fileNames){
                    String statisDate=name.split("_")[name.split("_").length-1];
                    statisDate=statisDate.split("\\.")[0];
                    set.add(statisDate);

                }
                if(set!=null && set.size()>0){
                    for(String str:set){
                        taskMarkService.callYydhStatis(str);
                    }
                }
            }
        }
    }
}
