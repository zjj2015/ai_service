package com.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Table(name="tb_rp_ct_vona_merges_sta_day")
public class TbRpCtVonaMergesStaDay implements Serializable,Cloneable{
    /** 统计日期 */
    private String statisDate ;
    /** 省份（呼入地） */
    private String provName ;
    /** 省份id（呼入地） */
    private String provCode ;
    /** 入口 */
    private String intrName ;
    /** 入口id */
    private String intrId ;
    /** 出口 */
    private String extName ;
    /** 出口id */
    private String extId ;
    /** 语音导航接通量 */
    private String getNum ;
    /** 导航满意度 */
    private String satifyRate ;
    /** 语音导航首解率 */
    private String sjRate ;
    /** 语音导航服务占比 */
    private String vonaRate ;
    /** 使用客户量 */
    private String userCnt ;
    /** 无声通话量 */
    private String novoCnt ;
    /** 无声通话占比 */
    private String novoRate ;
    /** 导航转人工量 */
    private String trunCnt ;
    /** 导航转人工率 */
    private String trunRate ;
    /** 主动转人工量 */
    private String trunZdCnt ;
    /** 主动转人工率 */
    private String trunZdRate ;
    /** 业务转人工量 */
    private String trunYwCnt ;
    /** 业务转人工率 */
    private String trunYwRate ;
    /** 导航转按键量 */
    private String trunAjCnt ;
    /** 导航转按键占比 */
    private String trunAjRate ;
    /** 超时交互次数 */
    private String timeOutCnt ;
    /** 拒识交互次数 */
    private String refuseCnt ;
    /** 平均通话时长 */
    private String callDurAvg ;
    /** 10086系统呼入量 */
    private String agentGetNum ;
    /** 10086人工服务请求量 */
    private String agentReqNum ;
    /** 策略转人工率 */
    private String trunClRate ;
    /** 策略转人工量 */
    private String trunClCnt ;
    /** 地市编码 */
    private String areaCode ;
    /** 地市名称 */
    private String areaName ;
    /** 星级编码 */
    private String levelId ;
    /** 星级名称 */
    private String levelName ;
    /** 首解量 */
    private String sjCnt ;
    /** 总交互次数 */
    private String zjhCnt ;
    /** 超时交互占比 */
    private String timeOutRate ;
    /** 拒识交互占比 */
    private String refuseRate ;
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
    /** 省份（呼入地） */
    public String getProvName(){
        return this.provName;
    }
    /** 省份（呼入地） */
    public void setProvName(String provName){
        this.provName = provName;
    }
    /** 省份id（呼入地） */
    public String getProvCode(){
        return this.provCode;
    }
    /** 省份id（呼入地） */
    public void setProvCode(String provCode){
        this.provCode = provCode;
    }
    /** 入口 */
    public String getIntrName(){
        return this.intrName;
    }
    /** 入口 */
    public void setIntrName(String intrName){
        this.intrName = intrName;
    }
    /** 入口id */
    public String getIntrId(){
        return this.intrId;
    }
    /** 入口id */
    public void setIntrId(String intrId){
        this.intrId = intrId;
    }
    /** 出口 */
    public String getExtName(){
        return this.extName;
    }
    /** 出口 */
    public void setExtName(String extName){
        this.extName = extName;
    }
    /** 出口id */
    public String getExtId(){
        return this.extId;
    }
    /** 出口id */
    public void setExtId(String extId){
        this.extId = extId;
    }
    /** 语音导航接通量 */
    public String getGetNum(){
        return this.getNum;
    }
    /** 语音导航接通量 */
    public void setGetNum(String getNum){
        this.getNum = getNum;
    }
    /** 导航满意度 */
    public String getSatifyRate(){
        return this.satifyRate;
    }
    /** 导航满意度 */
    public void setSatifyRate(String satifyRate){
        this.satifyRate = satifyRate;
    }
    /** 语音导航首解率 */
    public String getSjRate(){
        return this.sjRate;
    }
    /** 语音导航首解率 */
    public void setSjRate(String sjRate){
        this.sjRate = sjRate;
    }
    /** 语音导航服务占比 */
    public String getVonaRate(){
        return this.vonaRate;
    }
    /** 语音导航服务占比 */
    public void setVonaRate(String vonaRate){
        this.vonaRate = vonaRate;
    }
    /** 使用客户量 */
    public String getUserCnt(){
        return this.userCnt;
    }
    /** 使用客户量 */
    public void setUserCnt(String userCnt){
        this.userCnt = userCnt;
    }
    /** 无声通话量 */
    public String getNovoCnt(){
        return this.novoCnt;
    }
    /** 无声通话量 */
    public void setNovoCnt(String novoCnt){
        this.novoCnt = novoCnt;
    }
    /** 无声通话占比 */
    public String getNovoRate(){
        return this.novoRate;
    }
    /** 无声通话占比 */
    public void setNovoRate(String novoRate){
        this.novoRate = novoRate;
    }
    /** 导航转人工量 */
    public String getTrunCnt(){
        return this.trunCnt;
    }
    /** 导航转人工量 */
    public void setTrunCnt(String trunCnt){
        this.trunCnt = trunCnt;
    }
    /** 导航转人工率 */
    public String getTrunRate(){
        return this.trunRate;
    }
    /** 导航转人工率 */
    public void setTrunRate(String trunRate){
        this.trunRate = trunRate;
    }
    /** 主动转人工量 */
    public String getTrunZdCnt(){
        return this.trunZdCnt;
    }
    /** 主动转人工量 */
    public void setTrunZdCnt(String trunZdCnt){
        this.trunZdCnt = trunZdCnt;
    }
    /** 主动转人工率 */
    public String getTrunZdRate(){
        return this.trunZdRate;
    }
    /** 主动转人工率 */
    public void setTrunZdRate(String trunZdRate){
        this.trunZdRate = trunZdRate;
    }
    /** 业务转人工量 */
    public String getTrunYwCnt(){
        return this.trunYwCnt;
    }
    /** 业务转人工量 */
    public void setTrunYwCnt(String trunYwCnt){
        this.trunYwCnt = trunYwCnt;
    }
    /** 业务转人工率 */
    public String getTrunYwRate(){
        return this.trunYwRate;
    }
    /** 业务转人工率 */
    public void setTrunYwRate(String trunYwRate){
        this.trunYwRate = trunYwRate;
    }
    /** 导航转按键量 */
    public String getTrunAjCnt(){
        return this.trunAjCnt;
    }
    /** 导航转按键量 */
    public void setTrunAjCnt(String trunAjCnt){
        this.trunAjCnt = trunAjCnt;
    }
    /** 导航转按键占比 */
    public String getTrunAjRate(){
        return this.trunAjRate;
    }
    /** 导航转按键占比 */
    public void setTrunAjRate(String trunAjRate){
        this.trunAjRate = trunAjRate;
    }
    /** 超时交互次数 */
    public String getTimeOutCnt(){
        return this.timeOutCnt;
    }
    /** 超时交互次数 */
    public void setTimeOutCnt(String timeOutCnt){
        this.timeOutCnt = timeOutCnt;
    }
    /** 拒识交互次数 */
    public String getRefuseCnt(){
        return this.refuseCnt;
    }
    /** 拒识交互次数 */
    public void setRefuseCnt(String refuseCnt){
        this.refuseCnt = refuseCnt;
    }
    /** 平均通话时长 */
    public String getCallDurAvg(){
        return this.callDurAvg;
    }
    /** 平均通话时长 */
    public void setCallDurAvg(String callDurAvg){
        this.callDurAvg = callDurAvg;
    }
    /** 10086系统呼入量 */
    public String getAgentGetNum(){
        return this.agentGetNum;
    }
    /** 10086系统呼入量 */
    public void setAgentGetNum(String agentGetNum){
        this.agentGetNum = agentGetNum;
    }
    /** 10086人工服务请求量 */
    public String getAgentReqNum(){
        return this.agentReqNum;
    }
    /** 10086人工服务请求量 */
    public void setAgentReqNum(String agentReqNum){
        this.agentReqNum = agentReqNum;
    }
    /** 策略转人工率 */
    public String getTrunClRate(){
        return this.trunClRate;
    }
    /** 策略转人工率 */
    public void setTrunClRate(String trunClRate){
        this.trunClRate = trunClRate;
    }
    /** 策略转人工量 */
    public String getTrunClCnt(){
        return this.trunClCnt;
    }
    /** 策略转人工量 */
    public void setTrunClCnt(String trunClCnt){
        this.trunClCnt = trunClCnt;
    }
    /** 地市编码 */
    public String getAreaCode(){
        return this.areaCode;
    }
    /** 地市编码 */
    public void setAreaCode(String areaCode){
        this.areaCode = areaCode;
    }
    /** 地市名称 */
    public String getAreaName(){
        return this.areaName;
    }
    /** 地市名称 */
    public void setAreaName(String areaName){
        this.areaName = areaName;
    }
    /** 星级编码 */
    public String getLevelId(){
        return this.levelId;
    }
    /** 星级编码 */
    public void setLevelId(String levelId){
        this.levelId = levelId;
    }
    /** 星级名称 */
    public String getLevelName(){
        return this.levelName;
    }
    /** 星级名称 */
    public void setLevelName(String levelName){
        this.levelName = levelName;
    }
    /** 首解量 */
    public String getSjCnt(){
        return this.sjCnt;
    }
    /** 首解量 */
    public void setSjCnt(String sjCnt){
        this.sjCnt = sjCnt;
    }
    /** 总交互次数 */
    public String getZjhCnt(){
        return this.zjhCnt;
    }
    /** 总交互次数 */
    public void setZjhCnt(String zjhCnt){
        this.zjhCnt = zjhCnt;
    }
    /** 超时交互占比 */
    public String getTimeOutRate(){
        return this.timeOutRate;
    }
    /** 超时交互占比 */
    public void setTimeOutRate(String timeOutRate){
        this.timeOutRate = timeOutRate;
    }
    /** 拒识交互占比 */
    public String getRefuseRate(){
        return this.refuseRate;
    }
    /** 拒识交互占比 */
    public void setRefuseRate(String refuseRate){
        this.refuseRate = refuseRate;
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
