package com.dao;

import com.entity.DailyReport;
import com.entity.EvaluationReport;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DailyReportDao {
    int insert(DailyReport dailyReport);

    int selectCount();

    int delete(String statisDate);
}
