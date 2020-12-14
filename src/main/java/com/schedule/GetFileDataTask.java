package com.schedule;

import com.config.FtpConfig;
import com.entity.TaskMark;
import com.service.ReadFtpFileService;
import com.service.TaskMarkService;
import com.tool.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class GetFileDataTask {

    @Autowired
    FtpConfig ftpConfig;

    @Autowired
    ReadFtpFileService readFtpFileService;

    @Autowired
    private TaskMarkService taskMarkService;

    //@Scheduled(cron = "${task.corn1}")
    public void run(){
        System.out.println("******** job start******");
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
            String filePath=ftpConfig.getFtpPath() + File.separatorChar;
            String newTimeStr=readFtpFileService.getLastTime(filePath,ftpConfig.getFtpUserName(),ftpConfig.getFtpPassword(),ftpConfig.getFtpHost(),ftpConfig.getFtpPort());
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
        System.out.println("******** job end******");

    }
}
