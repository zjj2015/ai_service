package com.tool;

import com.util.ExcelUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
	
	public static final String FORMAT_YEAR_MONTH = "yyyy-MM";


	/**
	 * 获取传入月份第几个月前/后的月份
	 * @param yearMonth
	 * @param add 为负数时代表查询之前的月份 ， 为正数时代表查询之后的月份
	 * @return
	 */
	public static String addMonths(String yearMonth, int add) {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_YEAR_MONTH);
		Date date;
		try {
			date = sdf.parse(yearMonth);
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, add);
		return sdf.format(calendar.getTime());
	}

	public static boolean checkDate (String str , String format) {
		SimpleDateFormat sd=new SimpleDateFormat(format);//括号内为日期格式，y代表年份，M代表年份中的月份（为避免与小时中的分钟数m冲突，此处用M），d代表月份中的天数
		try {
			sd.setLenient(false);//此处指定日期/时间解析是否不严格，在true是不严格，false时为严格
			sd.parse(str);//从给定字符串的开始解析文本，以生成一个日期
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 根据传入的内容，转换为数据类的月份 ，即 第一季度、上半年、1月至10月……相关月份转换为yyyy-m1/yyyy-m2
	 * @param date
	 * @return
	 */
	public static  String changeChToNumType(String date){
		if(date == null || "".equals(date) || "null".equals(date)) return date;

		date = ExcelUtils.toolStr(date);//去空格和换行
		String monthFormat = "yyyy-MM";

		String returnDate = "";

		//当前年份
		String nowYear = new SimpleDateFormat("yyyy").format(new Date());
		//当前月份
		String nowMonth = new SimpleDateFormat(monthFormat).format(new Date());

		//判断是否有带上年份，可能存在2019年XXX或2019XXX两种情况(暂时设定为以上两种格式，除以上格式以外，即前面4位必须为纯数字，否则默认为当前年度)
		String year = date.substring(0,4);
		if(!NumUtil.isNum(year)){
			year = nowYear;
		}

		//TODO 待优化为字典配置
		//先判断季度
		if( date.indexOf("季度") != -1){
			if(date.indexOf("前三季度") != -1){
				returnDate = year + "01/" + year + "09";
			}else if(date.indexOf("第一季度") != -1){
				returnDate = year + "01/" + year + "03";
			}else if(date.indexOf("第二季度") != -1){
				returnDate = year + "04/" + year + "06";
			}else if(date.indexOf("第三季度") != -1){
				returnDate = year + "0/" + year + "03";
			}else if(date.indexOf("第四季度") != -1){
				returnDate = year + "01/" + year + "03";
			}

		} else if (date.indexOf("半年") != -1) {
			if(date.indexOf("上半年") != -1){
				returnDate = year + "01/" + year + "06";
			}else if(date.indexOf("下半年") != -1){
				returnDate = year + "07/" + year + "12";
			}

		}else if((date.indexOf("至") != -1 || date.indexOf("到") != -1) && date.indexOf("累计") != -1){
			//TODO 后面需要再加
		}else{//判断原数据是不是我们想要的数据
			//判断格式是否为特定格式 ，设定长度为15，并且是以年月/年月的格式传入
			if(date.length() == 15){
				if(date.indexOf("/") != -1){
					String[] dates = date.split("/");
					if(dates.length == 2){
						if(checkDate(dates[0] , monthFormat) && checkDate(dates[1] , monthFormat)){
							returnDate = date;
						}
					}
				}
			}
		}

		return returnDate;
	}

	/**
	 * 根据月份判断所在季度
	 * @param date 必须是格式为yyyy-MM
	 * @return
	 */
	public static int getSeasonNoByMonth(String date){
		int seasonNo = 1;
		int monthNo = Integer.parseInt(date.substring(5,date.length()));
		if(monthNo > 9){//大于9月，第四季度
			seasonNo = 4;
		}else if(monthNo > 6){//大于6月，第三季度
			seasonNo = 3;
		}else if(monthNo > 3){//大于3月，第二季度
			seasonNo = 2;
		}else{//小于等于3月，第一季度
			seasonNo = 1;
		}
		return seasonNo;
	}

	/**
	 * 根据年份返回日期
	 * @param year 格式yyyy
	 * @param seasonNo
	 * @return “yyyy-m1/yyyy-m2” 格式
	 */
	public static String getNumSeasonMonth(String year , int seasonNo){
		String seasonMonth = "";
		switch (seasonNo){
			case 1:
				seasonMonth = year + "-01/" + year + "-03";
				break;
			case 2:
				seasonMonth = year + "-04/" + year + "-06";
				break;
			case 3:
				seasonMonth = year + "-07/" + year + "-09";
				break;
			case 4:
				seasonMonth = year + "-10/" + year + "-12";
				break;
		}


		return seasonMonth;
	}

	/**
	 * 根据年份返回日期
	 * @param year 格式yyyy
	 * @param seasonNo
	 * @return “yyyy年第几季度” 格式
	 */
	public static String getChSeasonMonth(String year , int seasonNo){

		String seasonMonth = year + "年第" + seasonNo + "季度";

		return seasonMonth;
	}

	/**
	 * 获取年度所有季度
	 * @param year
	 * @return [{"TEXT": "2019年第一季度","VALUE": "2019-01/2019-03"}……]
	 */
	public static List<Map<String ,Object>> getYearAllSeason(String year){

		List<Map<String ,Object>> list = new ArrayList<>();
		Map<String ,Object> map = new HashMap<>();
		for(int i= 4 ; i >  0 ; i--){
			map = new HashMap<>();
			map.put("VALUE" , getChSeasonMonth(year , i));
			map.put("TEXT" , getChSeasonMonth(year , i));
			list.add(map);
		}

		return list;
	}

	/**
	 * 将中文日期转换为数字日期格式（season季度相关）
	 * */
	public static String getChToNumOfSeason(String seasonMonth){
		return getNumSeasonMonth(seasonMonth.substring(0,4) , Integer.parseInt(seasonMonth.substring(6 , 7)));
	}

	public static String getYesterdayStr(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		Date date=new Date();
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH,-1);
		date=c.getTime();
		String str=sdf.format(date);
		return str;
	}
}
