package com.dao;

import com.entity.TaskMark;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskMarkDao {
    int insert(TaskMark taskMark);

    String selectLastUploadTime();

    /**
     * 调用存储过程
     * @param callYydhStatis
     */
    void callYydhStatis(String dateStr);
}
