package com.tool;

import java.util.regex.Pattern;

/**
 * Copyright: ...
 * Company: bingo
 * Version: 1.0.0
 * Author: lihuanwei
 * Date: 2019/11/22
 * Description:
 */
public class NumUtil {
    public static boolean isNum(String str){

        Pattern pattern = Pattern.compile("^-?[0-9]+");
        if(pattern.matcher(str).matches()){
            //数字
            return true;
        } else {
            //非数字
            return false;
        }
    }
}
