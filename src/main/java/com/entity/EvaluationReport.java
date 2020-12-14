package com.entity;

import com.alibaba.excel.annotation.ExcelIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Table(name="evaluation_report")
public class EvaluationReport implements Serializable,Cloneable{
    /** 唯一标识 */
    @ExcelIgnore
    private String id ;
    /** 统计日期 */
    private String statisticalDate ;
    /** 呼入地id */
    private String callInId ;
    /** 呼入地 */
    private String callInName ;
    /** 归属地 */
    private String belongToPlace ;
    /** 地市 */
    private String city ;
    /** 入口 */
    private String entrance ;
    /** 出口 */
    private String export ;
    /** 星级 */
    private String star ;
    /** 导航接通量（月） */
    private String navigationMonthNum ;
    /** 调研触发量（月） */
    private String surveyMonthNum ;
    /** 回复量（月） */
    private String replyMonthNum ;
    /** 参评率（%）(月) */
    private String participationMonthRate ;
    /** 整体满意度评分(月) */
    private String satisfactionMonthScore ;
    /** 整体满意度(%)(月) */
    private String satisfactionMonthRate ;
    /** 自助服务使用体验评分(月) */
    private String serviceMonthScore ;
    /** 自助服务使用体验满意度(%)(月) */
    private String serviceMonthRate ;
    /** 听不懂我说的话回复量(月) */
    private String understandMonthNum ;
    /** 提示语太长回复量(月) */
    private String hintMonthNum ;
    /** 回答错误回复量(月) */
    private String errorMonthNum ;
    /** 答非所问回复量(月) */
    private String answerMonthNum ;
    /** 导航接通量(日) */
    private String navigationDayNum ;
    /** 调研触发量(日) */
    private String surveyDayNum ;
    /** 回复量(日) */
    private String replyDayNum ;
    /** 参评率(%)(日) */
    private String participationDayRate ;
    /** 整体满意度评分(日) */
    private String satisfactionDayScore ;
    /** 整体满意度(%)(日) */
    private String satisfactionDayRate ;
    /** 自助服务使用体验评分(日) */
    private String serviceDayScore ;
    /** 自助服务使用体验满意度(%)(日) */
    private String serviceDayRate ;
    /** 听不懂我说的话回复量(日) */
    private String understandDayNum ;
    /** 提示语太长回复量(日) */
    private String hintDayNum ;
    /** 回答错误回复量(日) */
    private String errorDayNum ;
    /** 答非所问回复量(日) */
    private String answerDayNum ;
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
    public String getStatisticalDate(){
        return this.statisticalDate;
    }
    /** 统计日期 */
    public void setStatisticalDate(String statisticalDate){
        this.statisticalDate = statisticalDate;
    }
    /** 呼入地id */
    public String getCallInId(){
        return this.callInId;
    }
    /** 呼入地id */
    public void setCallInId(String callInId){
        this.callInId = callInId;
    }
    /** 呼入地 */
    public String getCallInName(){
        return this.callInName;
    }
    /** 呼入地 */
    public void setCallInName(String callInName){
        this.callInName = callInName;
    }
    /** 归属地 */
    public String getBelongToPlace(){
        return this.belongToPlace;
    }
    /** 归属地 */
    public void setBelongToPlace(String belongToPlace){
        this.belongToPlace = belongToPlace;
    }
    /** 地市 */
    public String getCity(){
        return this.city;
    }
    /** 地市 */
    public void setCity(String city){
        this.city = city;
    }
    /** 入口 */
    public String getEntrance(){
        return this.entrance;
    }
    /** 入口 */
    public void setEntrance(String entrance){
        this.entrance = entrance;
    }
    /** 出口 */
    public String getExport(){
        return this.export;
    }
    /** 出口 */
    public void setExport(String export){
        this.export = export;
    }
    /** 星级 */
    public String getStar(){
        return this.star;
    }
    /** 星级 */
    public void setStar(String star){
        this.star = star;
    }
    /** 导航接通量（月） */
    public String getNavigationMonthNum(){
        return this.navigationMonthNum;
    }
    /** 导航接通量（月） */
    public void setNavigationMonthNum(String navigationMonthNum){
        this.navigationMonthNum = navigationMonthNum;
    }
    /** 调研触发量（月） */
    public String getSurveyMonthNum(){
        return this.surveyMonthNum;
    }
    /** 调研触发量（月） */
    public void setSurveyMonthNum(String surveyMonthNum){
        this.surveyMonthNum = surveyMonthNum;
    }
    /** 回复量（月） */
    public String getReplyMonthNum(){
        return this.replyMonthNum;
    }
    /** 回复量（月） */
    public void setReplyMonthNum(String replyMonthNum){
        this.replyMonthNum = replyMonthNum;
    }
    /** 参评率（%）(月) */
    public String getParticipationMonthRate(){
        return this.participationMonthRate;
    }
    /** 参评率（%）(月) */
    public void setParticipationMonthRate(String participationMonthRate){
        this.participationMonthRate = participationMonthRate;
    }
    /** 整体满意度评分(月) */
    public String getSatisfactionMonthScore(){
        return this.satisfactionMonthScore;
    }
    /** 整体满意度评分(月) */
    public void setSatisfactionMonthScore(String satisfactionMonthScore){
        this.satisfactionMonthScore = satisfactionMonthScore;
    }
    /** 整体满意度(%)(月) */
    public String getSatisfactionMonthRate(){
        return this.satisfactionMonthRate;
    }
    /** 整体满意度(%)(月) */
    public void setSatisfactionMonthRate(String satisfactionMonthRate){
        this.satisfactionMonthRate = satisfactionMonthRate;
    }
    /** 自助服务使用体验评分(月) */
    public String getServiceMonthScore(){
        return this.serviceMonthScore;
    }
    /** 自助服务使用体验评分(月) */
    public void setServiceMonthScore(String serviceMonthScore){
        this.serviceMonthScore = serviceMonthScore;
    }
    /** 自助服务使用体验满意度(%)(月) */
    public String getServiceMonthRate(){
        return this.serviceMonthRate;
    }
    /** 自助服务使用体验满意度(%)(月) */
    public void setServiceMonthRate(String serviceMonthRate){
        this.serviceMonthRate = serviceMonthRate;
    }
    /** 听不懂我说的话回复量(月) */
    public String getUnderstandMonthNum(){
        return this.understandMonthNum;
    }
    /** 听不懂我说的话回复量(月) */
    public void setUnderstandMonthNum(String understandMonthNum){
        this.understandMonthNum = understandMonthNum;
    }
    /** 提示语太长回复量(月) */
    public String getHintMonthNum(){
        return this.hintMonthNum;
    }
    /** 提示语太长回复量(月) */
    public void setHintMonthNum(String hintMonthNum){
        this.hintMonthNum = hintMonthNum;
    }
    /** 回答错误回复量(月) */
    public String getErrorMonthNum(){
        return this.errorMonthNum;
    }
    /** 回答错误回复量(月) */
    public void setErrorMonthNum(String errorMonthNum){
        this.errorMonthNum = errorMonthNum;
    }
    /** 答非所问回复量(月) */
    public String getAnswerMonthNum(){
        return this.answerMonthNum;
    }
    /** 答非所问回复量(月) */
    public void setAnswerMonthNum(String answerMonthNum){
        this.answerMonthNum = answerMonthNum;
    }
    /** 导航接通量(日) */
    public String getNavigationDayNum(){
        return this.navigationDayNum;
    }
    /** 导航接通量(日) */
    public void setNavigationDayNum(String navigationDayNum){
        this.navigationDayNum = navigationDayNum;
    }
    /** 调研触发量(日) */
    public String getSurveyDayNum(){
        return this.surveyDayNum;
    }
    /** 调研触发量(日) */
    public void setSurveyDayNum(String surveyDayNum){
        this.surveyDayNum = surveyDayNum;
    }
    /** 回复量(日) */
    public String getReplyDayNum(){
        return this.replyDayNum;
    }
    /** 回复量(日) */
    public void setReplyDayNum(String replyDayNum){
        this.replyDayNum = replyDayNum;
    }
    /** 参评率(%)(日) */
    public String getParticipationDayRate(){
        return this.participationDayRate;
    }
    /** 参评率(%)(日) */
    public void setParticipationDayRate(String participationDayRate){
        this.participationDayRate = participationDayRate;
    }
    /** 整体满意度评分(日) */
    public String getSatisfactionDayScore(){
        return this.satisfactionDayScore;
    }
    /** 整体满意度评分(日) */
    public void setSatisfactionDayScore(String satisfactionDayScore){
        this.satisfactionDayScore = satisfactionDayScore;
    }
    /** 整体满意度(%)(日) */
    public String getSatisfactionDayRate(){
        return this.satisfactionDayRate;
    }
    /** 整体满意度(%)(日) */
    public void setSatisfactionDayRate(String satisfactionDayRate){
        this.satisfactionDayRate = satisfactionDayRate;
    }
    /** 自助服务使用体验评分(日) */
    public String getServiceDayScore(){
        return this.serviceDayScore;
    }
    /** 自助服务使用体验评分(日) */
    public void setServiceDayScore(String serviceDayScore){
        this.serviceDayScore = serviceDayScore;
    }
    /** 自助服务使用体验满意度(%)(日) */
    public String getServiceDayRate(){
        return this.serviceDayRate;
    }
    /** 自助服务使用体验满意度(%)(日) */
    public void setServiceDayRate(String serviceDayRate){
        this.serviceDayRate = serviceDayRate;
    }
    /** 听不懂我说的话回复量(日) */
    public String getUnderstandDayNum(){
        return this.understandDayNum;
    }
    /** 听不懂我说的话回复量(日) */
    public void setUnderstandDayNum(String understandDayNum){
        this.understandDayNum = understandDayNum;
    }
    /** 提示语太长回复量(日) */
    public String getHintDayNum(){
        return this.hintDayNum;
    }
    /** 提示语太长回复量(日) */
    public void setHintDayNum(String hintDayNum){
        this.hintDayNum = hintDayNum;
    }
    /** 回答错误回复量(日) */
    public String getErrorDayNum(){
        return this.errorDayNum;
    }
    /** 回答错误回复量(日) */
    public void setErrorDayNum(String errorDayNum){
        this.errorDayNum = errorDayNum;
    }
    /** 答非所问回复量(日) */
    public String getAnswerDayNum(){
        return this.answerDayNum;
    }
    /** 答非所问回复量(日) */
    public void setAnswerDayNum(String answerDayNum){
        this.answerDayNum = answerDayNum;
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