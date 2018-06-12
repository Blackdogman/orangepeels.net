package net.orangepeels.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTools {

    /**
     * 把日期格式化为yyyyMMdd
     * @param date
     * @return
     */
    public static String simpleDateString(Date date){
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
        return ft.format(date);
    }
}
