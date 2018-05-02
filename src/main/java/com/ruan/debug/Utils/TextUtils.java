package com.ruan.debug.Utils;

/**
 * Created by 19820 on 2018/4/30.
 */
public class TextUtils {

    /**
     * 判断是否为空
     * @param msg
     * @return
     */
    public static boolean isEmpty(String msg){
        if (msg != null && msg.length() > 0)
            return false;
        return true;
    }

    /**
     * 判断两个字符串是否相等
     * @param str1
     * @param str2
     * @return
     */
    public static boolean equels(String str1 , String str2){
        if (str1 != null && str2 != null && str1.length() > 0 && str2.length() > 0)
            return str1.equals(str2);
        return false;
    }

}
