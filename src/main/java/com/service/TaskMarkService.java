package com.service;

import com.entity.TaskMark;

public interface TaskMarkService {
   int insert(TaskMark taskMark);

   String selectLastUploadTime();

   void callYydhStatis(String dateStr);
}
