package com.shine.common.util;

public class StringUtil {

    public static boolean isEmpty(String obj){
        return obj == null || obj.equals("");
    }

    public static boolean isNotEmpty(String obj){
        return !isEmpty(obj);
    }
}
