package com.entity;

import com.alibaba.excel.annotation.ExcelIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Table(name="statis_report")
public class StatisReport implements Serializable,Cloneable{
    /** 唯一标识 */
    @ExcelIgnore
    private String id ;
    /** 统计日期 */
    private String statisDate ;
    /** 区域 */
    private String centerName ;
    /** 地市 */
    private String areaName ;
    /** 星级 */
    private String userStar ;
    /** 拨打量 */
    private String callNum ;
    /** 客户量 */
    private String custNum ;
    /** 创建人 */
    private String createdBy ;
    /** 创建时间 */
    private Date createdTime ;
    /** 更新人 */
    private String updatedBy ;
    /** 更新时间 */
    private Date updatedTime ;

    /** 唯一标识 */
    public String getId(){
        return this.id;
    }
    /** 唯一标识 */
    public void setId(String id){
        this.id = id;
    }
    /** 统计日期 */
    public String getStatisDate(){
        return this.statisDate;
    }
    /** 统计日期 */
    public void setStatisDate(String statisDate){
        this.statisDate = statisDate;
    }
    /** 区域 */
    public String getCenterName(){
        return this.centerName;
    }
    /** 区域 */
    public void setCenterName(String centerName){
        this.centerName = centerName;
    }
    /** 地市 */
    public String getAreaName(){
        return this.areaName;
    }
    /** 地市 */
    public void setAreaName(String areaName){
        this.areaName = areaName;
    }
    /** 星级 */
    public String getUserStar(){
        return this.userStar;
    }
    /** 星级 */
    public void setUserStar(String userStar){
        this.userStar = userStar;
    }
    /** 拨打量 */
    public String getCallNum(){
        return this.callNum;
    }
    /** 拨打量 */
    public void setCallNum(String callNum){
        this.callNum = callNum;
    }
    /** 客户量 */
    public String getCustNum(){
        return this.custNum;
    }
    /** 客户量 */
    public void setCustNum(String custNum){
        this.custNum = custNum;
    }
    /** 创建人 */
    public String getCreatedBy(){
        return this.createdBy;
    }
    /** 创建人 */
    public void setCreatedBy(String createdBy){
        this.createdBy = createdBy;
    }
    /** 创建时间 */
    public Date getCreatedTime(){
        return this.createdTime;
    }
    /** 创建时间 */
    public void setCreatedTime(Date createdTime){
        this.createdTime = createdTime;
    }
    /** 更新人 */
    public String getUpdatedBy(){
        return this.updatedBy;
    }
    /** 更新人 */
    public void setUpdatedBy(String updatedBy){
        this.updatedBy = updatedBy;
    }
    /** 更新时间 */
    public Date getUpdatedTime(){
        return this.updatedTime;
    }
    /** 更新时间 */
    public void setUpdatedTime(Date updatedTime){
        this.updatedTime = updatedTime;
    }
}
