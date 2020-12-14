package com.dao;

import com.entity.EvaluationReport;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EvaluationReportDao {
    int insert(EvaluationReport evaluationReport);

    int selectCount();

    int delete(String statisDate);
}
