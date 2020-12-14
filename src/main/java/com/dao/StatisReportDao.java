package com.dao;

import com.entity.StatisReport;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface StatisReportDao {
    int insert(StatisReport statisReport);

    int insertByMap(Map<String, Object> map);

    int selectCount();

    int delete(String statisDate);
}
