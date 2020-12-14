package com.tool;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.text.NumberFormat;

import org.springframework.util.StringUtils;

/**
 * 格式化工具
 */
public class FormatUtil {
	
	/**
	 * 千
	 */
	public static final BigDecimal THOUSAND = new BigDecimal("1000");
	
	/**
	 * 万
	 */
	public static final BigDecimal TEN_THOUSAND = new BigDecimal("10000");
	
	/**
	 * 亿
	 */
	public static final BigDecimal HUNDRED_MILLION = new BigDecimal("100000000");

    /**
     * 删除数组长度
     *
     * @param oldArray
     * @param reduceLength
     * @return
     */
    public static Object arrayReduceLength(Object oldArray, int reduceLength) {
        Class c = oldArray.getClass();
        if (!c.isArray()) return null;
        Class componentType = c.getComponentType();
        int length = Array.getLength(oldArray);
        int newLength = length - reduceLength;
        Object newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(oldArray, 0, newArray, 0, newLength);
        return newArray;
    }

    /**
     * 字符串转double
     *
     * @param number
     * @return
     */
    public static Double StringToDouble(String number) {
        double num;
        java.text.DecimalFormat myformat = new java.text.DecimalFormat("#0.00");

        num = Double.parseDouble(number);//装换为double类型
        num = Double.parseDouble(myformat.format(num));//保留2为小数

        return num;
    }


    /**
     * 得到百分比
     *
     * @param nowQty
     * @param nextQty
     * @return
     */
    public static String getRatio(double nowQty, double nextQty) {
        if (nextQty == 0.0) {
            nextQty = 1;
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        String ratio = numberFormat.format((nowQty-nextQty) / nextQty * 100);
        return ratio;
    }

    /**
     * 根据单位转换value
     *
     * @param nowQty
     * @param unit
     * @return
     */
    public static String formatValueForUnit(double nowQty, int unit) {

        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setGroupingUsed(false);
        String value = numberFormat.format(nowQty / unit);
        return value;
    }


    /**
     * 得到单位
     *
     * @param unit
     * @return
     */
    public static String formatUnit(String unit) {
        if ("吨".equals(unit)) {
            unit = "万" + unit;
        } else if ("美元".equals(unit)) {
            unit = "亿" + unit;
        } else if ("元".equals(unit)) {
            unit = "万" + unit;
        } else if ("件".equals(unit)) {
            unit = "万" + unit;
        } else if ("人次".equals(unit)) {
            unit = "万" + unit;
        } else if ("票".equals(unit)) {
        	unit = "万" + unit;
        }
        return unit;
    }

	/**
	 * <p><b>单位转换：</b></p>
	 * 根据传入数值判断是否转换单位<br/>
	 * 当数值大于万时，转换单位为“万+unit”，大于亿时，转换单位为“亿+unit”<br/>
	 * 若传入的单位包含 “万”“亿” 则不转换
	 * @param qty 数值
	 * @param unit 单位 如：元、美元、千克、吨……
	 * @return [qty(BigDecimal), unit(String)]
	 */
    public Object[] formatValueForUnit(BigDecimal qty, String unit) {
		if (StringUtils.isEmpty(unit) || qty == null || qty.compareTo(TEN_THOUSAND)<0) {
			return new Object[]{qty, unit};
		}
		
		BigDecimal neoQty = qty;
		String neoUnit = unit;
//		if (unit.equals("千克")) {
//			if (neoQty.compareTo(THOUSAND) >= 0) {
//				neoQty = neoQty.divide(THOUSAND, 2, BigDecimal.ROUND_HALF_UP);
//				neoUnit = "吨";
//			}
//		}
		if (!neoUnit.matches("[万亿]")) {
			if (neoQty.compareTo(HUNDRED_MILLION) > 0) {
				neoQty = neoQty.divide(HUNDRED_MILLION, 2, BigDecimal.ROUND_HALF_UP);
				neoUnit = "亿" + neoUnit;
			}
			else if (neoQty.compareTo(TEN_THOUSAND) > 0) {
				neoQty = neoQty.divide(HUNDRED_MILLION, 2, BigDecimal.ROUND_HALF_UP);
				neoUnit = "万" + neoUnit;
			}
		}

		return new Object[]{neoQty, neoUnit};
	}


}
