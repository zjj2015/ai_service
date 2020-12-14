package com.service.impl;

import com.dao.DailyReportDao;
import com.dao.EvaluationReportDao;
import com.entity.DailyReport;
import com.entity.EvaluationReport;
import com.service.DailyReportService;
import com.service.EvaluationReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class DailyReportServiceImpl implements DailyReportService {

    @Autowired
    private DailyReportDao dailyReportDao;


    @Override
    public int insert(DailyReport dailyReport) {
        return dailyReportDao.insert(dailyReport);
    }

    @Override
    public int selectCount() {
        return dailyReportDao.selectCount();
    }

    @Override
    public int delete(String statisDate) {
        return dailyReportDao.delete(statisDate);
    }
}
