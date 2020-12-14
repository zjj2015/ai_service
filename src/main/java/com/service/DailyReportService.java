package com.service;

import com.entity.DailyReport;

public interface DailyReportService {
   int insert(DailyReport dailyReport);

   int selectCount();

   int delete(String statisDate);
}
