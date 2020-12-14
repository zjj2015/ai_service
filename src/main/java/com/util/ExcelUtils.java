package com.util;

import com.tool.CustomException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Copyright: ...
 * Company: bingo
 * Version: 1.0.0
 * Author: lihuanwei
 * Date: 2019/11/11
 * Description:
 */
public class ExcelUtils {

    /**
     * @方法名: excelTolist
     * @方法作用: Excel数据转换成对应的list对象集合
     * @param in：			承载着Excel的输入流
     * @param fieldMap：		Excel中的中文列头和类的英文属性的对应关系Map
     * @param uniqueField:		是否需要校验数据存在重复,取值范围：true是|false否，为true时uniqueFields条件生效
     * @param uniqueFields：指定业务主键组合（即复合主键），这些列的组合不能重复
     * @param frontRow:		Excel前几列是必填项
     * @return list集合
     * @throws Exception 	自己封装了ExcelException异常类，这个方法一共抛出了三个异常：
     *						1、throw new ExcelException("1," + name) 	列名不存在时抛出，name列名
     *						2、throw new ExcelException("2," + repeat)  	指定的不重复列重复时抛出，repeat重复的值
     *						3、throw new ExcelException("3," + (col + 1) + "," + (i + 1)) 必填列无数据时抛出 (col+1)行  (i+1)
     */
    public static List<Map<String,Object>> excelToListOfListMap(InputStream in, int sheetName ,int startRow ,  LinkedHashMap<String, String> fieldMap, boolean uniqueField, String[] uniqueFields, int frontRow) throws Exception {

        // 定义要返回的list
        List<Map<String , Object>> resultList = new ArrayList<>();
        // 根据Excel数据源创建WorkBook
        Workbook wb = Workbook.getWorkbook(in);
        // 获取工作表
        Sheet sheet = wb.getSheet(sheetName);
        // 获取工作表的有效行数
        int realRows = 0;
        for (int i = startRow; i < sheet.getRows(); i++) {

            int nullCols = 0;
            for (int j = 0; j < sheet.getColumns(); j++) {
                Cell currentCell = sheet.getCell(j, i);
                if (currentCell == null || "".equals(currentCell.getContents().toString())) {
                    nullCols++;
                }
            }
            if (nullCols == sheet.getColumns()) {
                break;
            } else {
                realRows++;
            }
        }
        // 如果Excel中没有数据则提示错误
        Cell[] firstRow = sheet.getRow(0);
        String[] excelFieldNames = new String[firstRow.length];
        // 获取Excel中的列名
        for (int i = 0; i < firstRow.length; i++) {
            excelFieldNames[i] = firstRow[i].getContents().toString().trim();
        }
        // 判断需要的字段在Excel中是否都存在
        boolean isExist = true;
        String name = "";
        List<String> excelFieldList = Arrays.asList(excelFieldNames);
        for (String cnName : fieldMap.values()) {
            if (!excelFieldList.contains(cnName)) {
                isExist = false;
                name = cnName;
                break;
            }
        }
        // 如果有列名不存在，则抛出异常，提示错误
        if (!isExist) {
            throw new CustomException("列名不存在！请检查导入模板格式是否正确！");
        }
        // 将列名和列号放入Map中,这样通过列名就可以拿到列号
        LinkedHashMap<String, Integer> colMap = new LinkedHashMap<String, Integer>();
        for (int i = 0; i < excelFieldNames.length; i++) {
            colMap.put(excelFieldNames[i], firstRow[i].getColumn());
        }
        // 判断是否有重复行
        if (uniqueField){
            // 1.获取uniqueFields指定的列
            Cell[][] uniqueCells = new Cell[uniqueFields.length][];
            for (int i = 0; i < uniqueFields.length; i++) {
                int col = colMap.get(uniqueFields[i]);
                uniqueCells[i] = sheet.getColumn(col);
            }
            // 2.从指定列中寻找重复行
            for (int i = 1; i < realRows; i++) {
                int nullCols = 0;
                String repeat = "";
                for (int j = 0; j < uniqueFields.length; j++) {
                    String currentContent = uniqueCells[j][i].getContents();
                    repeat = currentContent;
                    Cell sameCell = sheet.findCell(currentContent, uniqueCells[j][i].getColumn(), uniqueCells[j][i].getRow() + 1, uniqueCells[j][i].getColumn(), uniqueCells[j][realRows - 1].getRow(), true);
                    if (sameCell != null) {
                        nullCols++;
                    }
                }
                // 有重复行，报错
                if (nullCols == uniqueFields.length) {
                    throw new CustomException("存在重复行！请检查导入模板格式是否正确！" + repeat);
                }
            }
        }

        // 将sheet转换为list
        for (int i = startRow; i < realRows + startRow; i++) {
            // 新建要转换的对象
            Map<String ,Object> entity = new HashMap<>();
            // 确定前几列不能为空
            int index = frontRow;
            // 给对象中的字段赋值
            for (Map.Entry<String, String> entry : fieldMap.entrySet()) {
                // 获取中文字段名
                String cnNormalName = entry.getValue();
                // 获取英文字段名
                String enNormalName = entry.getKey();
                // 根据中文字段名获取列号
                int col = colMap.get(cnNormalName);
                // 获取当前单元格中的内容
                String content = sheet.getCell(col, i).getContents().toString().trim();
                // 判断前几列不能为空
                if (index > 0) {
                    if (content == null || content.equals("")) {
                        throw new CustomException("列数据为空！请检查导入模板是否正确！" + (col + 1) + "," + (i + 3));
                    }
                }
                if (!StringUtils.isEmpty(content)) {
                    // 给对象赋值
                    //setFieldValueByName(enNormalName, content, entity);
                    entity.put(enNormalName, content);
                }
                index--;
            }
            resultList.add(entity);
        }

        return resultList;
    }

    /**
     * 导出Excel模板 考试专用（导出到浏览器，可以自定义工作表的大小）
     *
     * @param fieldMap
     *            类的英文属性和Excel中的中文列名的对应关系
     * @param sheetName
     *            工作表的名称
     * @param response
     *            使用response可以导出到浏览器
     * @throws CustomException
     *             异常
     */
    public static <T> void leadToExcelQuestionBankTemplet(LinkedHashMap<String, String> fieldMap, Map<String, Object> resultMap, String sheetName, HttpServletResponse response) throws CustomException {

        // 设置默认文件名为当前时间：年月日时分秒
        String fileName =  sheetName + "-" +new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()).toString();

        // 如果文件名没提供，则使用时间戳
        if (fileName == null || fileName.trim().equals("")) {
            // 设置默认文件名为当前时间：年月日时分秒
            fileName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()).toString();
        }




        // 创建工作簿并发送到浏览器
        try {

            fileName = URLEncoder.encode(fileName , "utf-8");
            // 设置response头信息
            response.reset();
            response.setContentType("application/vnd.ms-excel"); // 改成输出excel文件
            response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xls");

            OutputStream out = response.getOutputStream();

            int sheetSize = 65535;

            // 创建工作簿并发送到OutputStream指定的地方
            WritableWorkbook wwb;
            try {
                wwb = Workbook.createWorkbook(out);

                // 因为2003的Excel一个工作表最多可以有65536条记录，除去列头剩下65535条
                // 所以如果记录太多，需要放到多个工作表中，其实就是个分页的过程
                // 1.计算一共有多少个工作表
                // double sheetNum = Math.ceil(list.size()
                // / new Integer(sheetSize).doubleValue());

                double sheetNum = 1;

                // 2.创建相应的工作表，并向其中填充数据
                // 如果只有一个工作表的情况
                if (1 == sheetNum) {
                    WritableSheet sheet = wwb.createSheet(sheetName, 1);

                    // 定义存放英文字段名和中文字段名的数组
                    String[] enFields = new String[fieldMap.size()];
                    String[] cnFields = new String[fieldMap.size()];

                    // 填充数组
                    int count = 0;
                    for (Map.Entry<String, String> entry : fieldMap.entrySet()) {
                        enFields[count] = entry.getKey();
                        cnFields[count] = entry.getValue();
                        count++;
                    }
                    // 填充表头
                    for (int i = 0; i < cnFields.length; i++) {
                        Label label = new Label(i, 0, cnFields[i]);
                        sheet.addCell(label);
                    }
                    if (resultMap != null && resultMap.size() > 0) {
                        //填充数据
                        List<Map<String, Object>> mapList = (List<Map<String, Object>>) (resultMap.get("tableData"));
                        //数据行数
                        int j = 1;
                        String dataKey = "";
                        String cellValue = "";
                        for (Map<String, Object> dataMap : mapList) {
                            //数据单元列数
                           /* int z = 0;
                            for (Map.Entry<String, String> entry : fieldMap.entrySet()) {
                                for (Map.Entry<String, Object> dataEntry : dataMap.entrySet()) {
                                    //匹配表头
                                    if (entry.getKey().equals(dataEntry.getKey())) {
                                        sheet.addCell(new Label(z, j, dataEntry.getValue().toString()));
                                        z++;
                                        break;
                                    }
                                }
                            }*/
                            //根据表头英文编码进行匹配数据
                            for(int k=0 ; k < enFields.length ; k++ ){
                                dataKey = enFields[k];
                                if(dataMap.get(dataKey) != null){
                                    cellValue = String.valueOf(dataMap.get(dataKey));
                                    if(!"".equals(cellValue) && !"null".equals(cellValue)){
                                        sheet.addCell(new Label(k, j, cellValue));
                                    }

                                }
                            }
                            j++;
                        }
                    }
                    // 设置自动列宽
                    setColumnAutoSize(sheet, 5);

                }

                wwb.write();
                wwb.close();

            } catch (Exception e) {
                e.printStackTrace();
                // 如果是ExcelException，则直接抛出
                if (e instanceof CustomException) {
                    throw (CustomException) e;

                    // 否则将其它异常包装成ExcelException再抛出
                } else {
                    throw new CustomException("导出Excel失败");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

            // 如果是ExcelException，则直接抛出
            if (e instanceof CustomException) {
                throw (CustomException) e;

                // 否则将其它异常包装成ExcelException再抛出
            } else {
                throw new CustomException("导出Excel失败");
            }
        }
    }

    /**
     * 根据字段名给对象的字段赋值
     *
     * @param fieldName
     *            字段名
     * @param fieldValue
     *            字段值
     * @param o
     *            对象
     * @throws Exception
     *             异常
     */
    public static void setFieldValueByName(String fieldName, Object fieldValue, Map<String,Object> o) throws Exception {

        Field field = getFieldByName(fieldName, o.getClass());
        if (field != null) {
            field.setAccessible(true);
            // 获取字段类型
            Class<?> fieldType = field.getType();
            // 根据字段类型给字段赋值
            if (String.class == fieldType) {
                field.set(o, String.valueOf(fieldValue));
            } else if ((Integer.TYPE == fieldType) || (Integer.class == fieldType)) {
                field.set(o, Integer.parseInt(fieldValue.toString()));
            } else if ((Long.TYPE == fieldType) || (Long.class == fieldType)) {
                field.set(o, Long.valueOf(fieldValue.toString()));
            } else if ((Float.TYPE == fieldType) || (Float.class == fieldType)) {
                field.set(o, Float.valueOf(fieldValue.toString()));
            } else if ((Short.TYPE == fieldType) || (Short.class == fieldType)) {
                field.set(o, Short.valueOf(fieldValue.toString()));
            } else if ((Double.TYPE == fieldType) || (Double.class == fieldType)) {
                field.set(o, Double.valueOf(fieldValue.toString()));
            } else if (Character.TYPE == fieldType) {
                if ((fieldValue != null) && (fieldValue.toString().length() > 0)) {
                    field.set(o, Character.valueOf(fieldValue.toString().charAt(0)));
                }
            } else if (Date.class == fieldType) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String value = fieldValue.toString();
                if (fieldValue.toString().indexOf(".") > 0) {
                    value = value.replace(".", "-");
                }
                field.set(o, format.parse(value));
            } else if (java.sql.Date.class == fieldType) {
                if(!fieldValue.equals("-100")) {
                    field.set(o, java.sql.Date.valueOf((String) fieldValue));
                }
                //field.set(o, java.sql.Date.valueOf((String) fieldValue));
            } else {
                field.set(o, fieldValue);
            }
        } else {
            field.set(o, fieldValue);
            //throw new CustomException(o.getClass().getSimpleName() + "类不存在字段名 " + fieldName);
        }
    }

    /**
     * 根据字段名获取字段
     *
     * @param fieldName
     *            字段名
     * @param clazz
     *            包含该字段的类
     * @return 字段
     */
    public static Field getFieldByName(String fieldName, Class<?> clazz) {
        // 拿到本类的所有字段
        Field[] selfFields = clazz.getDeclaredFields();

        // 如果本类中存在该字段，则返回
        for (Field field : selfFields) {
            if (field.getName().equals(fieldName)) {
                return field;
            }
        }

        // 否则，查看父类中是否存在此字段，如果有则返回
        Class<?> superClazz = clazz.getSuperclass();
        if (superClazz != null && superClazz != Object.class) {
            return getFieldByName(fieldName, superClazz);
        }

        // 如果本类和父类都没有，则返回空
        return null;
    }

    /**
     * 设置工作表自动列宽和首行加粗
     *
     * @param ws
     *            要设置格式的工作表
     * @param extraWith
     *            额外的宽度
     */
    public static void setColumnAutoSize(WritableSheet ws, int extraWith) {
        // 获取本列的最宽单元格的宽度
        for (int i = 0; i < ws.getColumns(); i++) {
            int colWith = 0;
            for (int j = 0; j < ws.getRows(); j++) {
                String content = ws.getCell(i, j).getContents().toString();
                int cellWith = content.length();
                if (colWith < cellWith) {
                    colWith = cellWith;
                }
            }
            // 设置单元格的宽度为最宽宽度+额外宽度
            ws.setColumnView(i, colWith + extraWith);
        }

    }

    /**
     * 处理字符串中换行以及空格
     * @param str
     * @return
     */
    public static String toolStr(String str){
        String resultStr = "";
        if(str != null && !"".equals(str) && !"null".equals(str) ){
            resultStr = str.replaceAll("\r|\n", "").replaceAll(" " , "");
        }
        return resultStr;
    }
}
