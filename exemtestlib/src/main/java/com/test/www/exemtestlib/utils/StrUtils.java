package com.test.www.exemtestlib.utils;

import android.util.Log;

import java.util.Set;

public class StrUtils {
    private static StrUtils strUtils;
    public static StrUtils Instance(){
        synchronized (StrUtils.class){
            if(strUtils==null){
                return strUtils=new StrUtils();
            }
        }
        return strUtils;
    }

    /**
     * 将数字转化为字母
     * @param num
     * @return
     */
    public String numberToLetter(int num) {
        if (num <= 0) {
            return null;
        }
        String letter = "";
        num--;
        do {
            if (letter.length() > 0) {
                num--;
            }
            letter = ((char) (num % 26 + (int) 'A')) + letter;
            num = (int) ((num - num % 26) / 26);
        } while (num > 0);
        Log.e("------->>>",letter);
        return letter;
    }
    //将字母转化为数字
    public int letterToNumber(String letter) {
        int length = letter.length();
        int num = 0;
        int number = 0;
        for(int i = 0; i < length; i++) {
            char ch = letter.charAt(length - i - 1);
            num = (int)(ch - 'A' + 1) ;
            num *= Math.pow(26, i);
            number += num;
        }
        return number;
    }
    public String SetToString(Set<String> set){
        StringBuffer stringBuffer=new StringBuffer();
        for (String str : set) {
           stringBuffer.append(str+",");
        }
        return stringBuffer.deleteCharAt(stringBuffer.length()-1).toString();
    }
}
