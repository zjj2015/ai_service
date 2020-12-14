package com.read;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.entity.DailyReport;
import com.entity.DemoData;
import com.service.DailyReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 模板的读取类
 *
 * @author Jiaju Zhuang
 */
// 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
public class DailyReportListener extends AnalysisEventListener<DailyReport> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DailyReportListener.class);
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 1000;
    List<DailyReport> list = new ArrayList<DailyReport>();
    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */
    private DailyReportService dailyReportService;

    /*public DemoDataListener() {
        // 这里是demo，所以随便new一个。实际使用如果到了spring,请使用下面的有参构造函数
        demoDAO = new DemoDAO();
    }*/

    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     *
     * @param
     */
    public DailyReportListener(DailyReportService dailyReportService) {
        this.dailyReportService = dailyReportService;
    }

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data
     *            one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context
     */
    @Override
    public void invoke(DailyReport data, AnalysisContext context) {
        //LOGGER.info("解析到一条数据:{}", JSON.toJSONString(data));
            list.add(data);
            // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
            if (list.size() >= BATCH_COUNT) {
                saveData();
                // 存储完成清理 list
                list.clear();
            }

    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        LOGGER.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        LOGGER.info("{}条数据，开始存储数据库！", list.size());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        for (DailyReport data:list){
            if(!StringUtils.isEmpty(data.getReportDate())){
                try {
                    String[] arr=data.getReportDate().split("/");
                    if(arr.length>0){
                        String day=arr[2];
                        if(day.length()==1){
                            day="0"+day;
                        }
                        data.setReportDate(arr[0]+"-"+arr[1]+"-"+day);
                        //System.out.printf(arr[0]+"-"+arr[1]+"-"+day);
                    }
                    //data.setReportDate(sdf.format(sdf.parse(data.getReportDate())));
                    dailyReportService.insert(data);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            //if(data.getReportDate().contains("-")) {  //尾部说明不插入数据库中

            //}
        }
        LOGGER.info("存储数据库成功！");
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String str="2020/12/1";
        String[] arr=str.split("/");
        if(arr.length>0){
            String day=arr[2];
            if(day.length()==1){
                day="0"+day;
            }
            System.out.printf(arr[0]+"-"+arr[1]+"-"+day);
        }
        //System.out.println(sdf.format(sdf.parse("2020/12/1")));
    }
}
