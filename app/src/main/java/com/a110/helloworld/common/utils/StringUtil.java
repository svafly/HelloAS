package com.a110.helloworld.common.utils;

/**
 * Create by vicky on 2018/10/11
 * 字符串工具类
 */
public class StringUtil {

    /**
     *
     * @param str
     * @return
     */
    public static boolean isBlank(String str){
        int length;
        if (str == null || (length = str.length()) == 0){
            return true;
        }
        for (int i=0;i<length;i++){
            if (!Character.isWhitespace(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
