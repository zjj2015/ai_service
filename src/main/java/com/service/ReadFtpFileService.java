package com.service;

import java.util.List;
import java.util.Map;

public interface ReadFtpFileService {
    public boolean read(String filePath, String user, String passward, String ip, int port, String fileName);

    public boolean readAll(String filePath, String user, String passward, String ip, int port, String fileName1);

    public List<String> getAllFileName(String filePath, String user, String passward, String ip, int port) ;

    String getLastTime(String filePath, String user, String passward, String ip, int port) ;

    Map<String,Object> read2(String filePath, String user, String passward, String ip, int port, String fileName);
}
