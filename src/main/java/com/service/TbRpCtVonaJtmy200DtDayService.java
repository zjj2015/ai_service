package com.service;


import java.util.List;
import java.util.Map;

public interface TbRpCtVonaJtmy200DtDayService {

   int insertByMap(Map<String, Object> map);

   void save(List<String[]> data);

   int selectCount();

   int delete(String statisDate);
}
