package com.service.impl;

import com.dao.EvaluationReportDao;
import com.entity.EvaluationReport;
import com.service.EvaluationReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class EvaluationReportServiceImpl implements EvaluationReportService {

    @Autowired
    private EvaluationReportDao evaluationReportDao;

    @Override
    public int insert(EvaluationReport evaluationReport) {
        int result=evaluationReportDao.insert(evaluationReport);
        return result;
        /*String sql="INSERT INTO Evaluation_Report (\n" +
                "\tid,\n" +
                "\tstatistical_Date,\n" +
                "\tcall_In_Id,\n" +
                "\tcall_In_Name,\n" +
                "\tbelong_To_Place,\n" +
                "\tcity,\n" +
                "\tentrance,\n" +
                "\texport,\n" +
                "\tstar,\n" +
                "\tnavigation_Month_Num,\n" +
                "\tsurvey_Month_Num,\n" +
                "\treply_Month_Num,\n" +
                "\tparticipation_Month_Rate,\n" +
                "\tsatisfaction_Month_Score,\n" +
                "\tsatisfaction_Month_Rate,\n" +
                "\tservice_Month_Score,\n" +
                "\tservice_Month_Rate,\n" +
                "\tunderstand_Month_Num,\n" +
                "\thint_Month_Num,\n" +
                "\terror_Month_Num,\n" +
                "\tanswer_Month_Num,\n" +
                "\tnavigation_Day_Num,\n" +
                "\tsurvey_Day_Num,\n" +
                "\treply_Day_Num,\n" +
                "\tparticipation_Day_Rate,\n" +
                "\tsatisfaction_Day_Score,\n" +
                "\tsatisfaction_Day_Rate,\n" +
                "\tservice_Day_Score,\n" +
                "\tservice_Day_Rate,\n" +
                "\thint_Day_Num,\n" +
                "\terror_Day_Num,\n" +
                "\tanswer_Day_Num,\n" +
                "\tcreated_By,\n" +
                "\tcreated_Time,\n" +
                "\tupdated_By,\n" +
                "\tupdated_Time\n" +
                ") values(\n" +
                "\treplace(uuid(),\"-\",\"\"),\n" +
                "\t#{statisticalDate},\n" +
                "\t#{callInId},\n" +
                "\t#{callInName},\n" +
                "\t#{belongToPlace},\n" +
                "\t#{city},\n" +
                "\t#{entrance},\n" +
                "\t#{export},\n" +
                "\t#{star},\n" +
                "\t#{navigationMonthNum},\n" +
                "\t#{surveyMonthNum},\n" +
                "\t#{replyMonthNum},\n" +
                "\t#{participationMonthRate},\n" +
                "\t#{satisfactionMonthScore},\n" +
                "\t#{satisfactionMonthRate},\n" +
                "\t#{serviceMonthScore},\n" +
                "\t#{serviceMonthRate},\n" +
                "\t#{understandMonthNum},\n" +
                "\t#{hintMonthNum},\n" +
                "\t#{errorMonthNum},\n" +
                "\t#{answerMonthNum},\n" +
                "\t#{navigationDayNum},\n" +
                "\t#{surveyDayNum},\n" +
                "\t#{replyDayNum},\n" +
                "\t#{participationDayRate},\n" +
                "\t#{satisfactionDayScore},\n" +
                "\t#{satisfactionDayRate},\n" +
                "\t#{serviceDayScore},\n" +
                "\t#{serviceDayRate},\n" +
                "\t#{hintDayNum},\n" +
                "\t#{errorDayNum},\n" +
                "\t#{answerDayNum},\n" +
                "\t'sys',\n" +
                "\tnow(),\n" +
                "\t'sys',\n" +
                "\tnow()\n" +
                ")";
        return firstJdbcTemplate.update(sql,evaluationReport);*/
    }

    @Override
    public int selectCount() {
        return evaluationReportDao.selectCount();
    }

    @Override
    public int delete(String statisDate) {
        return evaluationReportDao.delete(statisDate);
    }
}
