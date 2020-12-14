package com.service.impl;

import com.dao.EvaluationReportDao;
import com.dao.TaskMarkDao;
import com.entity.EvaluationReport;
import com.entity.TaskMark;
import com.service.EvaluationReportService;
import com.service.TaskMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TaskMarkServiceImpl implements TaskMarkService {

    @Autowired
    private TaskMarkDao taskMarkDao;


    @Override
    public int insert(TaskMark taskMark) {
        return taskMarkDao.insert(taskMark);
    }

    @Override
    public String selectLastUploadTime() {
        return taskMarkDao.selectLastUploadTime();
    }

    @Override
    public void callYydhStatis(String dateStr) {
        taskMarkDao.callYydhStatis(dateStr);
    }
}
