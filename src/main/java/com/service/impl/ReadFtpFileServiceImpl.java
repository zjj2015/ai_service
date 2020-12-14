package com.service.impl;

import com.alibaba.excel.EasyExcel;
import com.constant.DataClassEnum;
import com.entity.EvaluationReport;
import com.entity.TaskMark;
import com.read.DailyReportListener;
import com.read.EvaluationReportListener;
import com.read.StatisReportListener;
import com.service.*;
import com.util.TxtUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ReadFtpFileServiceImpl implements ReadFtpFileService {

    @Autowired
    private EvaluationReportService evaluationReportService;
    @Autowired
    private DailyReportService dailyReportService;

    @Autowired
    private StatisReportService statisReportService;

    @Autowired
    private TbRpCtVonaClzrgDayService tbRpCtVonaClzrgDayService;

    @Autowired
    private TbRpCtVonaJtmy200DtDayService tbRpCtVonaJtmy200DtDayService;

    @Autowired
    private TbRpCtVonaMergesStaDayService tbRpCtVonaMergesStaDayService;

    @Autowired
    private TaskMarkService taskMarkService;



    @Override
    public boolean read(String filePath, String user, String passward, String ip, int port, String fileName1) {
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
            String pwd = ftp.printWorkingDirectory();

//            FTPFile[] files=ftp.listFiles();
//            for(FTPFile file1:files){
//               // System.out.println(file1.getName());
//                String gbk=new String(file1.getName().getBytes(FTP.DEFAULT_CONTROL_ENCODING),"UTF-8");
//                String gbk_utf=new String(file1.getName().getBytes("UTF-8"),FTP.DEFAULT_CONTROL_ENCODING);
//                String gbk1=new String(file.getBytes("UTF-8"),FTP.DEFAULT_CONTROL_ENCODING);
//                System.out.println("gbk_file:"+gbk);
//              //  System.out.println("gbk_utf:"+gbk_utf);
//               // System.out.println("gbk1:"+gbk1);
////               if(file.equals(file1.getName())){
////                    System.out.println(file);
////                }
//            }

            // 检验文件是否存在
            InputStream is = ftp.retrieveFileStream(new String(file.getBytes("UTF-8"),FTP.DEFAULT_CONTROL_ENCODING));
            //InputStream is = ftp.retrieveFileStream(file);

            if(is !=null){
                String ext="";
                String fileName="";
                if(fileName1.contains(".")){
                    fileName=fileName1.split("\\.")[0];
                    ext=fileName1.split("\\.")[1];
                }
                if(ext.equals("xls") || ext.equals("xlsx") || ext.equals("csv")){   //处理excel数据
                    for (DataClassEnum dataClassEnum : DataClassEnum.values()) {
                        if (fileName.contains(dataClassEnum.getName())) {
                            if(dataClassEnum.name().equals("EVALUATION_REPORT")){
                                int n=evaluationReportService.selectCount();
                               // if(n==0){
                                    EasyExcel.read(is, dataClassEnum.getT(), new EvaluationReportListener(evaluationReportService)).sheet().doRead();
                               // }
                            }else if(dataClassEnum.name().equals("DAILY_REPORT")){
                                int n=dailyReportService.selectCount();
                               // if(n==0){
                                    EasyExcel.read(is, dataClassEnum.getT(), new DailyReportListener(dailyReportService)).sheet().headRowNumber(4).doRead();
                               // }
                            }else if(dataClassEnum.name().equals("STATIS_REPORT")){
                                int n=statisReportService.selectCount();
                               // if(n==0){
                                    EasyExcel.read(is, dataClassEnum.getT(), new StatisReportListener(statisReportService)).sheet().doRead();
                               // }
                            }
                        }
                    }
                }else if(ext.equals("txt")){   //处理txt数据
                    List<String[]> data= TxtUtils.txt2StringArr(is);
                    if(fileName.contains("tb_rp_ct_vona_clzrg_day")){
                        /*int n=tbRpCtVonaClzrgDayService.selectCount();
                        if(n==0){
                            tbRpCtVonaClzrgDayService.save(data);
                        }*/
                        tbRpCtVonaClzrgDayService.save(data);
                    }else if(fileName.contains("tb_rp_ct_vona_jtmy_200_dt_day")){
                        /*int n=tbRpCtVonaJtmy200DtDayService.selectCount();
                        if(n==0){
                            tbRpCtVonaJtmy200DtDayService.save(data);
                        }*/
                        tbRpCtVonaJtmy200DtDayService.save(data);
                    }else if(fileName.contains("tb_rp_ct_vona_merges_sta_day")){
                        /*int n=tbRpCtVonaMergesStaDayService.selectCount();
                        if(n==0){
                            tbRpCtVonaMergesStaDayService.save(data);
                        }*/
                        tbRpCtVonaMergesStaDayService.save(data);
                    }



                    /*Map map=null;
                   if(data!=null && data.size()>0){
                           for(String[] s:data){
                               map=new HashMap<>();
                               map.put("statis_date",s[0]);
                               map.put("center_name",s[1]);
                               map.put("area_name",s[2]);
                               map.put("user_star",s[3]);
                               map.put("call_num",s[4]);
                               map.put("cust_num",s[5]);
                               Map<String, Object> columnMap = new HashMap<>();
                               columnMap.put("columnMap", map);
                               statisReportService.insertByMap(columnMap);
                           }
                   }*/
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



    @Override
    public boolean readAll(String filePath, String user, String passward, String ip, int port, String fileName1) {
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

            // 检验文件是否存在
            InputStream is = ftp.retrieveFileStream(new String(file.getBytes("UTF-8"),FTP.DEFAULT_CONTROL_ENCODING));
            //InputStream is = ftp.retrieveFileStream(file);

            if(is !=null){
                String ext="";
                String fileName="";
                if(fileName1.contains(".")){
                    fileName=fileName1.split("\\.")[0];
                    ext=fileName1.split("\\.")[1];
                }
                if(ext.equals("xls") || ext.equals("xlsx") || ext.equals("csv")){   //处理excel数据
                    for (DataClassEnum dataClassEnum : DataClassEnum.values()) {
                        if (fileName.contains(dataClassEnum.getName())) {
                            if(dataClassEnum.name().equals("EVALUATION_REPORT")){
                                /*int n=evaluationReportService.selectCount();
                                if(n==0){
                                    EasyExcel.read(is, dataClassEnum.getT(), new EvaluationReportListener(evaluationReportService)).sheet().doRead();
                                }*/
                                EasyExcel.read(is, dataClassEnum.getT(), new EvaluationReportListener(evaluationReportService)).sheet().doRead();
                            }else if(dataClassEnum.name().equals("DAILY_REPORT")){
                               /* int n=dailyReportService.selectCount();
                                if(n==0){
                                    EasyExcel.read(is, dataClassEnum.getT(), new DailyReportListener(dailyReportService)).sheet().headRowNumber(4).doRead();
                                }*/
                                EasyExcel.read(is, dataClassEnum.getT(), new DailyReportListener(dailyReportService)).sheet().headRowNumber(4).doRead();
                            }else if(dataClassEnum.name().equals("STATIS_REPORT")){
                                /*int n=statisReportService.selectCount();
                                if(n==0){
                                    EasyExcel.read(is, dataClassEnum.getT(), new StatisReportListener(statisReportService)).sheet().doRead();
                                }*/
                                EasyExcel.read(is, dataClassEnum.getT(), new StatisReportListener(statisReportService)).sheet().doRead();
                            }
                        }
                    }
                }else if(ext.equals("txt")){   //处理txt数据
                    List<String[]> data= TxtUtils.txt2StringArr(is);
                    if(fileName.contains("tb_rp_ct_vona_clzrg_day")){
                        /*int n=tbRpCtVonaClzrgDayService.selectCount();
                        if(n==0){
                            tbRpCtVonaClzrgDayService.save(data);
                        }*/
                        tbRpCtVonaClzrgDayService.save(data);
                    }else if(fileName.contains("tb_rp_ct_vona_jtmy_200_dt_day")){
                        /*int n=tbRpCtVonaJtmy200DtDayService.selectCount();
                        if(n==0){
                            tbRpCtVonaJtmy200DtDayService.save(data);
                        }*/
                        tbRpCtVonaJtmy200DtDayService.save(data);
                    }else if(fileName.contains("tb_rp_ct_vona_merges_sta_day")){
                        /*int n=tbRpCtVonaMergesStaDayService.selectCount();
                        if(n==0){
                            tbRpCtVonaMergesStaDayService.save(data);
                        }*/
                        tbRpCtVonaMergesStaDayService.save(data);
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

    @Override
    public List<String> getAllFileName(String filePath, String user, String passward, String ip, int port) {
        FTPClient ftp = new FTPClient();
        List<String> names=new ArrayList<>();
        try {
            // 连接ftp服务器
            ftp.connect(ip, port);
            // 登陆
            ftp.login(user, passward);
            // 检验登陆操作的返回码是否正确
            if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
                ftp.disconnect();
            }

            ftp.enterLocalActiveMode();
            // 设置文件类型为二进制，与ASCII有区别
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            // 设置编码格式
            ftp.setControlEncoding("UTF-8");

            // 提取绝对地址的目录以及文件名
            filePath = filePath.replace("ftp://" + ip + ":" + port + "/", "");
            String dir = filePath.substring(0, filePath.lastIndexOf(File.separatorChar));
            //String file = filePath.substring(filePath.lastIndexOf(File.separatorChar)+1);

            // 进入文件所在目录，注意编码格式，以能够正确识别中文目录
            ftp.changeWorkingDirectory(new String(dir.getBytes("UTF-8"), FTP.DEFAULT_CONTROL_ENCODING));
            InputStream is = null;
            FTPFile[] files = ftp.listFiles();

            for (FTPFile file1 : files) {  //遍历所有文件
                names.add(file1.getName());
            }
        }catch (Exception e) {
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
        return names;
    }

    @Override
    public String getLastTime(String filePath, String user, String passward, String ip, int port) {
        FTPClient ftp = new FTPClient();
        List<String> names=new ArrayList<>();
        String lastTime="";
        long lastModifyTime=0;
        SimpleDateFormat sdf =  new SimpleDateFormat( "yyyy-MM-dd HH:mm");
        try {
            // 连接ftp服务器
            ftp.connect(ip, port);
            // 登陆
            ftp.login(user, passward);
            // 检验登陆操作的返回码是否正确
            if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
                ftp.disconnect();
            }

            ftp.enterLocalActiveMode();
            // 设置文件类型为二进制，与ASCII有区别
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            // 设置编码格式
            ftp.setControlEncoding("UTF-8");

            // 提取绝对地址的目录以及文件名
            filePath = filePath.replace("ftp://" + ip + ":" + port + "/", "");
            String dir = filePath.substring(0, filePath.lastIndexOf(File.separatorChar));
            //String file = filePath.substring(filePath.lastIndexOf(File.separatorChar)+1);

            // 进入文件所在目录，注意编码格式，以能够正确识别中文目录
            ftp.changeWorkingDirectory(new String(dir.getBytes("UTF-8"), FTP.DEFAULT_CONTROL_ENCODING));
            InputStream is = null;
            FTPFile[] files = ftp.listFiles();

            for (FTPFile file1 : files) {  //遍历所有文件

               long lastModifyTime1 =file1.getTimestamp().getTimeInMillis()+file1.getTimestamp().getTimeZone().getOffset(0);
                if(lastModifyTime1>lastModifyTime){
                    lastModifyTime=file1.getTimestamp().getTimeInMillis()+file1.getTimestamp().getTimeZone().getOffset(0);
                }

            }
        }catch (Exception e) {
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

        lastTime=sdf.format(new Date(lastModifyTime));
        System.out.println("lastModifyTime"+lastTime);
        return lastTime;
    }

    @Override
    public Map<String,Object> read2(String filePath, String user, String passward, String ip, int port,String fileName) {
        //定时任务最后获取的文件上传时间
        String lastUploadTime=taskMarkService.selectLastUploadTime();
        //ftp文件最近上传时间
        String newTime=getLastTime(filePath,user,passward,ip,port);
        SimpleDateFormat sdf =  new SimpleDateFormat( "yyyy-MM-dd HH:mm");
        Map<String,Object> map=new HashMap<>();
        try{
            Date date=sdf.parse(lastUploadTime);
            if(lastUploadTime.compareTo(newTime)<0){  //lastUploadTime<newTime
                map= readFile(filePath,user,passward,ip,port,fileName,date.getTime(),newTime);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return map;
    }


    public Map<String,Object> readFile(String filePath, String user, String passward, String ip, int port,String fileName1,long lastUploadTime,String newTimeStr) {
        FTPClient ftp = new FTPClient();
        Map<String,Object> map=new HashMap<>();
        try {
            // 连接ftp服务器
            ftp.connect(ip, port);
            // 登陆
            ftp.login(user, passward);
            // 检验登陆操作的返回码是否正确
            if(!FTPReply.isPositiveCompletion(ftp.getReplyCode())){
                ftp.disconnect();
                //return false;
            }

            ftp.enterLocalActiveMode();
            // 设置文件类型为二进制，与ASCII有区别
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            // 设置编码格式
            ftp.setControlEncoding("UTF-8");

            // 提取绝对地址的目录以及文件名
            filePath = filePath.replace("ftp://"+ip+":"+port+"/", "");
            String dir = filePath.substring(0, filePath.lastIndexOf(File.separatorChar));


            // 进入文件所在目录，注意编码格式，以能够正确识别中文目录
            ftp.changeWorkingDirectory(new String(dir.getBytes("UTF-8"),FTP.DEFAULT_CONTROL_ENCODING));
            String pwd = ftp.printWorkingDirectory();

            FTPFile[] files=ftp.listFiles();
            String ext="";
            String fileName="";
            if(fileName1.contains(".")){
                fileName=fileName1.split("\\.")[0];
                ext=fileName1.split("\\.")[1];
            }
            //SimpleDateFormat sdf =  new SimpleDateFormat( "yyyy-MM-dd HH:mm");
            int num=0; //记录入口文件数量
            String uploadFileName="";
            for(FTPFile file1:files){
               if(file1.getName().contains(fileName)){
                   long newTime =file1.getTimestamp().getTimeInMillis()+file1.getTimestamp().getTimeZone().getOffset(0);
                   if(lastUploadTime<newTime){  //ftp文件上传时间大于任务记录时间，则进行数据入库
                       String statisDate=file1.getName().split("_")[file1.getName().split("_").length-1];
                       statisDate=statisDate.split("\\.")[0];
                       // 检验文件是否存在
                       filePath=filePath+file1.getName();
                       String file = filePath.substring(filePath.lastIndexOf(File.separatorChar)+1);
                       InputStream is = ftp.retrieveFileStream(new String(file.getBytes("UTF-8"),FTP.DEFAULT_CONTROL_ENCODING));
                       filePath="";
                       //InputStream is = ftp.retrieveFileStream(file);
                       if(is !=null){
                           if(ext.equals("xls") || ext.equals("xlsx") || ext.equals("csv")){   //处理excel数据
                               for (DataClassEnum dataClassEnum : DataClassEnum.values()) {
                                   if (fileName.contains(dataClassEnum.getName())) {
                                       if(dataClassEnum.name().equals("EVALUATION_REPORT")){
                                          // int n=evaluationReportService.selectCount();
                                           evaluationReportService.delete(statisDate);
                                           // if(n==0){
                                           EasyExcel.read(is, dataClassEnum.getT(), new EvaluationReportListener(evaluationReportService)).sheet().doRead();
                                           // }
                                           num++;
                                           uploadFileName+=file1.getName()+",";
                                       }else if(dataClassEnum.name().equals("DAILY_REPORT")){
                                           //int n=dailyReportService.selectCount();
                                           dailyReportService.delete(statisDate);
                                           // if(n==0){
                                           EasyExcel.read(is, dataClassEnum.getT(), new DailyReportListener(dailyReportService)).sheet().headRowNumber(4).doRead();
                                           // }
                                           num++;
                                           uploadFileName+=file1.getName()+",";
                                       }else if(dataClassEnum.name().equals("STATIS_REPORT")){
                                           //int n=statisReportService.selectCount();
                                           statisReportService.delete(statisDate);
                                           // if(n==0){
                                           EasyExcel.read(is, dataClassEnum.getT(), new StatisReportListener(statisReportService)).sheet().doRead();
                                           // }
                                           num++;
                                           uploadFileName+=file1.getName()+",";
                                       }
                                   }
                               }
                           }else if(ext.equals("txt")){   //处理txt数据
                               //List<String[]> data= TxtUtils.txt2StringArr(is);
                               if(fileName.contains("tb_rp_ct_vona_clzrg_day")){
                                   tbRpCtVonaClzrgDayService.delete(statisDate);
                                   txt2StringArr(is,fileName);
                                   num++;
                                   uploadFileName+=file1.getName()+",";
                               }else if(fileName.contains("tb_rp_ct_vona_jtmy_200_dt_day")){
                                   tbRpCtVonaJtmy200DtDayService.delete(statisDate);
                                   txt2StringArr(is,fileName);
                                   num++;
                                   uploadFileName+=file1.getName()+",";
                               }else if(fileName.contains("tb_rp_ct_vona_merges_sta_day")){
                                   tbRpCtVonaMergesStaDayService.delete(statisDate);
                                   txt2StringArr(is,fileName);
                                   num++;
                                   uploadFileName+=file1.getName()+",";
                               }
                           }


                       }


                       if(is == null || ftp.getReplyCode() == FTPReply.FILE_UNAVAILABLE){
                           //return false;
                       }

                       if(is != null){
                           is.close();
                           ftp.completePendingCommand();
                       }
                       //return true;
                   }
               }
            }
            /*if(num>0){
                if(!StringUtils.isEmpty(uploadFileName)){
                    uploadFileName=uploadFileName.substring(0,uploadFileName.length()-1);
                }

            }*/
            map.put("num",num);
            map.put("uploadFileName",uploadFileName);

            //return true;


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
        return map;
    }


    public void txt2StringArr(InputStream inputStream,String fileName){
        //List<String[]> result = new ArrayList<>();
         int BATCH_COUNT = 1000;
        List<String[]> result = new ArrayList<>();

        InputStreamReader isr;
        try{
            isr = new InputStreamReader(inputStream, "utf-8");
            BufferedReader br = new BufferedReader(isr);//构造一个BufferedReader类来读取文件
            String s = null;
            //int i=0;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                /*if(i==0){   //去掉第一行标题
                    i=1;
                    continue;
                }*/
                String[] arr = s.split("&");
                result.add(arr);
                // 达到BATCH_COUNT了，需要去存储一次数据库，防止内存溢出
                if (result.size() >= BATCH_COUNT) {
                    if(fileName.contains("tb_rp_ct_vona_clzrg_day")){
                        tbRpCtVonaClzrgDayService.save(result);
                    }else if(fileName.contains("tb_rp_ct_vona_jtmy_200_dt_day")){
                        tbRpCtVonaJtmy200DtDayService.save(result);
                    }else if(fileName.contains("tb_rp_ct_vona_merges_sta_day")){
                        tbRpCtVonaMergesStaDayService.save(result);
                    }
                    // 存储完成清理 list
                    result.clear();
                }
            }
            //处理size小于BATCH_COUNT部分
            if(result!=null && result.size()>0){
                if(fileName.contains("tb_rp_ct_vona_clzrg_day")){
                    tbRpCtVonaClzrgDayService.save(result);
                }else if(fileName.contains("tb_rp_ct_vona_jtmy_200_dt_day")){
                    tbRpCtVonaJtmy200DtDayService.save(result);
                }else if(fileName.contains("tb_rp_ct_vona_merges_sta_day")){
                    tbRpCtVonaMergesStaDayService.save(result);
                }
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        long lastModifyTime= 1594627923000L;

        Date date= new Date(lastModifyTime);
        SimpleDateFormat sdf =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
    }
}
