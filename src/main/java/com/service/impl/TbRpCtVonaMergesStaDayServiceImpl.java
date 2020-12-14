package com.service.impl;


import com.dao.TbRpCtVonaJtmy200DtDayDao;
import com.dao.TbRpCtVonaMergesStaDayDao;
import com.service.TbRpCtVonaJtmy200DtDayService;
import com.service.TbRpCtVonaMergesStaDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TbRpCtVonaMergesStaDayServiceImpl implements TbRpCtVonaMergesStaDayService {

    @Autowired
    private TbRpCtVonaMergesStaDayDao tbRpCtVonaMergesStaDayDao ;

    @Override
    public int insertByMap(Map<String, Object> map) {
        return tbRpCtVonaMergesStaDayDao.insertByMap(map);
    }

    @Override
    public void save(List<String[]> data) {
        Map map = null;
        if (data != null && data.size() > 0) {
            for (String[] s : data) {
                map = new HashMap<>();
                map.put("statis_date", s[0]);
                map.put("prov_name", s[1]);
                map.put("prov_code", s[2]);
                map.put("intr_name", s[3]);
                map.put("intr_id", s[4]);
                map.put("ext_name", s[5]);
                map.put("ext_id", s[6]);
                map.put("get_num", s[7]);
                map.put("satify_rate", s[8]);
                map.put("sj_rate", s[9]);
                map.put("vona_rate", s[10]);
                map.put("user_cnt", s[11]);
                map.put("novo_cnt", s[12]);
                map.put("novo_rate", s[13]);
                map.put("trun_cnt", s[14]);
                map.put("trun_rate", s[15]);
                map.put("trun_zd_cnt", s[16]);
                map.put("trun_zd_rate", s[17]);
                map.put("trun_yw_cnt", s[18]);
                map.put("trun_yw_rate", s[19]);
                map.put("trun_aj_cnt", s[20]);
                map.put("trun_aj_rate", s[21]);
                map.put("time_out_cnt", s[22]);
                map.put("refuse_cnt", s[23]);
                map.put("call_dur_avg", s[24]);
                map.put("agent_get_num", s[25]);
                map.put("agent_req_num", s[26]);
                map.put("trun_cl_rate", s[27]);
                map.put("trun_cl_cnt", s[28]);
                map.put("area_code", s[29]);
                map.put("area_name", s[30]);
                map.put("level_id", s[31]);
                map.put("level_name", s[32]);
                map.put("sj_cnt", s[33]);
                map.put("zjh_cnt", s[34]);
                map.put("time_out_rate", s[35]);
                map.put("refuse_rate", s[36]);


                Map<String, Object> columnMap = new HashMap<>();
                columnMap.put("columnMap", map);
                tbRpCtVonaMergesStaDayDao.insertByMap(columnMap);
            }
        }
    }

    @Override
    public int selectCount() {
        return tbRpCtVonaMergesStaDayDao.selectCount();
    }

    @Override
    public int delete(String statisDate) {
        return tbRpCtVonaMergesStaDayDao.delete(statisDate);
    }
}
