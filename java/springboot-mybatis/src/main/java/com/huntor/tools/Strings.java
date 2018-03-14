package com.huntor.tools;

import java.util.regex.Pattern;

/**
 *hanxiaoyu
 * Date: 20/11/15
 */
public class Strings {

    /**
     * 判断字符串是否为null或""
     * @param s 字符串
     * @return 若为null或""返回true，反之false
     */
    public static Boolean isNullOrEmpty(String s){
        return s == null || "".equals(s);
    }

    /**
     * 替换敏感信息为***
     * @param str 原始字符
     * @param beforeNumber 保留前几位 为0时，表示前面都为*
     * @param afterNumber 保留后几位 为0时，表示后面都为*
     * @return 返回替换后的字符串，如果返回null，则表示字符串传入错误
     */
    public static String replaceSensitive(String str,int beforeNumber,int afterNumber){
        int strLength = str.length();
        if(strLength < (beforeNumber+afterNumber)){
            return null;
        }
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=0;i<strLength;i++){
            if(i < beforeNumber){
                stringBuffer.append(str.charAt(i));
                continue;
            }

            if(i>=(strLength-afterNumber)){
                stringBuffer.append(str.charAt(i));
                continue;
            }

            stringBuffer.append("*");
        }
        return stringBuffer.toString();
    }

    /**
     * 判断是否为正整数
     * @param str 传入的字符串
     * @return 是整数返回true,否则返回false
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }


//    public static void main(String args[]) {
//        System.out.println(isInteger("1"));
//        System.out.println(isInteger("-1"));
//        System.out.println(isInteger("thg"));
//        System.out.println(isInteger("0"));
//    }
}
