package com.service;

import com.entity.EvaluationReport;

public interface EvaluationReportService {
   int insert(EvaluationReport evaluationReport);

   int selectCount();

   int delete(String statisDate);
}
