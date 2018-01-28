package cn.xc.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @version V1.0
 * @Description: 日期转换工具类 可将由逗号分隔的毫秒时间转换成日期数组集合
 * @Author XiongCheng
 * @Date 2018/1/24 11:54.
 */
public class DateUtil {
    public static List<Date> MillisToDateList(String value){
        List<Date> result = new ArrayList<>();
        String[] date = value.split(",");
        for (String s : date) {
            result.add(new Date(Long.parseLong(s)));
        }
        return result;
    }
}
