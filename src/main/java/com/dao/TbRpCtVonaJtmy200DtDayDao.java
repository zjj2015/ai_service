package com.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface TbRpCtVonaJtmy200DtDayDao {
    int insertByMap(Map<String, Object> map);

    int selectCount();

    int delete(String statisDate);
}
