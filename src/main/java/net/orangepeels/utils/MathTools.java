package net.orangepeels.utils;

public class MathTools {

    /**
     * 判断这个字符是否是数字
     * @param str 比对字符
     * @return 如果为数字返回true，否则为false
     */
    public static boolean isNumber(char str){
        int ascii = (int)str;
        if(ascii >= 49 && ascii <=57){
            return true;
        }else {
            return false;
        }
    }
}
