package net.orangepeels.utils;

import org.junit.Test;

public class MathTools {

    public static boolean isNumber(char str){
        int ascii = (int)str;
        if(ascii >= 49 && ascii <=57){
            return true;
        }else {
            return false;
        }
    }
}
