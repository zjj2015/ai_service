package com.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Table(name="tb_rp_ct_vona_jtmy_200_dt_day")
public class TbRpCtVonaJtmy200DtDay implements Serializable,Cloneable{
    /** 统计日期 */
    private String statisDate ;
    /** 统计编码 */
    private String pCode ;
    /** 统计名称 */
    private String pName ;
    /** 调研触发量 */
    private String cfCnt ;
    /** 回复量 */
    private String hfCnt ;
    /** 听不懂我说的话(回复量) */
    private String hf1Cnt ;
    /** 提示语太长(回复量) */
    private String hf2Cnt ;
    /** 回答错误(回复量) */
    private String hf3Cnt ;
    /** 答非所问(回复量) */
    private String hf4Cnt ;
    /** 参评率(%) */
    private String cpRat ;
    /**  */
    private String q1 ;
    /**  */
    private String score1 ;
    /** 整体满意度评分 */
    private String score1Avg ;
    /**  */
    private String q2 ;
    /**  */
    private String score2 ;
    /**  */
    private String score2Avg ;
    /**  */
    private String q3 ;
    /**  */
    private String score3 ;
    /**  */
    private String score3Avg ;
    /**  */
    private String q4 ;
    /**  */
    private String score4 ;
    /** 自助服务使用体验评分 */
    private String score4Avg ;
    /** 整体满意度(%) */
    private String score1My ;
    /**  */
    private String score2My ;
    /**  */
    private String score3My ;
    /** 自助服务使用体验满意度(%) */
    private String score4My ;
    /**  */
    private String statisType ;
    /** 创建人 */
    private String createdBy ;
    /** 创建时间 */
    private Date createdTime ;
    /** 更新人 */
    private String updatedBy ;
    /** 更新时间 */
    private Date updatedTime ;

    /** 统计日期 */
    public String getStatisDate(){
        return this.statisDate;
    }
    /** 统计日期 */
    public void setStatisDate(String statisDate){
        this.statisDate = statisDate;
    }
    /** 统计编码 */
    public String getPCode(){
        return this.pCode;
    }
    /** 统计编码 */
    public void setPCode(String pCode){
        this.pCode = pCode;
    }
    /** 统计名称 */
    public String getPName(){
        return this.pName;
    }
    /** 统计名称 */
    public void setPName(String pName){
        this.pName = pName;
    }
    /** 调研触发量 */
    public String getCfCnt(){
        return this.cfCnt;
    }
    /** 调研触发量 */
    public void setCfCnt(String cfCnt){
        this.cfCnt = cfCnt;
    }
    /** 回复量 */
    public String getHfCnt(){
        return this.hfCnt;
    }
    /** 回复量 */
    public void setHfCnt(String hfCnt){
        this.hfCnt = hfCnt;
    }
    /** 听不懂我说的话(回复量) */
    public String getHf1Cnt(){
        return this.hf1Cnt;
    }
    /** 听不懂我说的话(回复量) */
    public void setHf1Cnt(String hf1Cnt){
        this.hf1Cnt = hf1Cnt;
    }
    /** 提示语太长(回复量) */
    public String getHf2Cnt(){
        return this.hf2Cnt;
    }
    /** 提示语太长(回复量) */
    public void setHf2Cnt(String hf2Cnt){
        this.hf2Cnt = hf2Cnt;
    }
    /** 回答错误(回复量) */
    public String getHf3Cnt(){
        return this.hf3Cnt;
    }
    /** 回答错误(回复量) */
    public void setHf3Cnt(String hf3Cnt){
        this.hf3Cnt = hf3Cnt;
    }
    /** 答非所问(回复量) */
    public String getHf4Cnt(){
        return this.hf4Cnt;
    }
    /** 答非所问(回复量) */
    public void setHf4Cnt(String hf4Cnt){
        this.hf4Cnt = hf4Cnt;
    }
    /** 参评率(%) */
    public String getCpRat(){
        return this.cpRat;
    }
    /** 参评率(%) */
    public void setCpRat(String cpRat){
        this.cpRat = cpRat;
    }
    /**  */
    public String getQ1(){
        return this.q1;
    }
    /**  */
    public void setQ1(String q1){
        this.q1 = q1;
    }
    /**  */
    public String getScore1(){
        return this.score1;
    }
    /**  */
    public void setScore1(String score1){
        this.score1 = score1;
    }
    /** 整体满意度评分 */
    public String getScore1Avg(){
        return this.score1Avg;
    }
    /** 整体满意度评分 */
    public void setScore1Avg(String score1Avg){
        this.score1Avg = score1Avg;
    }
    /**  */
    public String getQ2(){
        return this.q2;
    }
    /**  */
    public void setQ2(String q2){
        this.q2 = q2;
    }
    /**  */
    public String getScore2(){
        return this.score2;
    }
    /**  */
    public void setScore2(String score2){
        this.score2 = score2;
    }
    /**  */
    public String getScore2Avg(){
        return this.score2Avg;
    }
    /**  */
    public void setScore2Avg(String score2Avg){
        this.score2Avg = score2Avg;
    }
    /**  */
    public String getQ3(){
        return this.q3;
    }
    /**  */
    public void setQ3(String q3){
        this.q3 = q3;
    }
    /**  */
    public String getScore3(){
        return this.score3;
    }
    /**  */
    public void setScore3(String score3){
        this.score3 = score3;
    }
    /**  */
    public String getScore3Avg(){
        return this.score3Avg;
    }
    /**  */
    public void setScore3Avg(String score3Avg){
        this.score3Avg = score3Avg;
    }
    /**  */
    public String getQ4(){
        return this.q4;
    }
    /**  */
    public void setQ4(String q4){
        this.q4 = q4;
    }
    /**  */
    public String getScore4(){
        return this.score4;
    }
    /**  */
    public void setScore4(String score4){
        this.score4 = score4;
    }
    /** 自助服务使用体验评分 */
    public String getScore4Avg(){
        return this.score4Avg;
    }
    /** 自助服务使用体验评分 */
    public void setScore4Avg(String score4Avg){
        this.score4Avg = score4Avg;
    }
    /** 整体满意度(%) */
    public String getScore1My(){
        return this.score1My;
    }
    /** 整体满意度(%) */
    public void setScore1My(String score1My){
        this.score1My = score1My;
    }
    /**  */
    public String getScore2My(){
        return this.score2My;
    }
    /**  */
    public void setScore2My(String score2My){
        this.score2My = score2My;
    }
    /**  */
    public String getScore3My(){
        return this.score3My;
    }
    /**  */
    public void setScore3My(String score3My){
        this.score3My = score3My;
    }
    /** 自助服务使用体验满意度(%) */
    public String getScore4My(){
        return this.score4My;
    }
    /** 自助服务使用体验满意度(%) */
    public void setScore4My(String score4My){
        this.score4My = score4My;
    }
    /**  */
    public String getStatisType(){
        return this.statisType;
    }
    /**  */
    public void setStatisType(String statisType){
        this.statisType = statisType;
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
