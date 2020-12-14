package com.tool;

import com.alibaba.fastjson.JSON;   //引入fastjson依赖
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName HttpClientUtil
 * @Description TODO
 * @Author baishui
 * @Date 2019/11/13 16:50
 * @Version 1.0
 **/
public class HttpClientUtil {

    private static String username = "jsc"; //用户名
    private static String password = "jsc123.cn"; //密码
    private static String charset = "UTF-8";   //字符集
    private static String token = getToken();  //获取token
    private static final String validUrl = "http://10.53.127.113:99/sunrun-api/login"; //验证url

    /**
     *   @description   Post请求方法
     *   @param    urlParam 接口地址
     *   @param    params 请求参数
     *   @return   String json字符串
     **/
    public static String sendPost(String urlParam, Map<String,Object> params ){
        StringBuffer resultBuffer = null;
        HttpURLConnection con = null;
        BufferedReader br = null;
        PrintWriter out = null;
        try {
            if(token!=null)
                urlParam = urlParam+"?token="+token;
            URL url = new URL(urlParam);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);
            setConnect(con);
            out = new PrintWriter(con.getOutputStream());
            String queryJson = JSON.toJSONString(params);
            out.print(queryJson);
            out.flush();
            resultBuffer = new StringBuffer();
            br = new BufferedReader(new InputStreamReader((con.getInputStream()),charset));
            String temp;
            while ((temp = br.readLine())!=null){
                resultBuffer.append(temp);
            }
        }  catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(out!=null) {
                out.close();
            }
            if(br!=null){
                try {br.close();} catch (IOException e) {e.printStackTrace();}
            }
            if(con!=null){
                con.disconnect();
            }
        }
        return resultBuffer.toString();
    }

    /**
     *   @description   Get请求方法
     *   @param    urlParam 接口地址
     *   @param    params 请求参数
     *   @return   String json字符串
     **/
    public static String sendGet(String urlParam, Map<String,Object> params){
        StringBuffer resultBuffer = null;
        HttpURLConnection con = null;
        BufferedReader br = null;
        try {
            StringBuilder sbParams = new StringBuilder();
            if(params!=null&&params.size()>0) {
                for(Map.Entry<String,Object> e:params.entrySet()){
                    sbParams.append(e.getKey());
                    sbParams.append("=");
                    String value = URLEncoder.encode(e.getValue().toString(), "UTF-8");
                    sbParams.append(value);
                    sbParams.append("&");
                }
            }
            if(token!=null)
                urlParam = urlParam+"?token="+token+"&"+sbParams.substring(0,sbParams.length()-1);
            else {
                urlParam = urlParam + "?" + sbParams.substring(0, sbParams.length() - 1);
            }
            URL url = new URL(urlParam);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            setConnect(con);
            resultBuffer = new StringBuffer();
            br = new BufferedReader(new InputStreamReader((con.getInputStream()),charset));
            String temp;
            while ((temp = br.readLine())!=null){
                resultBuffer.append(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br!=null) {
                try { br.close(); } catch (IOException e) {e.printStackTrace();}
            }
            if(con!=null){
                con.disconnect();
            }
        }
        return resultBuffer.toString();
    }

    private static String getToken(){
        Map<String,Object> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        String result = sendPost(validUrl,map);
        Map<String , Object> map2 = (Map<String, Object>) JSONObject.parse(result);
        Map<String , Object> map3 = (Map<String, Object>) JSONObject.parse(map2.get("content").toString());
        return map3.get("token").toString();
    }

    private static  void setConnect(HttpURLConnection connection) {
        if(connection!=null) {
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.setRequestProperty("Accept", "*/*");
            connection.setRequestProperty("Connection", "keep-alive");
            connection.setRequestProperty("Content-Type", "application/json");
        }
    }
}
