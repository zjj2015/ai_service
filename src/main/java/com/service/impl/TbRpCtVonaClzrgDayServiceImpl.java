package com.service.impl;


import com.dao.TbRpCtVonaClzrgDayDao;
import com.service.TbRpCtVonaClzrgDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TbRpCtVonaClzrgDayServiceImpl implements TbRpCtVonaClzrgDayService {

    @Autowired
    private TbRpCtVonaClzrgDayDao tbRpCtVonaClzrgDayDao ;

    @Override
    public int insertByMap(Map<String, Object> map) {
        return tbRpCtVonaClzrgDayDao.insertByMap(map);
    }

    @Override
    public void save(List<String[]> data) {
        Map map = null;
        if (data != null && data.size() > 0) {
            for (String[] s : data) {
                map = new HashMap<>();
                map.put("statis_date", s[0]);
                map.put("prov_code", s[1]);
                map.put("prov_name", s[2]);
                map.put("package_name", s[3]);
                map.put("rule_name", s[4]);
                map.put("type_nm", s[5]);
                map.put("dh_my_rat", s[6]);
                map.put("dh_zrg_cnt", s[7]);
                map.put("dh_zrgbl_cnt", s[8]);
                map.put("dh_zrgbl_rat", s[9]);
                map.put("rg_my_rat", s[10]);
                map.put("rg_thtime_avg", s[11]);
                map.put("rule_cnt", s[12]);
                map.put("agent_req_num", s[13]);
                map.put("dh_zrgbl_all_cnt", s[14]);
                map.put("dh_zrgbl_all_rat", s[15]);
                map.put("score_1_my", s[16]);
                map.put("score_4_my", s[17]);
                map.put("pf_zt", s[18]);
                map.put("fwtdmyd", s[19]);
                map.put("fwnlmyd", s[20]);
                map.put("wtjjmyd", s[21]);

                Map<String, Object> columnMap = new HashMap<>();
                columnMap.put("columnMap", map);
                tbRpCtVonaClzrgDayDao.insertByMap(columnMap);
            }
        }
    }

    @Override
    public int selectCount() {
        return tbRpCtVonaClzrgDayDao.selectCount();
    }

    @Override
    public int delete(String statisDate) {
        return tbRpCtVonaClzrgDayDao.delete(statisDate);
    }
}
