package com.util;

import com.alibaba.excel.EasyExcel;
import com.constant.DataClassEnum;
import com.entity.DemoData;
import com.read.DailyReportListener;
import com.read.DemoDataListener;
import com.read.EvaluationReportListener;
import com.read.StatisReportListener;
import com.service.DailyReportService;
import com.service.EvaluationReportService;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class ReadFtpFile {

    @Autowired
    private EvaluationReportService evaluationReportService;

    @Autowired
    private DailyReportService dailyReportService;

    public boolean read(String filePath, String user, String passward, String ip, int port,String fileName){
        FTPClient ftp = new FTPClient();
        try {
            // 连接ftp服务器
            ftp.connect(ip, port);
            // 登陆
            ftp.login(user, passward);
            // 检验登陆操作的返回码是否正确
            if(!FTPReply.isPositiveCompletion(ftp.getReplyCode())){
                ftp.disconnect();
                return false;
            }

            ftp.enterLocalActiveMode();
            // 设置文件类型为二进制，与ASCII有区别
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            // 设置编码格式
            ftp.setControlEncoding("UTF-8");

            // 提取绝对地址的目录以及文件名
            filePath = filePath.replace("ftp://"+ip+":"+port+"/", "");
            String dir = filePath.substring(0, filePath.lastIndexOf(File.separatorChar));
            String file = filePath.substring(filePath.lastIndexOf(File.separatorChar)+1);

            // 进入文件所在目录，注意编码格式，以能够正确识别中文目录
            ftp.changeWorkingDirectory(new String(dir.getBytes("UTF-8"),FTP.DEFAULT_CONTROL_ENCODING));

            /*FTPFile[] files=ftp.listFiles();
            for(FTPFile file1:files){
                System.out.println(file1.getName());
                String gbk=new String(file1.getName().getBytes("UTF-8"),FTP.DEFAULT_CONTROL_ENCODING);
                String gbk_utf=new String(file1.getName().getBytes("UTF-8"),FTP.DEFAULT_CONTROL_ENCODING);
                String gbk1=new String(file.getBytes("UTF-8"),FTP.DEFAULT_CONTROL_ENCODING);
                System.out.println("gbk_file:"+gbk);
                System.out.println("gbk_utf:"+gbk_utf);
                System.out.println("gbk1:"+gbk1);
                if(file.equals(file1.getName())){
                    System.out.println(file);
                }
            }*/

            // 检验文件是否存在
            InputStream is = ftp.retrieveFileStream(new String(file.getBytes("UTF-8"),FTP.DEFAULT_CONTROL_ENCODING));
            //InputStream is = ftp.retrieveFileStream(file);

            if(is !=null){
                //DataClassEnum dataClassEnum=  DataClassEnum.valueOf(fileName);
                for (DataClassEnum dataClassEnum : DataClassEnum.values()) {
                    if (dataClassEnum.getName().equals(fileName)) {
                        if(dataClassEnum.name().equals("EVALUATION_REPORT")){
                            EasyExcel.read(is, dataClassEnum.getT(), new EvaluationReportListener(evaluationReportService)).sheet().doRead();
                        }else if(dataClassEnum.name().equals("DAILY_REPORT")){
                            EasyExcel.read(is, dataClassEnum.getT(), new DailyReportListener(dailyReportService)).sheet().doRead();
                        }else if(dataClassEnum.name().equals("STATIS_REPORT")){
                            //EasyExcel.read(is, dataClassEnum.getT(), new StatisReportListener()).sheet().doRead();
                        }

                    }
                }

            }


            if(is == null || ftp.getReplyCode() == FTPReply.FILE_UNAVAILABLE){
                return false;
            }

            if(is != null){
                is.close();
                ftp.completePendingCommand();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(ftp != null){
                try {
                    ftp.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
