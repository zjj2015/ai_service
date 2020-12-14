package com.tool;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class BaseController {

    public String toJson(Object obj) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().disableHtmlEscaping().create();

        String strReturn = gson.toJson(obj);
        return strReturn;
    }

    /**
     * 根据传入日期获取上一年月份时间
     * @param startTime
     * @return
     */
    public String toLastYearforMonthData(String startTime) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String  month="";
        try {
            Date date = sdf.parse(startTime);
            c.setTime(date);
            c.add(Calendar.YEAR, -1);
            Date y = c.getTime();
             month = format.format(y);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return month;
    }

    /**
     * 根据传入日期获取上一月时间
     * @param startTime
     * @return
     */
    public String toLastMonthData(String startTime) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String  month="";
        try {
            Date date = sdf.parse(startTime);
            c.setTime(date);
            c.add(Calendar.MONTH, -1);
            Date y = c.getTime();
            month = format.format(y);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return month;
    }

    /**
     * 将字符串解析成数组
     * @param param
     * @return
     */
    public List<String> getManyParams(String param) {
        return StringUtils.isEmpty(param) ? null : Arrays.asList(param.split(","));
    }

    /**
     * 获取UUID
     * @return
     */
    public String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 获取上一年度
     */
    public String toLastYear (String thisDate){

        String lastYear = String.valueOf(Integer.parseInt(thisDate.substring(0,4)) - 1);


        return lastYear;
    }


//    获取传入时间前几个月时间
    public static Date stepMonth(Date sourceDate, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(sourceDate);
        c.add(Calendar.MONTH, month);

        return c.getTime();
    }

    //    获取当前年
    public  static  int getYear(){
        Calendar c = Calendar.getInstance();
        int year =c.get(Calendar.YEAR);
        return year;
    }


    /**
     * 根据传入日期昨天
     * @param
     * @return
     */
    public Date toLastDayData() {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date d = cal.getTime();
        return  d;

    }



    /**
     * 根据传入日期获取上一年月份时间
     * @param startTime
     * @return
     */
    public String toLastYearforDayData(String startTime) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String  month="";
        try {
            Date date = sdf.parse(startTime);
            c.setTime(date);
            c.add(Calendar.YEAR, -1);
            Date y = c.getTime();
            month = format.format(y);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return month;
    }


}
