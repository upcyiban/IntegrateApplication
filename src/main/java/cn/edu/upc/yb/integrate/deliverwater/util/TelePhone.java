package cn.edu.upc.yb.integrate.deliverwater.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 陈子枫 on 2016/10/16.
 */
public class TelePhone {

    //用于匹配手机号码
    private final static String REGEX_MOBILEPHONE = "^0?1[34578]\\d{9}$";

    private static Pattern PATTERN_MOBILEPHONE;

    static{
        PATTERN_MOBILEPHONE = Pattern.compile(REGEX_MOBILEPHONE);
    }

    /**
     * 判断是否为手机号码
     *
     * @param number
     *            手机号码
     * @return
     */
    public static boolean isCellPhone(String number) {
        Matcher match = PATTERN_MOBILEPHONE.matcher(number);
        return match.matches();


    }
}
