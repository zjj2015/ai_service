package com.service.impl;


import com.dao.TbRpCtVonaJtmy200DtDayDao;
import com.service.TbRpCtVonaJtmy200DtDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TbRpCtVonaJtmy200DtDayServiceImpl implements TbRpCtVonaJtmy200DtDayService {

    @Autowired
    private TbRpCtVonaJtmy200DtDayDao tbRpCtVonaJtmy200DtDayDao ;

    @Override
    public int insertByMap(Map<String, Object> map) {
        return tbRpCtVonaJtmy200DtDayDao.insertByMap(map);
    }

    @Override
    public void save(List<String[]> data) {
        Map map = null;
        if (data != null && data.size() > 0) {
            for (String[] s : data) {
                map = new HashMap<>();
                map.put("statis_date", s[0]);
                map.put("p_code", s[1]);
                map.put("p_name", s[2]);
                map.put("cf_cnt", s[3]);
                map.put("hf_cnt", s[4]);
                map.put("hf1_cnt", s[5]);
                map.put("hf2_cnt", s[6]);
                map.put("hf3_cnt", s[7]);
                map.put("hf4_cnt", s[8]);
                map.put("cp_rat", s[9]);
                map.put("q1", s[10]);
                map.put("score_1", s[11]);
                map.put("score_1_avg", s[12]);
                map.put("q2", s[13]);
                map.put("score_2", s[14]);
                map.put("score_2_avg", s[15]);
                map.put("q3", s[16]);
                map.put("score_3", s[17]);
                map.put("score_3_avg", s[18]);
                map.put("q4", s[19]);
                map.put("score_4", s[20]);
                map.put("score_4_avg", s[21]);
                map.put("score_1_my", s[22]);
                map.put("score_2_my", s[23]);
                map.put("score_3_my", s[24]);
                map.put("score_4_my", s[25]);
                map.put("statis_type", s[26]);

                Map<String, Object> columnMap = new HashMap<>();
                columnMap.put("columnMap", map);
                tbRpCtVonaJtmy200DtDayDao.insertByMap(columnMap);
            }
        }
    }

    @Override
    public int selectCount() {
        return tbRpCtVonaJtmy200DtDayDao.selectCount();
    }

    @Override
    public int delete(String statisDate) {
        return tbRpCtVonaJtmy200DtDayDao.delete(statisDate);
    }
}
