package cn.xc.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  信息校验相关工具类
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/2/1 11:30.
 */
public class ValidatorUtil {
    public static final String phoneCheckRegex = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
    public static final String carNumberCheckRegex = "^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$";

    public static boolean checkPhoneNumberLegality(String phoneNumber){
        Pattern p = Pattern.compile(phoneCheckRegex);
        Matcher m = p.matcher(phoneNumber);
        return m.matches();
    }
    public static boolean checkCarNumberLegality(String carNumber){
        Pattern p = Pattern.compile(carNumberCheckRegex);
        Matcher m = p.matcher(carNumber);
        return m.matches();
    }
}
