package com.entity;

import com.alibaba.excel.annotation.ExcelIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Table(name="daily_report")
public class DailyReport implements Serializable,Cloneable{
    /** 唯一标识 */
    @ExcelIgnore
    private String id ;
    /** 日期 */
    private String reportDate ;
    /** 省份 */
    private String province ;
    /** 业务 */
    private String business ;
    /** 业务到达量(月) */
    private String arrivalMonthNum ;
    /** 业务处理成功量(月) */
    private String processMonthNum ;
    /** 业务办理成功量(月) */
    private String handleMonthNum ;
    /** 业务满意量(月) */
    private String satisfyMonthNum ;
    /** 业务满意率(月) */
    private String satisfyMonthRate ;
    /** 业务首解量(月) */
    private String firstSolutionMonthNum ;
    /** 无分支业务到达量(月) */
    private String noBranchingMonthNum ;
    /** 业务首解率(月) */
    private String firstSolutionMonthRate ;
    /** 业务处理成功量较上月同比 */
    private String processTbNum ;
    /** 业务办理成功量较上月同比 */
    private String handleTbNum ;
    /** 业务满意量较上月同比 */
    private String satisfyTbNum ;
    /** 业务满意率较上月同比 */
    private String satisfyTbRate ;
    /** 业务首解量较上月同比 */
    private String firstSolutionTbNum ;
    /** 业务首解率较上月同比 */
    private String firstSolutionTbRate ;
    /** 业务满意度评价量(月) */
    private String evaluateMonthNum ;
    /** 业务满意度评价量较上月 */
    private String evaluateLastMonthNum ;
    /** 业务到达量(日) */
    private String arrivalDayNum ;
    /** 业务处理成功量(日) */
    private String processDayNum ;
    /** 业务办理成功量(日) */
    private String handleDayNum ;
    /** 业务满意度评价量(日) */
    private String evaluateDayNum ;
    /** 业务满意量(日) */
    private String satisfyDayNum ;
    /** 业务满意率(日) */
    private String satisfyDayRate ;
    /** 业务首解量(日) */
    private String firstSolutionDayNum ;
    /** 无分支业务到达量(日) */
    private String noBranchingDayNum ;
    /** 业务首解率(日) */
    private String firstSolutionDayRate ;
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
    /** 日期 */
    public String getReportDate(){
        return this.reportDate;
    }
    /** 日期 */
    public void setReportDate(String reportDate){
        this.reportDate = reportDate;
    }
    /** 省份 */
    public String getProvince(){
        return this.province;
    }
    /** 省份 */
    public void setProvince(String province){
        this.province = province;
    }
    /** 业务 */
    public String getBusiness(){
        return this.business;
    }
    /** 业务 */
    public void setBusiness(String business){
        this.business = business;
    }
    /** 业务到达量(月) */
    public String getArrivalMonthNum(){
        return this.arrivalMonthNum;
    }
    /** 业务到达量(月) */
    public void setArrivalMonthNum(String arrivalMonthNum){
        this.arrivalMonthNum = arrivalMonthNum;
    }
    /** 业务处理成功量(月) */
    public String getProcessMonthNum(){
        return this.processMonthNum;
    }
    /** 业务处理成功量(月) */
    public void setProcessMonthNum(String processMonthNum){
        this.processMonthNum = processMonthNum;
    }
    /** 业务办理成功量(月) */
    public String getHandleMonthNum(){
        return this.handleMonthNum;
    }
    /** 业务办理成功量(月) */
    public void setHandleMonthNum(String handleMonthNum){
        this.handleMonthNum = handleMonthNum;
    }
    /** 业务满意量(月) */
    public String getSatisfyMonthNum(){
        return this.satisfyMonthNum;
    }
    /** 业务满意量(月) */
    public void setSatisfyMonthNum(String satisfyMonthNum){
        this.satisfyMonthNum = satisfyMonthNum;
    }
    /** 业务满意率(月) */
    public String getSatisfyMonthRate(){
        return this.satisfyMonthRate;
    }
    /** 业务满意率(月) */
    public void setSatisfyMonthRate(String satisfyMonthRate){
        this.satisfyMonthRate = satisfyMonthRate;
    }
    /** 业务首解量(月) */
    public String getFirstSolutionMonthNum(){
        return this.firstSolutionMonthNum;
    }
    /** 业务首解量(月) */
    public void setFirstSolutionMonthNum(String firstSolutionMonthNum){
        this.firstSolutionMonthNum = firstSolutionMonthNum;
    }
    /** 无分支业务到达量(月) */
    public String getNoBranchingMonthNum(){
        return this.noBranchingMonthNum;
    }
    /** 无分支业务到达量(月) */
    public void setNoBranchingMonthNum(String noBranchingMonthNum){
        this.noBranchingMonthNum = noBranchingMonthNum;
    }
    /** 业务首解率(月) */
    public String getFirstSolutionMonthRate(){
        return this.firstSolutionMonthRate;
    }
    /** 业务首解率(月) */
    public void setFirstSolutionMonthRate(String firstSolutionMonthRate){
        this.firstSolutionMonthRate = firstSolutionMonthRate;
    }
    /** 业务处理成功量较上月同比 */
    public String getProcessTbNum(){
        return this.processTbNum;
    }
    /** 业务处理成功量较上月同比 */
    public void setProcessTbNum(String processTbNum){
        this.processTbNum = processTbNum;
    }
    /** 业务办理成功量较上月同比 */
    public String getHandleTbNum(){
        return this.handleTbNum;
    }
    /** 业务办理成功量较上月同比 */
    public void setHandleTbNum(String handleTbNum){
        this.handleTbNum = handleTbNum;
    }
    /** 业务满意量较上月同比 */
    public String getSatisfyTbNum(){
        return this.satisfyTbNum;
    }
    /** 业务满意量较上月同比 */
    public void setSatisfyTbNum(String satisfyTbNum){
        this.satisfyTbNum = satisfyTbNum;
    }
    /** 业务满意率较上月同比 */
    public String getSatisfyTbRate(){
        return this.satisfyTbRate;
    }
    /** 业务满意率较上月同比 */
    public void setSatisfyTbRate(String satisfyTbRate){
        this.satisfyTbRate = satisfyTbRate;
    }
    /** 业务首解量较上月同比 */
    public String getFirstSolutionTbNum(){
        return this.firstSolutionTbNum;
    }
    /** 业务首解量较上月同比 */
    public void setFirstSolutionTbNum(String firstSolutionTbNum){
        this.firstSolutionTbNum = firstSolutionTbNum;
    }
    /** 业务首解率较上月同比 */
    public String getFirstSolutionTbRate(){
        return this.firstSolutionTbRate;
    }
    /** 业务首解率较上月同比 */
    public void setFirstSolutionTbRate(String firstSolutionTbRate){
        this.firstSolutionTbRate = firstSolutionTbRate;
    }
    /** 业务满意度评价量(月) */
    public String getEvaluateMonthNum(){
        return this.evaluateMonthNum;
    }
    /** 业务满意度评价量(月) */
    public void setEvaluateMonthNum(String evaluateMonthNum){
        this.evaluateMonthNum = evaluateMonthNum;
    }
    /** 业务满意度评价量较上月 */
    public String getEvaluateLastMonthNum(){
        return this.evaluateLastMonthNum;
    }
    /** 业务满意度评价量较上月 */
    public void setEvaluateLastMonthNum(String evaluateLastMonthNum){
        this.evaluateLastMonthNum = evaluateLastMonthNum;
    }
    /** 业务到达量(日) */
    public String getArrivalDayNum(){
        return this.arrivalDayNum;
    }
    /** 业务到达量(日) */
    public void setArrivalDayNum(String arrivalDayNum){
        this.arrivalDayNum = arrivalDayNum;
    }
    /** 业务处理成功量(日) */
    public String getProcessDayNum(){
        return this.processDayNum;
    }
    /** 业务处理成功量(日) */
    public void setProcessDayNum(String processDayNum){
        this.processDayNum = processDayNum;
    }
    /** 业务办理成功量(日) */
    public String getHandleDayNum(){
        return this.handleDayNum;
    }
    /** 业务办理成功量(日) */
    public void setHandleDayNum(String handleDayNum){
        this.handleDayNum = handleDayNum;
    }
    /** 业务满意度评价量(日) */
    public String getEvaluateDayNum(){
        return this.evaluateDayNum;
    }
    /** 业务满意度评价量(日) */
    public void setEvaluateDayNum(String evaluateDayNum){
        this.evaluateDayNum = evaluateDayNum;
    }
    /** 业务满意量(日) */
    public String getSatisfyDayNum(){
        return this.satisfyDayNum;
    }
    /** 业务满意量(日) */
    public void setSatisfyDayNum(String satisfyDayNum){
        this.satisfyDayNum = satisfyDayNum;
    }
    /** 业务满意率(日) */
    public String getSatisfyDayRate(){
        return this.satisfyDayRate;
    }
    /** 业务满意率(日) */
    public void setSatisfyDayRate(String satisfyDayRate){
        this.satisfyDayRate = satisfyDayRate;
    }
    /** 业务首解量(日) */
    public String getFirstSolutionDayNum(){
        return this.firstSolutionDayNum;
    }
    /** 业务首解量(日) */
    public void setFirstSolutionDayNum(String firstSolutionDayNum){
        this.firstSolutionDayNum = firstSolutionDayNum;
    }
    /** 无分支业务到达量(日) */
    public String getNoBranchingDayNum(){
        return this.noBranchingDayNum;
    }
    /** 无分支业务到达量(日) */
    public void setNoBranchingDayNum(String noBranchingDayNum){
        this.noBranchingDayNum = noBranchingDayNum;
    }
    /** 业务首解率(日) */
    public String getFirstSolutionDayRate(){
        return this.firstSolutionDayRate;
    }
    /** 业务首解率(日) */
    public void setFirstSolutionDayRate(String firstSolutionDayRate){
        this.firstSolutionDayRate = firstSolutionDayRate;
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