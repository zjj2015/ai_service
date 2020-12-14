package com.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class DemoData {
    @ExcelProperty("指标分类")
    private String zbfl;

    @ExcelProperty("指标名称")
    private String zbmc;
}
