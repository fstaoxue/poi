package com.taoge.poi.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * @author taoxuefeng
 * @date 2019/11/27
 */
public class CheckUtil {

    private static final Pattern pattern = Pattern.compile("[0-9]*\\.?[0-9]+");

    private CheckUtil(){}

    /**
     * 判断字符串是否为数字或者小数
     * @return
     */
    public static boolean isNumber(String number){
        if(StringUtils.isEmpty(number)){
            return false;
        }
        if(StringUtils.isNumeric(number)){
            return true;
        }
        if(pattern.matcher(number).matches()){
            return true;
        }
        return false;
    }
}
