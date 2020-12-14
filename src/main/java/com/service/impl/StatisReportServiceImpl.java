package com.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.dao.StatisReportDao;
import com.entity.StatisReport;
import com.service.StatisReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class StatisReportServiceImpl implements StatisReportService {

    @Autowired
    private StatisReportDao statisReportDao;


    @Override
    //@DS("db1")
    public int insert(StatisReport statisReport) {
        return statisReportDao.insert(statisReport);
    }

    @Override
    //@DS("db1")
    public int insertByMap(Map<String, Object> map) {
        return statisReportDao.insertByMap(map);
    }

    @Override
    //@DS("db1")
    public int selectCount() {
        return statisReportDao.selectCount();
    }

    @Override
    public int delete(String statisDate) {
        return statisReportDao.delete(statisDate);
    }
}
