package com.service;

import com.entity.DailyReport;
import com.entity.StatisReport;

import java.util.Map;

public interface StatisReportService {
   int insert(StatisReport statisReport);

   int insertByMap(Map<String, Object> map);

   int selectCount();

   int delete(String statisDate);
}
