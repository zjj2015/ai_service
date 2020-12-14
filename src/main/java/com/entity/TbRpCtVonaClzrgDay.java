package com.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Table(name="tb_rp_ct_vona_clzrg_day")
public class TbRpCtVonaClzrgDay implements Serializable,Cloneable{
    /** 统计日期 */
    private String statisDate ;
    /** 省份编码 */
    private String provCode ;
    /** 省份名称 */
    private String provName ;
    /** 策略包名称 */
    private String packageName ;
    /** 策略名称 */
    private String ruleName ;
    /** 策略类型 */
    private String typeNm ;
    /** 导航满意度 */
    private String dhMyRat ;
    /** 策略转人工接通量 */
    private String dhZrgCnt ;
    /** 策略转人工办理量 */
    private String dhZrgblCnt ;
    /** 人工办理转化率 */
    private String dhZrgblRat ;
    /** 人工服务满意度 */
    private String rgMyRat ;
    /** 人工服务平均通话时长 */
    private String rgThtimeAvg ;
    /** 策略调用量 */
    private String ruleCnt ;
    /** 人工服务请求量 */
    private String agentReqNum ;
    /** 策略转人工办理流水量 */
    private String dhZrgblAllCnt ;
    /** 人工办理成单率 */
    private String dhZrgblAllRat ;
    /** 导航场景测评整体满意度 */
    private String score1My ;
    /** 自助服务使用体验满意度 */
    private String score4My ;
    /** 人工场景式测评整体满意度 */
    private String pfZt ;
    /** 话务员服务态度满意度 */
    private String fwtdmyd ;
    /** 话务员服务能力满意度 */
    private String fwnlmyd ;
    /** 问题解决情况满意度 */
    private String wtjjmyd ;
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
    /** 省份编码 */
    public String getProvCode(){
        return this.provCode;
    }
    /** 省份编码 */
    public void setProvCode(String provCode){
        this.provCode = provCode;
    }
    /** 省份名称 */
    public String getProvName(){
        return this.provName;
    }
    /** 省份名称 */
    public void setProvName(String provName){
        this.provName = provName;
    }
    /** 策略包名称 */
    public String getPackageName(){
        return this.packageName;
    }
    /** 策略包名称 */
    public void setPackageName(String packageName){
        this.packageName = packageName;
    }
    /** 策略名称 */
    public String getRuleName(){
        return this.ruleName;
    }
    /** 策略名称 */
    public void setRuleName(String ruleName){
        this.ruleName = ruleName;
    }
    /** 策略类型 */
    public String getTypeNm(){
        return this.typeNm;
    }
    /** 策略类型 */
    public void setTypeNm(String typeNm){
        this.typeNm = typeNm;
    }
    /** 导航满意度 */
    public String getDhMyRat(){
        return this.dhMyRat;
    }
    /** 导航满意度 */
    public void setDhMyRat(String dhMyRat){
        this.dhMyRat = dhMyRat;
    }
    /** 策略转人工接通量 */
    public String getDhZrgCnt(){
        return this.dhZrgCnt;
    }
    /** 策略转人工接通量 */
    public void setDhZrgCnt(String dhZrgCnt){
        this.dhZrgCnt = dhZrgCnt;
    }
    /** 策略转人工办理量 */
    public String getDhZrgblCnt(){
        return this.dhZrgblCnt;
    }
    /** 策略转人工办理量 */
    public void setDhZrgblCnt(String dhZrgblCnt){
        this.dhZrgblCnt = dhZrgblCnt;
    }
    /** 人工办理转化率 */
    public String getDhZrgblRat(){
        return this.dhZrgblRat;
    }
    /** 人工办理转化率 */
    public void setDhZrgblRat(String dhZrgblRat){
        this.dhZrgblRat = dhZrgblRat;
    }
    /** 人工服务满意度 */
    public String getRgMyRat(){
        return this.rgMyRat;
    }
    /** 人工服务满意度 */
    public void setRgMyRat(String rgMyRat){
        this.rgMyRat = rgMyRat;
    }
    /** 人工服务平均通话时长 */
    public String getRgThtimeAvg(){
        return this.rgThtimeAvg;
    }
    /** 人工服务平均通话时长 */
    public void setRgThtimeAvg(String rgThtimeAvg){
        this.rgThtimeAvg = rgThtimeAvg;
    }
    /** 策略调用量 */
    public String getRuleCnt(){
        return this.ruleCnt;
    }
    /** 策略调用量 */
    public void setRuleCnt(String ruleCnt){
        this.ruleCnt = ruleCnt;
    }
    /** 人工服务请求量 */
    public String getAgentReqNum(){
        return this.agentReqNum;
    }
    /** 人工服务请求量 */
    public void setAgentReqNum(String agentReqNum){
        this.agentReqNum = agentReqNum;
    }
    /** 策略转人工办理流水量 */
    public String getDhZrgblAllCnt(){
        return this.dhZrgblAllCnt;
    }
    /** 策略转人工办理流水量 */
    public void setDhZrgblAllCnt(String dhZrgblAllCnt){
        this.dhZrgblAllCnt = dhZrgblAllCnt;
    }
    /** 人工办理成单率 */
    public String getDhZrgblAllRat(){
        return this.dhZrgblAllRat;
    }
    /** 人工办理成单率 */
    public void setDhZrgblAllRat(String dhZrgblAllRat){
        this.dhZrgblAllRat = dhZrgblAllRat;
    }
    /** 导航场景测评整体满意度 */
    public String getScore1My(){
        return this.score1My;
    }
    /** 导航场景测评整体满意度 */
    public void setScore1My(String score1My){
        this.score1My = score1My;
    }
    /** 自助服务使用体验满意度 */
    public String getScore4My(){
        return this.score4My;
    }
    /** 自助服务使用体验满意度 */
    public void setScore4My(String score4My){
        this.score4My = score4My;
    }
    /** 人工场景式测评整体满意度 */
    public String getPfZt(){
        return this.pfZt;
    }
    /** 人工场景式测评整体满意度 */
    public void setPfZt(String pfZt){
        this.pfZt = pfZt;
    }
    /** 话务员服务态度满意度 */
    public String getFwtdmyd(){
        return this.fwtdmyd;
    }
    /** 话务员服务态度满意度 */
    public void setFwtdmyd(String fwtdmyd){
        this.fwtdmyd = fwtdmyd;
    }
    /** 话务员服务能力满意度 */
    public String getFwnlmyd(){
        return this.fwnlmyd;
    }
    /** 话务员服务能力满意度 */
    public void setFwnlmyd(String fwnlmyd){
        this.fwnlmyd = fwnlmyd;
    }
    /** 问题解决情况满意度 */
    public String getWtjjmyd(){
        return this.wtjjmyd;
    }
    /** 问题解决情况满意度 */
    public void setWtjjmyd(String wtjjmyd){
        this.wtjjmyd = wtjjmyd;
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
