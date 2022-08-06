package com.hai.utils;

import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

/**
 * Created with IDEA
 * author:bdjw
 * Date:2022-02-23
 * Time:下午6:47
 */
public class DateTimeUtils {

    /**
     * 当前时间戳按指定格式转化为日期（String）
     * @return
     */
    public static String nowTimestamp2Date() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        final String format = formatter.format(date);
        return format;
    }

    /**
     * 时间戳按指定格式转化为日期（String）
     * @param timestamp
     * @param pattern
     * @return
     */
    public static String convertTimestamp2Date(Long timestamp, String pattern) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        return simpleDateFormat.format(new Date(timestamp));
    }
    public static String getDate(String time){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(new Date(time));
    }

    public static String getDateStr(String time){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
        return formatter.format(new Date(time));
    }

    public static Integer dateToStamp(String s) throws ParseException {
        SimpleDateFormat simpleDateFormat =   new SimpleDateFormat(  "yyyy-MM-dd HH:mm:ss" );
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        int res = Integer.parseInt(ts/1000+"");
        return res;
    }


    /**
     * 获取11位时间
     * @return 返回Integer对象
     */
    public static Integer getInt11Time(){
        return Integer.parseInt(System.currentTimeMillis() / 1000 + "");
    }

}
