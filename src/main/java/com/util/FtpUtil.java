package com.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
import java.net.SocketException;

public class FtpUtil {
    private final static Log logger = LogFactory.getLog(FtpUtil.class);

    /**
     * 获取FTPClient对象
     *
     * @param ftpHost
     *            FTP主机服务器
     * @param ftpPassword
     *            FTP 登录密码
     * @param ftpUserName
     *            FTP登录用户名
     * @param ftpPort
     *            FTP端口 默认为21
     * @return
     */
    public static FTPClient getFTPClient(String ftpHost, String ftpUserName,
                                         String ftpPassword, int ftpPort) {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient = new FTPClient();
            ftpClient.connect(ftpHost, ftpPort);// 连接FTP服务器
            ftpClient.login(ftpUserName, ftpPassword);// 登陆FTP服务器
            if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                logger.info("未连接到FTP，用户名或密码错误。");
                ftpClient.disconnect();
            } else {
                logger.info("FTP连接成功。");
            }
        } catch (SocketException e) {
            e.printStackTrace();
            logger.error("FTP的IP地址可能错误，请正确配置。");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("FTP的端口错误,请正确配置。");
        }
        return ftpClient;
    }

    /**
     * 上传文件
     *
     * @param ftpHost ftp服务器地址
     * @param ftpUserName anonymous匿名用户登录，不需要密码。administrator指定用户登录
     * @param ftpPassword 指定用户密码
     * @param ftpPort ftp服务员器端口号
     * @param ftpPath  ftp文件存放物理路径
     * @param fileName 文件路径
     * @param input 文件输入流，即从本地服务器读取文件的IO输入流
     */
    public static void uploadFile(String ftpHost, String ftpUserName,
                                  String ftpPassword, int ftpPort, String ftpPath,
                                  String fileName, InputStream input){
        FTPClient ftp=null;
        try {
            ftp=getFTPClient(ftpHost, ftpUserName, ftpPassword, ftpPort);
            ftp.changeWorkingDirectory(ftpPath);
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            fileName=new String(fileName.getBytes("GBK"),"iso-8859-1");
            ftp.storeFile(fileName, input);
            input.close();
            ftp.logout();
            System.out.println("upload succes!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
