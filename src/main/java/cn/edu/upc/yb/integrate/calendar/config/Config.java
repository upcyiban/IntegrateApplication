package cn.edu.upc.yb.integrate.calendar.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Jaxlying on 2016/7/10.
 */
public class Config {

    @Value("${yibanoauth.calendar.APPID}")
    public static String appid;

    @Value("${yibanoauth.calendar.APPkey}")
    public static String appkey;

    @Value("${yibanoauth.calendar.admin}")
    public static String admin;

    @Value("${yibanoauth.calendar.password}")
    public static String password;

}
