package cn.xc.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *  工具类
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/1/24 11:54.
 */
public class Util {
    /**
     * 日期转换工具类 可将由逗号分隔的毫秒时间转换成日期数组集合
     * @param value
     * @return
     */
    public static List<Timestamp> MillisToDateList(String value){
        List<Timestamp> result = new ArrayList<>();
        String[] date = value.split(",");
        for (String s : date) {
            result.add(new Timestamp(Long.parseLong(s)));
        }
        return result;
    }

    public static String getCurrentUsername(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
