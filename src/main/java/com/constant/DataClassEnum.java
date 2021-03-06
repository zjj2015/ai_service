package com.constant;

import com.entity.DailyReport;
import com.entity.EvaluationReport;
import com.entity.StatisReport;
import com.read.DemoDataListener;

public enum DataClassEnum {
   EVALUATION_REPORT("10086智能导航接入场景测评报表", EvaluationReport.class),
    DAILY_REPORT("语音导航业务统计指标日报表", DailyReport.class),
    STATIS_REPORT("IVR拨打量统计日报表(按地市星级)", StatisReport.class);

   private String name;
   private Class<?> T;

    DataClassEnum(String name, Class<?> T) {
        this.name=name;
        this.T=T;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<?> getT() {
        return T;
    }

    public void setT(Class<?> t) {
        T = t;
    }
}
