package com.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright: ...
 * Company: bingo
 * Version: 1.0.0
 * Author: lihuanwei
 * Date: 2019/12/16
 * Description:
 */
public class TxtUtils {

    public static List<String> txt2String(File file){
        List<String> result = new ArrayList<>();
        InputStreamReader isr;
        try{
            isr = new InputStreamReader(new FileInputStream(file), "utf-8");
            BufferedReader br = new BufferedReader(isr);//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.add(s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }


    public static List<String[]> txt2StringArr(InputStream inputStream){
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
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
