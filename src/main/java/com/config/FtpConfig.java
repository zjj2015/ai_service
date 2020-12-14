package com.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "ftp")
@Data
public class FtpConfig {
    /**
     * ip
     */
    private String ftpHost;

    /**
     * 端口
     */
    private int ftpPort;

    /**
     * 用户名
     */
    private String ftpUserName;

    /**
     * 密码
     */
    private String ftpPassword;

    /**
     * ftp文件位置
     */
    private String ftpPath;

    /**
     * 本地文件位置
     */
    private String localPath;

    private List<String> excelFileName;

    private List<String> txtFileName;
}
